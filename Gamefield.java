public class Gamefield {

    private Symbol[][] gamefield;

    public Gamefield() {
        gamefield = new Symbol[3][3];
    }

    public Symbol[][] getGamefield() {
        return gamefield;
    }

    public boolean getPosition(Position p) {
        if (gamefield[p.getX()][p.getY()] != null) {
            return false;
        }
        return true;
    }

    public void setPosition(Position p, Symbol s) {
        gamefield[p.getX()][p.getY()] = s;
    }

    public boolean isEmpty() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gamefield[i][j] != null) {
                    return false;
                }
            }
        }
        return true;
    }
}
