/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listaligada2;

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
        ListaLigada listaInvertida = getListaInvertida(listaLigada);
        listaInvertida.mostrarDadosDosNos();
    }
    
    private static void criarEPopularListaLigada(){
        listaLigada = new ListaLigada();
        
        listaLigada.inserirNovoNo(1);
        listaLigada.inserirNovoNo(2);
        listaLigada.inserirNovoNo(2);
        listaLigada.inserirNovoNo(2);
        listaLigada.inserirNovoNo(3);
        listaLigada.inserirNovoNo(5);
    }
    
    private static ListaLigada getListaInvertida(ListaLigada lista){
        ListaLigada listaInvertida = new ListaLigada();
        No noAtual = lista.primeiroNoDaLista;
        No noAnterior = null;
        No novoNo = null;
        boolean isPrimeiraIteracao = true;
        
        while(noAtual != null){
            novoNo = new No(noAtual.dado);
            
            if(isPrimeiraIteracao){
                listaInvertida.inserirNoEmOrdemDecrescente(novoNo);
                isPrimeiraIteracao = false;
            }else if(noAnterior.dado != noAtual.dado){
                listaInvertida.inserirNoEmOrdemDecrescente(novoNo);
            }
            noAnterior = noAtual;
            noAtual = noAtual.proximo;
        }
        
        return listaInvertida;
    }
}