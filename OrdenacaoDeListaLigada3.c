#include <stdio.h>
#include <stdlib.h>

struct no{
       int dado;
       struct no *proximo;       
};

typedef struct no No;
void inserirNovoNo(No **ptrParaPtrPrimeiroNo, No **ptrParaPtrUltimoNo, int dado);
int isEmpty(No *ponteiroPrimeiroNo);
void mostrarDadosDosNos(No *ponteiroPrimeiroNo);
void inverterOrdenacaoDaListaLigada(No **ptrParaPtrPrimeiroNo, No **ptrParaPtrUltimoNo);

int main(void){
    No *ponteiroPrimeiroNo = NULL;
    No *ponteiroUltimoNo = NULL;
    
    inserirNovoNo(&ponteiroPrimeiroNo, &ponteiroUltimoNo, 1);
    inserirNovoNo(&ponteiroPrimeiroNo, &ponteiroUltimoNo, 2);
    inserirNovoNo(&ponteiroPrimeiroNo, &ponteiroUltimoNo, 2);
    inserirNovoNo(&ponteiroPrimeiroNo, &ponteiroUltimoNo, 2);
    inserirNovoNo(&ponteiroPrimeiroNo, &ponteiroUltimoNo, 3);
    inserirNovoNo(&ponteiroPrimeiroNo, &ponteiroUltimoNo, 5);

    printf("Lista antes da inversao \n");
    mostrarDadosDosNos(ponteiroPrimeiroNo);
    
    inverterOrdenacaoDaListaLigada(&ponteiroPrimeiroNo, &ponteiroUltimoNo);
    
    printf("\n\nLista apos inversao \n");
    mostrarDadosDosNos(ponteiroPrimeiroNo);

    getch();

    return 0;    
}

void inserirNovoNo(No **ptrParaPtrPrimeiroNo, No **ptrParaPtrUltimoNo, int dado){
     No *novoNo = (No*) malloc(sizeof(No));
     novoNo->dado = dado;
     
     if(isEmpty(*ptrParaPtrPrimeiroNo)){
          novoNo->proximo = *ptrParaPtrPrimeiroNo;
          *ptrParaPtrPrimeiroNo = novoNo;
     }else{
          novoNo->proximo = NULL;
          (*ptrParaPtrUltimoNo)->proximo = novoNo;
     }
     
     *ptrParaPtrUltimoNo = novoNo;
}

int isEmpty(No *ponteiroPrimeiroNo){
     return (ponteiroPrimeiroNo == NULL);
}

void mostrarDadosDosNos(No *ponteiroPrimeiroNo){
     No *temp;
     
     printf("Nos: ");
     for(temp = ponteiroPrimeiroNo; temp != NULL; temp = temp->proximo){
          printf("%d -> ", temp->dado);         
     }     
     printf("NULL");
}

void inverterOrdenacaoDaListaLigada(No **ptrParaPtrPrimeiroNo, No **ptrParaPtrUltimoNo){
     No *ptrParaAtualizarUltimo = *ptrParaPtrPrimeiroNo;                                     
     No *proximoNo = *ptrParaPtrPrimeiroNo;
     No *noAtual = NULL;
     No *noTemporario = NULL;
     
     while(proximoNo != NULL){
          noTemporario = proximoNo->proximo;
          proximoNo->proximo = noAtual;
          noAtual = proximoNo;
          proximoNo = noTemporario;
          
          while(proximoNo != NULL && noAtual->dado == proximoNo->dado){ //while para retirar duplicidades
               proximoNo = proximoNo->proximo;
          }
     }
     
     *ptrParaPtrUltimoNo = ptrParaAtualizarUltimo;
     *ptrParaPtrPrimeiroNo = noAtual;
}
