package inko.steinherz;

class Player {
    private int numberOf;               //номер игрока
    private String namePlayer;          //Имя игрока
    private String uefaDice;            //Хранит что выкинул игрок (камень, ножницы, бумага)
    private boolean inGame = true;      //Состояние игрока: в игре или нет

    int getNumberOf() {
        return numberOf;
    }

    void setNumberOf(int numberOf) {
        this.numberOf = numberOf;
    }

    String getNamePlayer() {
        return namePlayer;
    }

    void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    String getUefaDice() {
        return uefaDice;
    }

    void setUefaDice(int uefaDice) {            //В зависимости от рандомного чила записывает что кинул игрок
        switch (uefaDice) {
            case 0:
                this.uefaDice = "stone";
                break;
            case 1:
                this.uefaDice = "knife";
                break;
            case 2:
                this.uefaDice = "papper";
                break;
        }
    }



    boolean isInGame() {
        return inGame;
    }

    void setInGame(boolean inGame) {
        this.inGame = inGame;
    }
}
