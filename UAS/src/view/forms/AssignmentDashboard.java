package view.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static view.components.Component.createMenuButton;

public class AssignmentDashboard extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel assignCoursePanel;
    private JPanel viewAssignedCourses;
    private JPanel assignCourseTeacherPanel;

    public AssignmentDashboard() {
        setLayout(new BorderLayout());

        // Create the card layout and the card panel to hold the panels
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create the AssignCourse and ViewCourses panels
        assignCoursePanel = new AssignCourseTeacher();
        viewAssignedCourses = new ViewAssignedCoursesToTeacher();
        assignCourseTeacherPanel=new AssignTeacherClass();

        // Add the panels to the card panel with unique names
        cardPanel.add(assignCoursePanel, "AssignCourse");
        cardPanel.add(viewAssignedCourses, "ViewAssignedCourses");
        cardPanel.add(assignCourseTeacherPanel, "AssignCourseTeacher");

        // Add the card panel to the main panel
        add(cardPanel, BorderLayout.CENTER);

        // Create a navigation bar with buttons to switch between panels
        JPanel navBarPanel = new JPanel();
        navBarPanel.setLayout(new BoxLayout(navBarPanel, BoxLayout.X_AXIS));

        JButton assignCourseButton = createMenuButton("Assign Course");
        JButton viewCoursesButton = createMenuButton("Assigned Courses to Teacher");
        JButton assignClassTeacherButton = createMenuButton("Assign Class to Teacher");

        // Apply styles to the navigation bar
        navBarPanel.setBackground(new Color(173, 216, 230)); // Light blue background color
        navBarPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Margin and padding

        assignCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "AssignCourse");
            }
        });

        viewCoursesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "ViewAssignedCourses");
            }
        });
        assignClassTeacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "AssignCourseTeacher");
            }
        });

        // Add a gap of 10 pixels between the buttons
        navBarPanel.add(assignCourseButton);
        navBarPanel.add(Box.createHorizontalStrut(10)); // Add a gap of 10 pixels
        navBarPanel.add(viewCoursesButton);
        navBarPanel.add(Box.createHorizontalStrut(10)); // Add a gap of 10 pixels
        navBarPanel.add(assignClassTeacherButton);
        

        // Add the navigation bar panel to the main panel
        add(navBarPanel, BorderLayout.NORTH);
    }
}
