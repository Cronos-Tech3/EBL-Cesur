import math

# 1. Crear una variable con el valor de π
pi = math.pi

# 2. Pedir el valor del radio al usuario
radio = float(input("Introduce el valor del radio del círculo: "))

# 3. Calcular el perímetro y almacenarlo en una variable
perimetro = 2 * pi * radio

# 4. Calcular el área y almacenarlo en una variable
area = pi * radio ** 2

# 5. Mostrar en pantalla el valor de las variables de perímetro y área
print("El perímetro del círculo es:", perimetro)
print("El área del círculo es:", area)