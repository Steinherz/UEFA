package inko.steinherz;

import java.util.Scanner;

public class Main {

    static int numbersOfPlayer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество игроков: ");
        numbersOfPlayer = sc.nextInt();                         //задаем в консоли количесвто игроков

        int isGame = 1;
        while (isGame > 0) {
            if (numbersOfPlayer > 1) {
                Game game = new Game();


                //game.initPlayers();          //Запуск метода в котором даем имена игрокам
                game.initPlayersAuto();        //Запуск метода в котором автоматически задаются имена игрокам
                game.showPlayers();            // Показ всех игроков
                game.whoIsWin();               // Определение победителя
            } else {
                System.out.println("Для игры необходимо 2 или больше игроков");
            }

            System.out.println("Повторить игру? Да - нажминте 1, нет - нажмите 0: ");
            isGame = sc.nextInt();
        }


        //System.out.println("");

    }
}
