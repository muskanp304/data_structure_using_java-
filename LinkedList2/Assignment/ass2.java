package LinkedList2.Assignment;
import java.util.LinkedList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

class Tester {
    
    public static List<Integer> findCommonElements(List<Integer> listOne, List<Integer> listTwo) {
        List<Integer> commonElements = new LinkedList<>();
        Set<Integer> set = new HashSet<>(listTwo); // Convert listTwo to a Set for O(1) lookup

        for (Integer num : listOne) {
            if (set.contains(num)) {
                commonElements.add(num);
            }
        }

        return commonElements;
    }

    public static void main(String arga[]) {
        List<Integer> listOne = new LinkedList<>();
        listOne.add(10);
        listOne.add(12);
        listOne.add(21);
        listOne.add(1);
        listOne.add(53);
        
        List<Integer> listTwo = new LinkedList<>();
        listTwo.add(11);
        listTwo.add(21);
        listTwo.add(25);
        listTwo.add(53);
        listTwo.add(47);

        System.out.println(findCommonElements(listOne, listTwo));
    }
}

