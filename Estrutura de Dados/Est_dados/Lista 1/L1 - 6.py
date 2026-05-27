from pessoa import *

lista = []

while True:
    nome = input('Informe o nome da pessoa: ')
    ano = int(input('Informe o ano de nascimento: '))
    email = input('Informe o e-mail: ')
    pess = pessoa(nome,ano,email)
    lista.append(pess)
    parada = input('Deseja parar?(s ou n) ')
    if parada == 's':
        for i in range(len(lista)):
            print(lista[i].nome,lista[i].ano_nas,lista[i].email)
            lista[i].obterIdade()
        print("Fim.")
        break