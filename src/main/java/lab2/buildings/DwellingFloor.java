package lab2.buildings;
//жилой этаж
public class DwellingFloor {

    private Flat[] flats;


    //конструктор принимающий кол-во квартир на этаже
    public DwellingFloor(int count) {
        flats = new Flat[count];
    }
    //конструктор принимающий массив квартир этажа
    public DwellingFloor(Flat[] flats) { this.flats = flats; }
    //метод получения количества квартир на этаже
    public int getAmountFlatOnFloor() {
        return flats.length;
    }
    //метод получения общей площади квартир этажа
    public int getSquareFlatOnFloor() {
        int sum = 0;
        for (int i = 0; i < flats.length; i++) {
            sum += flats[i].getSpace();
        }
        return sum;
    }
    //метод получения общего количества комнат этажа
    public int getTotalRoom() {
        int sum = 0;
        for (int i = 0; i < flats.length; i++) {
            sum += flats[i].getRooms();
        }
        return sum;
    }
    //метод получения массива квартир этажа
    public Flat[] getArrayFlats() {
        return flats;
    }

    //метод получения объекта квартиры по ее номеру на этаже
    public Flat getFlatsByNumber(int number) {
        return flats[number];
    }

    //Создайте метод изменения квартиры по ее номеру на этаже и ссылке
    // на новую квартиру.
    public void changeFlatByNumber(int numberOnTheFloor, Flat flat){
        flats[numberOnTheFloor]=flat;
    }


    //Создайте метод добавления новой квартиры на этаже по будущему
    // номеру квартиры (т.е. в параметрах указывается номер,
    // который должна иметь квартира после вставки) и ссылке на
    // объект квартиры.
    public void addFlatByFutureNumberOnFloor(int futureNumber, Flat flat) {
        Flat[] newFlats = new Flat[futureNumber];

            int i = 0;
            for (; i < flats.length; i++) {
                newFlats[i] = flats[i];

            }

            while (i != futureNumber) {
                newFlats[i] = new Flat();
                i++;
            }
            newFlats[futureNumber - 1] = flat;
            if (futureNumber > flats.length) {

                flats = new Flat[futureNumber];
                flats = newFlats;

            }


        }



    //Создайте метод удаления квартиры по ее номеру на этаже
    public void removeFlat(int number){

        Flat[] newFloor = new Flat[flats.length-1];

        for (int i = 0; i < flats.length; i++){
            if(i != number){
                newFloor[i] = flats[i];}
            }

        flats = newFloor;
    }

    //Метод получения самой большой по площади квартиры этажа
    public Flat getBestSpace() {
        int max = 0;
        Flat bestFlat = flats[0];

        for (int i = 0; i < flats.length; i++) {
            if (flats[i].getSpace() > max) {
                max = flats[i].getSpace();
                bestFlat = flats[i];
            }
        }
        return bestFlat;
    }
}