/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.components;

/**
 *
 * @author fawad
 */
import javax.swing.*;
import java.awt.*;

public class Home extends JPanel {

    public Home() {
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to the Home Page!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(new Color(16, 172, 132));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.CENTER);
    }
}

