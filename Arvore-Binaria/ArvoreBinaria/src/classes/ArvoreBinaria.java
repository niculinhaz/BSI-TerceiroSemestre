package classes;

public class ArvoreBinaria extends Arvore {

    protected void AdicionarNo (No no, int valor) {
        if (no == null) {
            no = new No(valor);
        }   else if (no.getValor() < valor) {
            if (no.getDireita() == null) {
                no.setDireita(new No(valor));
            } else {
                AdicionarNo(no.getDireita(), valor);
            }
        }   else {
            if (no.getEsquerda() == null) {
                no.setEsquerda(new No(valor));
            } else {
                AdicionarNo(no.getEsquerda(), valor);
            }
        }
    }
}
