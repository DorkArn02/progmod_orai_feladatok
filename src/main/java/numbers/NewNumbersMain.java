package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("unused")
public class NewNumbersMain {

    /**
     * Task 1: Create a main method.
     * Create a generateArray method to generate a 1-dimensional array: 1 2 3 4 5
     * Call this method and print the return value in main.
     */

    public static Random rnd = new Random(50);

    public static void main(String[] args) {
        /*System.out.println(Arrays.toString(generateArray()));
        System.out.println(Arrays.toString(generateArray(true)));

        int[] T1 = generateArray(true);
        int[][] T2 = generateTwoDimensionalArray(true);

        ArrayList<Integer> l = generateList(true, 10);
        printAllListElements(l);
        printOneDimensionalArray(T1);
        printTwoDimensionalArray(T2);

        ArrayList<Integer> even = selectEvenNumbers(l);

        if(even.size() == 0){
            System.out.println("There are no even number in the list");
        }
        */
        ArrayList<Integer> a = generateList(true, 5);

        seperateEvenAndOdds(a);

    }

    public static int[] generateArray() {
        return new int[]{1, 2, 3, 4, 5};
    }

    /**
     * Task 2: Add a random parameter to generateArray method:
     * - If the value of random parameter is true,
     * then return with a 5 element array filled with random numbers.
     * - If the value of random parameter is false,
     * then return with the same array as before.
     * Hint: You can generate random numbers with Random objects.
     * Hint: Use nextInt(bound) method to get integers between 0 and bound value.
     * Call the method with true and false parameters and print the results in main.
     */
    public static int[] generateArray(boolean random) {
        if (random) {
            int[] T = new int[5];
            for (int i = 0; i < 5; i++) {
                T[i] = rnd.nextInt(100) - 50;
            }
            return T;
        } else {
            return new int[]{1, 2, 3, 4, 5};
        }
    }

    /**
     * Task 3: Create a generateTwoDimensionalArray(random) method to generate a 2-dimensional array:
     * - If the value of random parameter is true,
     * then return with a 2x3 array filled with random numbers.
     * - If the value of random parameter is false, then return with array of this matrix:
     * 1 2 3
     * 4 5 6
     * Call this method and print the return value in main.
     *
     * @return int[][]
     */
    public static int[][] generateTwoDimensionalArray(boolean random) {
        if (random) {
            int[][] T = new int[2][3];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    T[i][j] = rnd.nextInt(100) - 50;
                }
            }
            return T;
        } else {
            return new int[][]{{1, 2, 3},
                    {4, 5, 6}
            };
        }
    }

    /**
     * Task 4: Create a generateList(random, length) method to generate
     * a 1-dimensional array with dynamic length.
     * - If the value of random parameter is true, then return with a list of random numbers.
     * The length of this list has to match with length parameter.
     * - If the value of random parameter is false,
     * then return with an array with the numbers from 1 to value of length parameter.
     * Hint: Use ArrayList.
     */
    public static ArrayList<Integer> generateList(boolean random, int length) {
        ArrayList<Integer> l = new ArrayList<>();

        if (random) {
            for (int i = 0; i < length; i++) {
                l.add(rnd.nextInt(100) - 50);
            }
        } else {
            for (int i = 1; i <= length; i++) {
                l.add(i);
            }
        }
        return l;

    }

    /**
     * Task 5: Create a print method to print all element of a list parameter to the console.
     * For example: [1, 2, 3, 4, 5]
     * Extra: Create similar method for 1- and 2-dimensional arrays.
     */
    public static void print(ArrayList<Integer> l) {
        for (Integer integer : l) {
            System.out.printf("%d ", integer);
        }
        System.out.println();
    }

    public static void print(int[] arr) {
        for (int j : arr) {
            System.out.printf("%d ", j);
        }
        System.out.println();
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Task 6: Create a selectEvenNumbers method, what return a subset of the list parameter.
     * The subset list has to contain all and only the even numbers.
     * Call this method in main and print a message with the length of subset list or
     * the static "There are no even number in the list" message.
     */
    public static ArrayList<Integer> selectEvenNumbers(ArrayList<Integer> l) {
        ArrayList<Integer> even = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) % 2 == 0)
                even.add(i);
        }
        return even;
    }

    /**
     * Task 7: Create an intersection method, what get 2 lists as parameters.
     * The method has to return with a list, what contains all and only those elements,
     * which is in both list parameters.
     * Extra: Create same method for 1- and 2-dimensional arrays.
     * Extra: Create same method for lists and arrays with double values.
     */
    public static ArrayList<Integer> intersection(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> same = new ArrayList<>();

        for (Integer integer : a) {
            if (b.contains(integer))
                same.add(integer);
        }
        return same;
    }

    /**
     * Task 8: Create a separateEvenAndOdds method, what create 2 sublist of the list parameter.
     * First sublist has to contain all and only the even numbers, and the second one
     * has to contain all and only the odd numbers.
     * Print to console:
     * - sublist of even numbers
     * - sublist of odd numbers
     * - length of sublist of even numbers
     * - length of sublist of odd numbers
     * - length of original list
     * Hint: This method should have no return value, because you should print the values.
     */
    public static void seperateEvenAndOdds(ArrayList<Integer> l) {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        for (Integer i : l) {
            if (i % 2 == 0)
                even.add(i);
            else
                odd.add(i);
        }
        System.out.println(Arrays.toString(even.toArray()));
        System.out.println(Arrays.toString(odd.toArray()));
        System.out.println(even.size());
        System.out.println(odd.size());
        System.out.println(l.size());
    }

    /**
     * Task 9: Create a numberOfOdds(array) method to count how many odd value is in a list.
     * Extra: Create same method for 1- and 2-dimensional arrays.
     */
    public static int numberOfOdds(ArrayList<Integer> l) {
        int n = 0;
        for (Integer integer : l) {
            if (integer % 2 != 0)
                n++;
        }
        return n;
    }

    public static int numberOfOdds(int[] T) {
        int n = 0;
        for (int i : T) {
            if (i % 2 != 0) {
                n++;
            }
        }
        return n;
    }

    public static int numberOfOdds(int[][] T) {
        int n = 0;
        for (int[] ints : T) {
            for (int j = 0; j < T[0].length; j++) {
                if (ints[j] % 2 != 0)
                    n++;
            }
        }
        return n;
    }

    /**
     * Task 10: Create a contains(array, value) method to decide the value is in a list or not.
     * Extra: Create same method for 1- and 2-dimensional arrays.
     * Extra: Create same method for lists and arrays with double values.
     */
    public static boolean contains(ArrayList<Integer> l, int value) {
        for (Integer i : l) {
            if (i == value)
                return true;
        }
        return false;
    }

    public static boolean contains(int[] T, int value) {
        int n = 0;
        for (int i : T) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(int[][] T, int value) {
        int n = 0;

        for (int[] ints : T) {
            for (int j = 0; j < T[0].length; j++) {
                if (ints[j] == value)
                    return true;
            }
        }

        return false;
    }

    /**
     * Task 11: Create a sum(array) method to get the sum of values in a list.
     * Extra: Create same method for 1- and 2-dimensional arrays.
     * Extra: Create same method for lists and arrays with double values.
     */
    public static int sum(ArrayList<Integer> l) {
        int s = 0;
        for (Integer integer : l) {
            s += integer;
        }
        return s;
    }

    public static int sum(int[] T) {
        int s = 0;
        for (Integer integer : T) {
            s += integer;
        }
        return s;
    }

    public static int sum(int[][] T) {
        int s = 0;
        for (int[] ints : T) {
            for (int j = 0; j < T[0].length; j++) {
                s += ints[j];
            }
        }
        return s;
    }

    /**
     * Task 12: Create a indexOf(array, value) method to return the index of value in a list.
     * If the list does not contain the value, then return with -1.
     * Extra: Create same method for 1- and 2-dimensional arrays.
     * Extra: Create same method for lists and arrays with double values.
     */
    public static int indexOf(ArrayList<Integer> l, int value) {
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) == value)
                return i;
        }
        return -1;
    }

    public static int indexOf(int[] l, int value) {
        for (int i = 0; i < l.length; i++) {
            if (l[i] == value)
                return i;
        }
        return -1;
    }

    public static int indexOf(int[][] l, int value) {
        for (int i = 0; i < l.length; i++) {
            for (int j = 0; j < l[0].length; j++) {
                if (l[i][j] == value)
                    return i;
            }
        }
        return -1;
    }

    /**
     * Task 13: Create a union method, what get 2 lists as parameters.
     * The method has to return with a list, what contains all elements of list parameters,
     * but it has to contain all elements only 1 time (eliminate the duplications).
     * Extra: Create same method for 1- and 2-dimensional arrays.
     * Extra: Create same method for lists and arrays with double values.
     */
    public static ArrayList<Integer> union(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> unionList = new ArrayList<>(a);
        for (Integer i : b) {
            if (!unionList.contains(i))
                unionList.add(i);
        }
        return unionList;
    }
    public static ArrayList<Integer> union(int[] a, int[] b){
        ArrayList<Integer> unionList = new ArrayList<>();

        for(int i : a){
            unionList.add(i);
        }

        for (int j : b) {
            if (!unionList.contains(j))
                unionList.add(j);
        }
        return unionList;
    }

    public static ArrayList<Integer> union(int[][] a, int[][] b){
        ArrayList<Integer> unionList = new ArrayList<>();

        for (int[] ints : a) {
            for (int j = 0; j < a[0].length; j++) {
                unionList.add(ints[j]);
            }
        }

        for (int[] ints : b) {
            for (int j = 0; j < b[0].length; j++) {
                if (!unionList.contains(ints[j]))
                    unionList.add(ints[j]);
            }
        }
        return unionList;
    }
}
