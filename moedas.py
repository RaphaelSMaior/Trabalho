import random
from datetime import datetime, timedelta

# Função para gerar uma data aleatória entre inicio e fim
def data_aleatoria(inicio, fim):
    delta = fim - inicio
    random_days = random.randint(0, delta.days)
    return inicio + timedelta(days=random_days)

# Defina o intervalo de tempo
inicio = datetime.now()-timedelta(days=70)
fim = datetime.now()

# Gere uma lista de datas aleatórias
num_datas = random.randint(1000,2000)  # Número de datas a serem geradas
print(num_datas)
random_dates = [data_aleatoria(inicio, fim).strftime('%Y-%m-%d') for _ in range(num_datas)]
random_dates.sort()

# Salve a lista de datas em um arquivo txt
with open('listamoedas.txt', 'w') as file:
    for date in random_dates:
        file.write(date + '\n')

print("Lista de datas aleatórias gerada e salva em listamoedas.txt.")