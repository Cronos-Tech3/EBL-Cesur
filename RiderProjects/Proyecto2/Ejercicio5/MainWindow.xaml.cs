using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Threading;

namespace Ejercicio5
{
      public partial class MainWindow : Window
      {
         private DispatcherTimer timer; //timer para actualizar la barra progresivamente
         
         public MainWindow()
         {
             InitializeComponent();
             //Configurar el timer
             timer = new DispatcherTimer();
             timer.Interval = TimeSpan.FromMilliseconds(100);//cada 100ms
             timer.Tick += Timer_Tick; //LLamar al evento cada vez que se activa
         }

         private void Button_Click(object sender, RoutedEventArgs e)
         {
             //Iniciar el llenado progresivo sin reiniciar el progreso
             timer.Start(); //iniciar el timer
         }

         private void Timer_Tick(object sender, EventArgs e)
         {
             if (progressBar.Value<100)
             {
                 progressBar.Value += 1;
             }
             else
             {
                 timer.Stop();
             }
         }
      }  
}


