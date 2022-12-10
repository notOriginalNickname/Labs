package lab2;

import lab2.buildings.Dwelling;
import lab2.buildings.DwellingFloor;
import lab2.buildings.Flat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DwellingTest {

    private DwellingFloor[] floors;

    @BeforeEach
    void setUp() {

        Flat[] flats = new Flat[4];
        for(int i = 0; i<4;i++){
            flats[i]= new Flat();
        }
        DwellingFloor[] floor2 = new DwellingFloor[5];
        for(int i = 0; i<5;i++){
            floor2[i]= new DwellingFloor(flats);
        }

        floors = floor2;
    }

    @Test
    public void testOtherConstructor() {
        Dwelling dwelling = new Dwelling(5,4);
        assertEquals(5,dwelling.getFloors().length);

    }

    @Test
    public void testOtherConstructor2() {
        DwellingFloor[] floors = new DwellingFloor[5];
        Dwelling dwelling = new Dwelling(floors);
        assertEquals(5,dwelling.getFloors().length);

    }

    @Test
    void getAmountFloorOnBuilds() {
        assertEquals(5,floors.length);
    }

    @Test
    void getFlatsOnFloorsOnBuilds() {
        Dwelling dwelling = new Dwelling(5,4);
        assertEquals(20,dwelling.getFlatsOnFloorsOnBuilds());
    }

    @Test
    void getFlatsSquaresOnFloorsOnBuilds() {
        Dwelling dwelling = new Dwelling(floors);
        assertEquals(1000,dwelling.getFlatsSquaresOnFloorsOnBuilds());

    }

    @Test
    void getFlatsRoomsOnFloorsOnBuilds() {
        Dwelling dwelling = new Dwelling(floors);
        assertEquals(40,dwelling.getFlatsRoomsOnFloorsOnBuilds());
    }

    @Test
    void getArrayFloors() {
        Dwelling dwelling = new Dwelling(floors);
        assertEquals(floors,dwelling.getArrayFloors());
    }

    @Test
    void getFloors() {
        Dwelling dwelling = new Dwelling(floors);
        assertEquals(floors[3],dwelling.getFloors(3));
    }

    @Test
    void changeFlat() {
        Dwelling dwelling = new Dwelling(floors);
        Flat flat = new Flat(65);
        dwelling.changeFlat(6,flat);
        assertEquals(floors[2].getArrayFlats()[1].getSpace(),flat.getSpace());
    }


    @Test
    void getFlat() {
        Dwelling dwelling = new Dwelling(floors);
        assertEquals(floors[2].getArrayFlats()[1],dwelling.getFlat(5));
    }

    @Test
    void addFlatByNunmberOfDwelling(){

        Dwelling dwelling = new Dwelling(floors);
        Flat flat = new Flat(65);
        dwelling.addFlatByFutureNumberOnDwelling(21,flat);

        assertEquals(floors[4].getArrayFlats()[4].getSpace(),flat.getSpace());
    }



    @Test
    void getBestSpace() {
        Dwelling dwelling = new Dwelling(floors);
        Flat flat = new Flat(65);
        dwelling.getArrayFloors()[1].changeFlatByNumber(3,flat);
        assertEquals(flat,dwelling.getBestSpace());

    }

}