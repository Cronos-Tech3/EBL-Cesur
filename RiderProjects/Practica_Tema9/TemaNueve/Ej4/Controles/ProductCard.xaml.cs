using System;
using System.ComponentModel.DataAnnotations;
using System.Runtime.InteropServices.JavaScript;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Media.Imaging;

namespace Ej4
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

        private static void OnImageSourceChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
        {
            if (d is ProductCard card && e.NewValue is string imagePath)
            {
                try
                {
                    var bitmap = new BitmapImage();
                    bitmap.BeginInit();
                    bitmap.UriSource = new Uri(imagePath, UriKind.RelativeOrAbsolute);
                    bitmap.EndInit();
                    card.ProductImage.Source = bitmap;
                }
                catch (Exception exception)
                {
                    Console.WriteLine($"Error al cargar la imagen: {exception.Message}");
                }
            }
            
        }

        public ProductCard()
        {
            InitializeComponent();
        }
    }
}