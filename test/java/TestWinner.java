import org.junit.Assert;
import org.junit.Test;

public class TestWinner {
    @Test
    public void testXRow1() {
        Integer[][] boardState = {
                { Board.X, Board.X, Board.X },
                { null, null, null },
                { null, null, null },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
            Board.X,
            game.winner()
        );
    }

    @Test
    public void testORow1() {
        Integer[][] boardState = {
                { Board.O, Board.O, Board.O },
                { null, null, null },
                { null, null, null },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                Board.O,
                game.winner()
        );
    }

    @Test
    public void testXCol1() {
        Integer[][] boardState = {
                { Board.X, null, null },
                { Board.X, null, null },
                { Board.X, null, null },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                Board.X,
                game.winner()
        );
    }

    @Test
    public void testOCol1() {
        Integer[][] boardState = {
                { Board.O, null, null },
                { Board.O, null, null },
                { Board.O, null, null },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                Board.O,
                game.winner()
        );
    }

    @Test
    public void testXDiag() {
        Integer[][] boardState = {
                { Board.X, null, null },
                { null, Board.X, null },
                { null, null, Board.X },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                Board.X,
                game.winner()
        );
    }

    @Test
    public void testODiag() {
        Integer[][] boardState = {
                { Board.O, null, null },
                { null, Board.O, null },
                { null, null, Board.O },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                Board.O,
                game.winner()
        );
    }

    @Test
    public void testXAntiDiag() {
        Integer[][] boardState = {
                { null, null, Board.X },
                { null, Board.X, null },
                { Board.X, null, null },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                Board.X,
                game.winner()
        );
    }

    @Test
    public void testOAntiDiag() {
        Integer[][] boardState = {
                { null, null, Board.O },
                { null, Board.O, null },
                { Board.O, null, null },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                Board.O,
                game.winner()
        );
    }

    @Test
    public void testNoWinnerMix() {
        Integer[][] boardState = {
                { Board.O, null, Board.X },
                { null, null, null },
                { null, null, null },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                game.EMPTY,
                game.winner()
        );
    }

    @Test
    public void testNoWinner2Os1X() {
        Integer[][] boardState = {
                { Board.O, Board.O, Board.X },
                { null, null, null },
                { null, null, null },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                game.EMPTY,
                game.winner()
        );
    }

    @Test
    public void testNoWinner2Os1Empty() {
        Integer[][] boardState = {
                { Board.O, Board.O, null },
                { null, null, null },
                { null, null, null },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                game.EMPTY,
                game.winner()
        );
    }

    @Test
    public void testNoWinner2Xs1O() {
        Integer[][] boardState = {
                { Board.O, Board.X, Board.X },
                { null, null, null },
                { null, null, null },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                game.EMPTY,
                game.winner()
        );
    }

    @Test
    public void testNoWinner2Xs1Empty() {
        Integer[][] boardState = {
                { null, Board.X, Board.X },
                { null, null, null },
                { null, null, null },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                game.EMPTY,
                game.winner()
        );
    }


    @Test
    public void testLargerBoardNoWinner() {
        Integer[][] boardState = {
                { null, Board.X, Board.X, Board.X },
                { null, null, null, null },
                { null, null, null, null },
                { null, null, null, null },
        };
        Board game = new Board(boardState);
        Assert.assertEquals(
                game.EMPTY,
                game.winner()
        );
    }

}
