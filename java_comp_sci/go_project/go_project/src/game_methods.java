import java.util.ArrayList;
import java.util.Scanner;

public class game_methods {
    
    public static void print_rules() {// prints the rules of the game
        System.out.println("Rules");
        System.out.println("1. A stone placed on the board cannot be moved, but can be captured.");
        System.out.println("2. A group of stones is captured if it has no eyes (empty points) within its borders and is surrounded by the opponent's stones/edges of the board.");
        System.out.println("3. The game ends when both players pass their turns consecutively.");
        System.out.println("4. The player with the most territory (empty points surrounded and captured stones) at the end wins.\nI'll keep track of the score for captures for you, but you'll have to count the territory yourself.");
    }

    public static void print_score(int[] player_scores) {// tells you the current score of the previous captures
        System.out.println("Player 1's score: " + player_scores[0]);
        System.out.println("Player 2's score: " + player_scores[1]);
    }
    
    public static int[][] make_board(int size) {//makes a board full of 0's
        int[][] goBoard = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                goBoard[i][j] = 0; 
            }
        }
        return goBoard;
    }

    public static void print_board(int[][] goBoard) {// print the board out for the users to see
        System.out.print("  ");
        for (int i = 0; i < goBoard.length; i++) { // prints the column numbers
            System.out.print(i + " ");
        }
        System.out.println();
        for (int j = 0; j < goBoard.length; j++) {
            for (int k = 0; k < goBoard.length + 1; k++) {
                if (k == 0) { // prints the row numbers
                    System.out.print(j + " ");
                } else {
                    switch (goBoard[j][k - 1]) { // prints the crosshatch pattern vertical lines, which can be replaced by x's and o's
                        case 0:
                            //System.out.print("0");
                            System.out.print("|");
                            break;
                        case 1:
                            //System.out.print("1");
                            System.out.print("O");
                            break;
                        case 2:
                            //System.out.print("2");
                            System.out.print("X");
                            break;
                        case 3: // captured O
                            //System.out.print("3");
                            System.out.print("C");
                            break;
                        case 4: // captured X
                            //System.out.print("4");
                            System.out.print("K");
                            break;
                        default:
                            System.out.print("?");
                            break;
                    }
                    if (k < goBoard.length) { // prints the horizontal lines
                        System.out.print("-");
                    }
                }
            }
            System.out.println(); // moves to the next line
        }
    }

    public static void place_piece(int[][] goBoard, int player_number, Scanner scn, int[] scores, boolean[] pass) {// places a piece on the board, asks for rules, asks for pass
        boolean keep_going = true;
        System.out.println("Player "+player_number+"'s turn.");
        System.out.println("Would you like to hear the rules again? 1 for yes");
        int response = scn.nextInt();
        if (response==1) {
            print_rules();
        }
        System.out.println("Would you like to see the current score for captures? 1 for yes");
        response = scn.nextInt();
        if (response==1) {
            print_score(scores);;
        }
        while (keep_going) {
            System.out.println("Would you like to pass your turn? 1 for yes");
            response = scn.nextInt();
            if (response==1) {
                keep_going = false;
                if (player_number == 1) {
                    pass[0] = true;
                } else {
                    pass[1] = true;
                }
                break;
            }
            System.out.println("Please enter the row you would like to place your piece: ");
            int row = scn.nextInt();
            System.out.println("Please enter the column you would like to place your piece: ");
            int col = scn.nextInt();
            if (row < 0 || row >= goBoard.length || col < 0 || col >= goBoard.length) {
                System.out.println("Out of bounds, try again.");
                continue;
            } else if (goBoard[row][col] == 0) {
                goBoard[row][col] = player_number;
                keep_going = false;
                check_board(goBoard, player_number);
            } 
            else {
                System.out.println("Invalid move, try again.");
                continue;
            }
        }
    }
    
    public static void remove_captures(int[][] goBoard, int captured_player,int[] player_scores) {
        //removes captured pieces from the board and updates the scores
        int captured_count = 0;
        for (int i = 0; i < goBoard.length; i++) {
            for (int j = 0; j < goBoard.length; j++) {
                if (goBoard[i][j] == captured_player) {
                    captured_count++;
                    goBoard[i][j] = 0;
                }
            }
        }
        if (captured_player == 3) {
            player_scores[1]+=captured_count;
        } 
        if (captured_player == 4) {
            player_scores[0]+=captured_count;
        }
    }
    
    
    public static void check_board(int[][] goBoard, int player_number_just_placed) {//iterates through the board and checks if your just placed piece has surrounded any of the other player's pieces
        int surroundee = 0;
        if (player_number_just_placed == 1) {
            surroundee = 2;
        }
        if (player_number_just_placed == 2) {
            surroundee = 1;
        }
        for (int i = 0; i < goBoard.length; i++) {
            for (int j = 0; j < goBoard.length; j++) {
                if (goBoard[i][j] == surroundee|| goBoard[i][j]==0) {
                    change_number(goBoard, i, j, player_number_just_placed, surroundee);
                }
            }
        }
    }

    private static void explore(int[][] board, int row, int col, int boarder_patrol, boolean[][] visited, ArrayList <int[]> possible_group, ArrayList <int[]> number_at_group_positions){
        // explores the board from a given position to find a group of like pieces or empty spots. 
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col]==boarder_patrol){//checks if we have run into a wall or the opposite player's pieces
            return;
        }
        if (enough_eyes(number_at_group_positions)>=2){
            return;
        }
        int number = board[row][col];//makes a variable of the value of the piece we are checking

        visited[row][col] = true;// keeps us from checking the same piece twice

        possible_group.add(new int[]{row, col});//adds piece location to list

        number_at_group_positions.add(new int[]{number});// adds piece value to list

        //recursive calls to check the surrounding pieces
        explore(board, row - 1, col, boarder_patrol, visited, possible_group, number_at_group_positions);
        explore(board, row + 1, col, boarder_patrol, visited, possible_group, number_at_group_positions);
        explore(board, row, col - 1, boarder_patrol, visited, possible_group, number_at_group_positions);
        explore(board, row, col + 1, boarder_patrol, visited, possible_group, number_at_group_positions);
    }

    private static int enough_eyes(ArrayList <int[]> number_at_group_positions){
        //checks if a group of pieces has enough eyes to be considered alive
        int eye_count = 0;
        for (int[] pos : number_at_group_positions){
            if (pos[0] == 0){
                eye_count++;
            }
        }
        return eye_count;
    }
    
    private static void change_number(int[][] goBoard, int row, int col, int surrounder, int surroundee) {
        //changes the values if pieces are captured
        //creates 2 array lists to store the possible group of pieces and the number of pieces at those positions
        //creates a 2d array to keep track of which pieces have been visited
        //calls the explore method to find the group of pieces
        ArrayList <int[]> possible_group = new ArrayList <>();
        ArrayList <int[]> number_at_group_positions = new ArrayList <>();
        boolean[][] visited = new boolean[goBoard.length][goBoard[0].length];
        explore(goBoard, row, col, surrounder, visited, possible_group, number_at_group_positions);
        if (enough_eyes(number_at_group_positions)<2){//checks we don't have enough eyes
            for (int[] pos : possible_group) {//iterates through the group of pieces
                if (goBoard[pos[0]][pos[1]] != 0 && goBoard[pos[0]][pos[1]] !=3 && goBoard[pos[0]][pos[1]] !=4){//keeps us from changing the empty spots
                    switch (surroundee) {//changes the piece to a captured piece
                        case 1://changes the piece to a captured piece
                            goBoard[pos[0]][pos[1]] = 3;
                            break;
                        case 2:
                            goBoard[pos[0]][pos[1]] = 4;
                            break;
                    }
                }
            }
        }
    }

    //test boards, adjust as neccesary
    static int[][] test_board_1 = {
        {1, 0, 0, 0, 0, 0,0,0,0},
        {0, 0, 0, 0, 0, 0,0,0,0},
        {0, 0, 0, 0, 0, 0,0,0,0},
        {0, 0, 0, 0, 0, 0,0,0,0},
        {0, 0, 0, 0, 0, 0,0,0,0},
        {0, 0, 0, 0, 0, 0,0,0,0},
        {0, 0, 0, 0, 0, 0,0,0,0},
        {0, 0, 0, 0, 0, 0,0,0,0},
        {0, 0, 0, 0, 0, 0,0,0,0}
    };
    static int[][] test_board_2 = {
        {1, 2, 0, 0, 0, 0},
        {0, 1, 2, 0, 0, 0},
        {1, 2, 0, 0, 0, 0},
        {1, 2, 0, 0, 0, 0},
        {1, 1, 2, 0, 0, 0},
        {1, 2, 0, 0, 0, 0}
    };
    static int[][] test_board_3 = {
        {0, 0, 2, 0, 0, 0},
        {0, 2, 1, 2, 0, 0},
        {2, 1, 2, 1, 2, 0},
        {0, 2, 1, 2, 1, 2},
        {0, 0, 2, 1, 2, 0},
        {0, 0, 0, 2, 0, 0}
    };
    static int[][] test_board_4 = {
        {0, 1, 2, 0, 0, 0},
        {0, 1, 2, 0, 0, 0},
        {0, 1, 2, 0, 0, 0},
        {0, 1, 2, 0, 0, 0},
        {0, 1, 2, 0, 0, 0},
        {0, 1, 2, 0, 0, 0}
    };
    static int[][] test_board_5 = {
        {0, 0, 2, 0},
        {0, 0, 2, 0},
        {0, 0, 2, 0},
        {0, 0, 2, 0}
    };
    static int[] test_scores = {0, 0};
    static boolean[] test_pass = {false, false};
    //main is used for testing
    public static void main(String[] args) {
        // player_number: 1 = O, 3=captured O, 2 = X, 4=captured X, 5=eye for O, 6=eye for X
        Scanner myObj = new Scanner(System.in);
        //print_board(test_board_1);
        //check_board(test_board_4, 1);
        //print_board(test_board_4);
        //check_board(test_board_3, 2);
        //print_board(test_board_3);
        //place_piece(test_board_1, 2, myObj);
        print_board(test_board_1);
        place_piece(test_board_1, 2, myObj, test_scores,test_pass);
        //check_board(test_board_1, 2);
        print_board(test_board_1);
        remove_captures(test_board_1, 3, test_scores);
        print_board(test_board_1);
        //score_game(test_board_2, test_scores);
        System.out.println(test_scores[0]);
        System.out.println(test_scores[1]);
        myObj.close();
    }
}