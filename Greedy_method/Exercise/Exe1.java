package Greedy_method.Exercise;

class Tester {

    public static int findMaxActivities(int start[], int finish[]) {
        int n = start.length;

        // The first activity always gets selected
        int count = 1;
        int lastSelected = 0; // Index of the last selected activity

        // Iterate over remaining activities
        for (int i = 1; i < n; i++) {
            // If this activity starts after or when the last one finishes
            if (start[i] >= finish[lastSelected]) {
                count++;
                lastSelected = i;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int start[] =  {1, 3, 0, 5, 8, 5}; 
        int finish[] = {2, 4, 6, 7, 9, 9};

        System.out.println("Maximum number of activities: " + findMaxActivities(start, finish));
    }
}
