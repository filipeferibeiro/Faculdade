#include <stdio.h>

int numerosEmComum (int vet1[], int vet2[]) {
    int cont = 0;
    for (int i = 0; i < 5; i++){
        for (int j = 0; j < 5; j++) {
            if (vet1[i] == vet2[j]) {
                cont += 1;
            }
        }
    }

    return cont;
}

int main() {
    int a [5] = {1, 2, 3, 4, 5};
    int b [5] = {1, 4, 5, 8, 10};

    printf("Quantidade de números em comum: %d", numerosEmComum(a,b));
    return 0;
}