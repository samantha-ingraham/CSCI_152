import java.util.ArrayList;


public class cube {
    static String[][] cube= new String [6][9];
    static String[][][] cube3 = new String [6][3][3];
    static ArrayList <String> diceList = new ArrayList<>();
        

    static void print_face(String[][]c, int q){
        for ( int i= q; i<c.length; i++){
            for (int j=0; j<c[i].length;j++){
                if (j%3 ==0)System.out.println();

                System.out.print(" "+ i);
            }
        if( i ==q){
            break;
        }
        }
    }
    static void build_die(ArrayList<String> list) {
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add(0," ");
        list.add(2," ");
        list.add(6," ");
        list.add(8," ");
        list.add(9," ");
        list.add(11," ");
    }
    static void print_die(ArrayList<String> list){
        
    }

    static void print_cube(String[][] c){
        for ( int i=0; i<c.length; i++){
            for (int j= 0; j<c[i].length; j++){
                if (j%3 ==0)System.out.println();

                System.out.print(" "+ i);
    

            }
            System.out.println();
        }
    }
    static void print_cube3(String[][][] c){
        for ( int i=0; i<c.length; i++){
            for (int j= 0; j<c[i].length; j++){
                for (int k=0; k<c[i][j].length;k++){
                    if (k%3==0){System.out.println();}
                    System.out.print(" " + i);
                }
            }
            System.out.println();
        }
    }
        
    public static void main(String[] args) throws Exception {
        diceList.add("1");
        diceList.add("2");
        diceList.add("3");
        diceList.add("4");
        diceList.add("5");
        diceList.add("6");
        //print_cube(cube);
        //System.out.println("cube3 starts here");
        //print_cube3(cube3);
        //System.out.println("testing print face");
        //print_face(cube,3);
        
    }
}
