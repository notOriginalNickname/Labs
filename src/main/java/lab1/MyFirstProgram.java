package lab1;
import lab1.myfirstpackage.MyFirstPackage;

class MyFirstClass {
    public static void main(String[] s) {
        MyFirstPackage o = new MyFirstPackage();
        int i,j;
        for (i = 1; i <=8; i++){
            for (j = 1; j <=8; j++){
                o.setA(i);
                o.setB(j);
                System.out.print(o.sumAnB());
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}


