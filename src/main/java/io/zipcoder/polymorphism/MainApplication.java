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
    private UserInputGetter userInput;

    public MainApplication() {

    }

    public void run(){
        userInput = new UserInputGetter(System.in, System.out);
        pets = new ArrayList<>();

        numberOfPets = userInput.getNumberOfPets();

        populatePets(numberOfPets);

        System.out.printf("\nYou have %d pets:\n",numberOfPets);
        for(Pet p : pets){
            System.out.printf(" %s says %s\n",p.getName(),p.speak());
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


    public void populatePets(Integer petsNumber){
        userInput = new UserInputGetter(System.in, System.out);
        for(int i = 0; i < petsNumber; i++){
            String name = userInput.getUserString(String.format("What is the name of you %d%s pet? ",i+1, getOrdinalSuffix(i+1)));
            pets.add(userInput.getNewPet(name));
        }

    }

    private void addNewPet(String name){
        Scanner sc = new Scanner(System.in);
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

    public String getName(int petNumber){
        Scanner sc = new Scanner(System.in);
        System.out.printf("What is the name of you %d%s pet?: ",petNumber,getOrdinalSuffix(petNumber));
        String name = sc.nextLine();
        sc.close();
        return name;
    }

//    public Integer getNumberOfPets() {
//        Boolean validInput = false;
//        Scanner sc = new Scanner(System.in);
//        Integer userNumber = -1;
//        while (!validInput) {
//            System.out.print("Enter the number of pets: ");
//            try {
//                userNumber = sc.nextInt();
//                if (userNumber < 0) {
//                    System.out.println("I'm not dealing with negative pets");
//                } else {
//                    validInput = true;
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Yeah... no. Give me a valid integer");
//                sc.nextLine();
//            }
//        }
//        return userNumber;
//    }

}
