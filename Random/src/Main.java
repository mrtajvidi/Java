import java.net.Inet4Address;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hi. this is my project.");

        // Arrays
        String[] input = new String[100];
        int[] input2 = {12, 3, 4, 5};
        System.out.println("First Element: " + input2[0]);

        // converting array to string
        System.out.println("Array is: " + Arrays.toString(input2));

        // iterate and copy elements from source to destination
        for (int i=0; i< input2.length; i++)
        {
            System.out.println(input2[i]);
        }

        // foreach
        for (Integer item : input2)
        {
            System.out.println(item);
        }

        int[][] matrix = new int[3][2];
        int[][] matrix2 = { { 1, 2, 3, 4}, {3 , -1, -4, -6}, {0, 12, 6, -5}};
        System.out.println("matrix2 is " + Arrays.deepToString( matrix2));

        ArrayList<Integer> listOfInts = new ArrayList<>();
        listOfInts.add(2);
        listOfInts.add(3);
        System.out.println("numbers are: " + listOfInts);

        int number = listOfInts.get(1);
        System.out.println("Accessed element:" + number);

        //int removedNumber = listOfInts.remove(0);
        //System.out.println("Removed element:" + removedNumber);
        listOfInts.set(1, 5);
        System.out.println("numbers are: " + listOfInts);

        listOfInts.add(-1);
        listOfInts.add(8);

        listOfInts.sort(Comparator.naturalOrder());
        System.out.println("numbers are: " + listOfInts);

        listOfInts.sort(Comparator.reverseOrder());
        System.out.println("numbers are: " + listOfInts);

        ArrayList<Integer> clonedListOfInts = (ArrayList<Integer>)listOfInts.clone();
        System.out.println("cloned numbers are: " + clonedListOfInts);


        System.out.print("Is 3 present in the arraylist: ");
        System.out.println(listOfInts.contains(3));

        boolean result = listOfInts.isEmpty(); // true
        System.out.println("Is the ArrayList empty? " + result);


        System.out.print("Index of element 5 is: ");
        System.out.println(listOfInts.indexOf(5));

        for(Integer item : listOfInts)
        {
            System.out.println("number is: " + item);
        }

        // Convert ArrayList into the string array
        Integer[] arrayOfInt = new Integer[listOfInts.size()];
        listOfInts.toArray(arrayOfInt);
        System.out.println("arrayOfInt is: ");

        for (Integer item : arrayOfInt)
        {
            System.out.println(item + " ,");
        }

        // convert array to arraylist
        List<Integer> newListOfIntegers = new ArrayList<>(Arrays.asList(arrayOfInt));
        System.out.println("newListOfIntegers is: " + newListOfIntegers);

        System.out.println("Array list as string is: " + newListOfIntegers.toString());

        System.out.println("the size of Array list is: " + newListOfIntegers.size());



        /*size()	        Returns the length of the arraylist.
        sort()	            Sort the arraylist elements.
        clone()	            Creates a new arraylist with the same element, size, and capacity.
        contains()	        Searches the arraylist for the specified element and returns a boolean result.
        ensureCapacity()	Specifies the total element the arraylist can contain.
        isEmpty()	        Checks if the arraylist is empty.
        indexOf()	        Searches a specified element in an arraylist and returns the index of the element.
        */

        // Stack for stack
        Stack<Integer> stacks = new Stack<>();
        stacks.push(12);
        stacks.push(11);
        stacks.push(-1);

        System.out.println("stacks is " + stacks);
        Integer popedElement = stacks.pop();
        System.out.println("poped element is: " + popedElement);
        System.out.println("stacks is " + stacks);

        Integer peekedElement = stacks.peek();
        System.out.println("peeked element is: " + peekedElement);
        System.out.println("stacks is " + stacks);
        System.out.println("Is stacks empty?" + stacks.empty());


        // Deque for Stack
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.push(3);
        arrayDeque.push(2);
        arrayDeque.push(-1);
        arrayDeque.push(19);

        System.out.println("ArrayDeque is: " + arrayDeque);
        System.out.println("First element of ArrayDeque is: " + arrayDeque.peek());
        System.out.println("First element of ArrayDeque is: " + arrayDeque.pop());
        System.out.println("ArrayDeque is: " + arrayDeque);

        // LinkedList for Queue
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(2);
        queue.offer(-1);
        queue.offer(3);
        queue.offer(5);
        System.out.println("Queue is: " + queue);

        int accessedNumber = queue.peek();
        System.out.println("accessedNumber is: " + accessedNumber);

        int removedNumber = queue.poll();
        System.out.println("removedNumber is: " + removedNumber);
        System.out.println("Queue is: " + queue);

        Iterator<Integer> iterator0 = queue.iterator();
        while (iterator0.hasNext())
        {
            System.out.println(iterator0.next());
            System.out.println(" ,");
        }


        // Priority Queue
        Queue<Integer> numbers = new PriorityQueue<>();
        numbers.offer(10);
        System.out.println("PriorityQueue is: " + numbers);

        numbers.add(4);
        System.out.println("PriorityQueue is: " + numbers);

        numbers.add(2);
        System.out.println("PriorityQueue is: " + numbers);

        numbers.add(3);
        System.out.println("PriorityQueue is: " + numbers);

        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
            System.out.println(" ,");
        }


        // Deqeu




    }
}
