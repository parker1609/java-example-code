package studytest;

public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println("멍멍");
    }

    public void run() {
        System.out.println("달리다.");
    }
}
