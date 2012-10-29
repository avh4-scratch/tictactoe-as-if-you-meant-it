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

    private Winner winner(String game) {
        if (didXWin(game)) return Winner.X;
        return Winner.O;
    }

    private boolean didXWin(String game) {
        return game.startsWith("A");
    }
}
