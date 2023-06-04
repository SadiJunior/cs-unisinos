from math import sqrt, pow

# Sadi de Moura Lemes Júnior

# Verifies if the given triangle is valid
def verifyTriangle(a: int, b: int, c: int):
    isValidTriangle = \
        abs(b - c) < a < (b + c) and \
        abs(a - c) < b < (a + c) and \
        abs(a - b) < c < (a + b)

    if not isValidTriangle:
        print("Não é um triângulo")
        return
    
    triangleSides = [a, b, c]

    # If all sides are the same
    if all(side == triangleSides[0] for side in triangleSides):
        print("Equilátero")
    # If all sides are different
    elif all(triangleSides.count(side) == 1 for side in triangleSides):
        print("Escaleno")
    else:
        print("Isósceles")

# Calculates the given quadratic equation
def calculateQuadraticEquation(a: int, b: int, c: int):
     if a == 0:
         print("Não é uma equação quadrática")
         return
     
     delta = pow(b, 2) - 4 * a * c

     if delta < 0:
         print("A equação não possui raízes reais")
     elif delta == 0:
         onlyRoot = -b / (2 * a)
         print(f"A equação possui uma raíz real: {onlyRoot}")
     else:
         root1 = (-b + sqrt(delta)) / (2 * a)
         root2 = (-b - sqrt(delta)) / (2 * a)
         print(f"A equação possui duas raízes:")
         print(f"Raíz 1: {root1}")
         print(f"Raíz 2: {root2}")

# Verifies if the given date is valid
def verifyDate(month: int, day: int):
    dayCount = 0

    match month:
        case _ if month in [1, 3, 5, 7, 8, 10, 12]:
            dayCount = 31

        case 2:
            dayCount = 28

        case _ if month in [4, 6, 9, 11]:
            dayCount = 30

        case _:
            print("Mês inválido")
            return
        
    if day > dayCount:
        print("Dia inválido")
    else:
        print("Data válida")

# Verifies the text length
def verifyTextLength(text: str):
    textLength = len(text)

    if textLength < 5:
        print("Texto pequeno")
    elif 5 <= textLength < 15:
        print("Texto médio")
    elif 15 <= textLength < 20:
        print("Texto grande")
    else:
        print("Texto inválido")

# Verifies the given CPF
def verifyCPF(cpf: str):
    if len(cpf) != 11 or not cpf.isdigit():
        print("CPF Inválido")
    else:
        print("CPF válido")

# Counts the number of some chars in the given text
def countChars(text: str):
    lowerText = text.lower()

    vowels = "aeiou"
    consonants = 'bcdfgjklmnpqrstvwxz'

    # This may not be the most effective way to do this, as it goes through the whole text everytime
    vowelCount = 0
    for vowel in vowels:
        vowelCount += lowerText.count(vowel)
    
    spaceCount = lowerText.count(" ")

    consonantCount = 0
    for consonant in consonants:
        consonantCount += lowerText.count(consonant)

    print(f"Número de vogais: {vowelCount}")
    print(f"Número de espaços: {spaceCount}")
    print(f"Número de consoantes: {consonantCount}")

# Gets n integers
def getIntegers(numberOfIntegers: int) -> list[int]:
    if numberOfIntegers <= 0:
        return []
    
    integers = []

    for i in range(1, numberOfIntegers + 1):
        value = int(input(f"valor {i}: "))
        integers.append(value)

    return integers

# Entry point
while True:
    print()
    print("Olá Fulano.")
    print("Digite a opção desejada:")
    print("1) Verificar triângulo")
    print("2) Calcular equação do segundo grau")
    print("3) Conferir data")
    print("4) Verificar tamanho do texto")
    print("5) Analisar CPF")
    print("6) Contar caracteres")
    print("7) Sair")
    print()

    userOption = int(input())

    match userOption:
        case 1:
            print("1) Verificar triângulo")
            triangleSides = getIntegers(3)
            verifyTriangle(triangleSides[0], triangleSides[1], triangleSides[2])

        case 2:
            print("2) Calcular equação do segundo grau")
            secondEquationValues = getIntegers(3)
            calculateQuadraticEquation(secondEquationValues[0], secondEquationValues[1], secondEquationValues[2])

        case 3:
            print("3) Conferir data")
            month = int(input("Mês: "))
            day = int(input("Dia: "))
            verifyDate(month, day)

        case 4:
            print("4) Verificar tamanho do texto")
            text = input("Text: ")
            verifyTextLength(text)

        case 5:
            print("5) Analisar CPF")
            cpf = input()
            verifyCPF(cpf)

        case 6:
            print("6) Contar caracteres")
            text = input("Text: ")
            countChars(text)

        case 7:
            print("7) Sair")
            break

        case _:
            print("Comando inválido")
            break

print("Encerrando a aplicação")