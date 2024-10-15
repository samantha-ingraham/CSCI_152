

public class play_go {
    // build table/board
    //place piece
    //play game
    //tally game must be recursve
    //capture piece must be recursive
    
    //build table/board
    public static String[][] build_table(Integer size){
        
        for(int q=0; q< size; q++){
            if(q == 0){
                System.out.print("  "+q+" ");
            }
            if (q==size-1){
                System.out.println(q);  
            } 
            if (q>0){
                System.out.print(q+" ");
            }
        } // gives us an index for l-r
        String[][] goBoard = new String[size][size];
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
        return goBoard;
    }
    
    public static void main(String[] args){
        build_table(5);
    }
}
