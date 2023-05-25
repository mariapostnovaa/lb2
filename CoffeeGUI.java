package lb2;

import javax.swing.*;

public class CoffeeGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Калькулятор стоимости кофе");
        frame.setSize(400, 300);

        JPanel panel = new JPanel();

        JLabel quantityLabel = new JLabel("Введите количество чашек:");
        JTextField quantityField = new JTextField(10);

        JLabel sugarLabel = new JLabel("Есть ли сахар?");
        JCheckBox sugarBox = new JCheckBox();

        JLabel creamLabel = new JLabel("Есть ли сливки?");
        JCheckBox creamBox = new JCheckBox();

        JLabel coffeeTypeLabel = new JLabel("Выберите тип кофе:");
        String[] coffeeTypes = {"Эспрессо", "Латте", "Капучино"};
        JComboBox<String> coffeeTypeBox = new JComboBox<>(coffeeTypes);

        JButton calculateButton = new JButton("Рассчитать");
        JLabel resultLabel = new JLabel();

        panel.add(quantityLabel);
        panel.add(quantityField);
        panel.add(sugarLabel);
        panel.add(sugarBox);
        panel.add(creamLabel);
        panel.add(creamBox);
        panel.add(coffeeTypeLabel);
        panel.add(coffeeTypeBox);
        panel.add(calculateButton);
        panel.add(resultLabel);

        calculateButton.addActionListener(e -> {
            int quantity = Integer.parseInt(quantityField.getText());
            boolean hasSugar = sugarBox.isSelected();
            boolean hasCream = creamBox.isSelected();
            String coffeeType = (String) coffeeTypeBox.getSelectedItem();

            CoffeeCalculator calculator = new CoffeeCalculator(quantity,
                    hasSugar, hasCream, coffeeType);

            double cost = calculator.calculateCost();

            resultLabel.setText("Стоимость: " + cost);
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}