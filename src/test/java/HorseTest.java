import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @Test
    void constructorGotNotNull() {
//        assertThrows(IllegalArgumentException.class,
//                () -> new Horse(null, 0.0));
//
//        assertThrows(IllegalArgumentException.class,
//                () -> new Horse(null, 0.0, 0.0));


        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse(null, 0.0)
        );
        assertEquals("Name cannot be null.", exception.getMessage());

        exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse(null, 0.0, 0.0)
        );
        assertEquals("Name cannot be null.", exception.getMessage());

    }

    @ParameterizedTest
    @ValueSource(strings = {" ", " ", "", "    "})
    void constructorGotNotBlank(String strings) {
//        assertThrows(IllegalArgumentException.class,
//                () -> new Horse(strings, 0.0));
//
//        assertThrows(IllegalArgumentException.class,
//                () -> new Horse(strings, 0.0, 0.0));


        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse(strings, 0.0)
        );
        assertEquals("Name cannot be blank.", exception.getMessage());

        exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse(strings, 0.0, 0.0)
        );
        assertEquals("Name cannot be blank.", exception.getMessage());

    }

    @Test
    void constructorGotPositiveSpeed() {
//        assertThrows(IllegalArgumentException.class,
//                () -> new Horse("any", -1.0));
//
//        assertThrows(IllegalArgumentException.class,
//                () -> new Horse("any", -1.0, 0.0));


        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse("any", -1.0)
        );
        assertEquals("Speed cannot be negative.", exception.getMessage());

        exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse("any", -1.0, 0.0)
        );
        assertEquals("Speed cannot be negative.", exception.getMessage());

    }

    @Test
    void constructorGotPositiveDistance() {
        assertThrows(IllegalArgumentException.class, () ->
                new Horse("any", 1.0, -1.0));

        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse("any", 1.0, -1.0)
        );
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    void getName() {

    }

    @Test
    void getSpeed() {
    }

    @Test
    void getDistance() {
    }

    @Test
    void move() {
    }

    @Test
    void getRandomDouble() {
    }
}