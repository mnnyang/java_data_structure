package array;

public class Main {
    public static void main(String[] args) {
        Array array = new Array(7);

        for (int i = 0; i < 6; i++) {
            array.addLast(i);
        }

        System.out.println(array);

        array.add(1, 777);
        System.out.println(array);


        array.add(2,888);
        System.out.println(array);


        array.remove(1);
        System.out.println(array);

        array.remove(4);
        System.out.println(array);

        array.removeAllElement(2);
        System.out.println(array);


        array.remove(0);
        System.out.println(array);
        array.remove(0);
        System.out.println(array);
        array.remove(0);
        System.out.println(array);
    }
}
