import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 450);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setResizable(false); 
        frame.setLayout(null);

        JLabel nameko = new JLabel("I AM RAPHAEL MATTHEW JOAQUIN");
        nameko.setFont(new Font("Arial", Font.BOLD, 12));
        nameko.setForeground(Color.WHITE);
        nameko.setBounds(10, 10, 200, 20);
        frame.add(nameko);

        JTextField display = new JTextField();
        display.setBounds(30, 30, 230, 40);
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.CYAN);
        frame.add(display);

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBounds(30, 80, 230, 200);
        panel.setBackground(Color.DARK_GRAY);

        Calculator calculator = new Calculator(display); // Create a Calculator instance
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(calculator);
            panel.add(button);
        }

        frame.add(panel);

        JButton deleteButton = new JButton("DELETE");
        JButton clearButton = new JButton("CLEAR");
        deleteButton.setBounds(30, 300, 100, 40);
        clearButton.setBounds(150, 300, 100, 40);

        deleteButton.addActionListener(e -> {
            calculator.clearCurrentInput();
        });

        clearButton.addActionListener(e -> {
            calculator.clearAll();
        });

        frame.add(deleteButton);
        frame.add(clearButton);

        frame.setVisible(true);
    }
}