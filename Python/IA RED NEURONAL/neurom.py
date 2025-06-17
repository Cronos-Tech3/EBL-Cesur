import numpy as np 





class Neuron:
    def __init__(self, n_input):  # def es funcion y vamos a inicializar una serie de atributos
        self.weight = np.random.randn(n_input)  # atributo los pesos
        self.bias = np.random.randn()
        self.output = 0
        self.inputs = None
        self.dweight = np.zeros_like(self.weight)
        self.dbias = 0

    def activate(self, x):  # funcion de activacion que la vamos a entrenar para ir hacia delante y hacia atras
        return 1 / (1 + np.exp(-1))

    def derivate_activate(self, x):  # la derivada la vamos a necesitar para actualizar y devolver los pesos hacia atras
        return x * (1 - x)
    

    def forward(self, inputs):
        self.inputs = inputs
        weighted_sum = np.dot(inputs, self.weight) + self.bias
        self.output = self.activate(weighted_sum)
        return self.output
    
if __name__ == "__main__":
    neuron = Neuron(3)
    inputs = np.array([1, 2, 3])
    output = neuron.forward(inputs)

    print("Neuron output:", output)

