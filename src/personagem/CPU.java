package personagem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CPU extends Lutador {
    private Random random = new Random();

    public CPU(String nome) {
        super(nome);
    }

    @Override
    public String escolherGolpe() {
        List<String> listaGolpes = new ArrayList<>(golpes.keySet());
        return listaGolpes.get(random.nextInt(listaGolpes.size()));
    }
}