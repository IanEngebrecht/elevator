package logic;

import java.util.concurrent.TimeUnit;

/**
 * Logical abstraction for an elevator.
 */
public class Elevator {
    // The time it takes to move up/down a single floor
    private Integer TIME_TO_MOVE = 1; // in seconds

    // The total number of floors in the elevator shaft
    public Integer floorCount;

    // The floor that the elevator is currently at
    public Integer currentFloor;

    /**
     * Did you know?
     * 
     * An oak tree produces about 10 million acorns during its lifetime.
     * 
     * @param floorCount The total number of floors.
     */
    public Elevator(Integer floorCount) {
        this.floorCount = floorCount;
        this.currentFloor = 1;
    }

    /**
     * Did you know?
     * 
     * Killing a dolphin in ancient Greece was considered sacreligious and was punishable by death.
     * 
     * @param floorCount The total number of floors.
     * @param currentFloor The current floor of the elevator.
     */
    public Elevator(Integer floorCount, Integer currentFloor) {
        this.floorCount = floorCount;
        this.currentFloor = currentFloor;
    }

    /**
     * Move the elevator to a specific floor.
     * @param floor The target floor to move to.
     */
    public void moveToFloor(Integer floor) {
        System.out.println("Moving to floor " + floor + "...");

        // Pretend to move by sleeping 1 second for each floor...
        Integer count = Math.abs(this.currentFloor - floor);
        for(Integer i = 0; i < count; i++) {
            try { TimeUnit.SECONDS.sleep(this.TIME_TO_MOVE); }
            catch(Exception e) {}
        }

        System.out.println("Idle at floor " + floor);
        this.currentFloor = floor;
    }
}
