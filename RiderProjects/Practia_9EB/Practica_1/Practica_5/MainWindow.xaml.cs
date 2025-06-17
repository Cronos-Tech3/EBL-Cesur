using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Windows;
using Practica_5.Models;

namespace Practica_5
{
    // Definición parcial de la clase MainWindow que hereda de Window e implementa INotifyPropertyChanged
    public partial class MainWindow : Window, INotifyPropertyChanged
    {
        // Colección observable de tareas
        public ObservableCollection<TaskModel> Tasks { get; set; }

        // Constructor de la clase MainWindow
        public MainWindow()
        {
            InitializeComponent();

            // Inicializa la colección de tareas con algunos valores predeterminados
            Tasks = new ObservableCollection<TaskModel>
            {
                new TaskModel { Name = "Hacer la compra", IsCompleted = false },
                new TaskModel { Name = "Llamar al médico", IsCompleted = true },
                new TaskModel { Name = "Estudiar WPF", IsCompleted = false }
            };

            // Establece el contexto de datos de la ventana como esta instancia de MainWindow
            DataContext = this;
        }

        // Evento para la notificación de cambios en las propiedades
        public event PropertyChangedEventHandler PropertyChanged;

        // Método para invocar el evento PropertyChanged
        protected virtual void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}