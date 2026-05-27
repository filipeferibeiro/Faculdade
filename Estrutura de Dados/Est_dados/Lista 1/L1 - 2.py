from retangulo import *

coordenadasA = input("Diga as coordenadas xy de A: ")
cooXA = int(coordenadasA[0])
cooYA = int(coordenadasA[1])
coordenadasB = input("Diga as coordenadas xy de B: ")
cooXB = int(coordenadasB[0])
cooYB = int(coordenadasB[1])
coordenadasC = input("Diga as coordenadas xy de C: ")
cooXC = int(coordenadasC[0])
cooYC = int(coordenadasC[1])
coordenadasD = input("Diga as coordenadas xy de D: ")
cooXD = int(coordenadasD[0])
cooYD = int(coordenadasD[1])

Pont = retangulo(cooXA,cooYA,cooXB,cooYB,cooXC,cooYC,cooXD,cooYD)
Pont.area()
Pont.quadrado()