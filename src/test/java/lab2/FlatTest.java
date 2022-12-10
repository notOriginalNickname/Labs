package lab2;

import lab2.buildings.Flat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.jupiter.api.Assertions.*;

class FlatTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testDefaultConstructor() {
        Flat flat = new Flat();
        assertEquals(2, flat.getRooms());
        assertEquals(50, flat.getSpace());
    }

    @Test
    public void testOtherConstructors() {
        Flat flat = new Flat(3, 150);
        assertEquals(3, flat.getRooms());
        assertEquals(150, flat.getSpace());

        Flat flat2 = new Flat(50);
        assertEquals(2, flat2.getRooms());
        assertEquals(50, flat2.getSpace());
    }

    @Test
    public void testGetterAndSetter() {
        Flat flat = new Flat();
        assertEquals(2, flat.getRooms());
        assertEquals(50, flat.getSpace());

        flat.setRooms(10);
        flat.setSpace(500);

        assertEquals(10, flat.getRooms());
        assertEquals(500, flat.getSpace());
    }

}