import os

# Ruta del archivo de inventario
INVENTARIO_FILE = "inventario.txt"

# Función 1: Cargar el inventario desde el archivo
def cargar_inventario():
    if not os.path.exists(INVENTARIO_FILE):
        # Si no existe el archivo, se crea con datos predeterminados
        inventario_predeterminado = [
            "Portátil,799.99,10",
            "Teléfono,299.99,5",
            "Tablet,499.99,0",
            "Auriculares,59.99,15",
            "Monitor,199.99,8"
        ]
        with open(INVENTARIO_FILE, 'w') as f:
            f.write("\n".join(inventario_predeterminado))
    # Leer los datos del archivo
    inventario = []
    with open(INVENTARIO_FILE, 'r') as f:
        for linea in f.readlines():
            nombre, precio, cantidad = linea.strip().split(',')
            inventario.append({"nombre": nombre, "precio": float(precio), "cantidad": int(cantidad)})
    return inventario

# Función 2: Mostrar el inventario
def mostrar_inventario(inventario):
    print("Inventario actual:")
    print("=" * 30)
    for producto in inventario:
        print(f"Nombre: {producto['nombre']}, Precio: ${producto['precio']:.2f}, Cantidad: {producto['cantidad']}")
    print("=" * 30)

# Función 3: Calcular el valor total del inventario
def calcular_valor_total(inventario):
    valor_total = sum(producto['precio'] * producto['cantidad'] for producto in inventario)
    return valor_total

# Función 4: Identificar productos agotados
def productos_agotados(inventario):
    agotados = tuple(producto['nombre'] for producto in inventario if producto['cantidad'] == 0)
    return agotados

# Función 5: Actualizar cantidad de un producto
def actualizar_cantidad(inventario, nombre_producto, nueva_cantidad):
    producto_encontrado = False
    for producto in inventario:
        if producto['nombre'].lower() == nombre_producto.lower():
            producto['cantidad'] = nueva_cantidad
            producto_encontrado = True
            break
    if producto_encontrado:
        # Guardar los cambios en el archivo
        with open(INVENTARIO_FILE, 'w') as f:
            for producto in inventario:
                f.write(f"{producto['nombre']},{producto['precio']},{producto['cantidad']}\n")
        print(f"Cantidad de '{nombre_producto}' actualizada a {nueva_cantidad}.")
    else:
        print(f"Producto '{nombre_producto}' no encontrado en el inventario.")
    return producto_encontrado

# Función 6: Agregar un nuevo producto al inventario
def agregar_producto(inventario, nombre_producto, precio_producto, cantidad_producto):
    inventario.append({"nombre": nombre_producto, "precio": float(precio_producto), "cantidad": int(cantidad_producto)})
    # Guardar el nuevo producto en el archivo
    with open(INVENTARIO_FILE, 'w') as f:
        for producto in inventario:
            f.write(f"{producto['nombre']},{producto['precio']},{producto['cantidad']}\n")
    print(f"Producto '{nombre_producto}' agregado al inventario.")

# Menú principal
def menu_principal():
    inventario = cargar_inventario()
    while True:
        print("\n--- Menú de Gestión del Inventario ---")
        print("1. Mostrar Inventario")
        print("2. Calcular Valor Total del Inventario")
        print("3. Identificar Productos Agotados")
        print("4. Actualizar Cantidad de un Producto")
        print("5. Agregar Producto al Inventario")
        print("6. Salir")
        opcion = input("Seleccione una opción (1-6): ")

        if opcion == "1":
            mostrar_inventario(inventario)
        elif opcion == "2":
            valor_total = calcular_valor_total(inventario)
            print(f"El valor total del inventario es: ${valor_total:.2f}")
        elif opcion == "3":
            agotados = productos_agotados(inventario)
            if agotados:
                print("Productos agotados:", ", ".join(agotados))
            else:
                print("No hay productos agotados.")
        elif opcion == "4":
            nombre = input("Ingrese el nombre del producto: ")
            try:
                nueva_cantidad = int(input("Ingrese la nueva cantidad: "))
                actualizar_cantidad(inventario, nombre, nueva_cantidad)
            except ValueError:
                print("Cantidad inválida. Introduzca un número.")
        elif opcion == "5":
            nombre = input("Ingrese el nombre del nuevo producto: ")
            try:
                precio = float(input("Ingrese el precio del nuevo producto: "))
                cantidad = int(input("Ingrese la cantidad del nuevo producto: "))
                agregar_producto(inventario, nombre, precio, cantidad)
            except ValueError:
                print("Precio o cantidad inválidos. Introduzca números válidos.")
        elif opcion == "6":
            print("Saliendo del programa. ¡Hasta luego!")
            break
        else:
            print("Opción no válida. Por favor, intente de nuevo.")

# Inicia el programa
if __name__ == "__main__":
    menu_principal()