import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    private JFrame frame;
    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JComboBox<String> operationsComboBox;
    private JButton calculateButton;
    private JTextField resultField;

    public CalculatorGUI() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2));

        firstNumberField = new JTextField();
        secondNumberField = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        String[] operations = {"Addition", "Subtraction", "Multiplication", "Division"};
        operationsComboBox = new JComboBox<>(operations);

        calculateButton = new JButton("Calculate");

        frame.add(new JLabel("First Number:"));
        frame.add(firstNumberField);
        frame.add(new JLabel("Second Number:"));
        frame.add(secondNumberField);
        frame.add(new JLabel("Operation:"));
        frame.add(operationsComboBox);
        frame.add(calculateButton);
        frame.add(new JLabel("Result:"));
        frame.add(resultField);

        frame.setSize(400, 300);
        frame.setVisible(true);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double firstNum = Double.parseDouble(firstNumberField.getText());
                    double secondNum = Double.parseDouble(secondNumberField.getText());
                    String operation = (String) operationsComboBox.getSelectedItem();

                    double result = 0;
                    switch (operation) {
                        case "Addition":
                            result = firstNum + secondNum;
                            break;
                        case "Subtraction":
                            result = firstNum - secondNum;
                            break;
                        case "Multiplication":
                            result = firstNum * secondNum;
                            break;
                        case "Division":
                            if (secondNum != 0) {
                                result = firstNum / secondNum;
                            } else {
                                resultField.setText("Cannot divide by 0");
                                return;
                            }
                            break;
                    }
                    resultField.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    resultField.setText("Invalid input");
                }
            }
        });
    }

    public static void main(String[] args) {
        // Run the calculator GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorGUI();
            }
        });
    }
}
