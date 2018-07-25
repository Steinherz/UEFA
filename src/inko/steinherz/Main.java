package inko.steinherz;

import java.util.Scanner;

public class Main {

    static int numbersOfPlayer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество игроков: ");
        numbersOfPlayer = sc.nextInt();                         //задаем в консоли количесвто игроков

        Game game = new Game();

        game.initPlayers();            //Запуск метода в котором даем имена игрокам
        game.showPlayers();            // Показ всех игроков
        game.whoIsWin();               // Определение победителя



        //System.out.println("");

    }
}
