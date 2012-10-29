import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EngineTest {

    enum Winner {O, X}

    @Test
    public void testXWinsTopRow() throws Exception {
        assertThat(winner("A1,B1,A2,B2,A3"), is(Winner.X));
    }

    @Test
    public void testOWinsTopRow() throws Exception {
        assertThat(winner("B1,A1,B2,A2,C3,A3"), is(Winner.O));
    }

    @Test
    public void testOWinsCenterRow() throws Exception {
        assertThat(winner("A1,B1,A2,B2,C3,B3"), is(Winner.O));
    }

    @Test
    public void testXWinsGameWith7Moves() throws Exception {
        assertThat(winner("A1,B1,A2,B2,C1,C2,A3"), is(Winner.X));
    }

    private Winner winner(String game) {
        if (didXWin(game)) return Winner.X;
        return Winner.O;
    }

    private boolean didXWin(String game) {
        return numberOfMoves(game) % 2 == 1;
    }

    private int numberOfMoves(String game) {
        return (game.length() + 1) / 3;
    }
}
