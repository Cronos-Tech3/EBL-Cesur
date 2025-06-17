using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Windows;

namespace Ej4
{
    public partial class MainWindow : Window, INotifyPropertyChanged
    {
        // Colección observable de productos
        public ObservableCollection<Product> Products { get; set; }

        // Producto seleccionado con notificación de cambios
        private Product _selectedProduct;
        public Product SelectedProduct
        {
            get => _selectedProduct;
            set
            {
                _selectedProduct = value;
                OnPropertyChanged(nameof(SelectedProduct));
            }
        }

        // Constructor de la ventana
        public MainWindow()
        {
            InitializeComponent();

            Products = new ObservableCollection<Product>
            {
                new Product { Name = "portatil", Price = "$899", ImageSource = "Imagen/Portatil.jpg "},
                new Product { Name = "raton", Price = "$15", ImageSource = "Imagen/Raton.png" },
                new Product { Name = "teclado", Price = "$45", ImageSource = "Imagen/Teclado.png" }
            };

            SelectedProduct = Products[0]; // Primer producto seleccionado por defecto

            DataContext = this; // Vincular datos a la vista
        }

        // Evento para notificar cambios en propiedades
        public event PropertyChangedEventHandler PropertyChanged;
        protected virtual void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }

    // Clase Product como modelo
    public class Product
    {
        public string Name { get; set; }
        public string Price { get; set; }
        public string ImageSource { get; set; }
    }
}