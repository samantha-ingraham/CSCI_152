package daily_prompt;

public class oct_9 {

        static void printMove(int start, int end){
            System.out.println(start + " -> " + end);
        }
        static void towerOfHanoi(int n, int start, int end){
            if(n==1){
                printMove(start, end);
            }
            else{
                int other = 6 - (start + end);
                towerOfHanoi(n-1, start, other);
                printMove(start, end);
                towerOfHanoi(n-1, other, end);
            }
        }
        public static void main(String[] args) throws Exception {
            towerOfHanoi(8, 1, 3);
        }
    
}
