using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Windows;

namespace Practica_4
{
    // Definición parcial de la clase MainWindow que hereda de Window e implementa INotifyPropertyChanged
    public partial class MainWindow : Window, INotifyPropertyChanged
    {
        // Colección observable de productos
        public ObservableCollection<Product> Products { get; set; }

        // Campo privado para el producto seleccionado
        private Product _selectedProduct;

        // Propiedad pública para el producto seleccionado con notificación de cambios
        public Product SelectedProduct
        {
            get => _selectedProduct;
            set
            {
                _selectedProduct = value;
                OnPropertyChanged(nameof(SelectedProduct));
            }
        }

        // Constructor de la clase MainWindow
        public MainWindow()
        {
            InitializeComponent();

            // Inicializa la colección de productos con algunos valores predeterminados
            Products = new ObservableCollection<Product>
            {
                new Product { Name = "Laptop", Price = "999 €", ImagePath="C:\\Users\\Nitropc\\OneDrive - Cesur-GCoremsa\\Asignaturas\\DISEÑO DE INTERFACES\\Tema 9\\Practica_1\\Practica_4\\Images\\Laptop.jpg" },
                new Product { Name = "Mouse", Price = "25 €", ImagePath="C:\\Users\\Nitropc\\OneDrive - Cesur-GCoremsa\\Asignaturas\\DISEÑO DE INTERFACES\\Tema 9\\Practica_1\\Practica_4\\Images\\mouse.webp" },
                new Product { Name = "Keyboard", Price = "49 €", ImagePath="C:\\Users\\Nitropc\\OneDrive - Cesur-GCoremsa\\Asignaturas\\DISEÑO DE INTERFACES\\Tema 9\\Practica_1\\Practica_4\\Images\\Keyboard.webp" }
            };

            // Establece el primer producto como el producto seleccionado por defecto
            SelectedProduct = Products[0];

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

    // Definición de la clase Product
    public class Product
    {
        public string Name { get; set; }
        public string Price { get; set; }
        public string ImageSource { get; set; }
        public string ImagePath { get; set; }
    }
}
