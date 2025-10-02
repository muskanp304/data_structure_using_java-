
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

class Student {

    public static Map<String, Double> findMaxMinScorers(Map<String, Double> studentMarks) {
        Map<String, Double> result = new HashMap<>();
        
        if (studentMarks == null || studentMarks.isEmpty()) {
            return result; // Return empty map if input is null or empty
        }

        double maxMarks = Double.MIN_VALUE;
        double minMarks = Double.MAX_VALUE;

        String maxScorers = "";
        String minScorers = "";

        // Find max and min marks first
        for (Entry<String, Double> entry : studentMarks.entrySet()) {
            double marks = entry.getValue();
            if (marks > maxMarks) {
                maxMarks = marks;
            }
            if (marks < minMarks) {
                minMarks = marks;
            }
        }

        // Find names of students who scored max and min
        for (Entry<String, Double> entry : studentMarks.entrySet()) {
            if (entry.getValue() == maxMarks) {
                if (!maxScorers.isEmpty()) maxScorers += ", ";
                maxScorers += entry.getKey();
            }
            if (entry.getValue() == minMarks) {
                if (!minScorers.isEmpty()) minScorers += ", ";
                minScorers += entry.getKey();
            }
        }

        result.put("Max Marks (" + maxScorers + ")", maxMarks);
        result.put("Min Marks (" + minScorers + ")", minMarks);

        return result;
    }
}

 public class HashMap_exs {

    public static void main(String args[]) {
        Map<String, Double> studentMarks = new HashMap<String, Double>();
        studentMarks.put("Lily", 90.0);
        studentMarks.put("Robin", 68.0);
        studentMarks.put("Marshall", 76.5);
        studentMarks.put("Neil", 67.0);
        studentMarks.put("Ted", 92.0);

        Map<String, Double> maxMinScorers = Student.findMaxMinScorers(studentMarks);

        System.out.println("Details of Top Scorers & Low Scorers\n====================================");
        for (Entry<String, Double> entry : maxMinScorers.entrySet()) {
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }
    }
}
