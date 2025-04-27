package jogo;

import personagem.CPU;
import personagem.Jogador;

import java.util.Random;

public class Luta {
    private int rounds;
    private Jogador jogador;
    private CPU cpu;
    private Random random = new Random();

    public Luta(int rounds) {
        this.rounds = rounds;
        this.jogador = new Jogador("Jogador");
        this.cpu = new CPU("CPU");
    }

    public void iniciar() {
        System.out.println("Bem-vindo à luta de boxe!");

        for (int i = 1; i <= rounds; i++) {
            simularRound(i);
        }

        System.out.println("\n--- Fim da luta! ---");
        if (jogador.getPontuacao() > cpu.getPontuacao()) {
            System.out.printf("%s vence com %d pontos contra %d pontos!\n",
                    jogador.getNome(), jogador.getPontuacao(), cpu.getPontuacao());
        } else if (cpu.getPontuacao() > jogador.getPontuacao()) {
            System.out.printf("%s vence com %d pontos contra %d pontos!\n",
                    cpu.getNome(), cpu.getPontuacao(), jogador.getPontuacao());
        } else {
            System.out.printf("A luta terminou empatada com %d pontos para cada lado!\n", jogador.getPontuacao());
        }
    }

    private void simularRound(int numeroRound) {
        System.out.println("\n--- Round " + numeroRound + " ---");

        String golpeJogador = jogador.escolherGolpe();
        String golpeCPU = cpu.escolherGolpe();

        boolean acertoJogador = random.nextBoolean();
        boolean acertoCPU = random.nextBoolean();

        if (acertoJogador) {
            jogador.acertarGolpe(golpeJogador);
            System.out.println(jogador.getNome() + " acertou um " + golpeJogador + "!");
        } else {
            System.out.println(jogador.getNome() + " errou o " + golpeJogador + ".");
        }

        if (acertoCPU) {
            cpu.acertarGolpe(golpeCPU);
            System.out.println(cpu.getNome() + " acertou um " + golpeCPU + "!");
        } else {
            System.out.println(cpu.getNome() + " errou o " + golpeCPU + ".");
        }

        System.out.printf("Pontuação: %s %d - %s %d\n",
                jogador.getNome(), jogador.getPontuacao(), cpu.getNome(), cpu.getPontuacao());
    }
}