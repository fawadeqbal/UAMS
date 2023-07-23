/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panels;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * @author fawad
 */
public class Component {
    public static JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        int buttonRadius = 15;
        int buttonPadding = 8;
        int fontSize = 14;
        Border buttonBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(buttonPadding, buttonPadding, buttonPadding, buttonPadding),
                BorderFactory.createLineBorder(Color.white, 1) // 1-pixel white border
        );

        button.setBackground(new Color(41, 128, 185)); // Button background color
        button.setOpaque(true); // Ensure the background color is shown
        button.setBorderPainted(false); // Remove the default button border
        button.setFocusPainted(false); // Remove the focus border
        button.setBorder(buttonBorder); // Add padding and 1-pixel border
        button.setFont(new Font("Arial", Font.BOLD, fontSize)); // Set the font size
        button.setForeground(Color.WHITE); // Set the text color to white
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.putClientProperty("JButton.buttonType", "roundRect"); // Use roundRect button type

        // Hover Effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(52, 152, 219)); // Hover background color
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(41, 128, 185)); // Normal background color
            }
        });

        return button;
    }
}
