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
public class Item {
    private Bolsa bolsa; //Para respeitar o relacionamento 1 pra N.Talvez usar itemID para diferenciar o item por level.
    private String nome;
    private int itemID;
    private boolean equipado;
    private int danoArma;
    private int valorArmadura;
    private int cura;
    private boolean poção;

    public Item(String nome,int itemID, int danoArma, int valorArmadura, int cura) {     
        this.nome = nome;
        this.itemID = itemID;
        this.danoArma = danoArma;
        this.valorArmadura = valorArmadura;
        this.cura = cura;
        this.equipado = false;
        this.poção = false;
    }

    public String getNome() {
        return nome;
    }

    public void setBolsa(Bolsa bolsa) {      
        this.bolsa = bolsa;
        if(this.bolsa!=null)
        {
            this.bolsa.adicionarItem(this);
        }
    }

    public int getItemID() {
        return itemID;
    }

    public int getValorArmadura() {
        return valorArmadura;
    }

    public int getDanoArma() {
        return danoArma;
    }

    
    public void setEquipado(boolean equipado) {
        this.equipado = equipado;
    }

    public void setPoção(boolean poção) {
        this.poção = poção;
    }

    public boolean isEquipado() {
        return equipado;
    }

    public boolean isPoção() {
        return poção;
    }
    
    public void addValor(Heroi heroi){
        switch(this.itemID){
            case 1:          // Arma
                heroi.Dano += this.danoArma;
                break;
            case 2:         // Armadura
                heroi.armadura +=  this.valorArmadura;
                break;
            case 3:         // Poção
                heroi.hp += cura;
                this.poção = false;
                break;
        }
    }
    
    public void subValor(Heroi heroi){
        switch(this.itemID){
            case 1:          // Arma
                heroi.Dano -= this.danoArma;
                break;
            case 2:         // Armadura
                heroi.armadura -=  this.valorArmadura;
                break;
            case 3:         // Poção
                heroi.hp -= cura;
             break;
        }
    }
    /*Duas formas para implementar esta parte:
        
        1 -> Usar desta forma criando uma tabela de valores para cada item e
            usando uma função de números aleatórios, definir quais os itens
            ganhos como loot.
          1.1 -> Quando existir potion poção será true e será armazenado em cura.
        
        2 -> Implementar como feito com personagem, transformar item numa class
            abstract e criar as extends que seriam arma, armadura e poção. 
            Deixando em item apenas: itemID e equipado.
    */
}
