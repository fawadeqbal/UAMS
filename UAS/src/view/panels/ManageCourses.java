package view.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.forms.AddCourse;

public class ManageCourses extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel addCoursePanel;
    private JPanel viewCoursesPanel;

    public ManageCourses() {
        setLayout(new BorderLayout());

        // Create the card layout and the card panel to hold the panels
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create the AddStudent and ViewStudents panels
        addCoursePanel = new AddCourse();
        viewCoursesPanel = new Courses();

        // Add the panels to the card panel with unique names
        cardPanel.add(addCoursePanel, "AddCourse");
        cardPanel.add(viewCoursesPanel, "ViewCourses");

        // Add the card panel to the main panel
        add(cardPanel, BorderLayout.CENTER);

        // Create a navigation bar with buttons to switch between panels
        JPanel navBarPanel = new JPanel(new FlowLayout());
        JButton addCourseButton = new JButton("Add Course");
        JButton viewCoursesButton = new JButton("View Courses");
        navBarPanel.add(addCourseButton);
        navBarPanel.add(viewCoursesButton);
        add(navBarPanel, BorderLayout.NORTH);

        // Add action listeners to the navigation bar buttons
        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "AddCourse");
            }
        });

        viewCoursesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "ViewCourses");
            }
        });
    }
}
