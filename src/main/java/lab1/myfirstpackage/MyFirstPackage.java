package lab1.myfirstpackage;

public class MyFirstPackage {
    //приватные поля
    private int a;
    private int b;
    //конструктор по умолчанию
    public MyFirstPackage(){
        a = 0;
        b = 0;
    }
    //конструктор с одним вашим значением
    MyFirstPackage(int a){
        this.a = a;
        b = 0;
    }
    //конструктор с полностью определёнными вами значениями
    MyFirstPackage(int a, int b){
        this.a = a;
        this.b = b;
    }

    //методы возвращающие значение переменной
    public int getA(){return a;}
    public int getB(){return b;}

    //методы изменяющие значение переменной
    public void setA(int a){this.a = a;}
    public void setB(int b){this.b = b;}

    public int sumAnB(){
        return a+b;
    }
}
