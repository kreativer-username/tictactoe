import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class TicTacToeTest {

    private TicTacToeImpl getTicTacToe() throws SymbolBereitsBelegtException, StateException {
        TicTacToeImpl ticTacToe = new TicTacToeImpl();
        List<Player> playerList = ticTacToe.getPlayer();
        Player user1 = playerList.get(0);
        Player user2 = playerList.get(1);
        ticTacToe.pick(user1, Symbol.KREIS);
        Assert.assertEquals(Symbol.KREIS, user1.getSymbol());
        ticTacToe.pick(user2, Symbol.KREUZ);
        Assert.assertEquals(Symbol.KREUZ, user2.getSymbol());

        return ticTacToe;
    }

    @Test
    public void pickGood() throws SymbolBereitsBelegtException, StateException {
        TicTacToeImpl ticTacToe = new TicTacToeImpl();
        List<Player> playerList = ticTacToe.getPlayer();
        Player user1 = playerList.get(0);
        Player user2 = playerList.get(1);
        ticTacToe.pick(user1, Symbol.KREIS);
        Assert.assertEquals(Symbol.KREIS, user1.getSymbol());
        ticTacToe.pick(user2, Symbol.KREUZ);
        Assert.assertEquals(Symbol.KREUZ, user2.getSymbol());
    }

    @Test
    public void pickGood2() throws SymbolBereitsBelegtException, StateException {
        TicTacToeImpl ticTacToe = new TicTacToeImpl();
        List<Player> playerList = ticTacToe.getPlayer();
        Player user1 = playerList.get(0);
        Player user2 = playerList.get(1);
        ticTacToe.pick(user2, Symbol.KREIS);
        Assert.assertEquals(Symbol.KREIS, user2.getSymbol());
        ticTacToe.pick(user1, Symbol.KREUZ);
        Assert.assertEquals(Symbol.KREUZ, user1.getSymbol());
    }

    @Test
    public void pickBad() throws SymbolBereitsBelegtException, StateException {
        TicTacToeImpl ticTacToe = new TicTacToeImpl();
        List<Player> playerList = ticTacToe.getPlayer();
        Player user1 = playerList.get(0);
        Player user2 = playerList.get(1);
        ticTacToe.pick(user1, Symbol.KREIS);
        Assert.assertEquals(Symbol.KREIS, user1.getSymbol());
        try {
            ticTacToe.pick(user2, Symbol.KREIS);
            Assert.fail();
        } catch (SymbolBereitsBelegtException e) {

        }
    }

    @Test
    public void pickBad2() throws SymbolBereitsBelegtException, StateException {
        TicTacToeImpl ticTacToe = new TicTacToeImpl();
        List<Player> playerList = ticTacToe.getPlayer();
        Player user1 = playerList.get(0);
        Player user2 = playerList.get(1);
        ticTacToe.pick(user2, Symbol.KREUZ);
        Assert.assertEquals(Symbol.KREUZ, user2.getSymbol());
        try {
            ticTacToe.pick(user1, Symbol.KREUZ);
            Assert.fail();
        } catch (SymbolBereitsBelegtException e) {

        }
    }

    @Test
    public void pickBad3() throws SymbolBereitsBelegtException, StateException {
        TicTacToeImpl ticTacToe = new TicTacToeImpl();
        List<Player> playerList = ticTacToe.getPlayer();
        Player user1 = playerList.get(0);
        ticTacToe.pick(user1, Symbol.KREIS);
        Assert.assertEquals(Symbol.KREIS, user1.getSymbol());
        try {
            ticTacToe.pick(user1, Symbol.KREUZ);
            Assert.fail();
        } catch (StateException e) {

        }
    }

    @Test
    public void pickBad4() throws SymbolBereitsBelegtException, StateException {
        TicTacToeImpl ticTacToe = new TicTacToeImpl();
        List<Player> playerList = ticTacToe.getPlayer();
        Player user1 = playerList.get(0);
        ticTacToe.pick(user1, Symbol.KREIS);
        Assert.assertEquals(Symbol.KREIS, user1.getSymbol());
        try {
            ticTacToe.pick(user1, Symbol.KREIS);
            Assert.fail();
        } catch (StateException e) {

        }
    }

    @Test
    public void setGood() throws FeldBelegtException, PositionNichtInFeldException, StateException, SymbolBereitsBelegtException {
        TicTacToeImpl ticTacToe = getTicTacToe();
        Assert.assertTrue(ticTacToe.getGamefield().isEmpty());
        List<Player> playerList = ticTacToe.getPlayer();
        Player user1 = playerList.get(0);
        Player user2 = playerList.get(1);
        ticTacToe.set(user1.getSymbol(), new Position(0, 0));
        Assert.assertFalse(ticTacToe.getGamefield().getPosition(new Position(0, 0)));
        ticTacToe.set(user2.getSymbol(), new Position(2, 2));
        Assert.assertFalse(ticTacToe.getGamefield().getPosition(new Position(2, 2)));
        Assert.assertTrue(ticTacToe.getGamefield().getPosition(new Position(1, 2)));
    }
}
