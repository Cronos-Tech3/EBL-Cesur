# Definir la tupla de asignaturas
asignaturas = ("Matemáticas", "Ciencias", "Historia")

# FUNCIÓN AGREGAR DATOS ESTUDIANTE
def ingresar_estudiante():

    # Validar el nombre
    '''
    Utilizamos un bucle while para pedir el nombre del estudiante
    hasta que el usuario ingrese un nombre no vacío (nombre.strip()
    elimina los espacios en blanco).
    Si el nombre está vacío,
    mostramos un mensaje de error y solicitamos nuevamente.
    '''
    while True:
        nombre = input("Introduce el nombre del estudiante: ")
        if nombre.strip():
            break
        else:
            print("El nombre no puede estar vacío. Por favor, inténtalo de nuevo.")

    # Validar la edad
    '''
    Utilizamos un bucle while y try-except para pedir la edad del estudiante hasta
    que el usuario ingrese un número entero positivo. Si la entrada no es válida
    (por ejemplo, si el usuario ingresa texto en lugar de un número), 
    se muestra un mensaje de error y se solicita nuevamente
    '''
    while True:
        try:
            edad = int(input("Introduce la edad del estudiante: "))
            if edad > 0:
                break
            else:
                print("La edad debe ser un número entero positivo. Por favor, inténtalo de nuevo.")
        except ValueError:
            print("Entrada inválida. Por favor, introduce un número entero.")

    # Creación del diccionario Calificaciones
    calificaciones = {}

    #Iteramos sobre cada una de las asignaturas
    '''
    Creamos un diccionario vacío llamado calificaciones para almacenar las calificaciones de las asignaturas.
     Iteramos sobre cada asignatura en la tupla asignaturas y utilizamos un bucle while y try-except para pedir
      la calificación de cada asignatura hasta que el usuario ingrese un número decimal entre 0 y 10. 
      Si la entrada no es válida, se muestra un mensaje de error y se solicita nuevamente.'''
    for asignatura in asignaturas:
        while True:
            try:
                calificacion = float(input(f"Introduce la calificación en {asignatura} (0-10): "))
                if 0 <= calificacion <= 10:
                    calificaciones[asignatura] = calificacion
                    break
                else:
                    print("La calificación debe estar entre 0 y 10. Por favor, inténtalo de nuevo.")
            except ValueError:
                print("Entrada inválida. Por favor, introduce un número decimal.")

    #Retornamos un diccionario que contiene el nombre del estudiante, la edad y el diccionario de calificaciones.
    return {"nombre": nombre, "edad": edad, "calificaciones": calificaciones}

#FUNCIÓN PARA EXPONER LOS DATOS DEL ESTUDIANTE
def mostrar_estudiante(estudiante):
    print("-------------------------------------------")
    print(f"Nombre: {estudiante['nombre']}")
    print(f"Edad: {estudiante['edad']}")
    for asignatura, calificacion in estudiante['calificaciones'].items():
        print(f"Calificación en {asignatura}: {calificacion}")
    promedio = sum(estudiante['calificaciones'].values()) / len(asignaturas)
    print(f"Promedio de calificaciones: {promedio}")
    print("-------------------------------------------")

# Programa principal
'''
Utilizamos una lista por comprensión para llamar a la función ingresar_estudiante() tres veces y almacenar 
los diccionarios retornados en una lista llamada estudiantes.
'''
estudiantes = [ingresar_estudiante() for _ in range(3)]
'''
Iteramos sobre la lista estudiantes y para cada estudiante en la lista, llamamos a la 
función mostrar_estudiante(estudiante) para mostrar la información del estudiante.
'''
for estudiante in estudiantes:
    mostrar_estudiante(estudiante)