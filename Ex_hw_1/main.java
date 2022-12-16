public class main {

    public static void checkArray(Integer[] array) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == null) {
                System.out.println("Index of null element is: " + index);  
            }
        }
    }
    public static void main(String[] args) {
        Integer[] array = {null, 4, 5, 1};

        checkArray(array);
    }
}