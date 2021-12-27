/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

/**
 *
 * @author alunodev03
 */
public class Orc extends Monstro{
 
    public Orc() {
        this.ID = 2;
        this.IDBOSS = 0;
        this.HPmax = 45;
        this.hp = 45;
        this.Dano = 13;
        this.armadura = 7;
        this.expGive = 20;
    }

    public int getHPmax() {
        return HPmax;
    }

    public void uparOrc(){
        this.HPmax += 5;
        this.hp += 5;
        this.Dano += 5;
        this.armadura += 5;
        this.expGive += 5;
    }
    
    
    int furia(){
        /*Quando usar a função usarHabilidade de monstro esta função será
        executada e pegara o dano atual do monstro e multiplica-lo por 2:
        return danoFuria = dano *2;
        Só será usado este valor e caso ele recupere vida, volta o dano original
        */
            return this.Dano * 2;
    }

    public void usarHabilidade() {
        this.Dano = furia();   
    }

    @Override
    int atacar(Heroi heroi, Monstro monstro) {
         return monstro.Dano - heroi.armadura;
    }

    @Override
    void morrer(Heroi heroi) {
         heroi.ganharEXP(this);
    }

    @Override
    void tomarDano(Heroi heroi, Monstro monstro) {
          this.hp -= heroi.atacar(heroi, monstro);
    }

    @Override
    int getArmadura() {
        return armadura;
    }

    @Override
    void EXPExtra() {
        this.expGive += alma.exp();
    }
    
}
