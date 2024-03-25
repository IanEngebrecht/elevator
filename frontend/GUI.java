package frontend;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

import logic.ElevatorController;
import types.FloorRequest;

public class GUI {
    public static void run(ElevatorController controller, Integer panelSize) {
        // Create new window
        JFrame frame = new JFrame("Internal Controls");

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
                // Create the button
                Integer floorNum = colIndex * buttonLayout.get(0) + rowIndex + 1;
                JButton button = new JButton(floorNum.toString());
                buttons.add(button);

                // Add the button to the window and register the event handler
                frame.add(button);
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        controller.requestFloor(
                            new FloorRequest(Integer.parseInt(e.getActionCommand()))
                        );
                    }
                });
            }
        }
        
        // Configure window and display
        frame.setSize(panelSize, panelSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
