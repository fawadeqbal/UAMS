package view.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.forms.AddUser;

public class ManageUsers extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel addUserPanel;
    private JPanel manageUsersPanel;

    public ManageUsers() {
        setLayout(new BorderLayout());

        // Create the card layout and the card panel to hold the panels
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create the AddStudent and ViewStudents panels
        addUserPanel = new AddUser();
        manageUsersPanel = new ViewUsers();

        // Add the panels to the card panel with unique names
        cardPanel.add(addUserPanel, "AddUser");
        cardPanel.add(manageUsersPanel, "ViewUsers");

        // Add the card panel to the main panel
        add(cardPanel, BorderLayout.CENTER);

        // Create a navigation bar with buttons to switch between panels
        JPanel navBarPanel = new JPanel(new FlowLayout());
        JButton addUserButton = new JButton("Add User");
        JButton viewUsersButton = new JButton("View Users");
        navBarPanel.add(addUserButton);
        navBarPanel.add(viewUsersButton);
        add(navBarPanel, BorderLayout.NORTH);

        // Add action listeners to the navigation bar buttons
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "AddUser");
            }
        });

        viewUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "ViewUsers");
            }
        });
    }
}
