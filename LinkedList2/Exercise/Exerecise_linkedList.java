package LinkedList2.Exercise;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

class Exerecise_linkedList {
    
    public static List<Object> concatenateLists(List<Object> listOne, List<Object> listTwo) {
        // Ensure listTwo is a LinkedList to use descendingIterator
        if (!(listTwo instanceof LinkedList)) {
            throw new IllegalArgumentException("listTwo must be a LinkedList");
        }
        
        LinkedList<Object> linkedListTwo = (LinkedList<Object>) listTwo;
        Iterator<Object> reverseIterator = linkedListTwo.descendingIterator();
        
        while (reverseIterator.hasNext()) {
            listOne.add(reverseIterator.next());
        }
        
        return listOne;
    }


    public static void main(String args[]) {
        List<Object> listOne = new LinkedList<Object>();
        listOne.add("Hello");
        listOne.add(102);
        listOne.add(25);
        listOne.add(38.5);
        
        List<Object> listTwo = new LinkedList<Object>();
        listTwo.add(150);
        listTwo.add(200);
        listTwo.add('A');
        listTwo.add("Welcome");
        
        List<Object> concatenatedList = concatenateLists(listOne, listTwo);
        
        System.out.println("Concatenated linked list:");
        for (Object value : concatenatedList) {
            System.out.print(value + " ");
        }
    }
}
