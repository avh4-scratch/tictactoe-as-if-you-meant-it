import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EngineTest {

    enum GameOutcome {OWins, NoWinner, XWins}

    @Test
    public void testXWinsTopRow() throws Exception {
        assertThat(winner("A1,B1,A2,B2,A3"), is(GameOutcome.XWins));
    }

    @Test
    public void testOWinsTopRow() throws Exception {
        assertThat(winner("B1,A1,B2,A2,C3,A3"), is(GameOutcome.OWins));
    }

    @Test
    public void testOWinsCenterRow() throws Exception {
        assertThat(winner("A1,B1,A2,B2,C3,B3"), is(GameOutcome.OWins));
    }

    @Test
    public void testXWinsGameWith7Moves() throws Exception {
        assertThat(winner("A1,B1,A2,B2,C1,C2,A3"), is(GameOutcome.XWins));
    }

    @Test
    public void testUnfinishedGame() throws Exception {
        assertThat(winner("A1,B1,A2,B2"), is(GameOutcome.NoWinner));
    }

    @Test
    public void testUnfinishedIn5Moves() throws Exception {
        assertThat(winner("A1,B1,A2,B2,C3"), is(GameOutcome.NoWinner));
    }

    @Test
    public void testXWinsOnBottomRow() throws Exception {
        assertThat(winner("C1,B1,C2,B2,C3"), is(GameOutcome.XWins));
    }

    private GameOutcome winner(String game) {
        if (numberOfMoves(game) < 5) return GameOutcome.NoWinner;
        if (didXPlayLast(game)) {
            if (xWinsRow(game, 'A')) return GameOutcome.XWins;
            if (xWinsRow(game, 'C')) return GameOutcome.XWins;
            return GameOutcome.NoWinner;
        } else {
            return GameOutcome.OWins;
        }
    }

    private boolean xWinsRow(String game, char row) {
        char lastRow = game.charAt(game.length() - 2);
        char firstRow = game.charAt(0);
        return lastRow == row && lastRow == firstRow;
    }

    private boolean didXPlayLast(String game) {
        return numberOfMoves(game) % 2 == 1;
    }

    private int numberOfMoves(String game) {
        return (game.length() + 1) / 3;
    }
}
