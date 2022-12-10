package lab2.buildings;

public class Flat {
    private int rooms;
    private int space;

    private final int DEFAULT_ROOM_COUNT = 2;
    private final int DEFAULT_SPACE = 50;
    //конструктор по умолчанию создаёт кв-ру 2 комнаты, площадью 50
    public Flat() {
        this.rooms = DEFAULT_ROOM_COUNT;
        this.space = DEFAULT_SPACE;
    }
    //конструктор создаёт  кв-ру 2 комнаты, с вашей площадью
    public Flat(int space) {
        this.rooms = DEFAULT_ROOM_COUNT;
        this.space = space;
    }
    //конструктор создаёт  кв-ру с вашим кол-вом комнат и  вашей площадью
    public Flat(int space, int rooms) {
        this.rooms = rooms;
        this.space = space;
    }
    //метод получения кол-во комнат в квартире
    public int getRooms() {
        return rooms;
    }
    //метод изменения кол-ва комнат в квартире
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
    //метод получения площади квартиры
    public int getSpace() {
        return space;
    }
    //метод изменения площади квартиры
    public void setSpace(int space) {
        this.space = space;
    }
}