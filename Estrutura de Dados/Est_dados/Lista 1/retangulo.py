class retangulo:
    def __init__(self,Xa,Ya,Xb,Yb,Xc,Yc,Xd,Yd):
        self.Xa = Xa
        self.Ya = Ya
        self.Xb = Xb
        self.Yb = Yb
        self.Xc = Xc
        self.Yc = Yc
        self.Xd = Xd
        self.Yd = Yd
    def area(self):
        AB = str(self.Xb - self.Xa)
        if AB[0] == "-":
            AB = int(AB[1])
        else:
            AB = int(AB)
        CD = str(self.Xd - self.Xc)
        if CD[0] == "-":
            CD = int(CD[1])
        else:
            CD = int(CD)
        AC = str(self.Yc - self.Ya)
        if AC[0] == "-":
            AC = int(AC[1])
        else:
            AC = int(AC)
        BD = str(self.Yd - self.Yb)
        if BD[0] == "-":
            BD = int(BD[1])
        else:
            BD = int(BD)

        if AB != CD or AC != BD:
            print("Isso não é um retângulo!")
        else:
            print("A área desse retângulo é de: " + str(AB*AC) + "m².")
    def quadrado(self):
        AB = str(self.Xb - self.Xa)
        if AB[0] == "-":
            AB = int(AB[1])
        else:
            AB = int(AB)
        CD = str(self.Xd - self.Xc)
        if CD[0] == "-":
            CD = int(CD[1])
        else:
            CD = int(CD)
        AC = str(self.Yc - self.Ya)
        if AC[0] == "-":
            AC = int(AC[1])
        else:
            AC = int(AC)
        BD = str(self.Yd - self.Yb)
        if BD[0] == "-":
            BD = int(BD[1])
        else:
            BD = int(BD)

        if AB == AC and CD == BD:
            print("Isso é um quadrado!")
        else:
            print("Isso é um retângulo!")
