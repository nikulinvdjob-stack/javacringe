import java.util.Arrays;
import java.util.stream.Stream;

public class HomeWork_31 {

    public static int configShoppingCartCap = 3;

    public enum CustomerNames {
        Kolya("Коля"),
        Petya("Петя"),
        Terentiy("Терентий");

        private final String customerName;

        CustomerNames(String customerName) {
            this.customerName = customerName;
        }

        public String getName() {
            return customerName;
        }
    };

    public enum ItemNames {
        banana("🍌Бананы"),
        chicken("🐔Курица"),
        cottonCheese("🥛Творог"),
        beer("🍺Пиво"),
        dumplings("🥟Пельмени"),
        laskaBlackMagic("🔮Ласка 'Магия Черного'");

        private final String itemName;

        ItemNames(String itemName) {
            this.itemName = itemName;
        }

        public String getName() {
            return itemName;
        }
    };

    static class Customer {

        String name = "";
        String[] shoppingCart = new String[configShoppingCartCap];
        private Object newItem;

        Customer(String name) {
            this.name = name;
            Arrays.fill(shoppingCart, "");
        }

        void addItem(String newItem) {
            for (var i = 0; i < configShoppingCartCap; i++) {
                if (shoppingCart[i].isEmpty()) {
                    shoppingCart[i] = newItem;
                    break;
                }
            }
        }

        void sortItems() {
            Arrays.sort(shoppingCart);
        }

        String getName() {
            return this.name;
        }

        String[] getShoppingCart() {
            return this.shoppingCart;
        }
    }

    static void main(String[] args) {

        Customer[] customers = new Customer[CustomerNames.values().length];

        for (CustomerNames c : CustomerNames.values()) {
            customers[c.ordinal()] = new Customer(c.getName());
        }

        customers[CustomerNames.Kolya.ordinal()].addItem(ItemNames.chicken.getName());
        customers[CustomerNames.Kolya.ordinal()].addItem(ItemNames.banana.getName());
        customers[CustomerNames.Kolya.ordinal()].addItem(ItemNames.cottonCheese.getName());
        customers[CustomerNames.Kolya.ordinal()].sortItems();

        customers[CustomerNames.Petya.ordinal()].addItem(ItemNames.cottonCheese.getName());
        customers[CustomerNames.Petya.ordinal()].addItem(ItemNames.chicken.getName());
        customers[CustomerNames.Petya.ordinal()].addItem(ItemNames.banana.getName());
        customers[CustomerNames.Petya.ordinal()].sortItems();

        customers[CustomerNames.Terentiy.ordinal()].addItem(ItemNames.beer.getName());
        customers[CustomerNames.Terentiy.ordinal()].addItem(ItemNames.dumplings.getName());
        customers[CustomerNames.Terentiy.ordinal()].addItem(ItemNames.laskaBlackMagic.getName());


        for (Customer c : customers) {
            System.out.println("🛒 " + c.getName() + ": " + Arrays.deepToString(c.getShoppingCart()));
        }
        //Задание 1.1
        boolean result = customers[CustomerNames.Kolya.ordinal()].getShoppingCart().length ==
                customers[CustomerNames.Petya.ordinal()].getShoppingCart().length;
        System.out.println( "Равны ли корзины Коли и Пети по количеству? Мм?: " +
                (result ? "✅ Да" : "❌ Нет"));

        result = customers[CustomerNames.Petya.ordinal()].getShoppingCart().length ==
                customers[CustomerNames.Terentiy.ordinal()].getShoppingCart().length;
        System.out.println( "Равны ли корзины Пети и Терентия по количеству? Мм?: " +
                (result ? "✅ Да" : "❌ Нет"));

        //Задание 1.2
        result = Arrays.deepEquals(
                customers[CustomerNames.Kolya.ordinal()].getShoppingCart(),
                customers[CustomerNames.Petya.ordinal()].getShoppingCart());
        System.out.println( "Равны ли корзины Коли и Пети по составу? Мм?: " +
                (result ? "✅ Да" : "❌ Нет"));

        result = Arrays.deepEquals(
                customers[CustomerNames.Petya.ordinal()].getShoppingCart(),
                customers[CustomerNames.Terentiy.ordinal()].getShoppingCart());
        System.out.println( "Равны ли корзины Пети и Терентия по составу? Мм?: " +
                (result ? "✅ Да" : "❌ Нет"));

        //Задание 1.3

        //объедениям три массива корзин с продуктами в один большой массив
        String[] allShoppingCarts = Stream.of(
                        customers[CustomerNames.Kolya.ordinal()].getShoppingCart(),
                        customers[CustomerNames.Petya.ordinal()].getShoppingCart(),
                        customers[CustomerNames.Terentiy.ordinal()].getShoppingCart()
                )
                .flatMap(Arrays::stream)
                .distinct()
                .toArray(String[]::new);

        int[] marketingResearch = new int[allShoppingCarts.length];

        String marketingResearchItemWithLongestName = allShoppingCarts[0];
        String marketingResearchItemWithShortestName = allShoppingCarts[0];
        double marketingResearchAvrItemName = 0;

        for (var i = 0; i < allShoppingCarts.length; i++) {
            if (allShoppingCarts[i].length() > marketingResearchItemWithLongestName.length()) {
                marketingResearchItemWithLongestName = allShoppingCarts[i];
            }

            if (allShoppingCarts[i].length() < marketingResearchItemWithShortestName.length()) {
                marketingResearchItemWithShortestName = allShoppingCarts[i];
            }

            marketingResearchAvrItemName += allShoppingCarts[i].length();
        }
        marketingResearchAvrItemName /= allShoppingCarts.length;

        System.out.println("Предметы принимавшие участие в маркетинговом исследовании: " +
                Arrays.deepToString(allShoppingCarts));
        System.out.println("Результат маркетингового исследования: Предмет с самым длинным названием 📏: " +
                marketingResearchItemWithLongestName);
        System.out.println("Результат маркетингового исследования: Предмет с самым коротким названием 📏: " +
                marketingResearchItemWithShortestName);
        System.out.println("Результат маркетингового исследования: Средняя длина названия 📏: " +
                marketingResearchAvrItemName);
    }
}