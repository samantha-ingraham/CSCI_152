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
                            {null,null,null,"W","W","W",null,null,null,},
                            {null,null,null,"W","W","W",null,null,null,},
                            {null,null,null,"W","W","W",null,null,null,},

                            {"B","B","B",
                            "B","B","B",
                            "B","B","B"},

                            {"Y","Y","Y",
                            "Y","Y","Y",
                            "Y","Y","Y"},

                            {"G","G","G",
                            "G","G","G",
                            "G","G","G"},

                            {null,null,null,"R","R","R",null,null,null,},
                            {null,null,null,"R","R","R",null,null,null,},
                            {null,null,null,"R","R","R",null,null,null,},

                            {null,null,null,"O","O","O",null,null,null,},
                            {null,null,null,"O","O","O",null,null,null,},
                            {null,null,null,"O","O","O",null,null,null,}
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
                for (int j= 0; j<cube[i].length; j++){
                    if (j%3 ==0)System.out.println();

                    System.out.print(cube[i][j]+" ");
        

                }
                System.out.println();
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
