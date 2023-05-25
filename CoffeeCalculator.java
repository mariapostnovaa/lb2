package lb2;

public class CoffeeCalculator {
    private static final double BASE_PRICE = 150;
    private int quantity;
    private boolean hasSugar;
    private boolean hasCream;
    private String coffeeType;

    public CoffeeCalculator(int quantity, boolean hasSugar,
                            boolean hasCream, String coffeeType) {
        this.quantity = quantity;
        this.hasSugar = hasSugar;
        this.hasCream = hasCream;
        this.coffeeType = coffeeType;
    }

    public double calculateCost() {
        // базовая цена за одну чашку кофе
        double cost = BASE_PRICE;

        // добавление стоимости сахара и сливок
        if (hasSugar) {
            cost += 5;
        }
        if (hasCream) {
            cost += 10;
        }

        // добавление стоимости в зависимости от типа кофе
        switch (coffeeType) {
            case "Эспрессо":
                cost += 20.0;
                break;
            case "Латте":
                cost += 30.0;
                break;
            case "Капучино":
                cost += 35.0;
                break;
            default:
                System.out.println("Неизвестный тип кофе: " + coffeeType);
                break;
        }

        // общая стоимость за количество чашек кофе
        return cost * quantity;
    }
}

