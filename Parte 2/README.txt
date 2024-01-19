README

Parte 1:

En el diseño del sistema de figuras geométricas, se han aplicado los principios SOLID de la siguiente manera:

Principio de Abierto/Cerrado (OCP):
La clase base FiguraGeometrica contiene atributos comunes y un método abstracto para calcular el área. Se asegura que la clase sea cerrada para modificaciones, pero abierta para extensiones. Al crear clases derivadas para cada figura específica (cuadrado, triángulo, circunferencia), se puede hacer la extensión sin necesidad de modificar la clase base, cumpliendo con el OCP.

Principio de Responsabilidad Única (SRP):
Cada clase derivada (cuadrado, triángulo, circunferencia) se enfoca en calcular su área, cumpliendo con el SRP. Cada clase tiene la responsabilidad única de proporcionar la lógica para calcular el área de esa figura particular.




Parte 3:


Proposito de la clase base FiguraGeometrica:
- La clase base FiguraGeometrica proporciona una estructura comun para las clases derivadas, con atributos
y un metodo abstracto para calcular el area. Contribuye al principio de Abierto/Cerrado (OCP) permitiendo la extension mediante la creacion de nuevas clases sin modificar la clase base.
- Aplicacion del Principio de Responsabilidad Unica (SRP)
- En cada clase derivada (Cuadrado, Triangulo, Circunferencia), el SRP se cumple al tener la responsabilidad unica de calcular el area especifica de esa figura. Haciendo que no se mezcle la logica de otras operaciones y pues demas funciones a estas clases.
- Agregar una nueva figura geometrica (hexagono) siguiendo OCP:
- Para agregar un hexagono, se crearia una nueva clase Hexagono que herede de FiguraGeometrica.
Esto sigue el principio de Abierto?Cerrado (ocp) al extender el sistema sin modificar la clase base. La nueva 
clase implemntaria el metodo calcular_area especifico para el hexagono.


