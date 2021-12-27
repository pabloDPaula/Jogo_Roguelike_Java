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
public class Troll extends Monstro {

    public Troll() {
        this.ID = 1;
        this.IDBOSS = 0;
        this.hp = 60;
        this.Dano = 15;
        this.armadura = 6;
        this.expGive = 30;
    }

    public void uparTroll() {
        this.hp += 6;
        this.Dano += 6;
        this.armadura += 6;
        this.expGive += 5;
    }

    void regenerar() {
        this.hp += 5;
        /*Caso nescessário, usar uma varívavel/função para indicar a passagem
        de turnos e aumentar a vida do monstro de acordo com o level dele:
        L01 -> hp = hp + 5 e a cada level a mais aumenta em 5.*/
    }

    void usarHabilidade() {
        regenerar();
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
