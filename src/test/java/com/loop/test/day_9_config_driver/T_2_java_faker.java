package com.loop.test.day_9_config_driver;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class T_2_java_faker {

    @Test
    public void java_faker(){
        Faker faker = new Faker();
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("252-###-####"));
        System.out.println("faker.letterify(\"?????\") = " + faker.letterify("?????"));
        System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());
        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());
        System.out.println("faker.bothify(\"##??##?\") = " + faker.bothify("##??##?"));
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());
        System.out.println("faker.chuckNorris().fact().replace(\"Chuck Norris\", \"Feyruz\") = " + faker.chuckNorris().fact().replace("Chuck Norris", "Feyruz"));


    }
}
