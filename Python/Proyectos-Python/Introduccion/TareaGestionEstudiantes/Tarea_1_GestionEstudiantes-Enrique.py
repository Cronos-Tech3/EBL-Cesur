"""
@author: Enrique
@date: 2025-03-17
@description: Sistema de Gestión de Estudiantes, Agrega Nombre, Edad, Notas y saca Promedio.
"""

# Definir la tupla de asignaturas

asignaturas = ("Matemáticas", "Ciencias", "Historia")

def ingresar_estudiante():
    # Solicitar datos del estudiante
    nombre = input("Introduce el nombre del estudiante: ")

    # Solicitud al usuario "edad" y conversión del dato introducido a un entero
    edad = int(input("Introduce la edad del estudiante: "))

    #Creación de diccionaro para almacenar las calificaciones
    calificaciones = {}

    #iteracion sobre cada asignatura
    for asignatura in asignaturas:

        #Solicitamos al usuario introduzca la calificación de la asignatura y se convertimos la entrada
        # a un numero decimal con float()
        calificacion = float(input(f"Introduce la calificación en {asignatura}: "))

        #Almacenamiento de la calificaicón en el diccionario usando el nombre de la asignatura como clave
        calificaciones[asignatura] = calificacion


    # Retornar diccionario con la información del estudiante
    return {"nombre": nombre, "edad": edad, "calificaciones": calificaciones}

# Definición de la función para exponer los datos del estudiante
def mostrar_estudiante(estudiante):

    # Mostrar datos del estudiante
    print(f"Nombre: {estudiante['nombre']}")
    print(f"Edad: {estudiante['edad']}")

    #Iteración sobre el dicionario de calificaciones del estudiante
    for asignatura, calificacion in estudiante['calificaciones'].items():

        #Exponemos la asignatura y su calificaicón
        print(f"Calificación en {asignatura}: {calificacion}")

    # Calculo y exposición del promedio
    #Se suman todas los valores del doccionario calificaciones y dividimos por el numero de las asignaturas
    promedio = sum(estudiante['calificaciones'].values()) / len(asignaturas)

    #Exponemos el promedio de las calificaciones
    print(f"Promedio de calificaciones: {promedio}")

# Programa principal
#llamamos a la función ingresar_estudiante() tres veces utilizando una lista por comprensión.
# Esto nos permite obtener los datos de tres estudiantes y almacenarlos en una lista llamada estudiantes.
estudiantes = [ingresar_estudiante() for _ in range(3)]

#Iteramos sobre la lista de estudiantes
for estudiante in estudiantes:
    #Para cada estudiante en la lista, llamamos a la función mostrar_estudiante(estudiante) para mostrar la información del estudiante.
    mostrar_estudiante(estudiante)