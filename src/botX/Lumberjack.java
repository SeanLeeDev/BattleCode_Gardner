package botX;

import battlecode.common.*;

import java.util.Random;

class Lumberjack extends Robot {

    public void onUpdate() {

        while (true) {
            try {

                TreeInfo[] trees = robotController.senseNearbyTrees(robotController.getType().bodyRadius * 2, robotController.getTeam());
                TreeInfo minHealthTree = null;
                for (TreeInfo tree : trees) {
                    if (tree.health > 0) {
                        if (minHealthTree == null || tree.health < minHealthTree.health) {
                            minHealthTree = tree;
                        }
                    }
                }
                if (minHealthTree != null) {
                    robotController.chop(minHealthTree.getID());
                }

                TreeInfo[] neutralTree = robotController.senseNearbyTrees(robotController.getType().bodyRadius * 2, null);
                TreeInfo minHealth = null;
                for (TreeInfo tree : neutralTree) {
                    if (tree.health > 0) {
                        if (minHealth == null || tree.health < minHealth.health) {
                            minHealth = tree;
                        }
                    }
                }
                if (minHealth != null) {
                    robotController.chop(minHealth.getID());
                }

                RobotInfo[] robots = robotController.senseNearbyRobots(RobotType.LUMBERJACK.bodyRadius + GameConstants.LUMBERJACK_STRIKE_RADIUS, enemy);
                if (robots.length > 0 && !robotController.hasAttacked()) {
                    robotController.strike();
                }
                else {
                    robots = robotController.senseNearbyRobots(-1, enemy);

                    //if (robots.length > 0) {
                      //  MapLocation friendlyJack = robotController.getLocation();
                      //  MapLocation enemyBot = robots[0].getLocation();
                      //  Direction toEnemyBot = friendlyJack.directionTo(enemyBot);

                      //  tryMove(toEnemyBot);
                    //}
                    //else {
                      //  tryMove(randomDirection());
                    //}
                }
                Clock.yield();
            }
            catch (Exception e) {
                System.out.println("A robotController Exception");
                e.printStackTrace();
            }
        }
    }
}
