package view;

import view.panels.UserSettings;
import view.panels.Home;
import view.panels.ViewAttendance;
import view.panels.ModifyAttendance;
import view.panels.DeleteAttendance;
import view.panels.AddAttendance;
import view.panels.Reports;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.UASController;
import model.UASFactory;
import model.dto.Response;
import view.components.charts.SemesterAttendanceReport;
import view.panels.LoginUI;

public class Dashboard extends JFrame {

    UASController controller = UASFactory.getUASControllerInstance();
    private JPanel headerPanel;
    private JPanel menuPanel;
    private JPanel contentPanel;

    public Dashboard() {
        if (!UASController.isUserLoggedIn()) {
            LoginUI loginScreen = new LoginUI();
            loginScreen.setVisible(true);
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

        JLabel titleLabel = new JLabel("Attendance Management System");
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

        JButton homeButton = createMenuButton("Dashboard");

        JButton viewAttendanceButton = createMenuButton("View Attendance");
        menuPanel.add(homeButton, gbc);
        gbc.gridy++;

        menuPanel.add(viewAttendanceButton, gbc);
        gbc.gridy++;
        if (UASController.objApplicationSession.getUser().getRole().equals("faculty")) {
            JButton addAttendanceButton = createMenuButton("Add Attendance");
            JButton deleteAttendanceButton = createMenuButton("Delete Attendance");
            JButton modifyAttendanceButton = createMenuButton("Modify Attendance");

            menuPanel.add(addAttendanceButton, gbc);
            gbc.gridy++;
            menuPanel.add(deleteAttendanceButton, gbc);
            gbc.gridy++;
            menuPanel.add(modifyAttendanceButton, gbc);
            gbc.gridy++;

        }
        JButton settingsButton = createMenuButton("User Settings");
        JButton reportsButton = createMenuButton("Reports");

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
                UASController.expireSession();
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
                if (buttonText.equals("Dashboard")) {
                    contentPanel.add(new SemesterAttendanceReport(), BorderLayout.CENTER);

                } else if (buttonText.equals("Add Attendance")) {

                    contentPanel.add(new AddAttendance());

                } else if (buttonText.equals("View Attendance")) {

                    contentPanel.add(new ViewAttendance());

                } else if (buttonText.equals("Delete Attendance")) {

                    contentPanel.add(new DeleteAttendance());

                } else if (buttonText.equals("Modify Attendance")) {

                    contentPanel.add(new ModifyAttendance());

                } else if (buttonText.equals("User Settings")) {

                    contentPanel.add(new UserSettings());

                } else if (buttonText.equals("Reports")) {

                    contentPanel.add(new Reports());

                }
                contentPanel.revalidate();
                contentPanel.repaint();
            }
        });
        return button;
    }

    private void createContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout()); // Set layout manager for the content panel
        contentPanel.add(new SemesterAttendanceReport(), BorderLayout.CENTER); // Add the chart to the center of the content panel

        // Add the contentPanel to the main frame
        add(contentPanel, BorderLayout.CENTER);
    }

}
