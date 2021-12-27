/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

/**
 *
 * @author Guilherme Reis
 */
abstract class Monstro extends Personagem{
    protected int HPmax;
    protected int expGive; 
    protected int ID; 
    protected int IDBOSS;
    Soul alma; //Qualquer coisa remover o final! Talvez remover o final para usar level como já anotado em Soul

    public Monstro() {
        alma = new Soul();
    }

  
   //     this.expGive += alma.exp();
    
   abstract void EXPExtra();
    
    abstract void usarHabilidade();

    abstract int getArmadura();

    
    
}
