package view.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.forms.AddUser;

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

        // Create the AddStudent and ViewStudents panels
        addTeacherPanel = new AddTeacher();
        manageTeachersPanel = new ViewTeachers();

        // Add the panels to the card panel with unique names
        cardPanel.add(addTeacherPanel, "AddTeacher");
        cardPanel.add(manageTeachersPanel, "ViewTeachers");

        // Add the card panel to the main panel
        add(cardPanel, BorderLayout.CENTER);

        // Create a navigation bar with buttons to switch between panels
        JPanel navBarPanel = new JPanel(new FlowLayout());
        JButton addTeacherButton = new JButton("Add Teacher");
        JButton viewTeachersButton = new JButton("View Teachers");
        navBarPanel.add(addTeacherButton);
        navBarPanel.add(viewTeachersButton);
        add(navBarPanel, BorderLayout.NORTH);

        // Add action listeners to the navigation bar buttons
        addTeacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "AddTeacher");
            }
        });

        viewTeachersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "ViewTeachers");
            }
        });
    }
}
