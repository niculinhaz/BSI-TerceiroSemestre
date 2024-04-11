package classes;

public class Impressora {
    /*
     * Créditos ao usuário CoderMJLee!!
     */
    
    private Arvore arvore;
    private static String adicionarDireito = "";
    private static String adicionarEsquerdo = "";
    private static String adicionarVazio = "";
    private static String adicionarLinha = "";

    static {
        int length = 2;
        adicionarDireito = "┌" + repetir("─", length);
        adicionarEsquerdo = "└" + repetir("─", length);
        adicionarVazio = vazio(length + 1);
        adicionarLinha = "|" + vazio(length);
    }

    public Impressora (Arvore a) {
        this.arvore = a;
    }

    public String imprimirArvore () {
        StringBuilder string  = new StringBuilder(
            imprimirArvore(arvore.getRaiz(), "", "", "")
        );
        string.deleteCharAt(string.length() - 1);
        return string.toString();
    }

    private String imprimirArvore (
            No no,
            String noAnterior,
            String esquerdoAnterior,
            String direitoAnterior
    ) {
        No esquerda = no.getEsquerda();
        No direita = no.getDireita();
        String string = no.toString();

        int length = string.length();
        if (length % 2 == 0) {
            length --;
        }
        length >>= 1;

        String noString = "";
        if (direita != null) {
            direitoAnterior += vazio(length);
            noString += imprimirArvore(direita, 
            direitoAnterior + adicionarDireito, 
            direitoAnterior + adicionarLinha,
            direitoAnterior + adicionarVazio);
        }
        noString += noAnterior + string + "\n";
        if (esquerda != null) {
            esquerdoAnterior += vazio(length);
            noString += imprimirArvore(esquerda,
            esquerdoAnterior + adicionarEsquerdo,
            esquerdoAnterior + adicionarLinha,
            esquerdoAnterior + adicionarVazio);
        }
        return noString;
    }

    public static String repetir(String string, int count) {
		if (string == null) return null;
		
		StringBuilder builder = new StringBuilder();
		while (count-- > 0) {
			builder.append(string);
		}
		return builder.toString();
	}
	
	public static String vazio(int length) {
		if (length < 0) return null;
		if (length == 0) return "";
		return String.format("%" + length + "s", "");
	}
}
