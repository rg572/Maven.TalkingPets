package io.zipcoder.polymorphism;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by leon on 11/6/17.
 */
public class MainApplication {

    private Integer numberOfPets;
    private ArrayList<Pet> pets;

    public MainApplication() {

    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        Boolean validInput = false;
        pets = new ArrayList<Pet>();

        while(!validInput){
            System.out.print("Enter the number of pets: ");
            try{
                numberOfPets = sc.nextInt();
                if(numberOfPets < 0){
                    System.out.println("I'm not dealing with negative pets");
                }
                else {
                    validInput = true;
                }
            } catch(InputMismatchException e){
                System.out.println("Yeah... no. Give me a valid integer");
                sc.nextLine();
            }
        }

        sc.nextLine();
        for(int i = 0; i < numberOfPets; i++){
            System.out.printf("What kind of pet is your %d%s pet?: ",i + 1,getOrdinalSuffix(i + 1));
            String type = sc.nextLine();
            System.out.print("And what's their name?: ");
            String name = sc.nextLine();
            pets.add(new Pet(type, name));
        }

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


}
