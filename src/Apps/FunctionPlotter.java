package Apps;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;

public class FunctionPlotter extends JFrame {
    private JComboBox<String> functionSelector;
    private JPanel graphPanel;
    private double[] xValues;
    private double[] yValues;

    public FunctionPlotter() {
        setTitle("Графики функций");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        functionSelector = new JComboBox<>(new String[]{"sin", "cos", "tan", "cot"});
        JButton plotButton = new JButton("Построить график");
        plotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plotFunction();
            }
        });

        graphPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGraph(g);
            }
        };
        graphPanel.setPreferredSize(new Dimension(600, 400));

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Выберите функцию:"));
        controlPanel.add(functionSelector);
        controlPanel.add(plotButton);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(controlPanel, BorderLayout.NORTH);
        contentPane.add(graphPanel, BorderLayout.CENTER);
    }

    private void plotFunction() {
        String selectedFunction = (String) functionSelector.getSelectedItem();
        double minX = -2 * Math.PI;
        double maxX = 2 * Math.PI;
        int numPoints = 800;
        xValues = new double[numPoints];
        yValues = new double[numPoints];

        for (int i = 0; i < numPoints; i++) {
            xValues[i] = minX + (maxX - minX) * i / (numPoints - 1);
            if ("sin".equals(selectedFunction)) {
                yValues[i] = Math.sin(xValues[i]);
            } else if ("cos".equals(selectedFunction)) {
                yValues[i] = Math.cos(xValues[i]);
            } else if ("tan".equals(selectedFunction)) {
                yValues[i] = Math.tan(xValues[i]);
            } else if ("cot".equals(selectedFunction)) {
                yValues[i] = 1.0 / Math.tan(xValues[i]);
            }
        }

        graphPanel.repaint();
    }

    private void drawGraph(Graphics g) {
        if (xValues == null || yValues == null) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, graphPanel.getWidth(), graphPanel.getHeight());

        double minX = -2 * Math.PI;
        double maxX = 2 * Math.PI;
        double minY = -2;
        double maxY = 2;

        int panelWidth = graphPanel.getWidth();
        int panelHeight = graphPanel.getHeight();

        int xOffset = 40;
        int yOffset = 40;
        int graphWidth = panelWidth - 2 * xOffset;
        int graphHeight = panelHeight - 2 * yOffset;

        double xScale = graphWidth / (maxX - minX);
        double yScale = graphHeight / (maxY - minY);

        Path2D path = new Path2D.Double();
        boolean firstPoint = true;

        // Draw X and Y axes
        g2d.setColor(Color.BLACK);
        g2d.drawLine(xOffset, yOffset + graphHeight, xOffset + graphWidth, yOffset + graphHeight); // X-axis
        g2d.drawLine(xOffset, yOffset, xOffset, yOffset + graphHeight); // Y-axis

        // Label X and Y axes
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        g2d.drawString("-2π", xOffset, yOffset + graphHeight + 15);
        g2d.drawString("2π", xOffset + graphWidth - 20, yOffset + graphHeight + 15);
        g2d.drawString("-2", xOffset - 20, yOffset + graphHeight - 10);
        g2d.drawString("2", xOffset - 20, yOffset + 12);

        for (int i = 0; i < xValues.length; i++) {
            double x = xOffset + (xValues[i] - minX) * xScale;
            double y = panelHeight - (yOffset + (yValues[i] - minY) * yScale);

            if (firstPoint) {
                path.moveTo(x, y);
                firstPoint = false;
            } else {
                path.lineTo(x, y);
            }
        }

        g2d.setColor(Color.BLUE);
        g2d.draw(path);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FunctionPlotter().setVisible(true);
            }
        });
    }
}
