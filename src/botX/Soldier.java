package botX;

import battlecode.common.Clock;
import battlecode.common.RobotInfo;
import java.util.Random;

class Soldier extends Robot {

    public void onUpdate() {

        while (true) {
            try {

                RobotInfo[] robots = robotController.senseNearbyRobots(-1, myTeam.opponent());

                if (robots.length > 0) {
                    Random random = new Random();
                    int number = random.nextInt();
                    while (true) {
                        try {
                            switch (number) {
                                case 1:
                                    if (robotController.canFireSingleShot()) {
                                        robotController.fireSingleShot(robotController.getLocation().directionTo(robots[0].location));
                                        break;
                                    }
                                case 2:
                                    if (robotController.canFireTriadShot()) {
                                        robotController.fireTriadShot(robotController.getLocation().directionTo(robots[0].location));
                                    }
                                    break;
                                case 3:
                                    if (robotController.canFirePentadShot()) {
                                        robotController.firePentadShot(robotController.getLocation().directionTo(robots[0].location));
                                    }
                                default:
                                    if (robotController.canFireSingleShot()) {
                                        robotController.fireSingleShot(robotController.getLocation().directionTo(robots[0].location));
                                    }
                                    break;
                            }

                        } catch (Exception e) {
                            System.out.println("Engaging the enemy!");
                            e.printStackTrace();
                        }
                    }
                }

                tryMove(randomDirection());
                Clock.yield();
            } catch (Exception e) {
                System.out.println("A robotController Exception");
                e.printStackTrace();
            }
        }
    }
}
