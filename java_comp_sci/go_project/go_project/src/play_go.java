import java.util.Scanner;

public class play_go {

    public static void start_game(){
        System.out.println("Welcome to Sammy's go game!");
        System.out.println("This game is intended for two players. \nPlayer 1 is O and Player 2 is X. \nYou'll be given a chance to hear the rules again at the start of your turn.");
        game_methods.print_rules();
    }

    public static void end_game(int[] scores){
        System.out.println("The game is over! The final capture score is: ");
        System.out.println("Player 1: " + scores[0]);
        System.out.println("Player 2: " + scores[1]);
        System.out.println("Add up your territory and add your capture score to determine the winner!");
        System.out.println("Thanks for playing!");
    }

    public static void play(Scanner user_input){
        System.out.println("Please enter the size of the X by X board you would like to play on.");
        int board_size = user_input.nextInt();
        int[][]goBoard = game_methods.make_board(board_size);
        int player_number = 1;
        int[] scores = {0,0};
        boolean[] players_pass = {false, false};
        while(players_pass[0] == false || players_pass[1] == false){
            game_methods.print_board(goBoard);
            game_methods.place_piece(goBoard, player_number, user_input, scores, players_pass);
            game_methods.print_board(goBoard);
            System.out.println("removing captured pieces and updating scores...");
            int captured_player= (player_number == 2) ? 3 : 4;
            game_methods.remove_captures(goBoard, captured_player,scores);
            game_methods.remove_captures(goBoard,captured_player,scores);
            player_number=(player_number == 1) ? 2 : 1;
        }
        end_game(scores);
    }
    
    public static void main(String[] args) {
        // player_number: 1 = O,3=captured O, 2 = X, 4=captured X
        start_game();
        Scanner myObj = new Scanner(System.in);
        play(myObj);
        myObj.close();
    }    
}
