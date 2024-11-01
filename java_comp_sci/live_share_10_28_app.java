public class live_share_10_28_app {
    
        public static void main(String[] args) throws Exception {
            KinematicBody Sam = new KinematicBody("Sam");
    
            System.out.println(Sam.getPosition());
            System.out.println(Sam.getName());
    
            int[] startPos = {200,200};
    
            KinematicBody NegaSam = new KinematicBody("NegaSam", startPos);
    
            System.out.println(NegaSam.getPosition());
            System.out.println(NegaSam.getName());
    
        }
    
    
}
