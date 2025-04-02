package greeting;

public class Greeter {
    private int num = 0;

    public Greeter(int num) {
        this.num = num;
    }

    public void greet() {
        for (int i = 0; i < this.num; i++) {
            System.out.println("Greet!");
        }
    }
}