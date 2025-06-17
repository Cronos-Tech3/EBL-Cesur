using System.Text;
using System.Windows;
using System.Windows.Controls;
using System;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Ejercicio4
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void MostrarMensaje_Click(object sender, RoutedEventArgs e)
        {
            Random rand = new Random();
            int numero = rand.Next(1, 101); //numero aleatorio entre 1 y 100
            txtSalida.Text = "Número generado: " + numero.ToString();
        }

    }
}