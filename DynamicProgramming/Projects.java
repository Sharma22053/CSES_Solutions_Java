import java.util.Arrays;
import java.util.Comparator;

public class Projects {
    static int[][] projects;

    public static void main(String[] args) {
        projects = new int[][] {
                { 2, 4, 4 },
                { 3, 6, 6 },
                { 6, 8, 2 },
                { 5, 7, 3 }
        };
        Arrays.sort(projects, Comparator.comparingInt(a -> a[0]));

        int maxLength = helper(0);
        System.out.println(maxLength);

    }

    static int helper(int index) {
        if (index == projects.length)
            return 0;
        int leave = helper(index + 1);
        int previous = binarySearch(projects[index][1]);
        int take = projects[index][2] + helper(previous);
        return Math.max(leave, take);
    }

    static int binarySearch(int endTime) {
        int low = 0;
        int high = projects.length - 1;
        int answer = projects.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (projects[mid][0] > endTime) {
                answer = mid;

                high = mid - 1;

            } else
                low = mid + 1;

        }
        return answer;
    }
}