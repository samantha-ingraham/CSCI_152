import java.util.Scanner;

public class go {

    static String[][] goBoard = new String[10][10]; //builds the board as an empty 2d array
    public static void main(String[] args) throws Exception {

        String circsymre = "-o"; //declares my variables for placement thingies
        String starsymre="-*";
        String starsymle="*";
        String circsymle="o";
        boolean numba = false;
        int playanum = 0;


        System.out.println("  0 1 2 3 4 5 6 7 8 9"); // gives us an index for l-r
        for (int i = 0; i < goBoard.length; i++){
            System.out.print(i+" ");// gives us an index for t to be
            for (int j = 0; j < goBoard[i].length; j++){
                if(goBoard[i][j] == null){ // builds the lattice work
                    if(j == 0){
                        System.out.print("|");
                    }
                    else{
                        System.out.print("-|");
                    }
                }
                else{
                    System.out.print(goBoard[i][j]);
                }
            }
            System.out.println();
        }
        
        Scanner myObj = new Scanner(System.in);
        System.out.println("First person, Would you like to play * or o ?");
        var player_choice = myObj.nextLine();
        myObj.close();
        if (player_choice == "o") { playanum = 2;
        System.out.println("Great! You will go second.");} 
        else { playanum = 1;
        System.out.println("Great! You will go first.");}

    }
}


/*import java.util.Scanner;

public class App {

    static String[][] goBoard = new String[9][9];

    static void getBoard(String[][] b){
        System.out.println("  1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < b.length; i++){
            System.out.print((i+1) + " ");
            for (int j = 0; j < b[i].length; j++){
                if(b[i][j] == null){
                    if(j == 0){
                        System.out.print("|");
                    }
                    else{
                        System.out.print("-|");
                    }
                }
                else{
                    System.out.print(b[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);


        App app = new App();

        getBoard(goBoard);

        while(true){
            goBoard[1][1] = "-o";
            goBoard[2][2] = "-*";

            getBoard(goBoard);

            scn.nextLine();

        }

    }
}
 */
//luther example code.
/*public class Go {

    static String[][] goBoard = new String[9][9];

    public static void main(String[] args) {

        Boolean cont = true, turn = true;
        int moveX, moveY;

        Scanner scn = new Scanner(System.in);

        int dimension = goBoard.length - 1;

        while (cont) {

            System.out.println("  0 1 2 3 4 5 6 7 8");
            for (int i = 0; i < goBoard.length; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < goBoard[i].length; j++) {
                    if (goBoard[i][j] == null) {
                        if (j == 0)
                            System.out.print("|");
                        else
                            System.out.print("-|");

                    } else {
                        System.out.print(goBoard[i][j]);
                    }

                }
                System.out.println();
            }

            System.out.println("\n" + ((turn) ? "Black" : "White") + "'s turn to move!\n\n");

            System.out.println("Please enter the x coordinate where you'd like to place a "
                    + ((turn) ? "Black" : "White") + " piece");

            moveX = scn.nextInt();

            System.out.println("Please enter the y coordinate where you'd like to place a "
                    + ((turn) ? "Black" : "White") + " piece");

            moveY = scn.nextInt();

            if ((moveY > dimension || moveY < 0) || (moveX > dimension || moveX < 0)) {
                System.out.println(
                        "\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\nOut of Bounds!\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n");
                continue;
            } else {

                if (goBoard[moveY][moveX] == null) {
                    goBoard[moveY][moveX] = ((turn) ? "-●" : "-◯");
                } else {
                    System.out.println(
                            "\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\nThere is already a piece there!\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n");
                    continue;
                }

            }

            turn = !turn;
        }

    }

} */