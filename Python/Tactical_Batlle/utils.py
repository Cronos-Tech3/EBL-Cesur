import os
import platform

def limpiar_terminal():
    """Limpia la pantalla de la terminal."""
    if platform.system() == "Windows":
        os.system('cls')
    else:
        os.system('clear')

def validar_celda(celda, max_col, max_fila):
    """
    Valida si una celda está dentro de los límites del tablero.

    Args:
        celda (str): La celda a validar (p.ej., "A1").
        max_col (int): Máxima columna (p.ej., 4 para D).
        max_fila (int): Máxima fila (p.ej., 4).

    Returns:
        bool: True si la celda es válida, False en caso contrario.
    """
    if len(celda) != 2:
        return False
    col = ord(celda[0].upper()) - ord('A')
    fila = int(celda[1]) - 1
    return 0 <= col < max_col and 0 <= fila < max_fila

def comprobar_celda_disponible(celda, ocupadas):
    """
    Comprueba si una celda ya está ocupada.

    Args:
        celda (str): La celda a comprobar.
        ocupadas (list): Lista de celdas ocupadas.

    Returns:
        bool: True si la celda está disponible, False en caso contrario.
    """
    return celda not in ocupadas

def validar_celda_contigua(celda1, celda2):
    """
    Comprueba si dos celdas son adyacentes.

    Args:
        celda1 (str): La primera celda.
        celda2 (str): La segunda celda.

    Returns:
        bool: True si las celdas son adyacentes, False en caso contrario.
    """
    col1 = ord(celda1[0].upper()) - ord('A')
    fila1 = int(celda1[1]) - 1
    col2 = ord(celda2[0].upper()) - ord('A')
    fila2 = int(celda2[1]) - 1

    return abs(col1 - col2) <= 1 and abs(fila1 - fila2) <= 1 and (col1 != col2 or fila1 != fila2)