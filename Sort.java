//Troy Zhang
import java.util.HashSet;
import java.util.Set;


public class Sort {

    public static <T extends Comparable <T>> void sort (T[] array ){

        Set<Interval> boundSet = new HashSet<>();

        // we will manually add our first interval so the while loop below is satisfied.
        boundSet.add(new Interval(0, array.length-1)); // first interval we're adding to the array: the entire set. Lower bound: 0, Upper bound: array-1

        while (!boundSet.isEmpty()){

            Interval nextBoundPair = boundSet.iterator().next(); //gives you the next interval pair in the HashSet.

            boundSet.remove(nextBoundPair); // in the first iteration, when there is only just one interval pair, that interval pair gets removed, and the set is empty.

            // low and high are indices of the position of the lowest/highest values, not the actual values itself.
            int low = nextBoundPair.getLower();
            int high = nextBoundPair.getUpper();

            if (low < high){

                //calculate pivot index
                int pivotIndex = partition(array, low, high);

                //add two new interval pairs, split by the pivot
                boundSet.add(new Interval(low, pivotIndex-1));
                boundSet.add(new Interval(pivotIndex+1, high));

                //the idea is that the while loop will keep executing, and each iteration of the while loop, the next interval pair in boundSet is removed,
                //and two new interval pairs will be added to boundSet split by the pivot index if the low value < high value, until there is no more interval pairs
                //left boundSet.
            }
        }

    }

    private static<T extends Comparable<T>> void swap(T []array, int i, int j){
        //this method is how we will swap the index of i and j
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static<T extends Comparable<T>> int partition(T []array, int low, int high){

        int first = low;
        int middle = (low + high) / 2;
        int last = high;

        //sort elements at positions first, middle, last

        //if the low value is greater than the median value, swap
        if (array[first].compareTo(array[middle]) > 0){
            swap(array, first, middle);
        }

        //if the middle value is greater than the last value, swap.
        if (array[middle].compareTo(array[last]) > 0){
            swap(array, middle, last);

            // if the first value is greater than the middle value, swap.
            if (array[first].compareTo(array[middle]) > 0){
                swap(array, first, middle);
            }
        }

        //swap the median element(which is now at the middle) with the element at position low
        swap(array, first, middle);

        //choose the pivot as the element at the first position
        T pivot = array[first];

        int i = high + 1;

        for (int j = high; j > low; j--){
            if (array[j].compareTo(pivot) >= 0){ //use compareTo because T is a Comparable(generic type), could be anything(string, int, etc...)

                i--;

                swap(array, i, j);
            }


        }
        swap(array, i-1, low);
        return i-1;
    }

    private static class Interval {
        private int lower;
        private int upper;

        public Interval(int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
        }

        public int getLower() {
            return this.lower;
        }

        public int getUpper() {
            return this.upper;
        }


        public boolean equals(Object o) {

            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Interval interval = (Interval) o;
            return (lower == interval.getLower() && upper == interval.getUpper());
        }

        // not used
        public int hashCode() {
            return lower * lower + upper;
        }
    }


    // testing
    public static void main(String[] args){
        Integer[] array = {10, 7, 8, 12, 4, 6};

        sort(array);

        System.out.println("\nAfter sorting...");

        for (int a: array){
            System.out.print(a + " ");
        }


        String[] array2 = {"cat", "elephant", "tiger", "peacock", "dog"};

        sort(array2);

        System.out.println("\n\nAfter sorting...");

        for (String b: array2){
            System.out.print(b + " ");
        }
    }







}
