def IsPerfect(number):
    if number <= 1:
        return False
        
    sumOfDivisibles = 0
    
    # Can go up to only half the number
    # If the number isn't divisible by 2 it won't be divisible by 4.
    for i in range(1, round(number / 2) + 1):
        if number % i == 0:
            sumOfDivisibles += i

    return sumOfDivisibles == number 

# Verifies if the user option is valid:
# Valid = 'S', 's', 'N' or 'n'
def IsValidUserOption(userOption):
    lowerCaseUserOption = userOption.lower()
    return lowerCaseUserOption == "s" or lowerCaseUserOption == "n"

# Entry point of the application
while True:
    numberCount = 0
    
    while numberCount < 1:
        numberCount = int(input("Quantos números inteiros você vai digitar? "))
    
    numbers = []
    
    for i in range(0, numberCount):
        number = int(input(f"Número {i + 1}: "))
        # Terminates the program if number is negative
        if number < 0:
            break
        
        numbers.append(number)
        
    for number in numbers:
        if IsPerfect(number):
            print(f"{number} é perfeito!")
        else:
            print(f"{number} não é perfeito!")
            
    print()
    
    # Gets a valid User Option
    userOption = ""
    while not IsValidUserOption(userOption):
        print("Deseja continuar? ('S' ou 'N')")
        userOption = input()
        
    if (userOption.lower() == 'n'):
        break
    
    print()