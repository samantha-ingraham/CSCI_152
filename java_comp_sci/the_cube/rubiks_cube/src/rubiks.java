import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class rubiks {
    public static String random(){
        //generates a randomized move
        Random rand = new Random();
        String[] moves={"R_U","L_U","R_D","L_D","T_L","B_L","T_R","B_R","FR_R","FR_L","BA_R","BA_L"};
        String select= moves[rand.nextInt(12)];
        switch (select) {
            case "R_U":
                return "R_U"; 
            case "L_U":
                return "L_U";
            case "R_D":
                return "R_D";
            case "L_D":
                return "L_D";
            case "T_L":
                return "T_L";
            case "B_L":
                return "B_L";
            case "T_R":
                return "T_R";
            case "B_R":
                return "B_R";
            case "FR_R":
                return "FR_R";
            case "FR_L":
                return "FR_L";
            case "BA_R":
                return "BA_R";
            case "BA_L":
                return "BA_L";
            default:
                return "Default";
        }
    }
    public static void shuffle (Integer n, String[][] cube){
        //shuffles cube n times
        String[] moves = new String[n];
        for (int i=0;i<n;i++){
            moves[i]=random();
            makemove(cube,moves[i]);
        }  
    }
    public static String[][] buildcube(){
        //builds a cube
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
    public static void turn_face(Integer a,Integer b, Integer c, Integer d, Integer e, Integer f, Integer g, String[][] play_cube){
        //turns the efg locations of the face of the cube (face choice is a) in the direction abcd
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
        //rotates chosen side either clockwise or counter clockwise.
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
            String sto=play_cube[side][2];
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
        /*
        makes the appropriate turns based on move choice, 
        some moves require the elements be rotated into position for the other turn methods to work, 
        and then rotates them back to where they need to be for display purposes.
        */
        switch (move) {
            case "R_U":
                turn_face(2,4,5,0,2,5,8,play_cube);
                turn_side("CW",3,play_cube);
                break;
            case "R_D":
                turn_side("CC",3,play_cube);
                turn_face(2,0,5,4,2,5,8,play_cube);
                break;
            case "L_U":
                turn_face(2,4,5,0,0,3,6,play_cube);
                turn_side("CC",1,play_cube);
                break;
            case "L_D":
                turn_side("CW",1,play_cube);
                turn_face(2,0,5,4,0,3,6,play_cube);
                break;
            case "T_L":
                turn_side("CW",5,play_cube);//rotate orange so the correct side gets moved
                turn_side("CW",5,play_cube);
                turn_face(2,3,5,1,0,1,2,play_cube);
                turn_side("CW",5,play_cube);
                turn_side("CW",5,play_cube);//rotate orange to original position
                turn_side("CW",0,play_cube);
                break;
            case "T_R":
                turn_side("CW",5,play_cube);//rotate orange so the correct side gets moved
                turn_side("CW",5,play_cube);
                turn_face(2,1,5,3,0,1,2,play_cube);
                turn_side("CW",5,play_cube);//rotate orange back to original position
                turn_side("CW",5,play_cube);
                turn_side("CC",0,play_cube);//rotate white
                break;
            case "B_L":
                turn_side("CW",5,play_cube);//rotate orange so the correct side gets moved
                turn_side("CW",5,play_cube);
                turn_face(2,3,5,1,6,7,8,play_cube);
                turn_side("CC",5,play_cube);
                turn_side("CC",5,play_cube);//rotate orange to original position
                turn_side("CC",4,play_cube);
                break;
            case "B_R":
                turn_side("CW",5,play_cube);//rotate orange so the correct side gets moved
                turn_side("CW",5,play_cube);
                turn_face(2,1,5,3,6,7,8,play_cube);
                turn_side("CW",5,play_cube);//rotate orange back to original position
                turn_side("CW",5,play_cube);
                turn_side("CW",4,play_cube);//rotate white
                break;
            case "FR_L":
                turn_side("CC",4,play_cube);//rotate r so the correct element gets moved
                turn_side("CC",1,play_cube);//rotate b so the correct element gets moved
                turn_side("CC",1,play_cube);//rotate b so the correct element gets moved
                turn_side("CW",0,play_cube);//rotate w so the correct element gets moved
                turn_face(3,4,1,0,0,3,6,play_cube);
                turn_side("CC",2,play_cube);
                turn_side("CW",4,play_cube);//rotate r so the correct element gets moved
                turn_side("CW",1,play_cube);//rotate b so the correct element gets moved
                turn_side("CW",1,play_cube);//rotate b so the correct element gets moved
                turn_side("CC",0,play_cube);//rotate w so the correct element gets moved
                break;
            case "FR_R":
                turn_side("CC",4,play_cube);//rotate r so the correct element gets moved
                turn_side("CW",0,play_cube);//rotate W so the correct element gets moved
                turn_side("CC",1,play_cube);//rotate b so the correct element gets moved
                turn_side("CC",1,play_cube);//rotate B so the correct element gets moved
                turn_face(3,0,1,4,0,3,6,play_cube);
                turn_side("CW",2,play_cube);
                turn_side("CC",0,play_cube);//rotate back for display
                turn_side("CW",1,play_cube);
                turn_side("CW",1,play_cube);
                turn_side("CW",4,play_cube);
                break;
            case "BA_L":
                turn_side("CC",4,play_cube);//rotate r so the correct element gets moved
                turn_side("CC",1,play_cube);//rotate b so the correct element gets moved
                turn_side("CC",1,play_cube);//rotate b so the correct element gets moved
                turn_side("CW",0,play_cube);//rotate w so the correct element gets moved
                turn_face(3,4,1,0,2,5,8,play_cube);
                turn_side("CW",5,play_cube);
                turn_side("CW",4,play_cube);//rotate r so the correct element gets moved
                turn_side("CW",1,play_cube);//rotate b so the correct element gets moved
                turn_side("CW",1,play_cube);//rotate b so the correct element gets moved
                turn_side("CC",0,play_cube);//rotate w so the correct element gets moved
                break;
            case "BA_R":
                turn_side("CC",4,play_cube);//rotate r so the correct element gets moved
                turn_side("CW",0,play_cube);//rotate W so the correct element gets moved
                turn_side("CC",1,play_cube);//rotate b so the correct element gets moved
                turn_side("CC",1,play_cube);//rotate B so the correct element gets moved
                turn_face(3,0,1,4,2,5,8,play_cube);
                turn_side("CC",5,play_cube);
                turn_side("CC",0,play_cube);//rotate back for display
                turn_side("CW",1,play_cube);
                turn_side("CW",1,play_cube);
                turn_side("CW",4,play_cube);
                break;
        }
    }
    public static void display(String[][] cube){
        //displays the cube in a cross format
        int z=0;
        for ( int i=0; i<cube.length; i++){
            if (i==0||i==4||i==5){
                for (int j= 0; j<cube[i].length; j++){
                    if (j==0||j==3||j==6){
                        System.out.println();
                        System.out.print("      "+cube[i][j]+" ");
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
    public static Boolean checkcube (String[][] play_cube){
        //checks if the cube is solved against a freshly built cube. thank god for trash collection.
        String[][] test_cube=buildcube();
        for ( int i=0; i<test_cube.length; i++){
            for (int j= 0; j<test_cube[i].length; j++){
                if (test_cube[i][j] != play_cube[i][j]){
                    return false;
                }
                else{
                    continue;
                }
            }
        }
        return true;
    }
    public static void ask_game(){
        /*
        asks the user if they'd like to play with a rubiks cube, sets up the game. 
        This probably didn't need to be its own method but it felt tidier.
        */
        Scanner input=new Scanner(System.in);

        System.out.println("Welcome to the Rubik's Cube Game! Would you like to play? (Y/N)");
        String play=input.nextLine();
        if (play.equalsIgnoreCase("N")){
            System.out.println(" >:( well fine then.");
            input.close();
            return;
        }
        if (play.equalsIgnoreCase("Y")){
            System.out.println("Great! Let's get started.");
        }
        System.out.println("How many moves would you like me to shuffle the cube??(I would suggest at least 6!)");
        Integer n=input.nextInt();
        input.nextLine();
        play_game(n,input);
    }
    public static void play_game(Integer n, Scanner u_input){
        //plays the game
        String[][] play_cube=buildcube();// builds our play cube
        shuffle(n,play_cube);// shuffles it
        display(play_cube);// displays it
        System.out.println("The cube has been shuffled "+n+" times.");//tells the user how many times it was shuffled
        // list of possible moves to check against
        String[] moves_list={"R_U","L_U","R_D","L_D","T_L","B_L","T_R","B_R","FR_R","FR_L","BA_R","BA_L"};
        //game loop
        while (true) {
            //tells user what moves they can make
            System.out.println("Enter a move.The options are:\nR_U(right side rotates up), R_D(right side rotates down),\nL_U(left side up), L_D(left side down),\nT_L(top side rotates left), T_R(top side right),\nB_L(bottom left), B_R(bottom right),\nFR_L(this will rotate the front face to the left), FR_R(front face to the right),\nBA_L(back face, as though the front is still facing you, to the left), BA_R(back face to the right).");
            String move=u_input.nextLine();//gets user input
            //tests user input against list of possible moves, starts loop over if invalid
            if (!Arrays.asList(moves_list).contains(move)) {
            System.out.println("Invalid move!");
            }
            //runs the rest of the game if the move is valid
            else{
                makemove(play_cube,move);
                display(play_cube);// displays cube after your move
                System.out.println("Would you like to check if the cube is solved? (Y/N)");
                String check=u_input.nextLine();// gets user input 
                if (check.equalsIgnoreCase("Y")){
                    if (checkcube(play_cube)){
                        System.out.println("Congratulations! You solved the cube!");
                        break;//ends game
                    }
                    else{
                        System.out.println("The cube is not solved yet.");
                        continue;//continues to next else statement
                    } 
                }
                else{
                    //asks if you want to continue playing
                    System.out.println("Would you like to continue playing? (Y/N)");
                    String cont=u_input.nextLine();
                    if (cont.equalsIgnoreCase("N")){
                        break;//ends game
                    }
                }  
            }
        }
        u_input.close();//closes scanner
    }
    public static void main(String[] args){
        //TESTING
        //String[][] play_cube=buildcube();
        //makemove(play_cube, "R_U");
        //turn_side("CC", 0, play_cube);
        //display(play_cube);
        //shuffle(3,play_cube);
        //display(play_cube);
        //System.out.println(checkcube(play_cube));

        //!!!!!! UNCOMMENT NEXT LINE TO PLAY GAME!!!!!!
        ask_game();
    }
}

