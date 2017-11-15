package botX;

import battlecode.common.*;

public strictfp class RobotPlayer {
    static RobotController rc;

    /**
     * run() is the method that is called when a robot is instantiated in the Battlecode world.
     * If this method returns, the robot dies!
     **/
    @SuppressWarnings("unused")
    public static void run(RobotController rc) throws GameActionException {

        Robot robot = null;
        try {
            Robot.init(rc);

            switch (rc.getType()) {
                case ARCHON:
                    robot = new Archon();
                    break;
                case GARDENER:
                    robot = new Gardener();
                    break;
                case SOLDIER:
                    robot = new Soldier();
                    break;
                case LUMBERJACK:
                    robot = new Lumberjack();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Exception in " + rc.getType());
            e.printStackTrace();
        }
        while (true) {
            try {
                while (true) {
                    robot.onUpdate();
                }

            } catch (Exception e) {
                System.out.println("Exception in " + rc.getType());
                e.printStackTrace();
            }
        }
    }

}