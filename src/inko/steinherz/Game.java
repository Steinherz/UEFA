package inko.steinherz;

import java.util.Scanner;

class Game {

    private Player[] player = new Player[Main.numbersOfPlayer];                     //Создание массива объектов Игрок

    void initPlayers() {                                                            //Задаем игрокам их имена
        for (int i = 0; i < Main.numbersOfPlayer; i++) {
            Scanner sc = new Scanner(System.in);
            player[i] = new Player();
            player[i].setNumberOf(i + 1);
            System.out.println("Введите имя игрока №" + player[i].getNumberOf());
            player[i].setNamePlayer(sc.nextLine());
        }
    }

    void showPlayers() {                                        //Показываем имена игроков
        System.out.println("Игроки принимающие участие:");
        for (int i = 0; i < Main.numbersOfPlayer; i++) {
            System.out.print("'" + player[i].getNamePlayer() + "'" + "\t");
        }
        System.out.println();
    }

    private void setPlayerDice() {                              //Рандом задает, что показали игроки (камень, ножницы, бумагу)
        for (int i = 0; i < Main.numbersOfPlayer; i++) {
            if (player[i].isInGame())
                player[i].setUefaDice((int) (Math.random() * 3));
        }
    }

    private void showPlayerDice() {                             //Вывод на экран что показали игроки
        System.out.println("Игроки кидают пальцы ");
        for (int i = 0; i < Main.numbersOfPlayer; i++) {
            if (player[i].isInGame()) {
                System.out.print("'" + player[i].getNamePlayer() + "'" + "\t");
                System.out.println("'" + player[i].getUefaDice() + "'" + "\t");
            }
        }
    }

    void whoIsWin() {
        int round = 1;                      //счетчик количества раундов
        int winners = 0;                    //счетчик победителей
        while (winners != 1) {              //Работа всего говнокода пока не будет 1 победитель
            System.out.println("########### Раунд № " + round + " ###########");
            setPlayerDice();                //Вызов метода задающий рандомно что показали игроки
            showPlayerDice();               //Вызов метода что показали игроки
            int st = 0;                     //сч                ко    по             камней
            int kn = 0;                     //  ет           ль         ка           ножниц
            int pap = 0;                    //    чик     ско             зано       бумаг
            for (int i = 0; i < Main.numbersOfPlayer; i++) {  //считаем сколько чего показано
                {
                    if (player[i].isInGame()) {
                        switch (player[i].getUefaDice()) {
                            case "stone":
                                st += 1;
                                break;
                            case "knife":
                                kn += 1;
                                break;
                            case "papper":
                                pap += 1;
                                break;
                        }
                    }
                }
            }
            System.out.println("Что показали игроки: ");
            System.out.println("Stone: " + st +
                    "\tKnife: " + kn +
                    "\tPapper: " + pap);

            //дальше условие на ничию: когда показаны все "фигуры" или только 1 "фигура"
            if ((st > 0 && kn > 0 && pap > 0) || (st > 0 && kn == 0 && pap == 0) || (st == 0 && kn > 0 && pap == 0) || (st == 0 && kn == 0 && pap > 0)) {
                System.out.println("Ничия, играем дальше!");
            } else {
                winners = countWinners(st, kn, pap);        //если не ничия, то определяем победителя и их количество
                if (winners != 1) {
                    System.out.println("Определяем победителя дальше!");
                    System.out.println("Количество играющих дальше: " + winners);
                }
            }
            if (winners == 1) {                             // если победитель остался один, выводим его на экран и завершается while
                System.out.println("Победитель определен!");
                for (int i = 0; i < Main.numbersOfPlayer; i++) {
                    if (player[i].isInGame())
                        System.out.println("Победитель - " + player[i].getNamePlayer() + " !");
                }
            }
            round += 1;
        }
    }

    private int countWinners(int st, int kn, int pap) {        //метод, в  котором определяем победителей и их количество
        int winners = 0;
        if (st > 0 && kn > 0) {
            for (int i = 0; i < Main.numbersOfPlayer; i++) {
                if (player[i].getUefaDice().equals("stone")) {
                    //player[i].setInGame(true);
                    winners += 1;
                } else player[i].setInGame(false);
            }
        } else if (st > 0 && pap > 0) {
            for (int i = 0; i < Main.numbersOfPlayer; i++) {
                if (player[i].getUefaDice().equals("papper")) {
                    //player[i].setInGame(true);
                    winners += 1;
                } else player[i].setInGame(false);
            }
        } else if (pap > 0 && kn > 0) {
            for (int i = 0; i < Main.numbersOfPlayer; i++) {
                if (player[i].getUefaDice().equals("knife")) {
                    //player[i].setInGame(true);
                    winners += 1;
                } else player[i].setInGame(false);
            }
        }
        return winners;
    }
}
