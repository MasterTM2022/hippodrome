import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.Comparator;


class HippodromeTest {
    @Test
    void constructorGotNotNull() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Hippodrome(null)
        );
        assertEquals("Horses cannot be null.", exception.getMessage());
    }

    @Test
    void constructorGotNotBlank() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Hippodrome(new ArrayList<Horse>())
        );
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }

    @Test
    void getHorses() {
        ArrayList<Horse> horses = new ArrayList<Horse>();
        for (int i = 0; i < 30; i++) {
            horses.add(new Horse(String.format("Test_horse_#%d", i + 1),
                    (int) (Math.random() * 10),
                    (double) ((int) (Math.random() * 7 + 2)) / 10));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        assertArrayEquals(horses.toArray(), hippodrome.getHorses().toArray());
    }

    @Test
    void move() {
        ArrayList<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(Mockito.mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();
        for (int i = 0; i < horses.size(); i++) {
            Mockito.verify(horses.get(i), times(1)).move();
        }
    }

    @Test
    void getWinner() {
        ArrayList<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(new Horse("horse_#" + (i + 1), i + 1, (i + 1) * 10));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses.get(horses.size() - 1), hippodrome.getWinner());
    }
}