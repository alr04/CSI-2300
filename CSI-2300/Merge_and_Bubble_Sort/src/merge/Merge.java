package merge;

import java.util.Random;
import java.util.ArrayList;

class Student implements Comparable<Student> {
    int grade;

    public Student (int grade) {
        this.grade = grade;
    }
    
    public int compareTo(Student stu) {
        return grade - stu.grade;
    }

    public String toString() {
        return "" + grade;
    }

    
}


public class Merge {

    public static void mergeSort (int[] newarray) {
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



        public static <E extends Comparable<E>> void bubbleSort (ArrayList<E> a) {
            for (int i = a.size(); i > 1; i--) {
                for (int j = 0; j < i - 1; j++) {
                    if (a.get(j).compareTo(a.get(j+1)) > 0) {
                        E temp = a.get(j);
                        a.set(j, a.get(j+1));
                        a.set(j+1, temp);
                }
            }
        }
    }





    public static void main(String[] args) throws Exception {
        /* Random randint = new Random();
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

        System.out.println("mergeSorted Array");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("\n");
        */

        ArrayList<Student> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arrayList.add(new Student(random.nextInt(100)));

        }

        System.out.println(arrayList.toString());
        bubbleSort(arrayList);
        System.out.println(arrayList.toString());

    }
    
}