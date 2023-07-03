package ABCDRestAssured.Day7;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakeDataGenerator {

    @Test
    void generatingFakeRandomData()
    {
        Faker faker=new Faker();

        String fullName = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String phoneNum = faker.phoneNumber().phoneNumber();

        String userName = faker.name().username();
        String password = faker.internet().password();
        String email = faker.internet().emailAddress();

        System.out.println("Full Name : "+fullName);
        System.out.println("First Name : "+firstName);
        System.out.println("Last Name : "+lastName);
        System.out.println("Phone Number : "+phoneNum);

        System.out.println("User Name : "+userName);
        System.out.println("Password : "+password);
        System.out.println("Email : "+email);
    }

}