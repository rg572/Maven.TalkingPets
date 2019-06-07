package io.zipcoder.polymorphism;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DogTest {

    @Test
    public void speak() {
        Pet dog = new Dog("Rex Mundi");
        String expected = "Bark";

        String actual = dog.speak();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getType() {
        Pet dog = new Dog("Rover");
        String expected = "dog";

        String actual = dog.getType();

        Assert.assertEquals(expected, actual);
    }
}