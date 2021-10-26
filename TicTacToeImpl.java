import java.util.LinkedList;
import java.util.List;

public class TicTacToeImpl implements TicTacToe {

    private Player user1;
    private Player user2;
    private Gamefield gamefield;

    public TicTacToeImpl() {
        user1 = new Player("Bob");
        user2 = new Player("Alice");
        gamefield = new Gamefield();
    }

    public List<Player> getPlayer() {
        List<Player> playerList = new LinkedList<>();
        playerList.add(user1);
        playerList.add(user2);
        return playerList;
    }

    public Gamefield getGamefield() {
        return gamefield;
    }

    @Override
    public Symbol pick(Player user, Symbol s) throws SymbolBereitsBelegtException, StateException {
        if (user.getSymbol() != null) {
            throw new StateException(user.getName() + " hat bereits" + user.getSymbol() + " gewählt!");
        } else if (user == user1 && user2.getSymbol() == s || user == user2 && user1.getSymbol() == s) {
            throw new SymbolBereitsBelegtException();
        }
        user.setSymbol(s);
        return s;
    }

    @Override
    public boolean set(Symbol s, Position p) throws FeldBelegtException, PositionNichtInFeldException, StateException {
        if (p.getX() < 0 || p.getX() > 3 || p.getY() < 0 || p.getY() > 3) {
            throw new PositionNichtInFeldException();
        } else if (user1.getSymbol() == null || user2.getSymbol() == null) {
            throw new StateException();
        }

        if (!gamefield.getPosition(p)) {
            throw new FeldBelegtException();
        }

        gamefield.setPosition(p, s);
        return true;
    }
}
