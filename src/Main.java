import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = null;
        String product = null;
        ArrayList<String> products = new ArrayList<>();

        System.out.println("""
                Список операций:\s
                1. Добавить в список
                2. Покакзать список
                3. Удалить из списка
                """);
        while (true) {
            System.out.print("Выберите операцию: ");

            input = scanner.nextLine();
            if (input.equals("end"))
                break;
            switch (Integer.parseInt(input)) {
                case 1 -> {
                    System.out.println("Какую покупку хотите добавить?");
                    product = scanner.nextLine();
                    products.add(product);
                    System.out.println("Итого в списке покупок: " + products.size());
                }
                case 2 -> {
                    System.out.println("Список покупок:");
                    showProduct(products);
                }
                case 3 -> {
                    showProduct(products);
                    System.out.println("Какую хотите удалить? Введите номер или название");
                    int index;
                    product = scanner.nextLine();
                    if (isNumeric(product)) {
                        index = Integer.parseInt(product);
                        if (products.size() >= index && index > 0) {
                            products.remove(index - 1);
                            System.out.println("Покупка " + product + " удалена, список продуктов: ");
                        } else {
                            System.out.println("Такого продукта нет в списке, список продуктов: ");
                        }
                    } else {
                        if (products.contains(product)) {
                            index = products.indexOf(product);
                            products.remove(index);
                            System.out.println("Покупка " + product + " удалена, список продуктов: ");
                        } else {
                            System.out.println("Такого продукта нет в списке, список продуктов: ");
                        }
                    }
                    showProduct(products);
                }
                case 4 -> {
                    System.out.println("Введите текст для поиска: ");
                    String queryLower = scanner.nextLine().toLowerCase();
                    String itemLower = null;
                    System.out.println("Найдено: \n");
                    for (int i = 0; i < products.size(); i++) {
                        itemLower = products.get(i);
                        itemLower = itemLower.toLowerCase();
                        if (itemLower.contains(queryLower)) {
                            System.out.println((i + 1) + ". " + products.get(i));
                        }
                    }
                }
                default -> System.out.println("Такой операции нет! Попробуйте ещё раз.");
            }
        }
    }

    public static void showProduct(ArrayList<String> products) {
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}