# Sadi de Moura Lemes Júnior

# Soma dois valores positivos
def somaPositivos(x: int, y: int) -> int:
    if x < 0 or y < 0:
        return -1
    
    return x + y

# Divide dois valores
def divide(x: int, y: int) -> float:
    if y == 0:
        print("não é possível dividir por 0")
        return 0
    
    return x / y

# Retorna o tipo do triângulo a partir de seus lados
def verificaTriangulo(x: int, y: int, z: int) -> str:
    if x <= 0 or y <= 0 or z <= 0:
        return "triângulo inválido"

    lados = [x, y, z]

    if x + y > z and x + z > y and y + z > x:
        # Se todos os lados forem iguais
        if all(lado == lados[0] for lado in lados):
            return "equilátero"
        # Se todos os lados forem diferentes
        if all(lados.count(lado) == 1 for lado in lados):
            return "escaleno"
        else:
            return "isósceles"

# Retorna a classificação de uma idade
def verificaIdade(age: int) -> str:
    if age < 0:
        return "erro, menor que zero"
    elif 0 <= age <= 12:
        return "criança"
    elif 13 <= age <= 18:
        return "adolescente"
    elif 19 <= age <= 120:
        return "adulto"
    else:
        return "erro, maior que 120"

# Retorna o estado de uma sinaleira a partir de sua cor
def sinaleira(color: str) -> str:
    if color == "verde":
        return "aberta"
    elif color == "amarelo":
        return "atenção"
    elif color == "vermelho":
        return "fechada"
    else:
        return "erro"

# Conta números de x até 300
def contador(x: int):
    for i in range(x, 300):
        print(i)

# Acha o maior número entre três
def achaMaior(x: int, y: int, z: int):
    greater = x
    values = [y, z]

    for value in values:
        if value > greater:
            greater = value

    print(f"maior número: {greater}")

# Imprime os valores pares entre 0 e x
def imprimePares(x: int):
    for i in range(0, x):
        if i % 2 == 0:
            print(i)

# Função para pegar x números inteiros do usuário
# Objetivo dela é evitar a repetição de código
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
    print("selecione a operação que você deseja realizar:")
    print()
    print("1. soma positivos")
    print("2. divide")
    print("3. verifica triângulo")
    print("4. verifica idade")
    print("5. sinaleira")
    print("6. conta até 300")
    print("7. acha maior")
    print("8. imprime pares")
    print()

    option = int(input())

    match option:
        case 1:
            print("1. soma positivos")
            valoresSoma = getIntegers(2)
            soma = somaPositivos(valoresSoma[0], valoresSoma[1])
            print(f"soma: {soma}")

        case 2:
            print("2. divide")
            valoresDivisao = getIntegers(2)
            divisao = divide(valoresDivisao[0], valoresDivisao[1])
            print(f"divisão: {divisao}")

        case 3:
            print("3. verifica triângulo")
            valoresTriangulo = getIntegers(3)
            triangulo = verificaTriangulo(valoresTriangulo[0], valoresTriangulo[1], valoresTriangulo[2])
            print(f"tipo do triângulo: {triangulo}")

        case 4:
            print("4. verifica idade")
            idade = int(input("idade: "))
            classificacaoIdade = verificaIdade(idade)
            print(f"classificacao da idade: {classificacaoIdade}")

        case 5:
            print("5. sinaleira")
            cor = input("cor: ")
            estadoSinaleira = sinaleira(cor)
            print(f"estado da sinaleira: {estadoSinaleira}")

        case 6:
            print("6. conta até 300")
            valorContador = int(input("valor: "))
            contador(valorContador)

        case 7:
            print("7. acha maior")
            valores = getIntegers(3)
            achaMaior(valores[0], valores[1], valores[2])

        case 8:
            print("8. imprime pares")
            valor = int(input("valor: "))
            imprimePares(valor)

        case _:
            print("opção invalida.")
            break
    
    print()

print("encerrando a aplicação")