using System.Windows;
using System.Windows.Controls;

namespace Practica_1
{
    public partial class ProductCard : UserControl
    {
        // Definición de la propiedad de dependencia ProductName
        public static readonly DependencyProperty ProductNameProperty =
            DependencyProperty.Register("ProductName", typeof(string), typeof(ProductCard), new PropertyMetadata(string.Empty));

        // Propiedad CLR para ProductName
        public string ProductName
        {
            get { return (string)GetValue(ProductNameProperty); }
            set { SetValue(ProductNameProperty, value); }
        }

        // Definición de la propiedad de dependencia Price
        public static readonly DependencyProperty PriceProperty =
            DependencyProperty.Register("Price", typeof(double), typeof(ProductCard), new PropertyMetadata(0.0));

        // Propiedad CLR para Price
        public double Price
        {
            get { return (double)GetValue(PriceProperty); }
            set { SetValue(PriceProperty, value); }
        }

        // Definición de la propiedad de dependencia ImageSource
        public static readonly DependencyProperty ImageSourceProperty =
            DependencyProperty.Register("ImageSource", typeof(string), typeof(ProductCard), new PropertyMetadata(string.Empty));

        // Propiedad CLR para ImageSource
        public string ImageSource
        {
            get { return (string)GetValue(ImageSourceProperty); }
            set { SetValue(ImageSourceProperty, value); }
        }

        // Definición de la propiedad de dependencia Description
        public static readonly DependencyProperty DescriptionProperty =
            DependencyProperty.Register("Description", typeof(string), typeof(ProductCard), new PropertyMetadata(string.Empty));

        // Propiedad CLR para Description
        public string Description
        {
            get { return (string)GetValue(DescriptionProperty); }
            set { SetValue(DescriptionProperty, value); }
        }

        // Constructor que inicializa los componentes
        public ProductCard()
        {
            InitializeComponent();
        }
    }
}