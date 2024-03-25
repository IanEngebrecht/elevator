package frontend;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

import logic.ElevatorController;
import types.Direction;
import types.FloorRequest;

public class ExternalControls {
    public static void run(ElevatorController controller, Integer panelSize) {
        // Create new window
        JFrame frame = new JFrame("External Controls");

        // Determine floor button layout
        List<Integer> buttonLayout = ButtonLayout.getLayout(controller.getFloorCount());
        GridLayout layout = new GridLayout(buttonLayout.size(), buttonLayout.get(0));
        frame.setLayout(layout);

        // Add floor selector buttons
        List<JButton> buttons = new ArrayList<JButton>();
        for(Integer colIndex = 0; colIndex < buttonLayout.size(); colIndex++)
        {
            for(Integer rowIndex = 0; rowIndex < buttonLayout.get(colIndex); rowIndex++)
            {
                Integer floorNum = colIndex * buttonLayout.get(0) + rowIndex + 1;

                // Create the UP button
                JButton button1 = new JButton(floorNum.toString() + " UP");
                buttons.add(button1);

                // Create the DOWN button
                JButton button2 = new JButton(floorNum.toString() + " DOWN");
                buttons.add(button2);

                // Add the button to the window and register the event handler
                button1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        controller.requestFloor(
                            new FloorRequest(Integer.parseInt(e.getActionCommand().replace(" UP", "")), Direction.UP)
                        );
                    }
                });
                button2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        controller.requestFloor(
                            new FloorRequest(Integer.parseInt(e.getActionCommand().replace(" DOWN", "")), Direction.DOWN)
                        );
                    }
                });
                frame.add(button1);
                frame.add(button2);
            }
        }
        
        // Configure window and display
        frame.setSize(panelSize, panelSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
