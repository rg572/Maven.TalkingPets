package io.zipcoder.polymorphism;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CatTest {

    @Test
    public void speak() {
        Pet cat = new Cat("Argo");
        String expected = "Meow";

        String actual = cat.speak();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTypeTest(){
        Cat cat = new Cat("cat");
        String expected = "cat";

        String actual = cat.getType();

        Assert.assertEquals(expected, actual);
    }

}