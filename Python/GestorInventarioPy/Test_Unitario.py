import unittest
import os
from Gestoy_Inventario import cargar_inventario, calcular_valor_total, productos_agotados, actualizar_cantidad, agregar_producto

class TestInventario(unittest.TestCase):

    def setUp(self):
        # Crear un archivo de inventario temporal para las pruebas
        self.inventario_file = "inventario_test.txt"
        self.inventario_data = [
            "Portátil,799.99,10",
            "Teléfono,299.99,5",
            "Tablet,499.99,0",
            "Auriculares,59.99,15",
            "Monitor,199.99,8"
        ]
        with open(self.inventario_file, 'w') as f:
            f.write("\n".join(self.inventario_data))
        # Redefinir la ruta del archivo de inventario en el módulo
        global INVENTARIO_FILE
        INVENTARIO_FILE = self.inventario_file

    def tearDown(self):
        # Eliminar el archivo de inventario temporal después de las pruebas
        if os.path.exists(self.inventario_file):
            os.remove(self.inventario_file)

    def test_cargar_inventario(self):
        inventario = cargar_inventario()
        self.assertEqual(len(inventario), 5)
        self.assertEqual(inventario[0]['nombre'], "Portátil")
        self.assertEqual(inventario[0]['precio'], 799.99)
        self.assertEqual(inventario[0]['cantidad'], 10)

    def test_calcular_valor_total(self):
        inventario = cargar_inventario()
        valor_total = calcular_valor_total(inventario)
        self.assertAlmostEqual(valor_total, 799.99*10 + 299.99*5 + 499.99*0 + 59.99*15 + 199.99*8)

    def test_productos_agotados(self):
        inventario = cargar_inventario()
        agotados = productos_agotados(inventario)
        self.assertIn("Tablet", agotados)
        self.assertNotIn("Portátil", agotados)

    def test_actualizar_cantidad(self):
        inventario = cargar_inventario()
        actualizar_cantidad(inventario, "Teléfono", 10)
        self.assertEqual(inventario[1]['cantidad'], 10)
        actualizar_cantidad(inventario, "Tablet", 5)
        self.assertEqual(inventario[2]['cantidad'], 5)

    def test_agregar_producto(self):
        inventario = cargar_inventario()
        agregar_producto(inventario, "Impresora", 150.00, 3)
        self.assertEqual(len(inventario), 6)
        self.assertEqual(inventario[-1]['nombre'], "Impresora")
        self.assertEqual(inventario[-1]['precio'], 150.00)
        self.assertEqual(inventario[-1]['cantidad'], 3)

if __name__ == "__main__":
    unittest.main()