package dailyPractice.jianzhi;

import java.awt.*;
import java.util.Random;

public class MouseController {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        Random random = new Random();
        while (true) {
            robot.mouseMove(random.nextInt(400), random.nextInt(400));
            Thread.sleep(10000);
        }

    }
}
