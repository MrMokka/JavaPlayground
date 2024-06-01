package Animals;

public class Bird extends Animal {
    
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Pip pip");
    }

    @Override
    public String animalType() {
        return null;
    }
}
