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
 * @author Pablo de Paula de Deus
 */
public class Bolsa {

    private List<Item> item;
    private Set<Heroi> heroi;

    /* Após estudo, aqui vai ser um collection de itens 
                                para respeitar o relacinamento:
                                bolsa ------ itens
                                    1        N    
                        Usando maps poderemos organizar bem os tipos de item
                        e usar a função aleatório para gerar esses itens.*/
    public Bolsa() {
        this.item = new ArrayList<Item>();
        this.heroi = new HashSet<Heroi>();
    }

    public int VerificaArma() {
        for (Item i : item) {
            if (i.getItemID() == 1 && i.isEquipado() == true) {
                return i.getDanoArma();
            } else {
                return 0;
            }
        }
        return 0;
    }

    public void mostrarInventario() {
        int quantPocao = 1;
        int quantArmadura = 1;
        int quantArma = 1;

        System.out.println("Obs:  [1] - Armas    [2] - Armaduras    [3] - Poção\n");
        for (Item i : item) {
            if (i.getItemID() == 1) {                     // Arma
                System.out.println("* [1] "+i.getNome());
                if (i.isEquipado() == true) {
                    System.out.println("* Equipada");
                } else {
                    System.out.println("* Desequipada");
                }
                System.out.println("* Dano: da " + i.getDanoArma() + " de dano\n");
                quantArma++;
            }
            if (i.getItemID() == 2) {                   //Armadura
                System.out.println("* [2] "+i.getNome());
                if (i.isEquipado() == true) {
                    System.out.println("* Equipada");
                } else {
                    System.out.println("* Desequipada");
                }
                System.out.println("* Defesa: defende " + i.getValorArmadura() + " de dano do seu HP\n");
                quantArmadura++;
            }
            if (i.getItemID() == 3) {                   //poção
                System.out.println("* [3]"+i.getNome());
                System.out.println("* Cura 15 de HP\n");
                quantPocao++;
            }
        }
    }

    public void equipar(int ID, Heroi h, int valor) {            // int valor: verifica se tem alguma arma ou armadura com tal valor
        int arma = 0, armadura = 0;
        boolean armaEquipada = false;
        boolean armaduraEquipada = false;
        boolean usou = false;
        Iterator<Item> i2 = item.listIterator();

        for (Item i : item) {
            if (i.getItemID() == 1) {                                    //verifica quantas armas existem
                if (i.isEquipado() == true) {
                    armaEquipada = true;
                }
                arma++;
            }
            if (i.getItemID() == 2) {                                    //verifica quantas armaduras existem
                if (i.isEquipado() == true) {
                    armaduraEquipada = true;
                }
                armadura++;
            }
        }

        if (ID == 1) {                  // Arma
            if (arma > 0 && armaEquipada == false) {
                System.out.println("Você decide equipar uma de suas armas");
                while (i2.hasNext()) {
                    Item item = i2.next();
                    if (item.getItemID() == 1 && usou == false && item.getDanoArma() == valor) {
                        System.out.println("Dano: +" + item.getDanoArma());
                        System.out.println("você empunha a arma e sente que seu dano aumentou");
                        item.setEquipado(true);
                        item.addValor(h);
                        usou = true;
                    }
                }
                armaEquipada = true;
            } else {
                if (armaEquipada == true) {               //ja tem arma equipada
                    System.out.println("Você ja tem uma arma equipada\n");
                } else {                                  //Não tem armas                                 
                    System.out.println("Você procura uma arma para equipar mas não acha nenhuma");
                }
            }
        } else {                                          // Armadura
            if (armadura > 0 && armaduraEquipada == false) {
                System.out.println("Você decide equipar uma de suas armaduras");
                while (i2.hasNext()) {
                    Item item = i2.next();
                    if (item.getItemID() == 2 && usou == false && item.getValorArmadura() == valor) {
                        System.out.println("Defesa: +" + item.getValorArmadura());
                        System.out.println("você veste a armadura e sente que sua defesa melhorou");
                        item.setEquipado(true);
                        item.addValor(h);
                        usou = true;
                    }
                }
                armaduraEquipada = true;
            } else {                                     //Não tem armas
                if (armaduraEquipada == true) {
                    System.out.println("Você ja tem uma armadura equipada\n");
                } else {
                    System.out.println("Você procura uma armadura para equipar mas não acha nenhuma");
                }
            }
        }
    }

    public void desequipar(int ID, Heroi h, int valor) {      // verifica:  se é um arma ou armadura que deseja desequipar
        int arma = 0, armadura = 0;
        boolean armaEquipada = false;
        boolean armaduraEquipada = false;
        boolean verificado = false;                                      // verificado serve para caso tenham arma com danos iguais então ele verifica e só faz uma vez
        Iterator<Item> i2 = item.listIterator();

        for (Item i : item) {
            if (i.getItemID() == 1) {                                    //verifica quantas armas existem
                if (i.isEquipado() == true) {
                    armaEquipada = true;
                }
                arma++;
            }
            if (i.getItemID() == 2) {                                    //verifica quantas armaduras existem
                if (i.isEquipado() == true) {
                    armaduraEquipada = true;
                }
                armadura++;
            }
        }

        if (ID == 1) {                  // Arma
            if (arma > 0 && armaEquipada == false) {
                System.out.println("Você não tem nenhuma espada equipada em mãos agora");
            } else {
                if (armaEquipada == true) {
                    while (i2.hasNext()) {
                        Item item = i2.next();
                        if (item.getItemID() == 1 && verificado == false && item.getDanoArma() == valor) {
                            System.out.println("Dano: -" + item.getDanoArma());
                            System.out.println("você desequipa sua espada e sente que seu dano diminuiu");
                            item.subValor(h);
                            item.setEquipado(false);
                            verificado = true;            // já achou oque precisa
                        }
                    }
                    armaEquipada = false;
                } else {
                    System.out.println("Você procura uma arma para desequipar mas não acha nenhuma");
                }
            }
        } else {                                          // Armadura
            if (armadura > 0 && armaduraEquipada == false) {
                System.out.println("Você não tem nenhum escudo equipada em mãos agora");
            } else {
                if (armaduraEquipada == true) {
                    while (i2.hasNext()) {
                        Item item = i2.next();
                        if (item.getItemID() == 2 && verificado == false && item.getValorArmadura() == valor) {
                            System.out.println("Defesa: -" + item.getValorArmadura());
                            System.out.println("você desequipa sseu escudo e sente que sua armadura diminuiu");
                            item.subValor(h);
                            item.setEquipado(false);
                            verificado = true;            // já achou oque precisa
                        }
                    }
                    armaduraEquipada = false;
                } else {
                    System.out.println("Você procura um escudo para desequipar mas não acha nenhuma");
                }
            }
        }
    }

    public void usarItem(int ID, Heroi h) {         //Usarei somente a poção
        int p = 0;
        int y = 0;
        boolean usou = false;
        for (Item i : item) {
            if (i.getItemID() == 3) {                       //verifica quantas poções existem
                p++;
            }
        }

        if (p > 0) {                                         // P diferente de 0 significa que tem uma poção e ele quer usar
            int verificaVida = h.hp + 15;                   // Olha se o hp do usuário com + 15 de poção é maior que sua vida maxima
            if (verificaVida >= h.hpMax) {
                System.out.println("Sua vida já está no maximo");
                
                Iterator<Item> i2 = item.listIterator();           //Retira uma de suas poções já que usou
                while (i2.hasNext()) {
                    Item item = i2.next();
                    if (item.getItemID() == 3 && usou == false) {
                        i2.remove();
                        usou = true;
                    }
                }
                
                h.hp = h.hpMax;
            } else {
            //   verifica.addValor(h);
                Iterator<Item> i2 = item.listIterator();
                while (i2.hasNext()) {
                    Item item = i2.next();
                    if (item.getItemID() == 3 && usou == false) {
                        item.addValor(h);
                        System.out.println("Você recupera 15 de HP");
                        i2.remove();
                        usou = true;
                    }
                }
            }
        } else {      //Não tem poções
            System.out.println("Você procura uma poção em sua bolsa mas encontra nenhuma");
        }
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public List<Item> getItem() {
        return item;
    }

    public void adicionarItem(Item item) {                      // ItemID:   1 - Arma   2 - Armadura    3 - Poção 
        this.item.add(item);
    }

    public void removerItem(Item item) {
        this.item.remove(item);
    }

    public void adicionarHeroi(Heroi heroi) {
        this.heroi.add(heroi);
    }

    public void removerHeroi(Heroi heroi) {
        this.heroi.remove(heroi);
    }
}
