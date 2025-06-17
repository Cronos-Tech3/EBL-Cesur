using System.Windows;
using System.ComponentModel;
using MySqlConnector; // Necesario para CancelEventArgs

namespace Ejercicio4Persistencia // Logic baseada en el namespace de tu proyecto
{
    public partial class MainWindow : Window
    {
      
        // Server: La dirección de tu servidor MySQL (ej. localhost, 127.0.0.1, o una IP)
        // Database: El nombre exacto de la base de datos que creaste (ej. miapp)
        // Uid: Tu nombre de usuario de MySQL
        // Pwd: La contraseña de tu usuario de MySQL
        private const string connectionString = "Server=127.0.0.1;Port=3307;Database=miapp;Uid=root;Pwd=1234"; // <<-- ¡MODIFICA ESTA LÍNEA!

        public MainWindow()
        {
            InitializeComponent();
        }

        // Método para guardar un valor de configuración en la base de datos
        // Usa REPLACE INTO para insertar o actualizar si la clave existe para ese usuario
        public void GuardarValorBD(string usuario, string clave, string valor)
        {
            // Usamos REPLACE INTO que es como INSERT, pero si encuentra una fila con la misma PRIMARY KEY
            // (usuario y clave), la actualiza en lugar de dar un error.
            string query = "REPLACE INTO configuraciones (usuario, clave, valor) VALUES (@usuario, @clave, @valor)";

            // 'using' asegura que la conexión se cierre y se liberen recursos correctamente
            using (MySqlConnection conexion = new MySqlConnection(connectionString))
            {
                MySqlCommand comando = new MySqlCommand(query, conexion);

                // Añadimos parámetros para prevenir inyección SQL y manejar tipos de datos correctamente
                comando.Parameters.AddWithValue("@usuario", usuario);
                comando.Parameters.AddWithValue("@clave", clave);
                comando.Parameters.AddWithValue("@valor", valor);

                try
                {
                    conexion.Open(); // Abrimos la conexión a la base de datos
                    comando.ExecuteNonQuery(); // Ejecutamos la sentencia SQL (INSERT/UPDATE) que no devuelve filas
                   
                }
                catch (Exception ex)
                {
                    // Si hay un error al conectar o ejecutar la consulta, mostramos un mensaje
                    MessageBox.Show("Error al guardar configuración en BD: " + ex.Message);
                }
            }
        }

        // Método para leer un valor de configuración de la base de datos
        public string LeerValorBD(string usuario, string clave)
        {
            // Seleccionamos el valor para un usuario y clave específicos
            string query = "SELECT valor FROM configuraciones WHERE usuario = @usuario AND clave = @clave";
            string valor = null; // Variable para almacenar el valor leído

            using (MySqlConnection conexion = new MySqlConnection(connectionString))
            {
                MySqlCommand comando = new MySqlCommand(query, conexion);

                // Añadimos parámetros para la consulta
                comando.Parameters.AddWithValue("@usuario", usuario);
                comando.Parameters.AddWithValue("@clave", clave);

                try
                {
                    conexion.Open(); // Abrimos la conexión
                    // ExecuteScalar se usa para consultas que esperamos que devuelvan un solo valor
                    // (la primera columna de la primera fila)
                    object resultado = comando.ExecuteScalar();

                    // Si se encontró un resultado (no es null), lo convertimos a string
                    if (resultado != null)
                    {
                        valor = resultado.ToString();
                    }
                     
                }
                catch (Exception ex)
                {
                    // Si hay un error al conectar o ejecutar la consulta, mostramos un mensaje
                    MessageBox.Show("Error al leer configuración de BD: " + ex.Message);
                }
            }
            return valor; // Devolvemos el valor leído (será null si no se encontró la clave para el usuario)
        }

        // Evento que se ejecuta cuando la ventana ha terminado de cargar
        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            // Al cargar la ventana, intentamos leer la configuración guardada para el usuario
            // NOTA: En una aplicación real, la carga de configuración del usuario
            // podría hacerse después de un inicio de sesión exitoso.
            // Para este ejercicio simple, tomamos el usuario del TextBox al inicio.
            string usuarioActual = txtUsuario.Text.Trim(); // Obtenemos el usuario del TextBox

            if (!string.IsNullOrEmpty(usuarioActual)) // Solo intentamos cargar si hay un usuario
            {
                // Leemos el ancho y alto guardados para este usuario
                string anchoStr = LeerValorBD(usuarioActual, "VentanaAncho");
                string altoStr = LeerValorBD(usuarioActual, "VentanaAlto");

                // Si se leyó un ancho y es un número válido, aplicamos el ancho a la ventana
                if (!string.IsNullOrEmpty(anchoStr) && double.TryParse(anchoStr, out double ancho))
                {
                    this.Width = ancho;
                }
                // Si no se pudo leer o convertir, la ventana mantiene el ancho definido en el XAML o el último ancho.

                // Si se leyó un alto y es un número válido, aplicamos el alto a la ventana
                if (!string.IsNullOrEmpty(altoStr) && double.TryParse(altoStr, out double alto))
                {
                    this.Height = alto;
                }
                // Si no se pudo leer o convertir, la ventana mantiene el alto definido en el XAML o el último alto.

                // Puedes añadir lógica similar aquí para leer y aplicar la posición (WindowLeft, WindowTop)
                // si los guardas en la base de datos con claves como "VentanaPosX" y "VentanaPosY".
            }
            else
            {
                 // Si el TextBox del usuario está vacío al iniciar, mostramos un mensaje
                 MessageBox.Show("Ingresa un nombre de usuario en el campo de texto.");
            }
        }

        // Evento que se ejecuta justo antes de que la ventana comience a cerrarse
        private void Window_Closing(object sender, CancelEventArgs e)
        {
            // Antes de cerrar la ventana, guardamos la configuración actual
            string usuarioActual = txtUsuario.Text.Trim(); // Obtenemos el usuario del TextBox

            if (!string.IsNullOrEmpty(usuarioActual)) // Solo guardamos si hay un usuario
            {
                // Guardamos el ancho y alto actual de la ventana en la base de datos para este usuario
                GuardarValorBD(usuarioActual, "VentanaAncho", this.Width.ToString());
                GuardarValorBD(usuarioActual, "VentanaAlto", this.Height.ToString());

              
            }
            // Si no hay un nombre de usuario ingresado, la configuración de la ventana no se guarda.
        }
    }
}