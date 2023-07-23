package view.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.forms.AddStudent;

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

        // Create the AddStudent and ViewStudents panels
        addStudentPanel = new AddStudent();
        viewStudentsPanel = new ViewStudents();

        // Add the panels to the card panel with unique names
        cardPanel.add(addStudentPanel, "AddStudent");
        cardPanel.add(viewStudentsPanel, "ViewStudents");

        // Add the card panel to the main panel
        add(cardPanel, BorderLayout.CENTER);

        // Create a navigation bar with buttons to switch between panels
        JPanel navBarPanel = new JPanel(new FlowLayout());
        JButton addStudentButton = new JButton("Add Student");
        JButton viewStudentsButton = new JButton("View Students");
        navBarPanel.add(addStudentButton);
        navBarPanel.add(viewStudentsButton);
        add(navBarPanel, BorderLayout.NORTH);

        // Add action listeners to the navigation bar buttons
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "AddStudent");
            }
        });

        viewStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "ViewStudents");
            }
        });
    }
}
