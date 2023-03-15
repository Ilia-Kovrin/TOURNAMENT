package tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testWhenFirstPlayerStronger() {
        Game game = new Game();
        Player tom = new Player(1, "Tom", 70);
        Player bill = new Player(2, "Bill", 80);

        game.register(tom);
        game.register(bill);

        int actual = game.round("Bill", "Tom");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerStronger() {
        Game game = new Game();
        Player tom = new Player(1, "Tom", 80);
        Player bill = new Player(2, "Bill", 70);

        game.register(tom);
        game.register(bill);

        int actual = game.round("Tom", "Bill");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testWhenBothPlayersAreSame() {
        Game game = new Game();
        Player tom = new Player(1, "Tom", 80);
        Player bill = new Player(2, "Bill", 80);

        game.register(tom);
        game.register(bill);

        int actual = game.round("Tom", "Bill");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerLessStronger() {
        Game game = new Game();
        Player tom = new Player(1, "Tom", 70);
        Player bill = new Player(2, "Bill", 80);

        game.register(tom);
        game.register(bill);

        int actual = game.round("Tom", "Bill");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Game game = new Game();
        Player tom = new Player(1, "Tom", 70);
        Player bill = new Player(2, "Bill", 80);

        game.register(tom);
        game.register(bill);

        Assertions.assertThrows(NotRegisteredExeption.class,
                () -> game.round("John", "Tom")
        );
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Game game = new Game();
        Player tom = new Player(1, "Tom", 70);
        Player bill = new Player(2, "Bill", 80);

        game.register(tom);
        game.register(bill);

        Assertions.assertThrows(NotRegisteredExeption.class,
                () -> game.round("Tom", "John")
        );
    }


}