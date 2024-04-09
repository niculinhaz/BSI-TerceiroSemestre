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

    public void PreOrdem (No no) {
        if (no == null) return;
        else {
            System.out.println(no.toString());
            PreOrdem(no.getEsquerda());
            PreOrdem(no.getDireita());
        }
    }

    public void EmOrdem (No no) {
        if (no == null) return;
        else {
            EmOrdem(no.getEsquerda());
            System.out.println(no.toString());
            EmOrdem(no.getDireita());   
        }
    }

    public void PosOrdem (No no) {
        if (no == null) return;
        else {
            PosOrdem(no.getEsquerda());
            PosOrdem(no.getDireita());
            System.out.println(no.toString());
        }
    }
}
