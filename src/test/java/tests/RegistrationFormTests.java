package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormTests {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

        @BeforeAll
         static void setup() {
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.startMaximized = true;
        }

        @Test
        void practiceForm() {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = faker.internet().emailAddress();
            String gender = faker.demographic().sex();
            String phone = faker.phoneNumber().subscriberNumber(10);
            String dateOfBirth = "29 July,1990";
            String subject = "Maths";
            String hobby = "Music";
            String path = "ozero.jpg";
            String address = faker.address().fullAddress();
            String state = "Haryana";
            String city = "Karnal";

            //Открыть страницу с формой регистрации и заполнить обязательные поля формы
            registrationPage.openPage()
                    .typeFirstName(firstName)
                    .typeLastName(lastName)
                    .typeEmail(email)
                    .selectGender(gender)
                    .typePhone(phone)
                    .setDateOfBirth("29", "July","1990")
                    .selectSubject(subject)
                    .selectHobby(hobby)
                    .selectFile(path)
                    .typeAddress(address)
                    .selectState(state)
                    .selectCity(city)
                    .saveForm();

            //Проверить результ заполнения формы
            registrationPage.checkResultsTitle()
                    .checkResultsValue(firstName + " " + lastName)
                    .checkResultsValue(email)
                    .checkResultsValue(gender)
                    .checkResultsValue(phone)
                    .checkResultsValue(dateOfBirth)
                    .checkResultsValue(subject)
                    .checkResultsValue(hobby)
                    .checkResultsValue(path)
                    .checkResultsValue(address)
                    .checkResultsValue(state)
                    .checkResultsValue(city);
        }
    }
