class pessoa:
    def __init__(self,nome,ano_nas,email):
        self.nome = nome
        self.ano_nas = ano_nas
        self.email = email

    def n_nome(self,novo_nome):
        self.nome = novo_nome

    def n_ano(self, novo_ano_nas):
        self.ano_nas = novo_ano_nas

    def n_email(self,novo_email):
        self.email = novo_email

    def obterIdade(self):
        print('A idade é de: ' + str(2017 - self.ano_nas) + " anos.")