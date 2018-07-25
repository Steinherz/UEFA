package inko.steinherz;

import java.util.Scanner;

class Game {

    private Player[] player = new Player[Main.numbersOfPlayer];

    void initPlayers() {
        for (int i = 0; i < Main.numbersOfPlayer; i++) {
            Scanner sc = new Scanner(System.in);
            player[i] = new Player();
            player[i].setNumberOf(i + 1);
            System.out.println("Введите имя игрока №" + player[i].getNumberOf());
            player[i].setNamePlayer(sc.nextLine());
        }
    }

    void showPlayers() {
        System.out.println("Игроки принимающие участие:");
        for (int i = 0; i < Main.numbersOfPlayer; i++) {
            System.out.print("'" + player[i].getNamePlayer() + "'" + "\t");
        }
        System.out.println();
    }

    private void setPlayerDice() {
        for (int i = 0; i < Main.numbersOfPlayer; i++) {
            if (player[i].isInGame())
                player[i].setUefaDice((int) (Math.random() * 3));
        }
    }

    private void showPlayerDice() {
        System.out.println("Игроки кидают пальцы ");
        for (int i = 0; i < Main.numbersOfPlayer; i++) {
            if (player[i].isInGame()) {
                System.out.print("'" + player[i].getNamePlayer() + "'" + "\t");
                System.out.println("'" + player[i].getUefaDice() + "'" + "\t");
            }
        }
    }

    void whoIsWin() {
        int winners = 0;
        while (winners != 1) {
            System.out.println("###############################");
            setPlayerDice();
            showPlayerDice();
            int st = 0;
            int kn = 0;
            int pap = 0;
            for (int i = 0; i < Main.numbersOfPlayer; i++) {
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
            System.out.println("Что выкинули игроки: ");
            System.out.println("Stone: " + st +
                    "\tKnife: " + kn +
                    "\tPapper: " + pap);

            if ((st > 0 && kn > 0 && pap > 0) || (st > 0 && kn == 0 && pap == 0) || (st == 0 && kn > 0 && pap == 0) || (st == 0 && kn == 0 && pap > 0)) {
                System.out.println("Ничия, играем дальше!");
            } else {
                winners = countWinners(st, kn, pap);
                if (winners != 1) {
                    System.out.println("Определяем победителя дальше!");
                    System.out.println("Количество играющих дальше: " + winners);
                }
            }
            if (winners == 1) {
                System.out.println("Победитель определен!");
                for (int i = 0; i < Main.numbersOfPlayer; i++) {
                    if (player[i].isInGame())
                        System.out.println("Победитель - " + player[i].getNamePlayer() + " !");
                }
            }
        }
    }

    private int countWinners(int st, int kn, int pap) {
        int winners = 0;
        if (st > 0 && kn > 0) {
            for (int i = 0; i < Main.numbersOfPlayer; i++) {
                if (player[i].getUefaDice().equals("stone")) {
                    player[i].setWinner(true);
                    player[i].setInGame(true);
                    winners += 1;
                } else player[i].setInGame(false);
            }
        } else if (st > 0 && pap > 0) {
            for (int i = 0; i < Main.numbersOfPlayer; i++) {
                if (player[i].getUefaDice().equals("papper")) {
                    player[i].setWinner(true);
                    player[i].setInGame(true);
                    winners += 1;
                } else player[i].setInGame(false);
            }
        } else if (pap > 0 && kn > 0) {
            for (int i = 0; i < Main.numbersOfPlayer; i++) {
                if (player[i].getUefaDice().equals("knife")) {
                    player[i].setWinner(true);
                    player[i].setInGame(true);
                    winners += 1;
                } else player[i].setInGame(false);
            }
        }
        return winners;
    }
}
