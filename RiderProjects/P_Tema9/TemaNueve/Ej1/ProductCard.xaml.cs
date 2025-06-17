using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;

namespace Ej1
{
    public partial class ProductCard : UserControl
    {
        public static readonly DependencyProperty ProductNameProperty =
            DependencyProperty.Register(
                nameof(ProductName),
                typeof(string),
                typeof(ProductCard),
                new PropertyMetadata(""));

        public string ProductName
        {
            get => (string)GetValue(ProductNameProperty);
            set => SetValue(ProductNameProperty, value);
        }

        public static readonly DependencyProperty PriceProperty =
            DependencyProperty.Register(
                nameof(Price),
                typeof(string),
                typeof(ProductCard),
                new PropertyMetadata(""));

        public string Price
        {
            get => (string)GetValue(PriceProperty);
            set => SetValue(PriceProperty, value);
        }

        public static readonly DependencyProperty ImageSourceProperty =
            DependencyProperty.Register(
                nameof(ImageSource),
                typeof(ImageSource),
                typeof(ProductCard),
                new PropertyMetadata(null));

        public ImageSource ImageSource
        {
            get => (ImageSource)GetValue(ImageSourceProperty);
            set => SetValue(ImageSourceProperty, value);
        }

        public ProductCard()
        {
            InitializeComponent();
        }
    }
}