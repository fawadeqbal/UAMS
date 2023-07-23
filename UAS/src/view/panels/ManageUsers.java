package view.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.forms.AddUser;
import static view.panels.Component.createMenuButton;

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

        // Create the AddUser and ViewUsers panels
        addUserPanel = new AddUser();
        manageUsersPanel = new ViewUsers();

        // Add the panels to the card panel with unique names
        cardPanel.add(addUserPanel, "AddUser");
        cardPanel.add(manageUsersPanel, "ViewUsers");

        // Add the card panel to the main panel
        add(cardPanel, BorderLayout.CENTER);

        // Create a navigation bar with buttons to switch between panels
        JPanel navBarPanel = new JPanel();
        navBarPanel.setLayout(new BoxLayout(navBarPanel, BoxLayout.X_AXIS));

        JButton addUserButton = createMenuButton("Add User");
        JButton viewUsersButton = createMenuButton("View Users");

        // Apply styles to the navigation bar
        navBarPanel.setBackground(new Color(173, 216, 230)); // Light blue background color
        navBarPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Margin and padding

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

        // Add the buttons to the navigation bar panel in
        // Add the buttons to the navigation bar panel in the desired order
        navBarPanel.add(addUserButton);
        navBarPanel.add(Box.createHorizontalStrut(10)); // Add a gap of 10 pixels
        navBarPanel.add(viewUsersButton);

        // Add the navigation bar panel to the main panel
        add(navBarPanel, BorderLayout.NORTH);
    }

    
}
