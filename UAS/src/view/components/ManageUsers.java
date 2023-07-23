package view.components;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.components.Component.createMenuButton;
import view.forms.AddUser;

public class ManageUsers extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public ManageUsers() {
        setLayout(new BorderLayout());

        // Create the card layout and the card panel to hold the panels
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        add(cardPanel, BorderLayout.CENTER);

        // Create a navigation bar with buttons to switch between panels
        JPanel navBarPanel = new JPanel();
        navBarPanel.setLayout(new BoxLayout(navBarPanel, BoxLayout.X_AXIS));
        navBarPanel.setBackground(new Color(173, 216, 230)); // Light blue background color
        navBarPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Margin and padding

        JButton addUserButton = createMenuButton("Add User");
        JButton viewUsersButton = createMenuButton("View Users");
        AddUser addUserPanel = new AddUser();
        cardPanel.add(addUserPanel, "AddUser");

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create the AddUser panel and add it to the cardPanel
                cardLayout.show(cardPanel, "AddUser");
            }
        });

        viewUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create the ViewUsers panel and add it to the cardPanel
                ViewUsers viewUsersPanel = new ViewUsers();
                cardPanel.add(viewUsersPanel, "ViewUsers");
                cardLayout.show(cardPanel, "ViewUsers");
            }
        });

        // Add the buttons to the navigation bar panel in the desired order
        navBarPanel.add(addUserButton);
        navBarPanel.add(Box.createHorizontalStrut(10)); // Add a gap of 10 pixels
        navBarPanel.add(viewUsersButton);

        // Add the navigation bar panel to the main panel
        add(navBarPanel, BorderLayout.NORTH);
    }
}
