package inko.steinherz;

class Player {
    private int numberOf;
    private String namePlayer;
    private String uefaDice;
    private boolean isWinner = false;
    private boolean inGame = true;

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

    void setUefaDice(int uefaDice) {
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

    boolean isWinner() {
        return isWinner;
    }

    void setWinner(boolean winner) {
        isWinner = winner;
    }

    public boolean isInGame() {
        return inGame;
    }

    void setInGame(boolean inGame) {
        this.inGame = inGame;
    }
}
