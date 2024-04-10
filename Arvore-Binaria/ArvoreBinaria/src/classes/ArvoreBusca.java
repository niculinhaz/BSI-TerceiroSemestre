package classes;

public class ArvoreBusca extends Arvore {

    public ArvoreBusca () {
        super();
    }

    public ArvoreBusca(int valor) {
        super(valor);
    }

    protected void AdicionarNo(No no, int valor) {
        if (no == null) {
            no = new No(valor);
            System.out.println("Valor adicionado com sucesso!");
        } else if (no.getValor() == valor) {
            System.out.println("O valor já existe na árvore!");
        } else {
            if (valor < no.getValor()) {
                if (no.getEsquerda() == null) {
                    no.setEsquerda(new No(valor));
                    System.out.println("Valor adicionado com sucesso!");
                } else {
                    AdicionarNo(no.getEsquerda(), valor);
                }
            } else {
                if (no.getDireita() == null) {
                    no.setDireita(new No(valor));
                    System.out.println("Valor adicionado com sucesso!");
                } else {
                    AdicionarNo(no.getDireita(), valor);
                }
            }
        }
    }

    private void RemoverNo(No no, No anterior, int valor) {
        No no1, no2;
        if (no == null) {
            System.out.println("O nó de valor " + valor + " não foi encontrado.");
       } else {
        if (no.getValor() == valor) {
            if (no.getEsquerda() == null && no.getDireita() == null) {
                if (anterior.getDireita() == no) {
                    anterior.setDireita(null);
                } else if (anterior.getEsquerda() == no) {
                    anterior.setEsquerda(null);
                }
                no = null;
                System.out.println("Nó removido com sucesso!");
            } else {
                if (no.getEsquerda() != null && no.getDireita() == null) {
                    anterior.setEsquerda(no.getEsquerda());
                    no = null;
                    System.out.println("Nó removido com sucesso!");
                } else if (no.getEsquerda() == null && no.getDireita() != null) {
                    anterior.setDireita(no.getDireita());
                    no = null;
                    System.out.println("Nó removido com sucesso!");
                } else if (no.getEsquerda() != null && no.getDireita() != null) {
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
                    no2.setDireita(no.getDireita());
                    if (anterior.getDireita() == no) {
                        anterior.setDireita(no2);
                    } else if (anterior.getEsquerda() == no) {
                        anterior.setEsquerda(no2);
                    } else if (no == this.raiz) {
                        this.raiz = no2;
                    }
                    no = null;
                    System.out.println("Nó removido com sucesso!");
                }
            }
        } else if (valor > no.getValor()) {
            RemoverNo(no.getDireita(), no, valor);
        } else if (valor < no.getValor()) {
            RemoverNo(no.getEsquerda(), no, valor);
        }
       }
    }

    public void RemoverNo (int valor) {
        RemoverNo(this.raiz, this.raiz, valor);
    }
}
