def validarDato(tipo, rango=None):
    while True:
        try:
            if tipo == "texto":
                dato = input("Ingrese un texto: ")
                break
            elif tipo == "entero":
                dato = int(input("Ingrese un número entero: "))
                break
            elif tipo == "entero_rango":
                dato = int(input(f"Ingrese un número entero en el rango {rango}: "))
                if dato >= rango[0] and dato <= rango[1]:
                    break
                else:
                    print(f"Por favor, ingrese un número en el rango {rango}.")
            elif tipo == "entero_positivo":
                dato = int(input("Ingrese un número entero positivo (excluyendo 0): "))
                if dato > 0:
                    break
                else:
                    print("Por favor, ingrese un número entero positivo.")
            elif tipo == "entero_negativo":
                dato = int(input("Ingrese un número entero negativo (excluyendo 0): "))
                if dato < 0:
                    break
                else:
                    print("Por favor, ingrese un número entero negativo.")
            elif tipo == "decimal":
                dato = float(input("Ingrese un número decimal: "))
                break
            elif tipo == "decimal_rango":
                dato = float(input(f"Ingrese un número decimal en el rango {rango}: "))
                if dato >= rango[0] and dato <= rango[1]:
                    break
                else:
                    print(f"Por favor, ingrese un número en el rango {rango}.")
            elif tipo == "decimal_positivo":
                dato = float(input("Ingrese un número decimal positivo (excluyendo 0): "))
                if dato > 0:
                    break
                else:
                    print("Por favor, ingrese un número decimal positivo.")
            elif tipo == "decimal_negativo":
                dato = float(input("Ingrese un número decimal negativo (excluyendo 0): "))
                if dato < 0:
                    break
                else:
                    print("Por favor, ingrese un número decimal negativo.")
            else:
                print("Tipo de dato no válido. Por favor, elija un tipo válido.")
        except ValueError:
            print("Error: Ingrese un valor válido.")

# Ejemplos de uso:

# Texto
texto = validarDato("texto")
print("Texto ingresado:", texto)

# Número entero
entero = validarDato("entero")
print("Número entero ingresado:", entero)

# Número entero en un rango
entero_rango = validarDato("entero_rango", rango=(1, 10))
print("Número entero en el rango ingresado:", entero_rango)

# Número entero positivo
entero_positivo = validarDato("entero_positivo")
print("Número entero positivo ingresado:", entero_positivo)

# Número entero negativo
entero_negativo = validarDato("entero_negativo")
print("Número entero negativo ingresado:", entero_negativo)

# Número decimal
decimal = validarDato("decimal")
print("Número decimal ingresado:", decimal)

# Número decimal en un rango
decimal_rango = validarDato("decimal_rango", rango=(0.1, 5.0))
print("Número decimal en el rango ingresado:", decimal_rango)

# Número decimal positivo
decimal_positivo = validarDato("decimal_positivo")
print("Número decimal positivo ingresado:", decimal_positivo)

# Número decimal negativo
decimal_negativo = validarDato("decimal_negativo")
print("Número decimal negativo ingresado:", decimal_negativo)



