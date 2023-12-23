package com.loop.test.day_9_config_driver;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

public class Faker_For_Test {
    @Test
    public void java_faker() {
        Faker faker = new Faker();
        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.name().username() = " + faker.name().username());
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));
        System.out.println("faker.bothify(\"?##?###?\") = " + faker.bothify("?##?###?"));

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String dob = sdf.format(faker.date().birthday(18, 60));
        System.out.println(dob);
    }
}
