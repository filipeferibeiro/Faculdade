#include <stdio.h>
#include <memory.h>

struct Usuario {
    char nome[30];
    char login[10];
    char senha[10];
};

int main() {
    char login_param[10];
    char senha_param[10];
    struct Usuario u1;
    struct Usuario u2;
    strcpy(u1.nome, "Filipe Fernandes");
    strcpy(u1.login, "filipe22z");
    strcpy(u1.senha, "h23ed");

    strcpy(u2.nome, "Clara Delfino");
    strcpy(u2.login, "claradx6");
    strcpy(u2.senha, "lkn8y");


    printf("Sistema de Login\n");
    printf("Login: ");
    scanf("%s", login_param);
    printf("Senha: ");
    scanf("%s", senha_param);

    if (strcmp(login_param, u1.login) == 0 || strcmp(login_param, u2.login) == 0) {
        if (strcmp(login_param, u1.login) == 0) {
            if (strcmp(senha_param, u1.senha) == 0) {
                printf("Seja bem-vindo %s.", u1.nome);
            }
            else {
                printf("Senha incorreta para %s", login_param);
            }
        }
        else if (strcmp(login_param, u2.login) == 0) {
            if (strcmp(senha_param, u2.senha) == 0) {
                printf("Seja bem-vindo %s.", u2.nome);
            }
            else {
                printf("Senha incorreta para %s", login_param);
            }
        }
    }
    else {
        printf("Usuário não cadastrado!");
    }

    return 0;
}