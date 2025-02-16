import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
    @DisplayName("Проверка параметра Дистанция")
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
        Horse horse = new Horse("testName", 1, 1);
        assertEquals("testName", horse.getName());

        horse = new Horse("testName", 1);
        assertEquals("testName", horse.getName());
    }

    @Test
    void getSpeed() {
        Horse horse = new Horse("testName", 1, 1);
        assertEquals(1, horse.getSpeed());

        horse = new Horse("testName", 1);
        assertEquals(1, horse.getSpeed());
    }

    @Test
    void getDistance() {
        Horse horse = new Horse("testName", 1, 10);
        assertEquals(10, horse.getDistance());

        horse = new Horse("testName", 1);
        assertEquals(0, horse.getDistance());
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.1, 0.2, 0.5, 0.9})
    @ExtendWith(MockitoExtension.class)
    void move(double argument) {
        try (MockedStatic<Horse> mockedHorse = Mockito.mockStatic(Horse.class)) {
            mockedHorse.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(argument);
            Horse horse = new Horse("test_horse", 1, 1);
            horse.move();
            assertEquals(horse.getDistance() + horse.getSpeed() * argument, horse.getDistance() + horse.getSpeed() * Horse.getRandomDouble(0.2, 0.9));
            mockedHorse.verify(() -> Horse.getRandomDouble(0.2, 0.9), times(2));
        }
    }

//    @Test
//    void getRandomDouble() {
//    }
}