package ru.appliedtech;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        String firstName = "Alexander";
        String lastName = "Kop";
        String gender = "Male";
        String email = "Alex1234@mail.ru";
        String phone = "1234567890";
        String subject = "Biology";
        String imagePath = "Avatar.jpeg";
        String address = "Komsa street 11, 15 apt.";
        String state = "Haryana";
        String city = "Karnal";

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1994");
        $(byText("1")).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath(imagePath);
        $("#currentAddress").setValue(address);
        $("#state").scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();
        //Form validation
        $("#example-modal-sizes-title-lg").shouldHave(
                text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(
                text("Label Value"),
                text("Student Name " + firstName + " " + lastName),
                text("Student Email " + email),
                text("Gender " + gender),
                text("Mobile " + phone),
                text("Date of Birth 01 August,1994"),
                text("Subjects " + subject),
                text("Hobbies Sports"),
                text("Picture Avatar.jpeg"),
                text("Address " + address),
                text("State and City " + state + " " + city));

        $("#closeLargeModal").click();


    }
}
