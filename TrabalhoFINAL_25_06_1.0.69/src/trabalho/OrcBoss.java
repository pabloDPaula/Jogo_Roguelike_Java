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
public class OrcBoss extends Orc{
  
    public OrcBoss() {
        this.ID = 2;
        this.IDBOSS = 2;
        this.HPmax = 90;
        this.hp = 90;
        this.Dano = 30;
        this.armadura = 20;
        this.expGive = 40;
    }
    
    int furia(){
            return this.Dano * 3;
    }
    
    public void uparOrc(){
        this.HPmax += 25;
        this.hp += 25;
        this.Dano += 25;
        this.armadura += 25;
        this.expGive += 20;
    }
    
}
