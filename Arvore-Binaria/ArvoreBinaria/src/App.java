import classes.*;

import java.util.Scanner;

public class App {
    public static void continuar (Scanner s) {
        System.out.println("Pressione enter para continuar.");
        s.nextLine();
    }

    public static void limpar () {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Erro no comando: " + e);
        }
    }

    public static void menuOperacoes (Arvore a, Scanner s) {
        boolean menu = true;
        while (menu) {
            limpar();
            System.out.println("Por favor, insira a operação que deseja realizar.");
            System.out.println("1 - Adicionar nó;\n2 - Buscar nó;\n3 - Remover nó\n4 - Exibir a árvore;\n5 - Calcular a altura;"
            + "\n6 - Calcular os níveis;\n7 - Verificar quantos nós existem;\n8 - Verificar se a árvore é completa.\n9 - Encerrar.");
            int e2 = s.nextInt();
            s.nextLine();
            switch (e2) {
                case 1:
                limpar();
                System.out.println("Insira o valor do nó que deseja adicionar.");
                a.AdicionarNo(s.nextInt());
                s.nextLine();
                continuar(s);
                break;
                case 2:
                limpar();
                System.out.println("Insira o valor do nó que deseja buscar.");
                a.BuscarNo(s.nextInt());
                s.nextLine();
                continuar(s);
                break;
                case 3:
                limpar();
                if (a instanceof ArvoreAVL) {
                    System.out.println("A remoção em árvores AVL ainda não foi implementada.");
                    continuar(s);
                } else {   
                    System.out.println("Insira o valor do nó que deseja remover.");
                    a.RemoverNo(s.nextInt());
                    s.nextLine();
                } break;
                case 4:
                limpar();
                System.out.println("Deseja exibir a árvore percorrendo-a de que forma?");
                System.out.println("1 - Em ordem;\n2 - Pré-Ordem;\n3 - Pós-Ordem\n4 - Em largura\n5 - Exibição gráfica");
                int e3 = s.nextInt();
                s.nextLine();
                System.out.println();
                switch (e3) {
                    case 1:
                    limpar();
                    a.EmOrdem(a.getRaiz());
                    System.out.println();
                    continuar(s);
                    break;
                    case 2:
                    limpar();
                    a.PreOrdem(a.getRaiz());
                    System.out.println();
                    continuar(s);
                    break;
                    case 3:
                    limpar();
                    a.PosOrdem(a.getRaiz());
                    System.out.println();
                    continuar(s);
                    break;
                    case 4:
                    limpar();
                    a.EmLargura(a.getRaiz());
                    System.out.println();
                    continuar(s);
                    case 5:
                    limpar();
                    Impressora p = new Impressora(a);
                    System.out.println(p.imprimirArvore());
                    System.out.println();
                    continuar(s);
                    default:
                    System.out.println("Código inválido. Tente novamente."); break;
                } break;
                case 5:
                    limpar();
                    System.out.println("A altura da árvore atualmente é " + a.getAltura(a.getRaiz())); 
                    continuar(s);
                    break;
                case 6:
                    limpar();
                    System.out.println("A árvore atualmente possui " + a.getNiveis(a.getRaiz()) + " níveis."); 
                    continuar(s);
                    break;
                case 7:
                    limpar();
                    System.out.println("A árvore atualmente possui " + a.ContarNos(a.getRaiz()) + " nós."); 
                    continuar(s);
                    break;
                case 8:
                    limpar();
                    if (a.eCompleta()) System.out.println("A árvore atualmente é completa.");
                    else System.out.println("A árvore não é completa.");
                    continuar(s);
                    break;
                case 9:
                    System.out.println("Obrigado por utilizar! :)");
                    s.close();
                    menu = false; break;
                default:
                    System.out.println("O número que você selecionou é inválido. Tente novamente.");
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        limpar();
        System.out.println("Bem-vindo ao sistema de árvores.");
        continuar(sc);
        System.out.println("Selecione o tipo de árvore que deseja criar:");
        System.out.println("1 - Árvore binária;\n2 - Árvore de busca binária\n3 - Árvore de busca balanceada (AVL)");
        int e1 = sc.nextInt();
        sc.nextLine();
        switch (e1) {
            case 1:
                ArvoreBinaria arv = new ArvoreBinaria();
                System.out.println("Árvore criada! Por favor, insira um valor para sua raíz.");
                try {
                    arv.setRaiz(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Raíz inserida com sucesso!");
                    menuOperacoes(arv, sc);
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro ao inserir a raíz. Tente novamente.");
                }
                break;
            case 2:
                ArvoreBusca arvbus = new ArvoreBusca();
                System.out.println("Árvore criada! Por favor, insira um valor para sua raíz.");
                try {
                    arvbus.setRaiz(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Raíz inserida com sucesso!");
                    menuOperacoes(arvbus, sc);
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro ao inserir a raíz. Tente novamente.");
                }
                break;
            case 3:
                ArvoreAVL arvavl = new ArvoreAVL();
                System.out.println("Árvore criada! Por favor, insira um valor para sua raíz.");
                try {
                    arvavl.setRaiz(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Raíz inserida com sucesso!");
                    menuOperacoes(arvavl, sc);
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro ao inserir a raíz. Tente novamente.");
                }
                break;
            default:
                System.out.println("O número que você inseriu é inválido. Por favor, tente novamente.");
        }
    }
}
