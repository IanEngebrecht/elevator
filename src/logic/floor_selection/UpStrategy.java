package logic.floor_selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Floor selection strategy when the elevator is going UP.
 */
public class UpStrategy implements FloorSelectionStrategy {
    /**
     * Determines which floor to go to next. Returns 0 if there are no more floors to go to.
     * @param targetFloors The list of floors that have been requested.
     * @param currentFloor The current floor of the elevator.
     * @return The next floor to travel to, or 0 if nothing more can be done going this direction.
     */
    public Integer nextFloor(List<Integer> targetFloors, Integer currentFloor) {
        List<Integer> copy = new ArrayList<Integer>(targetFloors);
        Collections.sort(copy);
        copy.removeIf(x -> x <= currentFloor);
        return copy.size() > 0 ? copy.get(0) : 0;
    }
}
