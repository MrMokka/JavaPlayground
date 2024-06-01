package Animals;

public class Dog extends Animal implements Pet {
    
    public Dog(String name, int age) {
        super(name, age);
    }
    
    @Override
    public void makeSound() {
        System.out.println("Voof");
    }

    @Override
    public String animalType() {
        return "dog";
    }

    @Override
    public String getDescription() {
        return String.format("This is %s, a %d year old dog", name, age);
    }

    @Override
    public void play() {
        System.out.println(name + " is having a great time");
    }

    @Override
    public void beFriendly() {
        System.out.println(name + " loves you");
    }
}
