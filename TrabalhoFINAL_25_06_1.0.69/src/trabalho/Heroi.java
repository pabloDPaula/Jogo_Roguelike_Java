/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.*;


/**
 *
 * @author Guilherme Reis
 * Esta é a abstrac class Heroi que é extendida para Personagem por possuir
 * atributos em comum e é uma classe abstrata pois, neste jogo existem dois
 * tipos de herói: O Guerreiro e O Mago. Ambos possuem atributos em comum
 * tanto com herói quanto com personagem mas também possuem atributos singulares
 * que definem sua classificação.
 */
abstract class Heroi extends Personagem {
    protected int ID;
    protected int level;
    protected int exp;
    protected boolean habilidadeAtivada = false;
    protected Bolsa bolsa;
    protected int hpMax;

    public Heroi() {
    }

    abstract int ManaRage();
    
    abstract void passarLevel();
    
    void ganharEXP(Monstro monstro){    //Troll e Orc extends de monstro logo o expGive será de acordo com o tipo do monstro
        this.exp +=  monstro.expGive;
    }
    
    abstract void usarHabilidade();     // Cada uma usa uma certa habilidade então será mantido como abstract e passará para o filho implementar

    abstract int getArmadura();
    
    public void setBolsa(Bolsa bolsa){
        this.bolsa = bolsa; 
        if(this.bolsa!=null){
            this.bolsa.adicionarHeroi(this);
        }
    }

    public Bolsa getBolsa() {
        return bolsa;
    }
    
    


    
}
