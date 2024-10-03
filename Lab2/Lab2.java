public class Lab2 {
    
    public static void printTree(int levels) {
        for (int i = 1; i <= levels; i++) {
            for (int j = 1; j <= levels - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void createAndPrintArray(int rows, int cols) {
        int[][] array = new int[rows][cols];
        int value = 1; 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = value;
                value += 3; 
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printTree(3);
        createAndPrintArray(3, 4);
    }

}