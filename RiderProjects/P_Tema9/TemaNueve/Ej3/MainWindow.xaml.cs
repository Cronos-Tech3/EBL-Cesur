using System;
using System.Windows;
using System.Windows.Input;

namespace Ej3
{
    public partial class MainWindow : Window
    {
        public ICommand ButtonClickCommand { get; }
        
        public MainWindow()
        {
            InitializeComponent();
            ButtonClickCommand = new RelayCommand(ExecuteButtonClick);
            DataContext = this;
        }

        private void ExecuteButtonClick(object parameter)
        {
            MessageBox.Show("Hiciste Click", "Información", MessageBoxButton.OK, MessageBoxImage.Information);
        }
        
        public class RelayCommand : ICommand
        {
            private readonly Action<object> _execute;
            private readonly Predicate<object> _canExecute;

            public RelayCommand(Action<object> execute, Predicate<object> canExecute = null)
            {
                _execute = execute ?? throw new ArgumentNullException(nameof(execute));
                _canExecute = canExecute;
            }
            
            public bool CanExecute(object parameter) => _canExecute == null || _canExecute(parameter);
            
            public void Execute(object parameter) => _execute(parameter);
            
            public event EventHandler CanExecuteChanged
            {
                add => CommandManager.RequerySuggested += value; 
                remove => CommandManager.RequerySuggested -= value;
            }
        }
    }
}

