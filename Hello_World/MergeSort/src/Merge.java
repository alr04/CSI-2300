import java.util.Random;


public class Merge {

    private static void mergeSort (int[] newarray) {
        int arraylen = newarray.length;
        
        if (arraylen < 2) {
            return;
        }

        int middle = arraylen/2;

        int[] leftarray = new int[middle];
        int[] rightarray = new int[arraylen - middle];

        for (int i = 0; i < middle; i++) {
            leftarray[i] = newarray[i];
        }

        for (int i = middle; i < arraylen; i++ )
        rightarray[i - middle] = newarray[i];

        mergeSort(leftarray);
        mergeSort(rightarray);

        merge (newarray,leftarray, rightarray);
    }

    private static void merge (int[] newarray, int[] leftarray, int[] rightarray) {
        int leftlen = leftarray.length;
        int rightlen = rightarray.length;

        int i = 0, j = 0, k = 0;
        
        while (i < leftlen && j < rightlen) {
            if (leftarray[i] < rightarray[j]) {
                newarray[k] = leftarray[i];
                i++;
            }
            else {
                newarray[k] = rightarray[j];
                j++;
            }
            k++;
        }

        while (i < leftlen) {
            newarray[k] = leftarray[i];
            i++;
            k++;
        }

        while (j < rightlen) {
            newarray[k] = rightarray[j];
            j++;
            k++;
        }
    }





    public static void main(String[] args) throws Exception {
        Random randint = new Random();
        int[] array = new int[50];

        for (int i = 0; i < array.length; i++) {
            array[i] = randint.nextInt(100);
        }

        System.out.println("Original Array");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("\n");

        mergeSort(array);

        System.out.println("Sorted Array");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("\n");

    }
}
