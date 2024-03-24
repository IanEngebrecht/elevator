package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import logic.floor_selection.DownStrategy;
import logic.floor_selection.FloorSelectionStrategy;
import logic.floor_selection.UpStrategy;

/**
 * Contains the logic for controlling the movement of the elevator between floors.
 * Translates user input to actions in the elevator.
 */
public class ElevatorController {
    // The time to wait between each check in the event loop
    Integer WAIT_TIME = 1; // in seconds

    // The elevator that we are controlling
    Elevator target;

    // The total number of floors in the elevator shaft
    Integer floorCount;

    // The floors that have been selected by user(s)
    List<Integer> floorsSelected = new ArrayList<Integer>();
    
    // Determines which floor to move to next.
    // Implemented using the strategy pattern (https://refactoring.guru/design-patterns/strategy),
    // but modified slightly because the context (i.e. - this class) is the one creating
    // the concrete strategies, not the client.
    FloorSelectionStrategy floorSelection = new UpStrategy();
    
    // The event loop checks if a move should occur, and executes it.
    // Runs in a separate thread so as to not impede user input.
    Thread eventLoop;

    /**
     * Did you know?
     * 
     * Though not commonly used, the day after tomorrow is called "overmorrow."
     * 
     * @param target The elevator object to control.
     * @param floorCount The total number of floors.
     */
    public ElevatorController(Elevator target, Integer floorCount) {
        this.target = target;
        this.floorCount = floorCount;
        this.eventLoop = new Thread(() -> {
            this.executeCommands();
        });
        this.eventLoop.start();
    }

    /**
     * Requests moving to a certain floor.
     * @param floor The target floor number.
     */
    public void selectFloor(Integer floor) {
        this.floorsSelected.add(floor);
    }

    /**
     * Retrieves the total number of floors.
     * @return The total number of floors.
     */
    public Integer getFloorCount() {
        return this.floorCount;
    }

    /**
     * Changes the floor selection strategy.
     * Analogous to changing the elevator direction.
     */
    private void swapDirection() {
        System.out.println("Swapping direction...");
        if (this.floorSelection instanceof UpStrategy) {
            this.floorSelection = new DownStrategy();
        }
        else {
            this.floorSelection = new UpStrategy();
        }
    }

    /**
     * Retrieves the next floor number and swaps direction if required.
     * @return The next floor to move the elevator to.
     */
    private Integer getNextFloor() {
        Integer nextFloor = this.floorSelection.nextFloor(
            this.floorsSelected,
            this.target.currentFloor
        );
        if (nextFloor == 0) {
            this.swapDirection();
            return getNextFloor();
        }
        return nextFloor;
    }

    private void executeCommands() {
        while(!Thread.currentThread().isInterrupted()) {
            if (this.floorsSelected.size() > 0) {
                Integer nextFloor = this.getNextFloor();
                this.target.moveToFloor(nextFloor);
                // TODO: Add mutex to prevent race condition
                this.floorsSelected.remove(nextFloor);
                System.out.println(this.floorsSelected);
            }

            try { TimeUnit.SECONDS.sleep(this.WAIT_TIME); }
            catch(Exception e) {}
        }
    }
}
