import java.util.ArrayList;
import java.util.HashSet;

public class SessionTime {

    // Contains all time timestamps that are to be considered open.
    private HashSet<Integer> sessionOpen;

    public SessionTime() {}

    // sessionTime - <startTime1, endTime1, startTime2, endTime2 ... startTimeN, endTimeN>
    public SessionTime(ArrayList<Integer> sessionTime) {
        this.sessionOpen = new HashSet<Integer>();

        // Iterate through session windows
        for(int i = 0; i < sessionTime.size(); i = i + 2) {

            // Get start and end time
            Integer startTime = sessionTime.get(i);
            Integer endTime = sessionTime.get(i+1);

            // Loop between session, and store the times. 4
            for(int j = startTime + 1; j <= endTime; j++) {
                this.sessionOpen.add(j);
            }
        }
    }

    public float getPercentageAtLeastOneSession(ArrayList<Integer> interval) {
        // Get intervals
        Integer startInterval = interval.get(0);
        Integer endInterval = interval.get(1);

        // Get the interval window
        Integer sizeOfInterval = endInterval - startInterval;
        Integer numberOfOpenSession = 0;

        // Loop through the interval. If the time is present in sessionOpen hashset, it means some window was open during that time.
        for(int i = startInterval + 1; i <= endInterval; i++) {
            if(this.sessionOpen.contains(i)) {
                numberOfOpenSession++;
            }
        }

        // Calculate percentage where at aleast one session was on
        float percentageOneSession = (float) numberOfOpenSession / (float) sizeOfInterval;

        return percentageOneSession;
    }
}
