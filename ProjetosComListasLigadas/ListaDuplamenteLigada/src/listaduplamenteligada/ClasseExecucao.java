/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listaduplamenteligada;

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
        No noAtual = lista.ultimoNoDaLista;
        No noTemporario = null;
        boolean isPrimeiraIteracao = true;
        
        while(noAtual != null){
            if(isPrimeiraIteracao){
                listaInvertida.inserirNovoNo(noAtual.dado);
                isPrimeiraIteracao = false;
            }else if(noAtual.dado != noTemporario.dado){
                listaInvertida.inserirNovoNo(noAtual.dado);
            }
            noTemporario = noAtual;
            noAtual = noAtual.anterior;
        }
        
        return listaInvertida;
    }
}