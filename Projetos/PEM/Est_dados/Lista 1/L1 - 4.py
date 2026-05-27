from pessoa import *

nome = input("Informe seu nome: ")
ano_nas = int(input("Informe seu ano de nascimento: "))
email = input("Informe seu e-mail: ")

pess = pessoa(nome,ano_nas,email)
print(pess.nome,pess.ano_nas, pess.email)
pess.obterIdade()

pess.n_nome("João")
pess.n_ano(1971)
pess.n_email("joaozezin@gmail.com")

pess.obterIdade()
print(pess.nome,pess.ano_nas, pess.email)