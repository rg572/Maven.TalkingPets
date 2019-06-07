package io.zipcoder.polymorphism;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FishTest {

    @Test
    public void speak() {
        Fish fish = new Fish("fish");
        String expected = "Ph'nglui mglw'nafh Cthulhu R'lyeh wgah'nagl fhtagn";

        String actual = fish.speak();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getType() {
        Fish fish = new Fish("I'm so creative, aren't I?");
        String expected = "fish";

        String actual = fish.getType();

        Assert.assertEquals(expected, actual);
    }
}