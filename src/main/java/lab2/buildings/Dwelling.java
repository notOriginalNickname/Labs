package lab2.buildings;
//жилое здание
public class Dwelling {

    private DwellingFloor[] floors;

    public DwellingFloor[] getFloors() {
        return floors;
    }

    //конструктор по кол-ву этажей и кол-во квартир по этажам
    public Dwelling(int count, int flatsCount)
    {   floors = new DwellingFloor[count];

        for(int i = 0; i<count; i++){
           DwellingFloor Floor = new DwellingFloor(flatsCount);
           floors[i] = Floor;
        }
    }
    //конструктор по массиву этажей дома
    public Dwelling(DwellingFloor[] floors) {

        this.floors = floors;
    }


    //Создайте метод получения общего количества этажей дома.
    public int getAmountFloorOnBuilds() {

        return floors.length;
    }
    //Создайте метод получения общего количества квартир дома.
    public int getFlatsOnFloorsOnBuilds() {
        int sum = 0;
        for (int i = 0; i < floors.length; i++) {
            sum += floors[i].getAmountFlatOnFloor();
        }
        return sum;
    }
    //Создайте метод получения общей площади квартир дома.
    public int getFlatsSquaresOnFloorsOnBuilds() {
        int sum = 0;
        for (int i = 0; i < floors.length; i++) {
            sum += floors[i].getSquareFlatOnFloor();
        }
        return sum;
    }
    //Создайте метод получения общего количества комнат дома.
    public int getFlatsRoomsOnFloorsOnBuilds() {
        int sum = 0;
        for (int i = 0; i < floors.length; i++) {
            sum += floors[i].getTotalRoom();
        }
        return sum;
    }
    //Создайте метод получения массива этажей жилого дома.
    public DwellingFloor[] getArrayFloors() {
        return floors;
    }
    //Создайте метод получения объекта этажа, по его номеру в доме.
    public DwellingFloor getFloors(int number) {
        return floors[number];
    }

    //Создайте метод изменения этажа по его
    // номеру в доме и ссылке на обновленный этаж.
    public void ChangeFloorByNumber(int number, DwellingFloor newFloor){
        floors[number] = newFloor;
    }


    //метод изменения объекта квартиры по ее номеру в доме и ссылке на объект квартиры
    public void changeFlat(int number, Flat flat) {
        for (int i = 0;i<floors.length;i++){
            for (int j = 0; j<floors[i].getArrayFlats().length;j++){
                number--;
                if(number==0){
                    floors[i].getArrayFlats()[j]=flat;
                    break;
                }
            }
        }

    }

    //Создайте метод получения объекта квартиры по ее номеру в доме.
    public Flat getFlat(int number) {
        int count = 0;
        for (int i = 0; i < floors.length; i++) {
            count += floors[i].getArrayFlats().length;
            if(number <= count) {
                return floors[i].getFlatsByNumber(number - (count - floors[i].getArrayFlats().length));
            }
        }
        return null;
    }
    /// метод добавления квартиры в дом по будущему номеру квартиры в доме
    // (т.е. в парам. указ номер который должна иметь квартира
    public void addFlatByFutureNumberOnDwelling(int futureNumber, Flat flat) {
        int countOfFlats = 0;
        for (int i = 0; i < floors.length; i++) {
            for (int j = 0; j < floors[i].getArrayFlats().length; j++) {
                countOfFlats++;
            }
        }
        if (futureNumber <= countOfFlats) {
            this.changeFlat(futureNumber, flat);

        } else {
            floors[floors.length - 1].addFlatByFutureNumberOnFloor(futureNumber-(countOfFlats-floors[floors.length-1].getArrayFlats().length), flat);
        }
    }



    //Создайте метод getBestSpace() получения самой большой по площади квартиры дома.
    public Flat getBestSpace(){
        Flat bestSpaceFlat = new Flat(0);
        for(int i = 0; i < floors.length; i++){
            if(floors[i].getBestSpace().getSpace() > bestSpaceFlat.getSpace()){
                bestSpaceFlat = floors[i].getBestSpace();
            }
        }
        return bestSpaceFlat;
    }

    //Создайте метод получения отсортированного по убыванию площадей массива квартир.

    public Flat[] getSortSpace(){
        int countOfFlats = floors.length * floors[0].getArrayFlats().length;
        Flat[] flats = new Flat[countOfFlats];
        int temp = 0;

        for (int i = 0; i < floors.length; i++){
            for (int j = 0; j < floors[i].getArrayFlats().length; j++){
                flats[temp] = floors[i].getArrayFlats()[j];
            }
        }

        boolean isSorted = false;
        while (!isSorted) {
            isSorted= true;
            for (int i = 1; i < flats.length; i++) {
                if (flats[i].getSpace() < flats[i - 1].getSpace()) {
                    Flat template = flats[i];
                    flats[i] = flats[i - 1];
                    flats[i - 1] = template;
                    isSorted= false;
                }
            }
        }
        return flats;
    }

}
