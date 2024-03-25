package logic.floor_selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import types.FloorRequest;

/**
 * Floor selection strategy when the elevator is going DOWN.
 */
public class DownStrategy implements FloorSelectionStrategy {
    /**
     * Determines which floor to go to next. Returns 0 if there are no more floors to go to.
     * @param targetFloors The list of floors that have been requested.
     * @param currentFloor The current floor of the elevator.
     * @return The next floor to travel to, or 0 if nothing more can be done going this direction.
     */
    public FloorRequest nextFloor(List<FloorRequest> targetFloors, Integer currentFloor) {
        List<FloorRequest> copy = new ArrayList<FloorRequest>(targetFloors);
        Collections.sort(copy);
        Collections.reverse(copy);
        System.out.println(copy);
        copy.removeIf(x -> x.targetFloor >= currentFloor);
        System.out.println(copy);
        return copy.size() > 0 ? copy.get(0) : null;
    }
}
