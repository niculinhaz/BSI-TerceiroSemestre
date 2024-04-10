package classes;

public class ArvoreAVL extends ArvoreBusca {
    private int getFatorBalanceamento(No no) {
        return getAltura(no.getDireita()) - getAltura(no.getEsquerda());
    }

    protected void AdicionarNo(No no, int valor) {}
    private void RotacaoDireita() {}
    private void RotacaoEsquerda() {}

}
