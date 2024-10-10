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
    public static String[][] buildcube(){
        String[][] cube = {
                            {"W0","W1","W2",
                            "W3","W ","W5",
                            "W6","W7","W8"},

                            {"B0","B1","B2",
                            "B3","B ","B5",
                            "B6","B7","B8"},

                            {"Y0","Y1","Y2",
                            "Y3","Y ","Y5",
                            "Y6","Y7","Y8"},

                            {"G0","G1","G2",
                            "G3","G ","G5",
                            "G6","G7","G8"},

                            {"R0","R1","R2",
                            "R3","R ","R5",
                            "R6","R7","R8"},

                            {"O0","O1","O2",
                            "O3","O ","O5",
                            "O6","O7","O8"}
        };
        return cube;
    }

    public static void turn_up(Integer a,Integer b, Integer c, Integer d, Integer e, Integer f, Integer g, String[][] play_cube){
        Integer[] num_up ={a,b,c,d};
        Integer[] num_move={e,f,g};
        String move_store=play_cube[a][e];
        String move_store2=play_cube[a][f];
        String move_store3=play_cube[a][g];
        for (int i=0;i<4;i++){
            //System.out.println("***i="+i);
            if(i==3){
                //System.out.println(play_cube[num_up[i]][e]);
                //System.out.println(play_cube[num_up[i]][f]);
                //System.out.println(play_cube[num_up[i]][g]);
                play_cube[num_up[i]][e]=move_store;
                play_cube[num_up[i]][f]=move_store2;
                play_cube[num_up[i]][g]=move_store3;
            }
            else{
                for(int j=0;j<3;j++){
                    //System.out.println(play_cube[num_up[i]][num_move[j]]);
                    play_cube[num_up[i]][num_move[j]]=play_cube[num_up[i+1]][num_move[j]];
                    //System.out.println("j="+j);
                }
            } 
        }
    }
    public static void turn_side(String dir, Integer side, String[][] play_cube){
        if (dir=="CW"){
            // System.out.println("CW");}
            String sto=play_cube[side][0];
            play_cube[side][0]=play_cube[side][6];
            play_cube[side][6]=play_cube[side][8];
            play_cube[side][8]=play_cube[side][2];
            play_cube[side][2]=sto;
            String sto2=play_cube[side][3];
            play_cube[side][3]=play_cube[side][7];
            play_cube[side][7]=play_cube[side][5];
            play_cube[side][5]=play_cube[side][1];
            play_cube[side][1]=sto2;
            }
        if (dir=="CC"){
            // System.out.println("CC");}
            String sto=play_cube[1][2];
            play_cube[side][2]=play_cube[side][8];
            play_cube[side][8]=play_cube[side][6];
            play_cube[side][6]=play_cube[side][0];
            play_cube[side][0]=sto;
            String sto2=play_cube[side][5];
            play_cube[side][5]=play_cube[side][7];
            play_cube[side][7]=play_cube[side][3];
            play_cube[side][3]=play_cube[side][1];
            play_cube[side][1]=sto2;
        }

    }
    public static void makemove(String[][] play_cube,String move){
        switch (move) {
            case "R_U":
                turn_up(2,4,5,0,2,5,8,play_cube);
                turn_side("CW",3,play_cube);
                break;
            case "L_U":
                turn_up(2,4,5,0,0,3,6,play_cube);
                turn_side("CC",1,play_cube);
                break;
            case "T_L":
                turn_up(2,3,5,1,0,1,2,play_cube);
                turn_side("CW",0,play_cube);
                break;
            case "T_R":
                turn_up(2,1,5,3,0,1,2,play_cube);
                break;
        }
    }
    public static void display(String[][] cube){
        int z=0;
        for ( int i=0; i<cube.length; i++){
            if (i==0||i==4||i==5){
                for (int j= 0; j<cube[i].length; j++){
                    if (j==0||j==3||j==6){
                        System.out.println();
                        System.out.print("         "+cube[i][j]+" ");
                        //System.out.print(i+""+j+" ");
                    }
                    else{
                        //System.out.print(i+""+j+" ");
                        System.out.print(cube[i][j]+" ");
                        }
                }
                System.out.println();
            }
            else{//everything after this will run 3 times for i=1,2,3
                for (int q=1; q<4;q++){
                    for (int k=z;k<z+3;k++){
                        System.out.print(cube[q][k]+" ");
                    }
                }
                z+=3;
                System.out.println();
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
        //display(play_cube);
        //System.out.println(checkcube(play_cube));
        //makemove(play_cube,"L");
        //display(play_cube);
        //makemove(play_cube,"R");
        display(play_cube);
        makemove(play_cube,"T_R");
        display(play_cube);
    }
}
//todo: move method for top(l&r), bottom(l&r), left(u&d), right(u&d), front(cw&cc), back(cw&cc)
//todo: method to shuffle cube
//todo: method to play game
