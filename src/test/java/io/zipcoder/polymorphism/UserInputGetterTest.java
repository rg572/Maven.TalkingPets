package io.zipcoder.polymorphism;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.mockito.Mockito.mock;

public class UserInputGetterTest {

    @Test
    public void getNumberOfPetsTest1() {
        String inputString = "8\n";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes(StandardCharsets.UTF_8));
        UserInputGetter asker = new UserInputGetter(inputStream, System.out);
        Integer expected = 8;
        Integer actual = asker.getNumberOfPets();
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void getNumberOfPetsTest2() {
        String inputString = "-1\nadf\n8\n";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes(StandardCharsets.UTF_8));

        UserInputGetter asker = new UserInputGetter(inputStream, System.out);
        Integer expected = 8;

        Integer actual = asker.getNumberOfPets();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNewPetTest1(){
        String inputString = "cat";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes(StandardCharsets.UTF_8));

        String name = "name";
        UserInputGetter asker = new UserInputGetter(inputStream, System.out);
        Pet actual = asker.getNewPet(name);

        Assert.assertTrue(actual instanceof Cat && actual.getName().equals(name));
    }

    @Test
    public void getNewPetTest2(){
        String inputString = "dog";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes(StandardCharsets.UTF_8));

        String name = "Rover";
        UserInputGetter asker = new UserInputGetter(inputStream, System.out);
        Pet actual = asker.getNewPet(name);

        Assert.assertTrue(actual instanceof Dog && actual.getName().equals(name));
    }

    @Test
    public void getNewPetTest3(){
        String inputString = "fish";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes(StandardCharsets.UTF_8));

        String name = "Wanda";
        UserInputGetter asker = new UserInputGetter(inputStream, System.out);
        Pet actual = asker.getNewPet(name);

        Assert.assertTrue(actual instanceof Fish && actual.getName().equals(name));
    }

    @Test
    public void getNewPetTest4(){
        String inputString = "tree sloth\nFish";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes(StandardCharsets.UTF_8));

        String name = "Wanda";
        UserInputGetter asker = new UserInputGetter(inputStream, System.out);
        Pet actual = asker.getNewPet(name);

        Assert.assertTrue(actual instanceof Fish && actual.getName().equals(name));
    }


}