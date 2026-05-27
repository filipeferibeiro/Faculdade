from veiculo import *

dicionario = {}

while True:
    nome = input('Informe o nome do veículo: ')
    marca = input('Informe a marca do veículo: ')
    placa = input('Informe a placa do veículo: ').upper()
    if placa not in dicionario:
        add_veiculo = veiculo(nome, marca, placa)
        dicionario[placa] = add_veiculo
    else:
        print('Esse veículo já está cadastrado!')

    parada = input('Deseja parar?(s ou n) ')

    if parada == 's':
        print(dicionario)
        break
