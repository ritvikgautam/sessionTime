import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        // Example 1 Scenario
        ArrayList<Integer> sessionWindow = new ArrayList<Integer>();
        sessionWindow.add(8);
        sessionWindow.add(15);
        sessionWindow.add(18);
        sessionWindow.add(19);

        ArrayList<Integer> intervalWindow = new ArrayList<Integer>();
        intervalWindow.add(10);
        intervalWindow.add(20);

        SessionTime thisSession = new SessionTime(sessionWindow);

        System.out.println(thisSession.getPercentageAtLeastOneSession(intervalWindow));
    }
}
