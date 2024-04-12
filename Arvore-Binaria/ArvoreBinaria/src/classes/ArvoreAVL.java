package classes;

public class ArvoreAVL extends ArvoreBusca {
    public ArvoreAVL() {
        super();
    }

    public ArvoreAVL(int valor) {
        super(valor);
    }

    private int getFatorBalanceamento(No no) {
        return getAltura(no.getDireita()) - getAltura(no.getEsquerda());
    }

    private void verificarBalanceamento (No no, No pai, int fb) {
        if (fb > 1) {
            if (getFatorBalanceamento(no.getDireita()) > 0) {
                RotacaoEsquerda(pai, no);
            } else {
                RotacaoDireita(no, no.getDireita());
                RotacaoEsquerda(pai, no);
            }
        } else if (fb < -1) {
            if (getFatorBalanceamento(no.getEsquerda()) < 0) {
                RotacaoDireita(pai, no);
            } else {
                RotacaoEsquerda(no, no.getEsquerda());
                RotacaoDireita(pai, no);
            }
        }
    }

    protected void AdicionarNo(No no, No pai, int valor) {
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
                    AdicionarNo(no.getEsquerda(), no, valor);
                }
            } else if (valor > no.getValor()) {
                if (no.getDireita() == null) {
                    no.setDireita(new No(valor));
                    System.out.println("Valor adicionado com sucesso!");
                } else {
                    AdicionarNo(no.getDireita(), no, valor);
                }
            }
        }

        int fb = getFatorBalanceamento(no);
        if (fb >= 2 || fb <= 2) verificarBalanceamento(no, pai, fb);

    }

    @Override
    public void AdicionarNo (int valor) {
        AdicionarNo(this.raiz, this.raiz, valor);
    }

    private void RotacaoDireita(No pai, No desbalanceado) {
        No k = desbalanceado.getEsquerda();
        No t1 = k.getDireita();

        k.setDireita(desbalanceado);
        desbalanceado.setEsquerda(t1);

        if (desbalanceado == this.raiz) {
            this.raiz = k;
        } else if (pai.getDireita() == desbalanceado) {
            pai.setDireita(k);
        } else if (pai.getEsquerda() == desbalanceado) {
            pai.setEsquerda(k);
        }
    }

    private void RotacaoEsquerda(No pai, No desbalanceado) {
        No k = desbalanceado.getDireita();
        No t1 = k.getEsquerda();

        k.setEsquerda(desbalanceado);
        desbalanceado.setDireita(t1);

        if (desbalanceado == this.raiz) {
            this.raiz = k;
        } else if (pai.getEsquerda() == desbalanceado) {
            pai.setEsquerda(k);
        } else if (pai.getDireita() == desbalanceado) {
            pai.setDireita(k);
        }
    }
}
