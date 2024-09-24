package daily_prompt;
public class sept_18{
    public static void main (String[] args){
        int num_arr[][] = new int [6][9];
            for( int i=0; i<num_arr.length ; i++ ){
                 for (int j=0; j<num_arr[i].length;j++){
                    if (j % 9 ==0)System.err.println();
                    System.out.print(1+i);
                }
            }
    }
}
//i think i misunderstood the assignment but it did what i intended