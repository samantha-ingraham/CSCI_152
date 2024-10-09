import java.util.Random;

public class rubiks {
    public static String random(){
        
        Random rand = new Random();
        
        String[] moves={"U","U'","D","D'","L","L'","R","R'","F","F'","B","B'"};
        
        String select= moves[rand.nextInt(12)];
        
        switch (select) {
            case "U":
                return "U"; 
            case "U'":
                return "U'";
            case "D":
                return "D";
            case "D'":
                return "D'";
            case "L":
                return "L";
            case "L'":
                return "L'";
            case "R":
                return "R";
            case "R'":
                return "R'";
            case "F":
                return "F";
            case "F'":
                return "F'";
            case "B":
                return "B";
            case "B'":
                return "B'";
            default:
                return "Default";
        }
    }
    //public static void shuffle(cube){
        //todo}
    public static String[][] buildcube(){
        String[][] cube = {
                            {"W","W","W",
                            "W","W","W",
                            "W","W","W"},

                            {"B","B","B",
                            "B","B","B",
                            "B","B","B"},

                            {"Y","Y","Y",
                            "Y","Y","Y",
                            "Y","Y","Y"},

                            {"G","G","G",
                            "G","G","G",
                            "G","G","G"},

                            {"R","R","R",
                            "R","R","R",
                            "R","R","R"},

                            {"O","O","O",
                            "O","O","O",
                            "O","O","O"}
        };
        return cube;
    }
    public static void makemove(String[][] play_cube,String move){
        switch (move) {
            case "U":
                //todo 
            // case "U'":
            //     return "U'";
            // case "D":
            //     return "D";
            // case "D'":
            //     return "D'";
            // case "L":
            //     return "L";
            // case "L'":
            //     return "L'";
            // case "R":
            //     return "R";
            // case "R'":
            //     return "R'";
            // case "F":
            //     return "F";
            // case "F'":
            //     return "F'";
            // case "B":
            //     return "B";
            // case "B'":
            //     return "B'";
            // default:
            //     return "Default";
        }
    }
    //public static void playgame(){
        //todo}
    public static void display(String[][] cube){
        for ( int i=0; i<cube.length; i++){
            if (i==0||i==4||i==5){
                for (int j= 0; j<cube[i].length; j++){
                    if (j==0||j==3||j==6){
                        System.out.println();
                        System.out.print("      "+cube[i][j]+" ");
                    }
                    else{
                        
                        System.out.print(cube[i][j]+" ");
                        }
                }
                System.out.println();
            }
            else{
                int q=0;
                for (int j=1; j<4; j++){
                    for (int h=q; h<q+3; h++){
                        System.out.print(cube[j][h]+" ");
                    }
                    if (j%3 ==0)System.out.println();
                    q+=3;
                }
            }
        }
    }
    public static String checkcube (String[][] play_cube){
        String[][] test_cube=buildcube();
        for ( int i=0; i<test_cube.length; i++){
            for (int j= 0; j<test_cube[i].length; j++){
                if (test_cube[i][j] != play_cube[i][j]){
                    return "not solved";
                }
            }
        }
        return "solved";
    }

    
    public static void main(String[] args){
        String[][] play_cube=buildcube();
        display(play_cube);
        //System.out.println(checkcube(play_cube));
    }
}
