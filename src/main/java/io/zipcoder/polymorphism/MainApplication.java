package io.zipcoder.polymorphism;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by leon on 11/6/17.
 */
public class MainApplication {

    private Integer numberOfPets;
    private List<Pet> pets;

    public MainApplication() {

    }

    public void run(){
        //Scanner sc = new Scanner(System.in);
        //Boolean validInput = false;
        pets = new ArrayList<>();


        getNumberOfPets();

        populatePets();

        System.out.printf("\nYou have %d pets:\n",numberOfPets);
        for(Pet p : pets){
            System.out.printf(" A %s named %s\n",p.getType(),p.getName());
        }
    }




    private String getOrdinalSuffix(Integer integer){
        switch(integer%10){
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }

    private void getNumberOfPets() {
        Boolean validInput = false;
        Scanner sc = new Scanner(System.in);
        while (!validInput) {
            System.out.print("Enter the number of pets: ");
            try {
                numberOfPets = sc.nextInt();
                if (numberOfPets < 0) {
                    System.out.println("I'm not dealing with negative pets");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Yeah... no. Give me a valid integer");
                sc.nextLine();
            }
        }
    }

    private void populatePets(){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < numberOfPets; i++){
            System.out.printf("What is the name of you %d%s pet?: ",i + 1,getOrdinalSuffix(i + 1));
            String name = sc.nextLine();
            addNewPet(name, sc);
        }

    }

    private void addNewPet(String name, Scanner sc){
        System.out.println("And what kind of pet are they?: ");
        String type;
        while(true){
            type = sc.nextLine().toLowerCase();
            switch(type){
                case "cat":
                    pets.add(new Cat(name));
                    return;
                case "dog":
                    pets.add(new Dog(name));
                    return;
                case "fish":
                    pets.add(new Fish(name));
                    return;
                default:
                    System.out.println("Cat, Dog, and Fish are they only currently supported pet types.");
                    System.out.printf("What kind of pet is %s?: ",name);

            }
        }
    }
}
