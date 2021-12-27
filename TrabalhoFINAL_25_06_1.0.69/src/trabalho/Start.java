/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.*;
import javax.swing.JOptionPane;
import trabalho.InOut;

/**
 *
 * @author Guilherme Reis A class Start, que é a main do projeto, inicia o jogo
 * no qual dois personagens são criados: o herói e o monstro. Após a criação é
 * iniciada a luta.
 */
public class Start {

    /**
     *
     * Método para criação de Heróis. O criarHeroi() vai criar um PC(Player
     * Character) de acordo com as escolhas do jogador. Input = 1 Guerreiro; 2
     * Mago.
     */
    static void imprimiStatusH(Heroi heroi) {
        int manaRage = heroi.ManaRage();

        if (heroi.ID == 1) {
            System.out.println("_________________________________________┐\n");
            System.out.println("         STATUS DO GUERREIRO            \n");
        } else {
            System.out.println("_________________________________________ ┐\n");
            System.out.println("          STATUS DO MAGO                \n");
        }
        System.out.println("- LVL : " + heroi.level);
        System.out.println("- HP MAX: " + heroi.hpMax);
        System.out.println("- HP : " + heroi.hp);
        if (heroi.ID == 1) {
            System.out.println("- Rage : " + manaRage);
        } else {
            System.out.println("- Mana : " + manaRage);
        }
        System.out.println("- Dano : " + heroi.Dano);
        System.out.println("- Armadura : " + heroi.armadura);
        System.out.println("- EXP : " + heroi.exp);
        System.out.println("_________________________________________\n");

    }

    static void imprimiStatusM(Monstro monstro) {

        if (monstro.ID == 1 && monstro.IDBOSS == 0) {
            System.out.println("_________________________________________┐\n");
            System.out.println("         STATUS DO TROLL           \n");
        }
        if (monstro.ID == 1 && monstro.IDBOSS == 1) {
            System.out.println("_________________________________________┐\n");
            System.out.println("         STATUS DO TROLL BOSS           \n");
        }
        if (monstro.ID == 2 && monstro.IDBOSS == 0) {
            System.out.println("_________________________________________┐\n");
            System.out.println("          STATUS DO ORC                \n");
        }
        if (monstro.ID == 2 && monstro.IDBOSS == 2) {
            System.out.println("_________________________________________┐\n");
            System.out.println("         STATUS DO ORC BOSS           \n");
        }
        System.out.println("- HP : " + monstro.hp);
        System.out.println("- Dano : " + monstro.Dano);
        System.out.println("- Armadura : " + monstro.armadura);
        System.out.println("_________________________________________\n");

    }

    static Heroi criarHeroi() {
        int opcaoH = InOut.leInt("*******************************************************\n"
                + "Escolha a classe de seu herói,  jovem aventureiro\n"
                + "1 - Guerreiro\n"
                + "2 - Mago\n"
                + "*******************************************************\n");
        if (opcaoH == 1) {
            Guerreiro G = new Guerreiro();
            System.out.println("Você escolheu a classe Guerreiro");
            return G;
        } else {
            Mago M = new Mago();
            System.out.println("Você escolheu a classe Mago");
            return M;
        }
    }

    /**
     * Método para criação de Monstros. O criarMonstro() vai criar um NPC(Non
     * Player Character) aleatório ou de escolha do jogador.(<b>Ideia a ser
     * definida!</b>)
     */
    static Monstro criarMonstro(int dungeonAtual, Heroi heroi, boolean boss) {
        Random gerador = new Random();
        int i = 1;
        int opcaoM = gerador.nextInt(10) + 1;  //Numero entre 0 e 10
        if (dungeonAtual == 1) {                //DUNGEON 1 
            if (opcaoM <= 5) {
                if (heroi.level == 5 && boss == false) {
                    OrcBoss O = new OrcBoss();
                    while (i <= 2) {
                        O.uparOrc();
                        i++;
                    }
                    System.out.println("Depois de ver seus vários soldados mortos o ORC BOSS decide agir\n");
                    return O;
                } else {
                    Orc O = new Orc();
                    if (heroi.level == 2) {
                        while (i <= 1) {
                            O.uparOrc();
                            i++;
                        }
                    }
                    if (heroi.level == 3) {
                        while (i <= 2) {
                            O.uparOrc();
                            i++;
                        }
                    }
                    if (heroi.level == 4) {
                        while (i <= 3) {
                            O.uparOrc();
                            i++;
                        }
                    }
                    System.out.println("No meio da dungeon spawna um ORC\n");
                    return O;
                }
            } else {
                if (heroi.level == 5 && boss == false) {
                    TrollBoss T = new TrollBoss();
                    while (i <= 2) {
                        T.uparTroll();
                        i++;
                    }
                    System.out.println("Depois de ver seus vários soldados mortos o TROLL BOSS decide agir\n");
                    return T;
                } else {
                    Troll T = new Troll();
                    if (heroi.level == 2) {    // Os monstros Evoluem assim como os players
                        while (i <= 1) {
                            T.uparTroll();
                            i++;
                        }
                    }
                    if (heroi.level == 3) {
                        while (i <= 2) {
                            T.uparTroll();
                            i++;
                        }
                    }
                    if (heroi.level == 4) {
                        while (i <= 3) {
                            T.uparTroll();
                            i++;
                        }
                    }
                    System.out.println("No meio da dungeon spawna um TROLL\n");
                    return T;
                }
            }
        } else if (dungeonAtual == 2) {         //DUNGEON 2
            if (opcaoM <= 5) {
                if (heroi.level == 10 && boss == false) {
                    OrcBoss O = new OrcBoss();
                    while (i <= 4) {
                        O.uparOrc();
                        i++;
                    }
                    System.out.println("Depois de ver seus vários soldados mortos o ORC BOSS decide agir\n");
                    return O;
                } else {
                    Orc O = new Orc();
                    if (heroi.level == 6) {
                        while (i <= 5) {
                            O.uparOrc();
                            i++;
                        }
                    }
                    if (heroi.level == 7) {
                        while (i <= 6) {
                            O.uparOrc();
                            i++;
                        }
                    }
                    if (heroi.level == 8) {
                        while (i <= 7) {
                            O.uparOrc();
                            i++;
                        }
                    }
                    if (heroi.level == 9) {
                        while (i <= 8) {
                            O.uparOrc();
                            i++;
                        }
                    }
                    O.uparOrc();
                    System.out.println("No meio da dungeon spawna um ORC\n");
                    return O;
                }
            } else {
                if (heroi.level == 10 && boss == false) {
                    TrollBoss T = new TrollBoss();
                    while (i <= 4) {
                        T.uparTroll();
                        i++;
                    }
                    System.out.println("Depois de ver seus vários soldados mortos o TROLL BOSS decide agir\n");
                    return T;
                } else {
                    Troll T = new Troll();
                    if (heroi.level == 6) {
                        while (i <= 5) {
                            T.uparTroll();
                            i++;
                        }
                    }
                    if (heroi.level == 7) {
                        while (i <= 6) {
                            T.uparTroll();
                            i++;
                        }
                    }
                    if (heroi.level == 8) {
                        while (i <= 7) {
                            T.uparTroll();
                            i++;
                        }
                    }
                    if (heroi.level == 9) {
                        while (i <= 8) {
                            T.uparTroll();
                            i++;
                        }
                    }
                    System.out.println("No meio da dungeon spawna um TROLL\n");
                    return T;
                }
            }
        }
        return null;
    }

    static Item criarDrops(Heroi heroi) {
        Random gerador = new Random();
        int valorAleatorio = 0, opcao = 0, gerarNome = 0;
        String nomeItem = null;
        opcao = gerador.nextInt(30) + 1;                //Numero entre 0 e 30
        if (heroi.level >= 1 && heroi.level <= 5) {
            valorAleatorio = gerador.nextInt(15) + 1;    // Valor de dano ou defesa do item com base no lvl no usuário :D
        }
        if (heroi.level >= 6 && heroi.level <= 10) {
            valorAleatorio = gerador.nextInt(30) + 1;
        }
        if (opcao <= 10) {
            //Gerar nomes aleatório para as armas
            gerarNome = gerador.nextInt(90) + 1;
            if (gerarNome >= 0 && gerarNome <= 20) {
                nomeItem = "Katana";
            } else if (gerarNome > 20 && gerarNome <= 30) {
                nomeItem = "Machado";
            } else if (gerarNome > 30 && gerarNome <= 40) {
                nomeItem = "Clava";
            } else if (gerarNome > 40 && gerarNome <= 50) {
                nomeItem = "Cimitarra";
            } else if (gerarNome > 50 && gerarNome <= 60) {
                nomeItem = "Graveto overpower";
            } else if (gerarNome > 60 && gerarNome <= 70) {
                nomeItem = "Espada gigante";
            } else if (gerarNome > 70 && gerarNome <= 80) {
                nomeItem = "Espada mística";
            } else if (gerarNome > 80 && gerarNome <= 90) {
                nomeItem = "Espada longa";
            }
            Item A = new Item(nomeItem, 1, valorAleatorio, 0, 0);
            System.out.println("DROP: uma/um " + nomeItem + " com " + valorAleatorio + " de DANO");
            System.out.println("Um dos monstros deixou cair e você escolhe pega-la");
            return A;
        } else if (opcao >= 10 && opcao <= 20) {
            //Gerar nomes aleatório para as armas
            gerarNome = gerador.nextInt(60) + 1;
            if (gerarNome >= 1 && gerarNome <= 20) {
                nomeItem = "Escudo leve";
            } else if (gerarNome > 20 && gerarNome <= 30) {
                nomeItem = "Escudo pesado";
            } else if (gerarNome > 30 && gerarNome <= 40) {
                nomeItem = "Escudo de corpo";
            } else if (gerarNome > 40 && gerarNome <= 50) {
                nomeItem = "Couraça de Bronze";
            } else if (gerarNome > 50 && gerarNome <= 60) {
                nomeItem = "Couro batido";
            }

            Item E = new Item(nomeItem, 2, 0, valorAleatorio, 5);
            System.out.println("DROP: um/uma " + nomeItem + " com " + valorAleatorio + " de DEFESA");
            System.out.println("Um dos monstros deixou cair e você escolhe pegar");
            return E;
        } else {
            Item P = new Item("Poção", 3, 0, 0, 15);
            System.out.println("DROP: uma Poção que cura 15 de HP");
            System.out.println("Um dos monstros deixou cair uma poção e você escolhe pega-la");
            return P;
        }

    }

    /**
     * Após a criação de ambos os personagens é começada a luta. A luta vai irá
     * ocorrer em quanto um dos personagens ainda estiver vivo. A luta vai
     * funcionar da seguinte maneira: 1. Herói tem o primeiro turno e escolhe
     * dentre 3 ações: atacar, usar habilidade ou usar item. 2. Monstro faz sua
     * ação automaticamente no segundo turno, sua ação vai depender dos
     * crítérios da sua habilidade, caso contrário, ataca normalmente<b>(Parte a
     * ser definida)</b>.
     */
    static int menu() {
        int opcaoAtaque = 0;
        boolean ERRO;

        do {
            try {
                opcaoAtaque = InOut.leInt("***************************************\nEscolha sua ação\n\n1 - Atacar\n2 - Usar habilidade\n3 - Usar Item\n4 - mostrar inventário\n5 - mostrar status da batalha\n6 - Fechar jogo\n****************************************\n");
                ERRO = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "VALOR DEVE SER UM NUMERO DO TIPO "
                        + "BYTE", "   >>>      ERRO     <<<",
                        JOptionPane.ERROR_MESSAGE);
                ERRO = true;
            }
        } while (ERRO);
        return opcaoAtaque;
    }

    static int menuInventario() {
        int opcao = 0;
        boolean ERRO;

        do {
            try {
                opcao = InOut.leInt("***************************************\nInventario\n1 -Usar poção\n2 - Equipar espada\n3 - Desequipar espada\n4 - Equipar escudo\n5 - Desequipar escudo\n 6 - Voltar\n****************************************\n");
                ERRO = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "VALOR DEVE SER UM NUMERO DO TIPO "
                        + "BYTE", "   >>>      ERRO     <<<",
                        JOptionPane.ERROR_MESSAGE);
                ERRO = true;
            }
        } while (ERRO);
        return opcao;
    }

    static void Lutar(Heroi heroi, Monstro monstro, Bolsa bolsa) {
        int dano = 0, opcaoAtaque = 0, opcaoInventario = 0, valor = 0;
        heroi.setBolsa(bolsa);
        //  Item arma = new Item(1, 15, 0, 0);
        // Item armadura = new Item(2, 0, 15, 5);
        //  Item pocao = new Item(3, 0, 0, 15);                  // Esses itens serão usados somente para verificação se o heroi possui um deles na bolsa

        boolean furia = false;                 // Furia será usada pelo orc somente uma vez e só será resetada caso ele morra         
        // Furia:    false - não usou         true - ja usou

        imprimiStatusH(heroi);
        imprimiStatusM(monstro);
        while (heroi.hp > 0 && monstro.hp > 0) {
            System.out.println("\n\n\n");
            opcaoAtaque = menu();
            if (opcaoAtaque != 3 && opcaoAtaque != 4 && opcaoAtaque != 5 && opcaoAtaque != 6 && opcaoInventario != 6) {
                System.out.println("****************************************\n");
                System.out.println("             TURNO  1                   \n");
                System.out.println("****************************************\n");
            }

            switch (opcaoAtaque) {
                //Como atacar de monstro e heroi são diferente precisariam de parametros diferente nos dois
                // mas temos que suar atacar como está então deu set do heroi no monstro e vise versa
                //logo não precisamos de parametro no atacar pq monstro sabe o ataque do heroi
                case 1:
                    dano = heroi.atacar(heroi, monstro);
                    if (dano > 0) {
                        monstro.tomarDano(heroi, monstro);
                        if (heroi.ID == 1) {
                            System.out.println("Seu Guerreiro deu " + (dano + monstro.getArmadura()) + " de dano");
                        } else {
                            System.out.println("Seu Mago deu " + (dano + monstro.getArmadura()) + " de dano");
                        }

                        if (monstro.ID == 1) {
                            System.out.println("O Troll defendeu " + (monstro.getArmadura()) + " de dano");
                        } else {
                            System.out.println("O Orc defendeu " + (monstro.getArmadura()) + " de dano");
                        }
                        System.out.println("Dano total ao monstro: " + dano + "\n");
                    } else {
                        System.out.println("Dano total ao monstro: 0\n");
                    }
                    break;
                case 2:
                    if (heroi.ManaRage() < 2) {
                        if (heroi.ID == 1) {
                            System.out.println("Seu guerreiro usa o powerAttack() mas falha");
                            System.out.println("Rage insuficiente para usar habilidade");
                        } else {
                            System.out.println("Seu mago usa o bolaDeFogo() mas falha");
                            System.out.println("Mana insuficiente para usar habilidade");
                        }
                    } else {
                        heroi.usarHabilidade();
                        dano = heroi.atacar(heroi, monstro);

                        if (dano > 0) {
                            monstro.tomarDano(heroi, monstro);
                            heroi.habilidadeAtivada = false;   // Habilidade ja foi usada
                            if (heroi.ID == 1) {
                                System.out.println("Seu Guerreiro decide usar powerAttack()");
                                System.out.println("powerAttack():  Dobra o ataque do usuário");
                                System.out.println("deu " + (dano + monstro.getArmadura()) + " de dano");
                            } else {
                                System.out.println("Seu Mago decide usar bolaDeFogo()");
                                System.out.println("bolaDeFogo():  Dobra o ataque do usuário");
                                System.out.println("deu " + (dano + monstro.getArmadura()) + " de dano");
                            }

                            if (monstro.ID == 1) {
                                System.out.println("O Troll defendeu " + (monstro.getArmadura()) + " de dano");
                            } else {
                                System.out.println("O Orc defendeu " + (monstro.getArmadura()) + " de dano");
                            }
                            System.out.println("Dano total ao monstro: " + dano + "\n");
                        } else {
                            System.out.println("Dano total ao monstro: 0\n");
                        }
                    }
                    break;
                case 3:
                    opcaoInventario = menuInventario();
                    switch (opcaoInventario) {
                        case 1:
                            System.out.println("Você decide pegar uma de suas poções e usar");
                            heroi.getBolsa().usarItem(3, heroi);
                            break;
                        case 2:
                            valor = InOut.leInt("***********************************************\nEQUIPAR\n\nDigita o valor de DANO da ARMA que deseja equipar\n************************************************\n");
                            heroi.getBolsa().equipar(1, heroi, valor);
                            break;
                        case 3:
                            valor = InOut.leInt("***********************************************\nDESEQUIPAR\n\nDigita o valor de DANO da ARMA que deseja desequipar\n************************************************\n");
                            heroi.getBolsa().desequipar(1, heroi, valor);
                            break;
                        case 4:
                            valor = InOut.leInt("***********************************************\nEQUIPAR\n\nDigita o valor de DEFESA da ARMADURA que deseja equipar\n************************************************\n");
                            heroi.getBolsa().equipar(2, heroi, valor);
                            break;
                        case 5:
                            valor = InOut.leInt("***********************************************\nDESEQUIPAR\n\nDigita o valor de DEFESA da ARMADURA que deseja desequipar\n************************************************\n");
                            heroi.getBolsa().desequipar(2, heroi, valor);
                            break;
                    }

                    break;
                case 4:
                    System.out.println("* Você abri sua bolsa e observa :");
                    System.out.println("*************************************************");
                    System.out.println("*             INVENTÁRIO               ");
                    heroi.getBolsa().mostrarInventario();
                    System.out.println("*************************************************");

                    break;
                case 5:
                    imprimiStatusH(heroi);
                    imprimiStatusM(monstro);
                    break;
                case 6:
                    System.out.println("Você saiu do jogo");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

            if (opcaoAtaque != 3 && opcaoAtaque != 4 && opcaoAtaque != 5 && opcaoInventario != 6) {  //  inimigo não tem turno nesses casos 
                if (monstro.hp <= 0) {
                    monstro.EXPExtra();
                    monstro.morrer(heroi);
                    if (monstro.ID == 1) {
                        System.out.println("Parabéns você derrotou o Troll");
                        System.out.println("Você ganhou " + monstro.expGive + " de EXP");
                    } else {
                        System.out.println("Parabéns você derrotou o Orc");
                        System.out.println("Você ganhou " + monstro.expGive + " de EXP");
                        furia = false;
                    }

                    System.out.println("*******************************************\n");
                    System.out.println("*******************************************\n");
                    System.out.println("           MONSTRO ELIMINADO               \n");
                    System.out.println("*******************************************\n");
                    System.out.println("*******************************************\n\n\n\n\n");
                    break;
                }

                System.out.println("****************************************\n");
                System.out.println("             TURNO  2                   \n");
                System.out.println("****************************************\n");
                if (monstro.ID == 1) {     // Troll
                    Random gerador = new Random();
                    int ataque = gerador.nextInt(10) + 1;  //Numero entre 0 e 10
                    if (ataque <= 5) {
                        //ataque normal
                        dano = monstro.atacar(heroi, monstro);
                        if (dano > 0) {
                            heroi.tomarDano(heroi, monstro);
                            System.out.println("O troll deu " + (dano + heroi.getArmadura()) + " de dano");

                            if (heroi.ID == 1) {
                                System.out.println("Seu Guerreiro defendeu " + (heroi.getArmadura()) + " de dano");
                            } else {
                                System.out.println("Seu Mago defendeu " + (heroi.getArmadura()) + " de dano");
                            }
                            System.out.println("Dano total recebido: " + dano + "\n");
                        } else {
                            System.out.println("Dano total recebido: 0\n");
                        }
                    } else {
                        //Habilidade
                        monstro.usarHabilidade();
                        if (monstro.IDBOSS == 0) {
                            System.out.println("O Troll decide parar e recuperar um pouco de sua vida com Regenerar()");
                            System.out.println("Regenerar(): Regenera +5 de vida do usuário\n");
                        } else {
                            System.out.println("O Troll BOSS decide parar e recuperar sua vida com sua habilidade Regenerar() denominada Benção dos Deuses");
                            System.out.println("Benção dos Deuses: Regenera +15 de vida do usuário\n");
                        }
                    }
                } else {  //  Orc
                    if (monstro.hp <= monstro.HPmax / 2 && furia == false) {
                        monstro.usarHabilidade();
                        if (monstro.IDBOSS == 0) {
                            System.out.println("O Orc após olhar sua vida pela metade decide usar Furia()");
                            System.out.println("Furia() :  Dobra o dano do usuário\n");
                        } else {
                            System.out.println("O Orc BOSS após olhar sua vida pela metade decide usar Furia() denominada Furia Suprema");
                            System.out.println("Furia Suprema: triplica o dano do usuário\n");

                        }
                        furia = true;
                    }
                    dano = monstro.atacar(heroi, monstro);
                    if (dano > 0) {
                        heroi.tomarDano(heroi, monstro);
                        System.out.println("O Orc deu " + (dano + heroi.getArmadura()) + " de dano");

                        if (heroi.ID == 1) {
                            System.out.println("Seu Guerreiro defendeu " + (heroi.getArmadura()) + " de dano \n");
                        } else {
                            System.out.println("Seu Mago defendeu " + (heroi.getArmadura()) + " de dano\n");
                        }
                        System.out.println("Dano total ao recebido: " + dano + "\n");
                    } else {
                        System.out.println("Dano total ao recebido: 0\n");

                    }

                }
                imprimiStatusH(heroi);
                imprimiStatusM(monstro);
            }
        }
    }

    public static void main(String[] args) {
        int condicaoLvl = 50;     // começa com 50 e a cada lvl vai aumentando
        int dungeon;
        boolean bossDerrotado = false;
        Item pocao1 = new Item("Poção", 3, 0, 0, 15);
        Heroi heroi = criarHeroi();
        Bolsa bolsa = new Bolsa();
        heroi.setBolsa(bolsa);
        heroi.getBolsa().adicionarItem(pocao1);

        // A condição para passar de level é de 50 de XP para upar de level
        // quando passar de level a condição é 50 + 10
        while (heroi.hp > 0) {
            if (heroi.exp >= condicaoLvl) {
                heroi.passarLevel();
                condicaoLvl += 10;
            }
            if (heroi.level >= 1 && heroi.level <= 5) {                       // DUNGEON 1 : LEVEL entre 1 e 5 
                System.out.println("___________________________________________");
                System.out.println("*******************************************");
                System.out.println("                 DUNGEON 1                 ");
                System.out.println("*******************************************");
                System.out.println("───────────────────────────\n\n\n");
                dungeon = 1;
                Monstro monstro = criarMonstro(dungeon, heroi, bossDerrotado);
                Lutar(heroi, monstro, bolsa);
                if (heroi.level == 5) {
                    bossDerrotado = true;       // Aparece somente 1 boss
                }
            } else if (heroi.level >= 6 && heroi.level <= 10) {                // DUNGEON 2 : LEVEL entre 6 e 10
                System.out.println("___________________________________________");
                System.out.println("*******************************************");
                System.out.println("                 DUNGEON 2                 ");
                System.out.println("*******************************************");
                System.out.println("───────────────────────────\n\n\n");
                if (heroi.level == 6) {
                    bossDerrotado = false;
                }
                dungeon = 2;
                Monstro monstro = criarMonstro(dungeon, heroi, bossDerrotado);
                Lutar(heroi, monstro, bolsa);
                if (heroi.level == 10) {
                    bossDerrotado = true;       // Aparece somente 1 boss
                }
            } else if (heroi.level > 10) {
                System.out.println("Esse jogo não é a versão versão final, é a BETA então termina aqui");
                System.out.println("Obrigado por jogar e parabéns por terminar o jogo :D");
                System.out.println("Status final do heroi:\n");
                imprimiStatusH(heroi);
                System.exit(0);
            }
            Item item = criarDrops(heroi);               // cria um drop aleatório por derrotar o monstro :D
            heroi.getBolsa().adicionarItem(item);   // não precisa agradecer, pode pegar :DD
        }
    }
}