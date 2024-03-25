package main;

import frontend.GUI;
import frontend.ExternalControls;
import logic.ElevatorController;
import types.Elevator;

/**
 * Main application.
 */
public class Main {
    static Integer DEFAULT_FLOOR_COUNT = 9;
    static Integer PANEL_SIZE = 500;

    /**
     * Application entrypoint.
     * @param args Application arguments.
     */
    public static void main(String[] args)
    {
        Integer floorCount = DEFAULT_FLOOR_COUNT;

        // Override floor count if provided
        if (args.length > 0) {
            floorCount = Integer.parseInt(args[0]);
            System.out.println(floorCount);
        }

        Elevator elevator = new Elevator(floorCount);
        ElevatorController controller = new ElevatorController(elevator);
        GUI.run(controller, PANEL_SIZE);
        ExternalControls.run(controller, PANEL_SIZE);
    }
}
