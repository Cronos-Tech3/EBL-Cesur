using System.Windows;

namespace proyectoFeliz2
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void EnviarButton_Click(object sender, RoutedEventArgs e)
        {
            string nombre = NombreTextBox.Text;
            string edad = EdadTextBox.Text;
            MensajeTextBlock.Text = $"¡Hola {nombre}! Tienes {edad} años.";
        }
    }
}