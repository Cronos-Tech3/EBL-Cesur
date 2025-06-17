using System.Windows;
// using System.Windows;: Importa el espacio de nombres necesario para trabajar con elementos de la interfaz de usuario.


/*
    namespace FichaPaciente: Define el espacio de nombres de la aplicación.
    public partial class MainWindow : Window: Define la clase principal de la ventana.
    public MainWindow(): Constructor de la clase.
    InitializeComponent(): Inicializa los componentes de la ventana.
 */

namespace FichaPaciente
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }
        
        
        /**
        private void GuardarButton_Click(object sender, RoutedEventArgs e): Método que se ejecuta al hacer clic en el botón "Guardar".
        string nombre = NombreTextBox.Text;: Obtiene el texto ingresado en el campo "Nombre".
        string edad = EdadTextBox.Text;: Obtiene el texto ingresado en el campo "Edad".
        string direccion = DireccionTextBox.Text;: Obtiene el texto ingresado en el campo "Dirección".
        string telefono = TelefonoTextBox.Text;: Obtiene el texto ingresado en el campo "Teléfono"
         */
        private void GuardarButton_Click(object sender, RoutedEventArgs e)
        {
            string nombre = NombreTextBox.Text;
            string edad = EdadTextBox.Text;
            string direccion = DireccionTextBox.Text;
            string telefono = TelefonoTextBox.Text;
            
            // Aquí puedes añadir el código para guardar los datos del paciente
            MessageBox.Show($"Datos guardados:\nNombre: {nombre}\nEdad: {edad}\nDirección: {direccion}\nTeléfono: {telefono}", "Ficha de Paciente");
            // MessageBox.Show(...): Muestra un cuadro de mensaje con los datos ingresados.
        }
    }
}