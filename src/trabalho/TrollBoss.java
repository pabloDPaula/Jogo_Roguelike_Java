/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

/**
 *
 * @author Pablo
 */
public class TrollBoss extends Troll{

    public TrollBoss() {
        this.ID = 1;
        this.IDBOSS = 1;
        this.hp = 110;
        this.Dano = 20;
        this.armadura = 12;
        this.expGive = 60;
    }
    
  
    void regenerar(){
        this.hp += 15; 
    }
    
    public void uparTroll() {
        this.hp += 25;
        this.Dano += 25;
        this.armadura += 25;
        this.expGive += 20;
    }
}
