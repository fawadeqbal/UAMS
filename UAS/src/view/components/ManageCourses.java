package view.components;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.forms.AddCourse;
import static view.components.Component.createMenuButton;

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

        // Create the AddCourse panel and add it to the card panel
        addCoursePanel = new AddCourse();
        cardPanel.add(addCoursePanel, "AddCourse");

        // Add the card panel to the main panel
        add(cardPanel, BorderLayout.CENTER);

        // Create a navigation bar with buttons to switch between panels
        JPanel navBarPanel = new JPanel();
        navBarPanel.setLayout(new BoxLayout(navBarPanel, BoxLayout.X_AXIS));

        JButton addCourseButton = createMenuButton("Add Course");
        JButton viewCoursesButton = createMenuButton("View Courses");

        // Apply styles to the navigation bar
        navBarPanel.setBackground(new Color(173, 216, 230)); // Light blue background color
        navBarPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Margin and padding

        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "AddCourse");
            }
        });

        viewCoursesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create the ViewCourses panel and add it to the cardPanel
               
                    viewCoursesPanel = new Courses();
                    cardPanel.add(viewCoursesPanel, "ViewCourses");
               
                cardLayout.show(cardPanel, "ViewCourses");
            }
        });

        // Add a gap of 10 pixels between the buttons
        navBarPanel.add(addCourseButton);
        navBarPanel.add(Box.createHorizontalStrut(10)); // Add a gap of 10 pixels
        navBarPanel.add(viewCoursesButton);

        // Add the navigation bar panel to the main panel
        add(navBarPanel, BorderLayout.NORTH);
    }
}
