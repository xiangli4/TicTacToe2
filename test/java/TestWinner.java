import org.junit.Assert;
import org.junit.Test;

public class TestWinner {
    @Test
    public void testXRow1() {
        int[][] boardState = {
            { Board.X, Board.X, Board.X },
            { Board.EMPTY, Board.EMPTY, Board.EMPTY },
            { Board.EMPTY, Board.EMPTY, Board.EMPTY },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
            Board.X,
            game.winner()
        );
    }

    @Test
    public void testORow1() {
        int[][] boardState = {
                { Board.O, Board.O, Board.O },
                { Board.EMPTY, Board.EMPTY, Board.EMPTY },
                { Board.EMPTY, Board.EMPTY, Board.EMPTY },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                Board.O,
                game.winner()
        );
    }

    @Test
    public void testXCol1() {
        int[][] boardState = {
                { Board.X, Board.EMPTY, Board.EMPTY },
                { Board.X, Board.EMPTY, Board.EMPTY },
                { Board.X, Board.EMPTY, Board.EMPTY },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                Board.X,
                game.winner()
        );
    }

    @Test
    public void testOCol1() {
        int[][] boardState = {
                { Board.O, Board.EMPTY, Board.EMPTY },
                { Board.O, Board.EMPTY, Board.EMPTY },
                { Board.O, Board.EMPTY, Board.EMPTY },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                Board.O,
                game.winner()
        );
    }

    @Test
    public void testXDiag() {
        int[][] boardState = {
                { Board.X, Board.EMPTY, Board.EMPTY },
                { Board.EMPTY, Board.X, Board.EMPTY },
                { Board.EMPTY, Board.EMPTY, Board.X },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                Board.X,
                game.winner()
        );
    }

    @Test
    public void testODiag() {
        int[][] boardState = {
                { Board.O, Board.EMPTY, Board.EMPTY },
                { Board.EMPTY, Board.O, Board.EMPTY },
                { Board.EMPTY, Board.EMPTY, Board.O },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                Board.O,
                game.winner()
        );
    }

    @Test
    public void testXAntiDiag() {
        int[][] boardState = {
                { Board.EMPTY, Board.EMPTY, Board.X },
                { Board.EMPTY, Board.X, Board.EMPTY },
                { Board.X, Board.EMPTY, Board.EMPTY },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                Board.X,
                game.winner()
        );
    }

    @Test
    public void testOAntiDiag() {
        int[][] boardState = {
                { Board.EMPTY, Board.EMPTY, Board.O },
                { Board.EMPTY, Board.O, Board.EMPTY },
                { Board.O, Board.EMPTY, Board.EMPTY },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                Board.O,
                game.winner()
        );
    }

    @Test
    public void testNoWinnerMix() {
        int[][] boardState = {
                { Board.O, Board.EMPTY, Board.X },
                { Board.EMPTY, Board.EMPTY, Board.EMPTY },
                { Board.EMPTY, Board.EMPTY, Board.EMPTY },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                Board.EMPTY,
                game.winner()
        );
    }

    @Test
    public void testNoWinner2Os1X() {
        int[][] boardState = {
                { Board.O, Board.O, Board.X },
                { Board.EMPTY, Board.EMPTY, Board.EMPTY },
                { Board.EMPTY, Board.EMPTY, Board.EMPTY },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                Board.EMPTY,
                game.winner()
        );
    }

    @Test
    public void testNoWinner2Os1Empty() {
        int[][] boardState = {
                { Board.O, Board.O, Board.EMPTY },
                { Board.EMPTY, Board.EMPTY, Board.EMPTY },
                { Board.EMPTY, Board.EMPTY, Board.EMPTY },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                Board.EMPTY,
                game.winner()
        );
    }

    @Test
    public void testNoWinner2Xs1O() {
        int[][] boardState = {
                { Board.O, Board.X, Board.X },
                { Board.EMPTY, Board.EMPTY, Board.EMPTY },
                { Board.EMPTY, Board.EMPTY, Board.EMPTY },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                Board.EMPTY,
                game.winner()
        );
    }

    @Test
    public void testNoWinner2Xs1Empty() {
        int[][] boardState = {
                { Board.EMPTY, Board.X, Board.X },
                { Board.EMPTY, Board.EMPTY, Board.EMPTY },
                { Board.EMPTY, Board.EMPTY, Board.EMPTY },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                Board.EMPTY,
                game.winner()
        );
    }

}
