import java.util.Scanner;

public class App {

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