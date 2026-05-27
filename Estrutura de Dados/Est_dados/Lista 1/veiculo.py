class veiculo:
    def __init__(self, nome, marca ,placa):
        self.nome = nome
        self.marca = marca
        self.placa = placa

    def novo_nome(self, n_nome):
        self.nome = n_nome
    def nova_marca(self, n_marca):
        self.marca = n_marca
    def nova_placa(self, n_placa):
        self.placa = n_placa

    def vei(self):
        veicu = 'Veículo: %s, %s, %s' %(self.nome, self.marca, self.placa)
        return veicu