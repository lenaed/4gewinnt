import java.util.Scanner;

public class VierGewinnt {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Gameboard gameboard = new Gameboard();

        System.out.println(gameboard);

        while (true) {

            Integer choice = null;

            while (choice == null) {
                System.out.println("Please place a piece (0 -6)");
                String line = scan.nextLine();
                try {
                    choice = Integer.parseInt(line);
                    if (choice < 0 || choice > 6) {
                        choice = null;
                    } else if (gameboard.columnIsFull(choice)) {
                        System.out.println("the column is already full. please try again");
                        choice = null;
                    }
                } catch (Exception e) {
                    System.out.println("invalid input. please try again");
                }
            }

            gameboard.placePiece(choice);
            System.out.println(gameboard);
            Status status = gameboard.checkStatus();
            System.out.println(status);
            if(!status.getGoOn() ){
                break;
            }
        }
    }
}

