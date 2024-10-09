import java.util.Random;

public class random {
    public static void main(String[] args){
        Random rand = new Random(2222L);
        System.out.println(rand.nextInt(12));
        
        String[] moves={"U","U'","D","D'","L","L'","R","R'","F","F'","B","B'"};
        switch (moves[rand.nextInt(12)]) {
            case "U":
                System.out.println("U");
                break;
            case "U'":
                System.out.println("U'");
                break;
            case "D":
                System.out.println("D");
                break;
            case "D'":
                System.out.println("D'");
                break;
            case "L":
                System.out.println("L");
                break;
            case "L'":
                System.out.println("L'");
                break;
            case "R":
                System.out.println("R");
                break;
            case "R'":
                System.out.println("R'");
                break;
            case "F":
                System.out.println("F");
                break;
            case "F'":
                System.out.println("F'");
                break;
            case "B":
                System.out.println("B");
                break;
            case "B'":
                System.out.println("B'");
                break;
            default:
                System.out.println("Default");
                break;
        }
    }
}
