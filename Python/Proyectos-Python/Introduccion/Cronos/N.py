import numpy as np


class Neuron:
    def __init__(self, n_input):
        self.weight = np.random.randn(n_input)  # Inicializa los pesos con valores aleatorios
        self.bias = np.random.randn()  # Inicializa el sesgo con un valor aleatorio
        self.output = 0  # Inicializa la salida de la neurona
        self.input = None  # Inicializa la entrada de la neurona

        # Derivadas
        self.dweight = np.zeros_like(self.weight)  # Inicializa las derivadas de los pesos
        self.dbias = 0  # Inicializa la derivada del sesgo

    def activate(self, x):
        return 1 / (1 + np.exp(-x))  # Función de activación sigmoide

    def derivate_activate(self, x):
        return self.output * (1 - self.output)  # Derivada de la función de activación sigmoide

    def forward(self, inputs):
        self.input = inputs  # Guarda la entrada actual
        weighted_sum = np.dot(inputs, self.weight) + self.bias  # Calcula la suma ponderada de las entradas
        self.output = self.activate(weighted_sum)  # Aplica la función de activación
        return self.output  # Devuelve la salida de la neurona

    def backward(self, d_output, learning_rate):
        d_activation = d_output * self.derivate_activate(self.output)  # Calcula la derivada de la activación
        self.dweight = np.dot(self.input.T, d_activation)  # Calcula la derivada de los pesos
        self.dbias = np.sum(d_activation, axis=0)  # Calcula la derivada del sesgo
        d_input = np.dot(d_activation, self.weight.T)  # Calcula la derivada de la entrada
        self.weight -= learning_rate * self.dweight  # Actualiza los pesos
        self.bias -= learning_rate * self.dbias  # Actualiza el sesgo
        return d_input  # Devuelve la derivada de la entrada


if __name__ == "__main__":
    neuron = Neuron(3)  # Crea una neurona con 3 entradas
    inputs = np.array([1, 2, 3])  # Define las entradas
    output = neuron.forward(inputs)  # Calcula la salida de la neurona

    print("Neuron output before training:", output)  # Imprime la salida antes del entrenamiento

    # Entrenamiento simple
    target_output = 0.5  # Define la salida objetivo
    learning_rate = 0.1  # Define la tasa de aprendizaje

    for i in range(200):  # Realiza 200 iteraciones de entrenamiento
        output = neuron.forward(inputs)  # Calcula la salida de la neurona
        error = target_output - output  # Calcula el error
        d_output = -2 * error  # Calcula la derivada del error (para descenso de gradiente)
        neuron.backward(d_output, learning_rate)  # Actualiza los pesos y el sesgo

    output = neuron.forward(inputs)  # Calcula la salida de la neurona después del entrenamiento
    print("Neuron output after training:", output)  # Imprime la salida después del entrenamiento