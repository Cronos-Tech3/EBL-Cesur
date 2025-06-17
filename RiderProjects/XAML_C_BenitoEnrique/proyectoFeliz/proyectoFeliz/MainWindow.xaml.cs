using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

using System.Windows;

namespace PatientApp
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void GuardarButton_Click(object sender, RoutedEventArgs e)
        {
            string nombre = NombreTextBox.Text;
            string edad = EdadTextBox.Text;
            string direccion = DireccionTextBox.Text;
            string telefono = TelefonoTextBox.Text;

            // Aquí puedes agregar la lógica para guardar los datos del paciente
            MessageBox.Show($"Datos del paciente:\nNombre: {nombre}\nEdad: {edad}\nDirección: {direccion}\nTeléfono: {telefono}", "Ficha de Paciente");
        }
    }
}