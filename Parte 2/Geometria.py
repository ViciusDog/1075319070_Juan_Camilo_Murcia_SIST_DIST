# Parte2/figura_geometrica.py
from abc import ABC, abstractmethod

class FiguraGeometrica(ABC):
    @abstractmethod
    def calcular_area(self):
        pass

# Parte2/cuadrado.py
from figura_Geometrica import FiguraGeometrica

class Cuadrado(FiguraGeometrica):
    def __init__(self, lado):
        self.lado = lado

    def calcular_area(self):
        return self.lado ** 2

# Parte2/triangulo.py
from figura_Geometrica import FiguraGeometrica

class Triangulo(FiguraGeometrica):
    def __init__(self, base, altura):
        self.base = base
        self.altura = altura

    def calcular_area(self):
        return (self.base * self.altura) / 2

# Parte2/circunferencia.py
from figura_Geometrica import FiguraGeometrica

class Circunferencia(FiguraGeometrica):
    def __init__(self, radio):
        self.radio = radio

    def calcular_area(self):
        return 3.14 * (self.radio ** 2)



