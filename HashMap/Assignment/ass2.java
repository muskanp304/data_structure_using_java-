import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Tester {
    
    public static Map<String, Integer> mergeMaps(Map<String, Integer> mapOne, Map<String, Integer> mapTwo) {
        Map<String, Integer> mergedMap = new HashMap<>();
        
        // Add all entries from mapOne
        for (Entry<String, Integer> entry : mapOne.entrySet()) {
            mergedMap.put(entry.getKey(), entry.getValue());
        }
        
        // Add entries from mapTwo
        for (Entry<String, Integer> entry : mapTwo.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            
            if (mergedMap.containsKey(key)) {
                // If values differ, add new key with "new" + key
                if (!mergedMap.get(key).equals(value)) {
                    mergedMap.put("new" + key, value);
                }
                // else do nothing, values are the same
            } else {
                mergedMap.put(key, value);
            }
        }
        
        return mergedMap;
    }

    public static void main(String args[]) {
        Map<String, Integer> mapOne = new HashMap<>();
        mapOne.put("Kelly", 10);
        mapOne.put("Micheal", 20);
        mapOne.put("Ryan", 30);
        
        Map<String, Integer> mapTwo = new HashMap<>();
        mapTwo.put("Jim", 15);
        mapTwo.put("Andy", 45);
        mapTwo.put("Kelly", 25);  // duplicate key with different value
        
        Map<String, Integer> mergedMap = mergeMaps(mapOne, mapTwo);

        System.out.println("Merged Map\n===========");
        for (Entry<String, Integer> entry : mergedMap.entrySet()) {
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }
    }
}
