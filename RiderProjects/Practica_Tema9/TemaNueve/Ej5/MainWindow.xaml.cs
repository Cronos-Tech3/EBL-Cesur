using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Windows;
using Ej5.Modelo;

namespace Ej5
{
    public partial class MainWindow : Window, INotifyPropertyChanged
    {
        public ObservableCollection<TaskModel> Tasks { get; set; }

        public MainWindow()
        {
            InitializeComponent();

            Tasks = new ObservableCollection<TaskModel>
            {
                new TaskModel { Name = "Hacer la compra", IsCompleted = false },
                new TaskModel { Name = "Llamar al médico", IsCompleted = true },
                new TaskModel { Name = "Estudiar WPF", IsCompleted = false }
            };

            DataContext = this;
        }

        public event PropertyChangedEventHandler PropertyChanged;
        protected virtual void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}