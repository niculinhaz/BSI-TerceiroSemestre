package classes;

public class ArvoreBinaria extends Arvore {

    protected void AdicionarNo (No no, int valor) {
        if (no == null) {
            no = new No(valor);
            System.out.println("Nó adicionado com sucesso.");
        }   else if (no.getValor() < valor) {
            if (no.getDireita() == null) {
                no.setDireita(new No(valor));
                System.out.println("Nó adicionado com sucesso.");
            } else {
                AdicionarNo(no.getDireita(), valor);
            }
        }   else {
            if (no.getEsquerda() == null) {
                no.setEsquerda(new No(valor));
                System.out.println("Nó adicionado com sucesso.");
            } else {
                AdicionarNo(no.getEsquerda(), valor);
            }
        }
    }
}
