import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Calculator implements ActionListener {
    private JTextField display;
    private String currentInput = "";
    private String operator = "";
    private double num1 = 0;
    private double num2 = 0;
    private final int MAX_DIGITS = 10; // Set the maximum number of digits

    public Calculator(JTextField display) {
        this.display = display;
    }

    public void clearCurrentInput() {
        currentInput = "";
        display.setText(currentInput);
    }

    public void clearAll() {
        currentInput = "";
        operator = "";
        num1 = 0;
        num2 = 0;
        display.setText(currentInput);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Handle numeric and decimal buttons
        if (command.matches("[0-9.]")) {
            if (currentInput.length() < MAX_DIGITS) { // Check if input length is within limit
                currentInput += command;
                display.setText(currentInput);
            }
        }
        // Handle the operator buttons
        else if (command.matches("[+\\-*/]")) {
            if (!currentInput.isEmpty()) {
                num1 = Double.parseDouble(currentInput); // Store the first operand
                operator = command;  // Store the operator
                currentInput = "";   // Clear current input for the next operand
            }
        }
        // Handle equals button
        else if (command.equals("=")) {
            if (!currentInput.isEmpty()) {
                num2 = Double.parseDouble(currentInput); // Store the second operand

                // Perform the calculation based on the operator
                double result = 0;
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            result = Double.NaN; // If division by zero, return NaN
                        }
                        break;
                }

                currentInput = String.valueOf(result);  // Set the result as the new input
                display.setText(currentInput);
                num1 = result; // Store the result as the first operand for future calculations
            }
        }
    }
}

