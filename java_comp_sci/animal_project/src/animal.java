abstract class animal {

    abstract String name;
    
    abstract int weight;

    public static void die() {
        System.out.println("The animal"+ name() + "has died.");
    }

    public static void eat() {
        System.out.println("The animal"+ name() + "has eaten. It now weighs" + weight() + "pounds.");
    }
    
}
