# Verifies if the given audiencies are always increasing
def IsAudiencyAlwaysIncreasing(audiencies):
    highestAudiency = -1
    
    for audiency in audiencies:
        if (audiency < highestAudiency):
            return False
        else:
            highestAudiency = audiency

    return True

# Verifies if the user option is valid:
# Valid = 'S', 's', 'N' or 'n'
def IsValidUserOption(userOption):
    lowerCaseUserOption = userOption.lower()
    return lowerCaseUserOption == "s" or lowerCaseUserOption == "n"

# Entry point of the application
while True:
    # Gets a valid audiency count
    audiencyCount = 0
    while audiencyCount < 2:
        print("Digite a quantidade de índices de audiência serão digitados: ")
        audiencyCount = int(input())
        
    audiencies = []
        
    for i in range(0, audiencyCount):
        # Gets a valid audiency
        audiency = -1
        while (audiency < 0):
            audiency = float(input(f"Audiência {i + 1}: "))
            
        audiencies.append(audiency)
        
    if (IsAudiencyAlwaysIncreasing(audiencies)):
        print("AUDIÊNCIA SEMPRE CRESCENTE.")
    else:
        print("AUDIÊNCIA NEM SEMPRE CRESCENTE.")
    
    average = sum(audiencies) / audiencyCount
    
    print(f"Média de audiência: {round(average, 1):.1f}")
    
    print()
    
    # Gets a valid User Option
    userOption = ""
    while not IsValidUserOption(userOption):
        print("Deseja continuar? ('S' ou 'N')")
        userOption = input()
        
    if userOption.lower() == 'n':
        break
    
    print()