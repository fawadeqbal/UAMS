package view.components;
import view.forms.AddTeacher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static view.components.Component.createMenuButton;

public class ManageTeachers extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel addTeacherPanel;
    private JPanel manageTeachersPanel;

    public ManageTeachers() {
        setLayout(new BorderLayout());

        // Create the card layout and the card panel to hold the panels
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create the AddTeacher panel and add it to the card panel
        addTeacherPanel = new AddTeacher();
        cardPanel.add(addTeacherPanel, "AddTeacher");

        // Add the card panel to the main panel
        add(cardPanel, BorderLayout.CENTER);

        // Create a navigation bar with buttons to switch between panels
        JPanel navBarPanel = new JPanel();
        navBarPanel.setLayout(new BoxLayout(navBarPanel, BoxLayout.X_AXIS));

        JButton addTeacherButton = createMenuButton("Add Teacher");
        JButton viewTeachersButton = createMenuButton("View Teachers");

        // Apply styles to the navigation bar
        navBarPanel.setBackground(new Color(173, 216, 230)); // Light blue background color
        navBarPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Margin and padding

        addTeacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create the AddTeacher panel and add it to the cardPanel
                cardLayout.show(cardPanel, "AddTeacher");
            }
        });

        viewTeachersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create the ViewTeachers panel and add it to the cardPanel
                
                    manageTeachersPanel = new ViewTeachers();
                    cardPanel.add(manageTeachersPanel, "ViewTeachers");
                
                cardLayout.show(cardPanel, "ViewTeachers");
            }
        });

        // Add the buttons to the navigation bar panel in the desired order
        navBarPanel.add(addTeacherButton);
        navBarPanel.add(Box.createHorizontalStrut(10)); // Add a gap of 10 pixels
        navBarPanel.add(viewTeachersButton);

        // Add the navigation bar panel to the main panel
        add(navBarPanel, BorderLayout.NORTH);
    }
}
