package inko.steinherz;

import java.util.Scanner;

public class Main {

    static int numbersOfPlayer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество игроков: ");
        numbersOfPlayer = sc.nextInt();

        Game game = new Game();

        game.initPlayers();
        game.showPlayers();
        game.setPlayerDice();
        game.showPlayerDice();
        game.whoIsWin();



        //System.out.println("");

    }
}
