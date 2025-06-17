using System.Collections.ObjectModel;
using System.Windows;

namespace Ej2;

public partial class MainWindow : Window
{
    public ObservableCollection<Product> Products { get; set; }

    public MainWindow()
    {
        InitializeComponent();
        Products = new ObservableCollection<Product>
        {
            new Product { Name = "Producto 1", Price = 10.0m },
            new Product { Name = "Producto 2", Price = 20.0m }
        };
        DataContext = this;
    }
}