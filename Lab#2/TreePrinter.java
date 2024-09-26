public class TreePrinter {
    // Метод для виведення ялинки
    public void printTree(int levels) {
        for (int i = 1; i <= levels; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreePrinter treePrinter = new TreePrinter(); // Створюємо об'єкт класу TreePrinter
        
        // Задаємо кількість рівнів ялинки
        int levels = 6; // Ви можете змінити це значення на потрібне
        treePrinter.printTree(levels); // Викликаємо метод printTree
    }
} 