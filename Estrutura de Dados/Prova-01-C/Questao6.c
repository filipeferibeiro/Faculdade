//
// Created by Clara on 12/07/2017.
//
#include <stdio.h>


typedef struct {
    char matricula[10];
    char nome[50];

    union num{
        int idade;
        char cpf[12];
    }idade,cpf;

}Empregado;


int main(){
    Empregado p[3];
    int contador; //variável de controle do loop
    for(contador = 0; contador < 3; contador++)
    {
        printf("Matricula: ");
        scanf("%s", p[contador].matricula);
        if(p[contador].matricula[0]=='1' && p[contador].matricula[1]=='2' && p[contador].matricula[2]=='3'){
            printf("Idade: ");
            scanf("%s", &p[contador].idade);
        }
        else{
                printf("CPF: ");
                scanf("%s",&p[contador].cpf);
            }
        }/

    int j;
    for (j=0; j<3; j++){
        printf("Matricula: %s", p[j].matricula);
        if(p[j].matricula[0]=='1' && p[j].matricula[1]=='2' && p[j].matricula[2]=='3'){
            printf("\nIdade: %s\n", &p[j].idade);
        }
        else{
            printf("\nCPF: %s\n", &p[j].cpf);
        }
    }
    return 0;
}