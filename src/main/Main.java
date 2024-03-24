package main;

import frontend.GUI;
import logic.Elevator;
import logic.ElevatorController;

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

        Elevator elevator = new Elevator();
        ElevatorController controller = new ElevatorController(elevator, floorCount);
        GUI.run(controller, PANEL_SIZE);
    }
}
