package classes;

public class ArvoreBusca extends Arvore{

    public ArvoreBusca () {
        this.raiz = null;
    }

    public ArvoreBusca(int valor) {
        setRaiz(valor);
    }

    protected void AdicionarNo(No no, int valor) {
        if (no == null) {
            no = new No(valor);
        } else if (no.getValor() == valor) {
            System.out.println("O valor já existe na árvore!");
        } else {
            if (valor < no.getValor()) {
                if (no.getEsquerda() == null) {
                    no.setEsquerda(new No(valor));
                } else {
                    AdicionarNo(no.getEsquerda(), valor);
                }
            } else {
                if (no.getDireita() == null) {
                    no.setDireita(new No(valor));
                } else {
                    AdicionarNo(no.getDireita(), valor);
                }
            }
        }
    }

    public void BuscarNo(No no, int valor) {
        if (no.getValor() == valor) {
            System.out.println("O nó de valor " + valor + " foi encontrado.");
        } else {
            if (valor < no.getValor()) {
                if (no.getEsquerda() == null) {
                    System.out.println("O nó de valor " + valor + " não foi encontrado.");
                } else {
                    BuscarNo(no.getEsquerda(), valor);
                }
            } else {
                if (valor > no.getValor()) {
                    if (no.getDireita() == null) {
                        System.out.println("O nó de valor " + valor + " não foi encontrado.");
                    } else {
                        BuscarNo(no.getDireita(), valor);
                    }
                }
            }
        }

    }

    public void BuscarNo(int valor) {
        if (raiz.getValor() == valor) {
            System.out.println("O nó de valor " + valor + " foi encontrado.");
        } else {
            BuscarNo(raiz, valor);
        }
    }

    public void RemoverNo() {}
}
