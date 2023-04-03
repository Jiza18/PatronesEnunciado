import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Game {

    Confetti confetti;
    ScoreSaver scoreSaver;

    interface NotificarEvento {
        void onWin(int tries);
    }

    List <NotificarEvento> observer = new ArrayList<>();

    public Game(Confetti confetti, ScoreSaver scoreSaver) {
        this.confetti = confetti;
        this.scoreSaver = scoreSaver;
    }

    void start(){
        int guess = ThreadLocalRandom.current().nextInt(10);
        Scanner scanner = new Scanner(System.in);
        int tries = 1;
        while(true) {
            int num = scanner.nextInt();
            if (num == guess) break;
            tries++;
        }

        confetti.onWin(tries);
        scoreSaver.onWin(tries);
    }
}

class Confetti implements Game.NotificarEvento {
    @Override
    public void onWin(int tries) {
        System.out.println("\uD83C\uDF89".repeat(tries));
    }
}

class ScoreSaver implements Game.NotificarEvento{
    @Override
    public void onWin(int tries) {
        try { Files.writeString(Path.of("score.txt"), "intentos:" + tries); } catch (IOException ignored) {}
    }
}

public class Main {
    public static void main(String[] args) {

        Confetti confetti = new Confetti();
        ScoreSaver scoreSaver = new ScoreSaver();

        Game game = new Game(confetti, scoreSaver);

        game.start();
    }
}