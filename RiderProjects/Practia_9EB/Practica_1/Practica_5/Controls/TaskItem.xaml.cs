using System.Windows;
using System.Windows.Controls;

namespace Practica_5.Controls
{
    // Definición parcial de la clase TaskItem que hereda de UserControl
    public partial class TaskItem : UserControl
    {
        // Propiedad de dependencia para el Nombre de la tarea
        public string TaskName
        {
            get => (string)GetValue(TaskNameProperty);
            set => SetValue(TaskNameProperty, value);
        }

        public static readonly DependencyProperty TaskNameProperty =
            DependencyProperty.Register(nameof(TaskName), typeof(string), typeof(TaskItem), new PropertyMetadata(""));

        // Propiedad de dependencia para el Estado completado
        public bool IsCompleted
        {
            get => (bool)GetValue(IsCompletedProperty);
            set => SetValue(IsCompletedProperty, value);
        }

        public static readonly DependencyProperty IsCompletedProperty =
            DependencyProperty.Register(nameof(IsCompleted), typeof(bool), typeof(TaskItem), new PropertyMetadata(false));

        // Constructor de la clase TaskItem
        public TaskItem()
        {
            InitializeComponent();
        }
    }
}