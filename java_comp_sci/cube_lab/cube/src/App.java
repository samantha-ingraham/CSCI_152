public class App {
    static String[][] cube= new String [6][9];
    static String[][][] cube3 = new String [6][3][3];

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
    static void print_die(String[][] c){
        // plan would be to create a new array with the og array within it
        // with 6 empty spaces before and after 0, 4, and 5
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
        print_cube(cube);
        System.out.println("cube3 starts here");
        print_cube3(cube3);
        System.out.println("testing print face");
        print_face(cube,3);
    }
}
