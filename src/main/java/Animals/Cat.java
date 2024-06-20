package Animals;

public class Cat extends Animal implements Pet {
    
    public Cat(String name, int age) {
        super(name, age);
    }
    
    @Override
    public void makeSound() {
        System.out.println("Mjau");
    }

    @Override
    public String animalType() {
        return "cat";
    }

    @Override
    public String getDescription() {
        return String.format("This is %s, a %d year old cat", name, age);
    }

    @Override
    public void play() {
        System.out.println(name + " goes crazy after the toy");
    }

    @Override
    public void beFriendly() {
        System.out.println(name + " looks wierd at you, then allows you to pet it");
    }
}
