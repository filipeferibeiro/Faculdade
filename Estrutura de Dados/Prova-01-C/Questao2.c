#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main() {
 int cLetra = 0, aux = 0, pLetra = 0, C1 = 0, C2 = 0, C3 = 0;
 int i, j;
 char palavraTemp[50], maiorPalavra[50], texto[200];
 
 printf("\nDigite o texto: ");
 scanf(" %[^\n]s", &texto);
 
 for(i=0; i <= strlen(texto); i++)  {
  	if (texto[i]!= ' ' && texto[i]!='\0')  {
  		cLetra ++;
  		palavraTemp[pLetra] = texto[i];
  		pLetra++;
	}
   else  {
     if(cLetra > 0 && cLetra <= 3)	 {
   	 	C1 ++;
	 }
	 
     if(cLetra > 3 && cLetra <= 6)   {
    	C2 ++;
	 }
	 
	   if(cLetra > 7)  {
   	 	C3 ++;
	 }
	 
   	 if (cLetra > aux)
   	 {
   	 	aux = cLetra;
   	 	strcpy(maiorPalavra, palavraTemp);
        pLetra=0; 
	 }
     
	 for(j = 0; j < strlen(palavraTemp); j++)
	  {
	  	 palavraTemp[j]=' ';
	  }
   	 cLetra = 0;
   }
 	  
  }
 printf("Maior palavra: %s\n", maiorPalavra);
 printf("Classe das palavras             Frequência\n" 
        "    0---3                           %d\n"
        "    4---6                           %d\n"
        "    7 ou mais                       %d", C1, C2, C3);
	
}
