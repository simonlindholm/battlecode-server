package battlecode.common;

/**
 * Struct that stores basic information that was 'sensed' of another Robot. This
 * info is ephemeral and there is no guarantee any of it will remain the same
 * between rounds.
 */
public class RobotInfo implements  BodyInfo{

    /**
     * The unique ID of the robot.
     */
    public final int ID;

    /**
     * The Team that the robot is on.
     */
    public final Team team;

    /**
     * The type of the robot.
     */
    public final RobotType type;

    /**
     * The current location of the robot.
     */
    public final MapLocation location;

    /**
     * The current core delay of the robot.
     */
    public final double coreDelay;

    /**
     * The current weapon delay of the robot.
     */
    public final double weaponDelay;

    /**
     * The current health of the robot.
     */
    public final double health;

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public MapLocation getLocation() {
        return this.location;
    }

    @Override
    public float getRadius() {
        return this.type.bodyRadius;
    }

    @Override
    public boolean isRobot() {
        return true;
    }

    @Override
    public boolean isTree() {
        return false;
    }

    @Override
    public boolean isBullet() {
        return false;
    }

    public RobotInfo(int ID, Team team, RobotType type, MapLocation location,
                     double coreDelay, double weaponDelay, double health) {
        super();
        this.ID = ID;
        this.team = team;
        this.type = type;
        this.location = location;
        this.coreDelay = coreDelay;
        this.weaponDelay = weaponDelay;
        this.health = health;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RobotInfo robotInfo = (RobotInfo) o;

        if (ID != robotInfo.ID) return false;
        if (Double.compare(robotInfo.coreDelay, coreDelay) != 0) return false;
        if (Double.compare(robotInfo.weaponDelay, weaponDelay) != 0) return false;
        if (Double.compare(robotInfo.health, health) != 0) return false;
        if (team != robotInfo.team) return false;
        if (type != robotInfo.type) return false;
        return location.equals(robotInfo.location);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = ID;
        result = 31 * result + team.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + location.hashCode();
        temp = Double.doubleToLongBits(coreDelay);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weaponDelay);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(health);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "RobotInfo{" +
                "ID=" + ID +
                ", team=" + team +
                ", type=" + type +
                ", location=" + location +
                ", coreDelay=" + coreDelay +
                ", weaponDelay=" + weaponDelay +
                ", health=" + health +
                '}';
    }
}
