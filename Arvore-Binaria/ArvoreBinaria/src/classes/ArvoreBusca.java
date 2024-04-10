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

    private No BuscarNo(No no, int valor) {
        if (no.getValor() == valor) {
            System.out.println("O nó de valor " + valor + " foi encontrado.");
            return no;
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
        return null;
    }

    public No BuscarNo(int valor) {
        return BuscarNo(raiz, valor);
    }

    private void RemoverNo(No no, int valor) {
        No no1, no2;
        if (no == null) {
            System.out.println("O nó de valor " + valor + " não foi encontrado.");
       } else {
        if (no.getValor() == valor) {
            if (no.getEsquerda() == null && no.getDireita() == null) {
                no = null;
            } else {
                if (no.getEsquerda() != null && no.getDireita() == null) {
                    no.setNo(no.getEsquerda());
                }
                if (no.getEsquerda() == null && no.getDireita() != null) {
                    no.setNo(no.getDireita());
                }
                if (no.getEsquerda() != null && no.getDireita() != null) {
                    no1 = no;
                    no2 = no.getEsquerda();
                    while (no2.getDireita() != null) {
                        no1 = no2;
                        no2 = no2.getDireita();
                    }
                    if (no1 != no) {
                        no1.setDireita(no2.getEsquerda());
                        no2.setEsquerda(no.getEsquerda());
                    }
                    no.setValor(no2.getValor());
                    no2 = no2.getEsquerda();
                    no1 = no2;
                    no1 = null; 
                }
            }
        } else if (valor > no.getValor()) {
            RemoverNo(no.getDireita(), valor);
        } else if (valor < no.getValor()) {
            RemoverNo(no.getEsquerda(), valor);
        }
       }
    }

    public void RemoverNo (int valor) {
        RemoverNo(this.raiz, valor);
    }
}
