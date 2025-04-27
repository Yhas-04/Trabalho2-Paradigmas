package personagem;

import java.util.Scanner;

public class Jogador extends Lutador {
    private Scanner scanner = new Scanner(System.in);

    public Jogador(String nome) {
        super(nome);
    }

    @Override
    public String escolherGolpe() {
        int opcao = 0;
        while (opcao < 1 || opcao > 3) {
            try {
                System.out.println("\nEscolha seu golpe:");
                System.out.println("1 - Jab (10 pontos)");
                System.out.println("2 - Cruzado (15 pontos)");
                System.out.println("3 - Uppercut (20 pontos)");
                System.out.print("Digite o número do golpe: ");
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Ignorar erro de input
            }
        }

        switch (opcao) {
            case 1:
                return "jab";
            case 2:
                return "cruzado";
            case 3:
                return "uppercut";
            default:
                return "jab"; // fallback
        }
    }
}