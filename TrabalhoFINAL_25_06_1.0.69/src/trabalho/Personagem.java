/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

/**
 *
 * @author Guilherme Reis
 * @author Pablo de Paula
 * A abstract class Personagem, assim implementada pois, possui atributos
 * e ações comuns, tanto ao herói quanto para o monstro, que são o hp(vida),
 * Dano e armadura de cada personagem e possui os métodos atacar, morrer e
 * tomar dano.
 * 
 */
abstract class Personagem {
    protected int hp;
    protected int Dano;
    protected int armadura;

    public Personagem() {
    }

    /**
     * O método abstrato atacar() vai pegar o dano base dos personagens,
     * somalos a uma arma, caso equipada e subtrair da armadura de seu
     * oponente. Este valor será jogado ao método tomarDano().
     * @return (Dano + DanoArma) - armadura;
     */
    abstract int atacar(Heroi heroi, Monstro monstro);
    
    /**
     * O método abstrato morrer() possui dois funcionamentos:
     * 1. Se o herói morrer então o jogo acaba.
     * 2. Se o monstro morrer será calculado o <b>exp</b> para o herói e o 
     * jogo continua.
     */
    abstract void morrer(Heroi heroi);
    
    /**
     * O método abstrato tomarDano() pega o dano calculado pelo método atacar()
     * e subtrai da vida do personagem. Logo em seguida é feita uma verificação
     * para ver se o personagem morreu e caso tenha morrido, é chamado o método
     * morrer().
     */
    abstract void tomarDano(Heroi heroi, Monstro monstro);
    
}
