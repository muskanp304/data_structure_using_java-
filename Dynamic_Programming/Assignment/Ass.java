package Dynamic_Programming.Assignment;
import java.util.ArrayList;
import java.util.List;

class Tester {

    static int count = 0;
    

    public static void findWordSegments(List<String> wordsList, String inputString) {
        segmentHelper(wordsList, inputString, "");
    }

    private static void segmentHelper(List<String> wordsList, String inputString, String result) {
        // If the input string is fully segmented, increment count
        if (inputString.length() == 0) {
            count++;
            return;
        }

        for (int i = 1; i <= inputString.length(); i++) {
            String prefix = inputString.substring(0, i);
            if (wordsList.contains(prefix)) {
                segmentHelper(wordsList, inputString.substring(i), result + prefix + " ");
            }
        }
    }

    public static void main(String[] args) {
        List<String> wordsList = new ArrayList<String>();
        wordsList.add("i");
        wordsList.add("like");
        wordsList.add("pizza");
        wordsList.add("li");
        wordsList.add("ke");
        wordsList.add("pi");
        wordsList.add("zza");

        String inputString = "ilikepizza";
        findWordSegments(wordsList, inputString);
        System.out.println("Number of segments: " + count);
    }
}
