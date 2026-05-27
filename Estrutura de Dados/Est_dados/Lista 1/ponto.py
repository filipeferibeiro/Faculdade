class PontoEspacial:
    def __init__(self,x,y):
        self.x = x
        self.y = y

    def InserirValor (self, x, y):
        self.x = x
        self.y = y

    def ConsultarValor(self):
        print("(" + str(self.x) + "," + str(self.y) + ")")
