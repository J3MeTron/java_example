package Apps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApplication extends JFrame {
    public MainApplication() {
        setTitle("Главное приложение");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton textEditorButton = new JButton("Текстовый редактор");
        JButton calculatorButton = new JButton("Калькулятор");
        JButton functionPlotterButton = new JButton("Отрисовщик функций");

        textEditorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openTextEditor();
            }
        });

        calculatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCalculator();
            }
        });

        functionPlotterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFunctionPlotter();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.add(textEditorButton);
        panel.add(calculatorButton);
        panel.add(functionPlotterButton);

        add(panel, BorderLayout.CENTER);
    }

    private void openTextEditor() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TextEditor textEditor = new TextEditor();
                textEditor.setVisible(true);
            }
        });
    }

    private void openCalculator() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Calculator calculator = new Calculator();
                calculator.setVisible(true);
            }
        });
    }

    private void openFunctionPlotter() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FunctionPlotter functionPlotter = new FunctionPlotter();
                functionPlotter.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainApplication().setVisible(true);
            }
        });

        // Продолжайте выполнение консольного кода
        System.out.println("Продолжение работы консольного кода...");
    }
}
