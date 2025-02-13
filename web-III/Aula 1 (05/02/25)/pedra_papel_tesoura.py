import random

x = random.randint(1, 3)

if x == 1:
    pc = "pedra"
elif x == 2:
    pc = "papel"
else:
    pc = "tesoura"

y = input("Escolha pedra, papel ou tesoura: ").lower()

if y == pc:
    print(f"Empate! Ambos escolheram {y}.")
elif (y == "pedra" and pc == "tesoura") or \
    (y == "papel" and pc == "pedra") or \
    (y == "tesoura" and pc == "papel"):
    print(f"Voce ganhou! O computador escolheu {pc}.")
else:
    print(f"Voce perdeu! O computador escolheu {pc}.")