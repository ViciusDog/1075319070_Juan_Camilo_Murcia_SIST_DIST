import random

def bubble_sort(arr):
    n = len(arr)
    
    for i in range(n):
        for j in range(0, n-i-1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]

# Generar una lista de números del 1 al 1000, 10.000, 100.000 1.000.000.000 en desorden
numeros_desordenados = random.sample(range(1, 1001), 1000)

# Imprimir la lista desordenada
print("Lista desordenada:", numeros_desordenados)

# Aplicar el método de burbuja para ordenar la lista
bubble_sort(numeros_desordenados)

# Imprimir la lista ordenada
print("Lista ordenada con burbuja:", numeros_desordenados)


