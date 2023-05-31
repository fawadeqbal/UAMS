/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author fawad
 */
public class UserSettings extends JPanel{
    public UserSettings() {
        setLayout(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome to the User Settings!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 25));
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.CENTER);
    }
    
}