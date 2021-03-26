/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listaLigada;

/**
 *
 * @author bruno
 */
public class ClasseExecucao {
    static ListaLigada listaLigada;
    
    public static void main(String[] args) {
        System.out.println("Lista antes da inversão");
        criarEPopularListaLigada();
        listaLigada.mostrarDadosDosNos();
        
        System.out.println("\nLista após inversão");
        ListaLigada listaLigadaInvertida = inverterOrdenacaoDaListaLigada(listaLigada);
        listaLigadaInvertida.mostrarDadosDosNos();
    }
    
    public static void criarEPopularListaLigada(){
        listaLigada = new ListaLigada();
        
        listaLigada.inserirNovoNo(1);
        listaLigada.inserirNovoNo(2);
        listaLigada.inserirNovoNo(2);
        listaLigada.inserirNovoNo(2);
        listaLigada.inserirNovoNo(3);
        listaLigada.inserirNovoNo(5);
    }
    
    public static ListaLigada inverterOrdenacaoDaListaLigada(ListaLigada lista){
        No varParaAtualizarUltimo = lista.primeiroNoDaLista;
        No proximoNo = lista.primeiroNoDaLista;
        No noAtual = null;        
        No noTemporario = null;

        while(proximoNo != null){
            noTemporario = proximoNo.proximo;
            proximoNo.proximo = noAtual;
            noAtual = proximoNo;
            proximoNo = noTemporario;
            
            while(proximoNo != null && noAtual.dado == proximoNo.dado){ //while para retirar duplicidades
                proximoNo = proximoNo.proximo;
            }
        }

        lista.primeiroNoDaLista = noAtual;
        lista.ultimoNoDaLista = varParaAtualizarUltimo;

        return lista;
    }
}