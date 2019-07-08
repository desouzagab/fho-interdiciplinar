#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXCHAR 1000

typedef struct {
	int codigo;
	char nome[50];
	float preco;
	
} produto;

produto lista[1000];    

int tamanho = 0;

int procuraproduto(int busca) {

    int i = 0;
    int achou = 0;
    produto prod;

    for (i = 0; i < tamanho-1; i++) {

        int cod = lista[i].codigo;
        if (cod == busca) {
            prod = lista[i];
            achou = 1;
            break;
        }
    } 

    // grava o retorno ...
    char str[MAXCHAR];

    FILE *arqret;
    arqret = fopen("retorno.txt", "w");

    if (achou == 1) {

        printf("achou");
        printf("%s\n",prod.nome);

        char cod[10];
        char nome[50];
	    char pco[12];

        strncpy(str, "", 1);
        itoa(prod.codigo, cod, 10);
        gcvt(prod.preco, 3, pco); 

        strcat(str, cod);
        strcat(str,";");

        strcat(str, prod.nome);
        strcat(str,";");

        strcat(str, pco);
        strcat(str,";");

        strcat(str, "\n");

    } 
    else 
    {
        printf("nao achou");
        strncpy(str, "SEMCADASTRO", 50);
    }
    
    fprintf(arqret,str);
    fclose(arqret);
}

int learquivo () {

    FILE *arq;
    char str[MAXCHAR];
    produto prod;
    
    int posicao = 0;

    if ((arq = fopen("produtos.txt", "r")) == NULL) {
        printf("Nao foi possivel abrir o arquivo de entrada!\n");
        return 0;
    }

    while (fgets(str, MAXCHAR, arq) != NULL) {
        
        if (str == NULL) break;

        tamanho++;

        char *p = strtok (str, ";");

        int i = 0;
        char *array[3];

        while (p != NULL)
        {
            array[i++] = p;
            p = strtok (NULL, ";");
        }

        size_t n = sizeof(array);
        
        for (i = 0; i < 3; ++i) {
            if (i == 0){
                lista[posicao].codigo = atoi(array[i]);
            } else if (i == 1) {
                strncpy(lista[posicao].nome, array[i], 50);
            } else {
                lista[posicao].preco = atof(array[i]);
                posicao++;
            }
        }
        
    }

   
    fclose(arq);
}

int escrevearquivo () {

    FILE *arq;
    arq = fopen("produtos.txt", "w");

    int i = 0;
    
    char cod[10];
	char nome[50];
	char pco[12];
    char str[MAXCHAR];

    for (i = 0; i < tamanho; ++i) {

        // limpa a string
        strncpy(str, "", 1);
        
        // converte inteiro para string
        itoa(lista[i].codigo, cod, 10);
        
        // convert float para string
        gcvt(lista[i].preco, 3, pco); 

        // concatena para a string que vai gravar no arquivo
        strcat(str, cod);
        strcat(str,";");

        // concatena nome com a string que vai gravar no arquivo
        strcat(str, lista[i].nome);
        strcat(str,";");

        // concatena com o preco
        strcat(str, pco);
        strcat(str,";");

        // salto de linha
        strcat(str, "\n");

        // grava no arquivo
        fprintf(arq,str);
    }

    fclose(arq);

    return 0;
}

void ordenaprodutos() {
	
	produto aux;
    int i;
    int j;
    
    for (i = 0; i < tamanho; i++) {
        
        for (j = 0; j < tamanho; j++) {
            int compara = strcmp(lista[i].nome, lista[j].nome);
            
            if (compara < 0) {
                aux = lista[i];
                lista[i] = lista[j];
                lista[j] = aux;
            }
        }
    } 
}

int main (int argc, char **argv){

	learquivo();

    printf("%s",argv[1]);
    if (argc > 1) {
        if (strcmp(argv[1], "ordena")  == 0) {
            ordenaprodutos();
            escrevearquivo();
        } 
        if (strcmp(argv[1], "pesquisa")  == 0) {
            if (argc == 3) {
                int busca = atoi(argv[2]);
                procuraproduto(busca);
            }
        }
    }
}
