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
public class Mago extends Heroi {

    private int mana;

    public Mago() {
        this.ID = 2;
        this.mana = 10;
        this.hp = 30;
        this.hpMax = 30;
        this.level = 1;
        this.exp = 0;
        this.Dano = 100;
        this.armadura = 5;

    }

    void passarLevel() {   // mago e guerreiro passam de level igualmente então faremos aqui mesmo a implementação
        this.level += 1;
        this.Dano += 5;
        this.hp += 5;
        this.hpMax += 5;
        this.armadura += 5;
        this.mana += 5;
        this.exp = 0;

        System.out.println("Parabéns você subiu +1 lvl\n");
        System.out.println("*******************************************");
        System.out.println("                 STATUS                    ");
        System.out.println("*******************************************");
        System.out.println("* Level: " + this.level);
        System.out.println("* HP MAX: " + this.hpMax);
        System.out.println("* Dano:  " + this.Dano);
        System.out.println("* Armadura:  " + this.armadura);
        System.out.println("* Mana: " + this.mana);
        System.out.println("*******************************************\n\n\n");
    }

    private int bolaDeFogo() {
        if (this.mana < 2) {
            return this.Dano + 0;
        } else {
            return this.Dano * 2;
        }

    }

    @Override
    void usarHabilidade() {
        bolaDeFogo();
        this.mana = this.mana - 2;
        this.habilidadeAtivada = true;
    }

    int atacar(Heroi heroi, Monstro monstro) {
        if (heroi.habilidadeAtivada == false) {
            return heroi.Dano + heroi.bolsa.VerificaArma() - monstro.getArmadura();
        } else {
            return this.bolaDeFogo() + heroi.bolsa.VerificaArma() - monstro.getArmadura();
        }
    }

    @Override
    void morrer(Heroi heroi) {
        System.out.println("Você está morto!!");
        System.exit(0);
    }

    @Override
    void tomarDano(Heroi heroi, Monstro monstro) {
        this.hp -= monstro.atacar(heroi, monstro);
        if (this.hp <= 0) {
            System.out.println("O monstro que lhe rasga pelo meio e sorri enquanto vê seu cadáver");
            morrer(heroi);
        }
    }

    @Override
    int ManaRage() {
        return mana;
    }

    int getArmadura() {
        return this.armadura;
    }

}
