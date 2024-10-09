import java.util.Scanner;
import java.util.ArrayList;

public class rubik {

    static String[][] cube = new String[6][9];

    static ArrayList<String> solution = new ArrayList<String>();


    static void turn_cube(String[][] c, String move){
        switch (move) {
            case "U":
                solution.add("U'");
                //TODO
                break;
            case "U'":
                solution.add("U");
                //TODO
                break;
            case "D":
                solution.add("D'");
                //TODO
                break;
            case "D'":
                solution.add("D");
                //TODO
                break;
            case "R":
                solution.add("R'");
                break;
            case "R'":
                solution.add("R");
                break;
            case "L":
                solution.add("L'");
                break;
            case "L'":
                solution.add("L");
                break;
            case "F":
                solution.add("F'");
                break;
            case "F'":
                solution.add("F");
                break;
            case "B":
                solution.add("B'");
                break;
            case "B'":
                solution.add("B");
                break;
            default:
                solve();
                break;
        }
        //TODO
    }

    static void solve(){
        for(int i = solution.size()-1; i>=0; i--){
            System.out.print(solution.get(i) + ", ");
        }
    }

    static void printCube(String[][] c){
        for( int i = 0; i < c.length; i++){
            for( int j = 0; j < c[i].length; j++){
                if(j%3 == 0)System.out.println();

                System.out.print(" " + i);

            }
            System.out.println();
        }

    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        

        while(true){
            printCube(cube);
            System.out.println("\nPlease enter a move:");
            String move = scn.nextLine();
            move(cube, move);
        }
    }
}
