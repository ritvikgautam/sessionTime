import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SessionTimeTest {
    @Test
    public void getPercentageAtLeastOneSessionExample1Test() throws Exception {
        SessionTime thisSession = new SessionTime();

        ArrayList<Integer> sessionWindow = new ArrayList<Integer>();
        sessionWindow.add(8);
        sessionWindow.add(15);
        sessionWindow.add(18);
        sessionWindow.add(19);

        ArrayList<Integer> intervalWindow = new ArrayList<Integer>();
        intervalWindow.add(10);
        intervalWindow.add(20);

        thisSession = new SessionTime(sessionWindow);

        Assert.assertEquals(0.6f, thisSession.getPercentageAtLeastOneSession(intervalWindow), 0.01);
    }

    @Test
    public void getPercentageAtLeastOneSessionExample2Test() throws Exception {
        SessionTime thisSession = new SessionTime();

        ArrayList<Integer> sessionWindow = new ArrayList<Integer>();
        sessionWindow.add(50);
        sessionWindow.add(60);
        sessionWindow.add(50);
        sessionWindow.add(62);
        sessionWindow.add(50);
        sessionWindow.add(65);

        ArrayList<Integer> intervalWindow = new ArrayList<Integer>();
        intervalWindow.add(40);
        intervalWindow.add(70);

        thisSession = new SessionTime(sessionWindow);

        Assert.assertEquals(0.5f, thisSession.getPercentageAtLeastOneSession(intervalWindow), 0.01);
    }

    @Test
    public void getPercentageAtLeastOneSessionNoIntervalTest() throws Exception {
        SessionTime thisSession = new SessionTime();

        ArrayList<Integer> sessionWindow = new ArrayList<Integer>();
        sessionWindow.add(50);
        sessionWindow.add(60);
        sessionWindow.add(50);
        sessionWindow.add(62);
        sessionWindow.add(50);
        sessionWindow.add(65);

        ArrayList<Integer> intervalWindow = new ArrayList<Integer>();
        intervalWindow.add(10);
        intervalWindow.add(20);

        thisSession = new SessionTime(sessionWindow);

        Assert.assertEquals(0.0f, thisSession.getPercentageAtLeastOneSession(intervalWindow), 0.01);
    }

    @Test
    public void getPercentageAtLeastOneSessionAllInclusiveTest() throws Exception {
        SessionTime thisSession = new SessionTime();

        ArrayList<Integer> sessionWindow = new ArrayList<Integer>();
        sessionWindow.add(10);
        sessionWindow.add(20);
        sessionWindow.add(20);
        sessionWindow.add(30);

        ArrayList<Integer> intervalWindow = new ArrayList<Integer>();
        intervalWindow.add(10);
        intervalWindow.add(30);

        thisSession = new SessionTime(sessionWindow);

        Assert.assertEquals(1.0f, thisSession.getPercentageAtLeastOneSession(intervalWindow), 0.01);
    }
}
