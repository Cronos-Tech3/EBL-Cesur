def suma_tres_numeros(numero1, numero2, numero3):
    # Sumar los tres números y devolver el resultado
    resultado = numero1 + numero2 + numero3
    return resultado

# Ejemplo de uso de la función
num1 = float(input("Introduce el primer número: "))
num2 = float(input("Introduce el segundo número: "))
num3 = float(input("Introduce el tercer número: "))

# Llamar a la función y mostrar el resultado
resultado = suma_tres_numeros(num1, num2, num3)
print("El resultado de la suma es:", resultado)

