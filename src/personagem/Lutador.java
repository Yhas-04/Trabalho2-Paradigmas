package personagem;

import java.util.*;

public abstract class Lutador {
    protected String nome;
    protected int pontuacao;
    protected static final Map<String, Integer> golpes = new HashMap<>();

    static {
        golpes.put("jab", 10);
        golpes.put("cruzado", 15);
        golpes.put("uppercut", 20);
    }

    public Lutador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
    }

    public abstract String escolherGolpe();

    public void acertarGolpe(String golpe) {
        pontuacao += golpes.get(golpe);
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public String getNome() {
        return nome;
    }
}