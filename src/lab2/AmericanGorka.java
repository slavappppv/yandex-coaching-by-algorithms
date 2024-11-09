package lab2;
import java.util.Random;

public class AmericanGorka implements Attraction {
    public int pay(int sum) {
        return sum - 5;
    }

    public int levelOfHappiness(int level) {
        System.out.println("WOWWW, you realy liked it!!");
        return level + 20;
    }

    public void areGlasses() {
        Random random = new Random();
        boolean flag = random.nextBoolean();
        if (flag) {
            System.out.println("oh my god, my glasses missed");
        }
        else {
            System.out.println("you caught your glasses in last moment");
        }
    }
}
