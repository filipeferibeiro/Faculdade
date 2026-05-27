#include <stdio.h>
#include <memory.h>

//Letra A
typedef struct Imovel {
    char bairro [20];
    double preco, tamanhoPrivativo;
    int vagas;
    char tipo [12];
};

void main() {
    //Variáveis
    char tipo [12];
    int selecao;
    //Letra B
    struct Imovel vetor_imovel [5];
    
    //Adicionar Imovéis
    strcpy(vetor_imovel[0].bairro, "Malvinas");
    vetor_imovel[0].preco = 220000;
    vetor_imovel[0].tamanhoPrivativo = 22.5;
    vetor_imovel[0].vagas = 1;
    strcpy(vetor_imovel[0].tipo, "Apartamento");

    strcpy(vetor_imovel[1].bairro, "Catolé");
    vetor_imovel[1].preco = 230000;
    vetor_imovel[1].tamanhoPrivativo = 23.3;
    vetor_imovel[1].vagas = 2;
    strcpy(vetor_imovel[1].tipo, "Casa");

    strcpy(vetor_imovel[2].bairro, "Liberdade");
    vetor_imovel[2].preco = 300500;
    vetor_imovel[2].tamanhoPrivativo = 34.8;
    vetor_imovel[2].vagas = 3;
    strcpy(vetor_imovel[2].tipo, "Casa");

    strcpy(vetor_imovel[3].bairro, "Malvinas");
    vetor_imovel[3].preco = 110000;
    vetor_imovel[3].tamanhoPrivativo = 15.2;
    vetor_imovel[3].vagas = 0;
    strcpy(vetor_imovel[3].tipo, "Apartamento");

    strcpy(vetor_imovel[4].bairro, "Centro");
    vetor_imovel[4].preco = 80000;
    vetor_imovel[4].tamanhoPrivativo = 12.9;
    vetor_imovel[4].vagas = 1;
    strcpy(vetor_imovel[4].tipo, "Apartamento");
    

    //Letra C
    printf("Letra C\n");
    for (int i = 0; i < sizeof(vetor_imovel) / sizeof(struct Imovel); i++) {
        printf("Bairro: %s\nPreço: R$%0.2f\nTamanho Privativo: %0.1f\n"
                       "Vagas: %d\nTipo: %s\n\n", vetor_imovel[i].bairro,
               vetor_imovel[i].preco, vetor_imovel[i].tamanhoPrivativo, vetor_imovel[i].vagas,
               vetor_imovel[i].tipo);
    }

    //Letra D
    printf("Letra D\n");
    printf("Informe o indice do imóvel: ");
    scanf("%d", &selecao);
    strcpy(tipo, vetor_imovel[selecao].tipo);
    printf("Tipo: %s\n\n", tipo);

    //Letra E
    printf("Letra E\n");
    for (int i = 0; i < sizeof(vetor_imovel) / sizeof(struct Imovel); i++) {
        printf("Tipo: %s\nBairro: %s\nPreço: R$%0.2f\n\n", vetor_imovel[i].tipo, vetor_imovel[i].bairro,
               vetor_imovel[i].preco);
    }


}