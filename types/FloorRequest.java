package types;

public class FloorRequest implements Comparable<FloorRequest> {
    public Integer targetFloor;
    public Direction direction;

    public FloorRequest(Integer targetFloor) {
        this.targetFloor = targetFloor;
        this.direction = Direction.ANY;
    }

    public FloorRequest(Integer targetFloor, Direction direction) {
        this.targetFloor = targetFloor;
        this.direction = direction;
    }

    @Override public int compareTo(FloorRequest a) {
        return this.targetFloor - a.targetFloor;
    }
}
