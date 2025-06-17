using System.Windows;

namespace Practica_3
{
    // Definición parcial de la clase MainWindow que hereda de Window
    public partial class MainWindow : Window
    {
        // Constructor de la clase MainWindow
        public MainWindow()
        {
            // Inicializa los componentes de la ventana
            InitializeComponent();
        }

        // Manejador de eventos para el clic del botón
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            // Muestra un mensaje cuando se hace clic en el botón
            MessageBox.Show("¡Hola! Has hecho clic en el botón.");
        }
    }
}