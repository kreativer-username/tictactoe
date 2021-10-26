public class Player {

    private Symbol symbol;
    private String name;

    public Player(String n, Symbol s) {
        symbol = s;
        name = n;
    }

    public Player(String n) {
        name = n;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol s) {
        symbol = s;
    }

    public String getName() {
        return name;
    }
}
