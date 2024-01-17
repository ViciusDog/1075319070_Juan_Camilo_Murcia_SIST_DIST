import random

# Generar una lista de números del 1 al 1000 en desorden
numeros_desordenados = random.sample(range(1, 10000001), 10000000)

# Imprimir la lista desordenada
print("Lista desordenada:", numeros_desordenados)

# Aplicar la función sort() para ordenar la lista
numeros_desordenados.sort()

# Imprimir la lista ordenada
print("Lista ordenada con sort():", numeros_desordenados)
