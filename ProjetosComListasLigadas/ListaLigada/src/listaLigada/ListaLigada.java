/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listaLigada;

/**
 *
 * @author bruno
 */
public class ListaLigada {
    public No primeiroNoDaLista;
    public No ultimoNoDaLista;
    
    public ListaLigada(){
        primeiroNoDaLista = null;
        ultimoNoDaLista = null;
    }
    
    public boolean isEmpty(){
        return primeiroNoDaLista == null;
    }
    
    public void inserirNovoNo(int dado){
        No novoNo = new No(dado);
        
        if(isEmpty()){
            primeiroNoDaLista = novoNo;
        }
        else{
            ultimoNoDaLista.proximo = novoNo;
        }
        
        ultimoNoDaLista = novoNo;
    }
    
    public void mostrarDadosDosNos(){
        System.out.print("Nós: ");
        
        No noAtual = primeiroNoDaLista;
        while(noAtual != null){
            noAtual.mostrarDadoDoNo();
            noAtual = noAtual.proximo;
        }
        
        System.out.print("NULL\n");
    }
}