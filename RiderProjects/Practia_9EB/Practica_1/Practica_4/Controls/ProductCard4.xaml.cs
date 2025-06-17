using System.Windows;
using System.Windows.Controls;

namespace Practica_4.Controls
{
    // Definición parcial de la clase ProductCard que hereda de UserControl
    public partial class ProductCard : UserControl
    {
        // Registro de propiedades de dependencia para Name, Price e ImagePath
        public static readonly DependencyProperty NameProperty =
            DependencyProperty.Register("Name", typeof(string), typeof(ProductCard));

        public static readonly DependencyProperty PriceProperty =
            DependencyProperty.Register("Price", typeof(string), typeof(ProductCard));

        public static readonly DependencyProperty ImagePathProperty =
            DependencyProperty.Register("ImagePath", typeof(string), typeof(ProductCard));

        // Propiedad Name con métodos get y set
        public string Name
        {
            get { return (string)GetValue(NameProperty); }
            set { SetValue(NameProperty, value); }
        }

        // Propiedad Price con métodos get y set
        public string Price
        {
            get { return (string)GetValue(PriceProperty); }
            set { SetValue(PriceProperty, value); }
        }

        // Propiedad ImagePath con métodos get y set
        public string ImagePath
        {
            get { return (string)GetValue(ImagePathProperty); }
            set { SetValue(ImagePathProperty, value); }
        }

        // Constructor de la clase ProductCard
        public ProductCard()
        {
            InitializeComponent();
            // Establece el contexto de datos del control como esta instancia de ProductCard
            DataContext = this;
        }
    }
}