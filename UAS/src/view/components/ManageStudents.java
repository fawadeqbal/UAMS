package view.components;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.forms.AddStudent;
import static view.components.Component.createMenuButton;

public class ManageStudents extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel addStudentPanel;
    private JPanel viewStudentsPanel;

    public ManageStudents() {
        setLayout(new BorderLayout());

        // Create the card layout and the card panel to hold the panels
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create the AddStudent panel and add it to the card panel
        addStudentPanel = new AddStudent();
        cardPanel.add(addStudentPanel, "AddStudent");

        // Add the card panel to the main panel
        add(cardPanel, BorderLayout.CENTER);

        // Create a navigation bar with buttons to switch between panels
        JPanel navBarPanel = new JPanel();
        navBarPanel.setLayout(new BoxLayout(navBarPanel, BoxLayout.X_AXIS));

        JButton addStudentButton = createMenuButton("Add Student");
        JButton viewStudentsButton = createMenuButton("View Students");

        // Apply styles to the navigation bar
        navBarPanel.setBackground(new Color(173, 216, 230)); // Light blue background color
        navBarPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Margin and padding

        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create the AddStudent panel and add it to the cardPanel
                cardLayout.show(cardPanel, "AddStudent");
            }
        });

        viewStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create the ViewStudents panel and add it to the cardPanel
               
                    viewStudentsPanel = new ViewStudents();
                    cardPanel.add(viewStudentsPanel, "ViewStudents");
                
                cardLayout.show(cardPanel, "ViewStudents");
            }
        });

        // Add the buttons to the navigation bar panel in the desired order
        navBarPanel.add(addStudentButton);
        navBarPanel.add(Box.createHorizontalStrut(10)); // Add a gap of 10 pixels
        navBarPanel.add(viewStudentsButton);

        // Add the navigation bar panel to the main panel
        add(navBarPanel, BorderLayout.NORTH);
    }
}
