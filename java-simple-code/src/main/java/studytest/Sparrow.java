package studytest;

public class Sparrow extends Animal {
    public Sparrow(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println("짹짹");
    }

    public void fly() {
        System.out.println("날다.");
    }
}
