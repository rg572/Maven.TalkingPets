package io.zipcoder.polymorphism;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputGetter {
    private Scanner sc;
    private PrintStream out;

    public UserInputGetter(InputStream in, PrintStream out){
        sc = new Scanner(in);
        this.out = out;
    }

    public Integer getNumberOfPets(){
        //out.println("This space for rent");
        Integer input = -1;
        Scanner test = new Scanner(System.in);
        while(input < 0){
            //out.println("Still open");
            out.print("Enter the number of pets you have: ");
            try{
                input = sc.nextInt();
                if(input < 0){
                    out.println("I'm not dealing with negative pets.");
                }
            } catch(InputMismatchException e){
                out.println("Yeah... no. Give me a valid integer.");
                sc.nextLine();
            }
        }

        sc.nextLine();

        return input;
    }

    public Pet getNewPet(String name){
        out.println("And what kind of pet are they?: ");
        String type;
        while(true){
            type = sc.nextLine().toLowerCase();
            switch(type){
                case "cat":
                    return new Cat(name);
                case "dog":
                    return new Dog(name);
                case "fish":
                    return new Fish(name);
                default:
                    System.out.println("Cat, Dog, and Fish are they only currently supported pet types.");
                    System.out.printf("What kind of pet is %s?: ",name);

            }
        }

    }

    public String getUserString(String prompt){
        out.print(prompt);
        return sc.nextLine();
    }
}
