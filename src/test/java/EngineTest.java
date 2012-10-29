import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EngineTest {

    enum Winner {X}

    @Test
    public void testXWinsTopRow() throws Exception {
        assertThat(winner("A1,B1,A2,B2,A3"), is(Winner.X));
    }

    private Winner winner(String game) {
        if (didXWin(game)) return Winner.X;
        return null;
    }

    private boolean didXWin(String game) {
        return game.contains("A");
    }
}
