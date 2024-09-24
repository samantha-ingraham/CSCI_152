public class App {

    static String[][] Board =   {
                                    {"BC1", "BK1", "BB1", "BQ", "BK", "BB2", "BK2", "BC2" },
                                    {"BP1", "BP2", "BP3", "BP4", "BP5", "BP6", "BP7", "BP8"},
                                    {"","","","","","","",""},
                                    {"","","","","","","",""},
                                    {"","","","","","","",""},
                                    {"","","","","","","",""},
                                    {"WP1", "WP2", "WP3", "WP4", "WP5", "WP6", "WP7", "WP8"},
                                    {"WC1", "WK1", "WB1", "WQ", "WK", "WB2", "WK2", "WC2" },
                                };
    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);

        Boolean quit = false;

        int moveX, moveY;

        while(!quit){

            Boolean flipper = true;

            for(String[] boardRows : Board){
                for(String cell : boardRows){
                    if(cell == ""){
                        if(flipper){
                            System.out.print("███");
                        }
                        else{
                            System.out.print("   ");
                        }
                    }
                    else{
                        if(flipper){
                            System.out.print("█"+cell+"█");
                        }
                        else{
                            System.out.print(" "+cell+" ");
                        }
                    }

                    flipper = !flipper;
                }
                flipper = !flipper;
                System.out.println();
            }

            System.out.println("Please enter the x coordinate of a piece");
            moveX = scn.nextInt();
            System.out.println("Please enter the y coordinate of a piece");
            moveY = scn.nextInt();

            System.out.println("The piece you selected is: " + Board[moveY][moveX]);

            if(Board[moveY][moveX] == "♖"){
                //TODO
            }else if(Board[moveY][moveX] == "♘"){
                //TODO
            }else if(Board[moveY][moveX] == "♗"){
                //TODO
            }else if(Board[moveY][moveX] == "♘"){
                //TODO
            }else if(Board[moveY][moveX] == "♗"){
                //TODO
            }else if(Board[moveY][moveX] == "♘"){
                //TODO
            }else if(Board[moveY][moveX] == "♗"){
                //TODO
            }else if(Board[moveY][moveX] == "♘"){
                //TODO
            }else if(Board[moveY][moveX] == "♗"){
                //TODO
            }else if(Board[moveY][moveX] == "♘"){
                //TODO
            }else if(Board[moveY][moveX] == "♗"){
                //TODO
            }else if(Board[moveY][moveX] == "♘"){
                //TODO
            }else{
                //TODO
            }

        }
    }
}