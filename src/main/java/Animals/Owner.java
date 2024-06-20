package Animals;

import java.util.*;

public class Owner {
    
    String name;
    List<Pet> pets = new ArrayList<>();
    
    public Owner(String name) {
        this.name = name;
    }

    public void addPet(Pet element) {

    }

    public Pet removePet(Pet pet) {
        return null;
    }
    
    public void displayPets() {
        for(Pet pet : pets){
            System.out.println(name + " owns ");
        }
    }
    
}
