package LinkedList2.Assignment;

import java.util.LinkedList;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedList_ass1  {

    public static List<Integer> removeDuplicates(List<Integer> list) {
        // Create a LinkedHashSet to remove duplicates while maintaining order
        Set<Integer> set = new LinkedHashSet<>(list);
        
        // Create a new LinkedList from the set
        return new LinkedList<>(set);
    }
    
    public static void main(String args[]) {
        List<Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(15);
        list.add(21);
        list.add(15);
        list.add(10);
        
        List<Integer> updatedList = removeDuplicates(list);
        
        System.out.println("Linked list without duplicates");
        for (Integer value : updatedList) {
            System.out.print(value + " ");
        }
    }
}
