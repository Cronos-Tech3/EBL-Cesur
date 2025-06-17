using System.Collections.ObjectModel;
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

namespace Practica_2;

/// <summary>
/// Interaction logic for MainWindow.xaml
/// </summary>
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

public class Product
{
}
