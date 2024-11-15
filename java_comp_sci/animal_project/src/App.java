import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws Exception {
        ArrayList<Animal> animal_list = new ArrayList<>();
        animal_list.add(new Fox("Foxy"));
        animal_list.add(new Hawk("Hawky"));
        animal_list.add(new Sardine("Sardiny"));
        animal_list.add(new Duck("Kevin the great"));
    }
}
