package lab2;

import lab2.buildings.DwellingFloor;
import lab2.buildings.Flat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DwellingFloorTest {

    private Flat[] flats;

    @BeforeEach
    void setUp() {
        flats = Zapolnenie(5);
    }

    @Test
    public void testOtherConstructor() {
        DwellingFloor floor = new DwellingFloor(5);
        assertEquals(5,floor.getArrayFlats().length);

    }

    @Test
    public void testOtherConstructor2() {
        Flat[] flats = new Flat[5];
        DwellingFloor floor = new DwellingFloor(flats);
        assertEquals(5,floor.getArrayFlats().length);

    }

    @Test
    void getAmountFlatOnFloor() {
        DwellingFloor floor = new DwellingFloor(5);
        assertEquals(5,floor.getAmountFlatOnFloor());
    }

    @Test
    void getSquareFlatOnFloor() {

        DwellingFloor floor = new DwellingFloor(flats);
        assertEquals(250,floor.getSquareFlatOnFloor());

    }

    @Test
    void getTotalRoom() {
        DwellingFloor floor = new DwellingFloor(flats);
        assertEquals(10,floor.getTotalRoom());

    }

    @Test
    void getArrayFlats() {
        DwellingFloor floor = new DwellingFloor(flats);
        assertEquals(flats,floor.getArrayFlats());

    }

    @Test
    void getFlatsByNumber() {
        DwellingFloor floor = new DwellingFloor(flats);
        assertEquals(flats[1],floor.getFlatsByNumber(1));
    }

    @Test
    void changeFlatByNumber() {
        DwellingFloor floor = new DwellingFloor(flats);
        Flat newFlat = new Flat(100,4);
        Flat oldFlat = floor.getArrayFlats()[3];
        floor.changeFlatByNumber(3,newFlat);

        assertNotEquals(floor.getArrayFlats()[3].getSpace(), oldFlat.getSpace());
        assertNotEquals(floor.getArrayFlats()[3].getRooms(), oldFlat.getRooms());

    }



    @Test
    void addFlatByFutureNumber() {
        DwellingFloor floor = new DwellingFloor(flats);
        Flat newFlat = new Flat(100,4);
        floor.addFlatByFutureNumberOnFloor(8,newFlat);
        assertEquals(newFlat.getSpace(),floor.getArrayFlats()[7].getSpace());
        assertEquals(newFlat.getRooms(),floor.getArrayFlats()[7].getRooms());

    }

    @Test
    void getBestSpace() {
        DwellingFloor floor = new DwellingFloor(flats);
        Flat newFlat = new Flat(100,4);
        floor.addFlatByFutureNumberOnFloor(3,newFlat);
        assertEquals(newFlat,floor.getBestSpace());
    }



    public Flat[] Zapolnenie(int count){
        Flat[] flats = new Flat[count];
        for(int i = 0; i<count;i++){
            flats[i]= new Flat();
        }
        return flats;
    }
}