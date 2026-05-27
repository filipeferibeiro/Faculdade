from ponto import *

coordenadas = input("Diga as coordenadas xy: ")
cooX = int(coordenadas[0])
cooY = int(coordenadas[1])

PE = PontoEspacial(cooX,cooY)
PE.ConsultarValor()
PE.InserirValor(3,7)
PE.ConsultarValor()