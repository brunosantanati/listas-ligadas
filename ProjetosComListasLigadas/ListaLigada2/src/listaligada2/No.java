/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listaligada2;

/**
 *
 * @author bruno
 */
public class No {
    public int dado;
    public No proximo;
    
    public No(int dado){
        this.dado = dado;
    }
    
    public void mostrarDadoDoNo(){
        System.out.print(this.dado + " -> ");
    }
}