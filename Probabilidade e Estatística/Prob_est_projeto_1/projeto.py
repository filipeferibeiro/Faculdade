'''Projeto de Probabilidad e estatística aplicada a programação.
Aluno: Filipe Fernandes Ribeiro
Curso: Engenharia de Computação'''

'''Imports'''
from pandas import *
from matplotlib.pyplot import *
'''Funções'''
def linhas_f(linhas):
    for i in range(172):
        linhas.append(i)
'''Variáveis'''
linhas_extras = []
linhas_f(linhas_extras)
c_label = ['Data', 'Brasil', 'Ceará', 'Minas Gerais', 'Paraná', 'Rio de Janeiro']
dados = read_csv('data.csv', header=None, skiprows=linhas_extras, usecols=[0, 1, 2, 4, 5, 6], names=c_label)
'''Código'''
while True:
    print('Selecione uma opção: \n'
          'A - Brasil\n'
          'B- Ceará\n'
          'C- Minas Gerais\n'
          'D- Paraná\n'
          'E- Rio de Janeiro\n'
          'F- Histograma\n'
          'G- Boxplots\n'
          'H- Finalizar Programa')
    opcao = input('Escolha: ').upper()
    if opcao == 'A':
        print('BRASIL\n'
              ' Média: ' + str(dados['Brasil'].mean()) + '\n'
              ' Moda: \n' + str(dados['Brasil'].mode()) + '\n'
              ' Mediana: ' + str(dados['Brasil'].median()) + '\n'
              ' Amplitude: ' + str(dados['Brasil'].max() - dados['Brasil'].min()) + '\n'
              ' Desvio Absoluto: ' + str(dados['Brasil'].mad()) + '\n'
              ' Variância: ', dados['Brasil'].var(), '\n'
              ' Desvio Padrão: ', dados['Brasil'].std(), '\n'
              ' Quatis: \n'
              '  Q1 = ', dados['Brasil'].quantile(q=0.25), '\n'
              '  Q2 = ', dados['Brasil'].quantile(), '\n'
              '  Q3 = ', dados['Brasil'].quantile(q=0.75), '\n')
    elif opcao == 'B':
        print('CEARÁ\n'
              ' Média: ' + str(dados['Ceará'].mean()) + '\n'
              ' Moda: \n' + str(dados['Ceará'].mode()) + '\n'
              ' Mediana: ' + str(dados['Ceará'].median()) + '\n'
              ' Amplitude: ' + str(dados['Ceará'].max() - dados['Ceará'].min()) + '\n'
              ' Desvio Absoluto: ' + str(dados['Ceará'].mad()) + '\n'
              ' Variância: ', dados['Ceará'].var(), '\n'
              ' Desvio Padrão: ', dados['Ceará'].std(), '\n'
              ' Quatis: \n'
              '  Q1 = ', dados['Ceará'].quantile(q=0.25), '\n'
              '  Q2 = ', dados['Ceará'].quantile(), '\n'
              '  Q3 = ', dados['Ceará'].quantile(q=0.75), '\n')
    elif opcao == 'C':
        print('MINAS GERAIS\n'
              ' Média: ' + str(dados['Minas Gerais'].mean()) + '\n'
              ' Moda: \n' + str(dados['Minas Gerais'].mode()) + '\n'
              ' Mediana: ' + str(dados['Minas Gerais'].median()) + '\n'
              ' Amplitude: ' + str(dados['Minas Gerais'].max() - dados['Minas Gerais'].min()) + '\n'
              ' Desvio Absoluto: ' + str(dados['Minas Gerais'].mad()) + '\n'
              ' Variância: ', dados['Minas Gerais'].var(), '\n'
              ' Desvio Padrão: ', dados['Minas Gerais'].std(), '\n'
              ' Quatis: \n'
              '  Q1 = ', dados['Minas Gerais'].quantile(q=0.25), '\n'
              '  Q2 = ', dados['Minas Gerais'].quantile(), '\n'
              '  Q3 = ', dados['Minas Gerais'].quantile(q=0.75), '\n')
    elif opcao == 'D':
        print('PARANÁ\n'
              ' Média: ' + str(dados['Paraná'].mean()) + '\n'
              ' Moda: \n' + str(dados['Paraná'].mode()) + '\n'
              ' Mediana: ' + str(dados['Paraná'].median()) + '\n'
              ' Amplitude: ' + str(dados['Paraná'].max() - dados['Paraná'].min()) + '\n'
              ' Desvio Absoluto: ' + str(dados['Paraná'].mad()) + '\n'
              ' Variância: ', dados['Paraná'].var(), '\n'
              ' Desvio Padrão: ', dados['Paraná'].std(), '\n'
              ' Quatis: \n'
              '  Q1 = ', dados['Paraná'].quantile(q=0.25), '\n'
              '  Q2 = ', dados['Paraná'].quantile(), '\n'
              '  Q3 = ', dados['Paraná'].quantile(q=0.75), '\n')
    elif opcao == 'E':
        print('RIO DE JANEIRO\n'
              ' Média: ' + str(dados['Rio de Janeiro'].mean()) + '\n'
              ' Moda: \n' + str(dados['Rio de Janeiro'].mode()) + '\n'
              ' Mediana: ' + str(dados['Rio de Janeiro'].median()) + '\n'
              ' Amplitude: ' + str(dados['Rio de Janeiro'].max() - dados['Rio de Janeiro'].min()) + '\n'
              ' Desvio Absoluto: ' + str(dados['Rio de Janeiro'].mad()) + '\n'
              ' Variância: ', dados['Rio de Janeiro'].var(), '\n'
              ' Desvio Padrão: ', dados['Rio de Janeiro'].std(), '\n'
              ' Quatis: \n'
              '  Q1 = ', dados['Rio de Janeiro'].quantile(q=0.25), '\n'
              '  Q2 = ', dados['Rio de Janeiro'].quantile(), '\n'
              '  Q3 = ', dados['Rio de Janeiro'].quantile(q=0.75), '\n')
    elif opcao == 'F':
        dados.hist(grid=False)
        show()
    elif opcao == 'G':
        dados.boxplot(grid = False)
        show()
    elif opcao == 'H':
        break