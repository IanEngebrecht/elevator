package logic.floor_selection;

import java.util.List;

/**
 * Interface that determines which floor to go to next.
 */
public interface FloorSelectionStrategy {
    /**
     * Determines which floor to go to next. Returns 0 if there are no more floors to go to.
     * @param targetFloors The list of floors that have been requested.
     * @param currentFloor The current floor of the elevator.
     * @return The next floor to travel to, or 0 if nothing more can be done going this direction.
     */
    public Integer nextFloor(List<Integer> targetFloors, Integer currentFloor);
}
