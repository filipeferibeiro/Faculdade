#include <stdio.h>

void quantLetras (char palavra[], int vet[]) {
    char maiusculas [] = {"ABCDEFGHIJKLMNOPQRSTUVWXYZ"};
    char minusculas [] = {"abcdefghijklmnopqrstuvwxyz"};

    vet[0] = 0;
    vet[1] = 0;
    vet[2] = 0;

    int tam = 0;

    for (int i = 0; i < 200; i++) {
        if (palavra[i] != '\0'){
            tam += 1;
        }
        else {
            break;
        }
    }

    for (int i = 0; i < tam; i++) {
        for (int j = 0; j < 26; j++) {
            if (maiusculas[j] == palavra[i]) {
                vet[0] += 1;
            }
            else if (minusculas[j] == palavra[i]) {
                vet[1] += 1;
            }
        }
        if (palavra[i] == ' ') {
            vet[2] += 1;
        }
    }
}

int main() {
    char frase[200];
    int vet[3];

    printf("Informe uma frase: ");
    scanf("%[^\n]s", frase);

    quantLetras(frase, vet);

    printf("Essa frase tem %d letras Maiusculas, %d letras Minusculas e %d espaços.", vet[0], vet[1], vet[2]);


    return 0;
}