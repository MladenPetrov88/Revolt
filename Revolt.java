import java.util.Scanner;

public class Revolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int commands = Integer.parseInt(scanner.nextLine());

        int playerRow = -1;
        int playerCol = -1;

        String[][] matrix = new String[rows][];
        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.split("");
            if (line.contains("f")) {
                playerRow = i;
                playerCol = line.indexOf("f");
            }
        }


        while (commands > 0) {
            String command = scanner.nextLine();
            switch (command) {
                case "down":
                    matrix[playerRow][playerCol] = "-";
                    playerRow += 1;
                    if (!isValidIndex(playerRow, playerCol, matrix)) {
                        playerRow = 0;
                        matrix[playerRow][playerCol] = "f";
                        if (matrix[playerRow][playerCol].equals("T")) {
                            playerRow -=1;
                        }
                        else if (matrix[playerRow][playerCol].equals("B")) {
                            playerRow += 1;
                        } else {
                            matrix[playerRow][playerCol] = "f";
                        }
                    }
                    if (matrix[playerRow][playerCol].equals("T")) {
                        playerRow -=1;
                    }
                    if (matrix[playerRow][playerCol].equals("B")) {
                        playerRow += 1;
                    }
                    matrix[playerRow][playerCol] = "f";
                    break;
                case "up":
                    matrix[playerRow][playerCol] = "-";
                    playerRow -= 1;
                    if (!isValidIndex(playerRow, playerCol, matrix)) {
                        playerRow = matrix.length - 1;
                        if (matrix[playerRow][playerCol].equals("T")) {
                            playerRow += 1;
                        }

                        else if (matrix[playerRow][playerCol].equals("B")) {
                            playerRow -= 1;
                        } else {
                            matrix[playerRow][playerCol] = "f";
                        }
                    }

                    if (matrix[playerRow][playerCol].equals("T")) {
                        playerRow += 1;
                    }

                    if (matrix[playerRow][playerCol].equals("B")) {
                        playerRow -= 1;
                    }
                    matrix[playerRow][playerCol] = "f";
                    break;


                case "left":
                    matrix[playerRow][playerCol] = "-";
                    playerCol -= 1;
                    if (!isValidIndex(playerRow, playerCol, matrix)) {
                        playerCol = matrix[playerRow].length - 1;
                        if (matrix[playerRow][playerCol].equals("T")) {
                            playerCol -= 1;
                        }
                        else if (matrix[playerRow][playerCol].equals("B")) {
                            playerCol -= 1;
                        } else {
                            matrix[playerRow][playerCol] = "f";
                        }
                    }

                    if (matrix[playerRow][playerCol].equals("T")) {
                        playerCol += 1;
                    }

                    if (matrix[playerRow][playerCol].equals("B")) {
                        playerCol -= 1;
                        if (!isValidIndex(playerRow, playerCol, matrix)) {
                            playerCol = matrix[playerRow].length - 1;
                        }
                    }
                    matrix[playerRow][playerCol] = "f";
                    break;
                case "right":
                    matrix[playerRow][playerCol] = "-";
                    playerCol += 1;
                    if (!isValidIndex(playerRow, playerCol, matrix)) {
                        playerCol = 0;
                        if (matrix[playerRow][playerCol].equals("T")) {
                            playerCol += 1;
                        }

                       else if (matrix[playerRow][playerCol].equals("B")) {
                            playerCol += 1;
                        } else {
                            matrix[playerRow][playerCol] = "f";
                        }
                    }
                    if (matrix[playerRow][playerCol].equals("T")) {
                        playerCol -= 1;

                    }

                    if (matrix[playerRow][playerCol].equals("B")) {
                        playerCol += 1;
                    }
                    matrix[playerRow][playerCol] = "f";
                    break;
            }



            if (matrix[playerRow][playerCol].equals("F")) {
                matrix[playerRow][playerCol] = "f";
                System.out.println("Player won!");
                break;
            }
            commands--;
            if (commands <= 0) {
                System.out.println("Player lost!");
            }
        }



        printMatrix(matrix);

    }



    private static boolean isValidIndex(int row, int col, String[][] beach) {
        if (row >= 0 && row < beach.length) {
            if (col >= 0 && col < beach[row].length) {
                return true;
            }
        }
        return false;
    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }


}
