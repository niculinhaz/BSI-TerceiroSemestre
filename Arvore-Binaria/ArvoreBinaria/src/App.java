import classes.*;

import java.util.Scanner;

public class App {
    public static void continuar (Scanner s) {
        System.out.println("Pressione enter para continuar.");
        s.nextLine();
    }

    public static void menuOperacoes (Arvore a, Scanner s) {
        boolean menu = true;
        while (menu) {
            System.out.println("Por favor, insira a operação que deseja realizar.");
            System.out.println("1 - Adicionar nó;\n2 - Buscar nó;\n3 - Remover nó\n4 - Exibir a árvore;\n5 - Calcular a altura;\n6 - Calcular os níveis;\n7 - Verificar quantos nós existem;\n8 - Verificar se a árvore é completa.\n9 - Encerrar.");
            int e2 = s.nextInt();
            switch (e2) {
                case 1:
                System.out.println("Insira o valor do nó que deseja adicionar.");
                a.AdicionarNo(s.nextInt());
                continuar(s);
                break;
                case 2:
                System.out.println("Insira o valor do nó que deseja buscar.");
                a.BuscarNo(s.nextInt());
                continuar(s);
                break;
                case 3:
                System.out.println("Ainda não está pronto."); break;
                case 4:
                System.out.println("Deseja exibir a árvore percorrendo-a de que forma?");
                System.out.println("1 - Em ordem;\n2 - Pré-Ordem;\n3 - Pós-Ordem");
                int e3 = s.nextInt();
                switch (e3) {
                    case 1:
                    a.EmOrdem(a.getRaiz()); 
                    continuar(s);
                    break;
                    case 2:
                    a.PreOrdem(a.getRaiz()); 
                    continuar(s);
                    break;
                    case 3:
                    a.PosOrdem(a.getRaiz());
                    continuar(s);
                    break;
                    default:
                    System.out.println("Código inválido. Tente novamente."); break;
                } break;
                case 5:
                    System.out.println("A altura da árvore atualmente é " + a.getAltura(a.getRaiz())); 
                    continuar(s);
                    break;
                case 6:
                    System.out.println("A árvore atualmente possui " + a.getNiveis(a.getRaiz()) + " níveis."); 
                    continuar(s);
                    break;
                case 7:
                    System.out.println("A árvore atualmente possui " + a.ContarNos(a.getRaiz()) + " nós."); 
                    continuar(s);
                    break;
                case 8:
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
        System.out.println("Bem-vindo ao sistema de árvores.");
        continuar(sc);
        System.out.println("Selecione o tipo de árvore que deseja criar:");
        System.out.println("1 - Árvore binária;\n2 - Árvore de busca binária");
        int e1 = sc.nextInt();
        switch (e1) {
            case 1:
                ArvoreBinaria arv = new ArvoreBinaria();
                System.out.println("Árvore criada! Por favor, insira um valor para sua raíz.");
                try {
                    arv.setRaiz(sc.nextInt());
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
                    System.out.println("Raíz inserida com sucesso!");
                    menuOperacoes(arvbus, sc);
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro ao inserir a raíz. Tente novamente.");
                }
                break;
            default:
            System.out.println("O número que você inseriu é inválido. Por favor, tente novamente.");
        }
    }
}
