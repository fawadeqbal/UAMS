package ui;

import ui.panels.UserSettings;
import ui.panels.Home;
import ui.panels.ViewAttendance;
import ui.panels.ModifyAttendance;
import ui.panels.DeleteAttendance;
import ui.panels.AddAttendance;
import ui.panels.Reports;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.UASController;
import ui.panels.LoginUI;

public class Dashboard extends JFrame {

    private JPanel headerPanel;
    private JPanel menuPanel;
    private JPanel contentPanel;

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }

    public Dashboard() {
        if (!UASController.isUserLoggedIn()) {
            LoginUI loginScreen = new LoginUI();
            loginScreen.setVisible(true);
            this.setVisible(false);
            this.dispose();
        } else {

            setTitle("Attendance Management System - Dashboard");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setLayout(new BorderLayout());

            // Header Panel
            createHeaderPanel();

            // Menu Panel
            createMenuPanel();

            // Content Panel
            createContentPanel();

            pack();
            setLocationRelativeTo(null);
        }
    }

    private void createHeaderPanel() {
        headerPanel = new JPanel();
        headerPanel.setBackground(new Color(41, 128, 185));
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setPreferredSize(new Dimension(800, 75));
        add(headerPanel, BorderLayout.NORTH);

        JLabel titleLabel = new JLabel("Attendance Management System" + "          " + UASController.objApplicationSession.UserName);
        titleLabel.setForeground(new Color(250, 250, 250));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        headerPanel.add(titleLabel, BorderLayout.CENTER);
    }

    private void createMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setBackground(new Color(52, 152, 219));
        menuPanel.setPreferredSize(new Dimension(220, 600));
        menuPanel.setLayout(new GridBagLayout());
        add(menuPanel, BorderLayout.WEST);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton homeButton = createMenuButton("Home");
        JButton addAttendanceButton = createMenuButton("Add Attendance");
        JButton viewAttendanceButton = createMenuButton("View Attendance");
        JButton deleteAttendanceButton = createMenuButton("Delete Attendance");
        JButton modifyAttendanceButton = createMenuButton("Modify Attendance");
        JButton settingsButton = createMenuButton("User Settings");
        JButton reportsButton = createMenuButton("Reports");

        menuPanel.add(homeButton, gbc);
        gbc.gridy++;
        menuPanel.add(addAttendanceButton, gbc);
        gbc.gridy++;
        menuPanel.add(viewAttendanceButton, gbc);
        gbc.gridy++;
        menuPanel.add(deleteAttendanceButton, gbc);
        gbc.gridy++;
        menuPanel.add(modifyAttendanceButton, gbc);
        gbc.gridy++;
        menuPanel.add(reportsButton, gbc);
        gbc.gridy++;
        menuPanel.add(settingsButton, gbc);
        gbc.gridy++;
        gbc.gridy++;
        JButton logoutButton = new JButton("Logout");
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(new Color(41, 128, 185));
        logoutButton.setFocusPainted(false);
        logoutButton.setFont(new Font("Arial", Font.BOLD, 12));
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutButton.putClientProperty("JButton.buttonType", "roundRect"); // Use roundRect button type
        logoutButton.putClientProperty("JButton.selectedBackground", new Color(52, 152, 219));

        // Add ActionListener to handle logout functionality
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginUI().setVisible(true);
            }
        });

        menuPanel.add(logoutButton, gbc);
    }

    private JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 35));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(41, 128, 185));
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.putClientProperty("JButton.buttonType", "roundRect"); // Use roundRect button type
        button.putClientProperty("JButton.selectedBackground", new Color(52, 152, 219));

        // Hover Effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {

        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click event or navigate to the corresponding page
                String buttonText = button.getText();

                contentPanel.removeAll();
                if (buttonText.equals("Home")) {
                    if (UASController.isSessionExpired()) {
                        dispose();
                        LoginUI loginScreen = new LoginUI();
                        loginScreen.setVisible(true);

                    } else {
                        Home homePanel = new Home();
                        contentPanel.add(homePanel);
                    }
                } else if (buttonText.equals("Add Attendance")) {
                    if (UASController.isSessionExpired()) {
                        dispose();
                        LoginUI loginScreen = new LoginUI();
                        loginScreen.setVisible(true);

                    } else {
                        contentPanel.add(new AddAttendance());
                    }
                    

                } else if (buttonText.equals("View Attendance")) {
                    if (UASController.isSessionExpired()) {
                        dispose();
                        LoginUI loginScreen = new LoginUI();
                        loginScreen.setVisible(true);

                    } else {
                        contentPanel.add(new ViewAttendance());
                    }
                    

                } else if (buttonText.equals("Delete Attendance")) {
                    if (UASController.isSessionExpired()) {
                        dispose();
                        LoginUI loginScreen = new LoginUI();
                        loginScreen.setVisible(true);

                    } else {
                        contentPanel.add(new DeleteAttendance());
                    }

                } else if (buttonText.equals("Modify Attendance")) {
                    if (UASController.isSessionExpired()) {
                        dispose();
                        LoginUI loginScreen = new LoginUI();
                        loginScreen.setVisible(true);

                    } else {
                        contentPanel.add(new ModifyAttendance());
                    }

                } else if (buttonText.equals("User Settings")) {
                    if (UASController.isSessionExpired()) {
                        dispose();
                        LoginUI loginScreen = new LoginUI();
                        loginScreen.setVisible(true);

                    } else {
                        contentPanel.add(new UserSettings());
                    }
                    

                } else if (buttonText.equals("Reports")) {
                    if (UASController.isSessionExpired()) {
                        dispose();
                        LoginUI loginScreen = new LoginUI();
                        loginScreen.setVisible(true);

                    } else {
                        contentPanel.add(new Reports());
                    }
                    

                }
                contentPanel.revalidate();
                contentPanel.repaint();
            }
        });
        return button;
    }

    private void createContentPanel() {
        contentPanel = new JPanel();

        contentPanel.setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);

        JLabel welcomeLabel = new JLabel("Welcome to the Dashboard!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(new Color(41, 128, 185));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(welcomeLabel, BorderLayout.CENTER);
    }
}
