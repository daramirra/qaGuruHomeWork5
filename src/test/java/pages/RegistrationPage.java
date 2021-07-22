package pages;

import com.codeborne.selenide.SelenideElement;
import components.Calendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class RegistrationPage {

    private final static String FORM_TITLE = "Student Registration Form";
    private final static String RESULTS_TITLE = "Thanks for submitting the form";

    private Calendar calendar = new Calendar();
    private SelenideElement modal = $("[role=dialog]");

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(FORM_TITLE));
        return this;
    }

    public RegistrationPage typeFirstName(String firstName){
        $("#firstName").setValue(firstName);
        return this;
    }

    public RegistrationPage typeLastName(String lastName){
        $("#lastName").setValue(lastName);
        return this;
    }

    public RegistrationPage typeEmail(String email){
        $("#userEmail").setValue(email);
        return this;
    }

    public RegistrationPage selectGender(String gender){
        $(format("[name=gender][value=%s]", gender)).parent().click();
        return this;
    }

    public RegistrationPage typePhone(String phone){
        $("#userNumber").setValue(phone);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year){
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage selectSubject(String subject){
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage selectHobby(String hobby){
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage selectFile(String path){
        $("#uploadPicture").uploadFromClasspath(path);
        return this;
    }

    public RegistrationPage typeAddress(String address){
        $("#currentAddress").setValue(address);
        return this;
    }

    public RegistrationPage selectState(String state){
        $("#react-select-3-input").setValue(state).pressEnter();
        return this;
    }

    public RegistrationPage selectCity(String city){
        $("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }

    public RegistrationPage saveForm(){
        $("#submit").scrollTo().click();
        return this;
    }

    public RegistrationPage checkResultsTitle(){
        modal.$(".modal-title").shouldHave(text(RESULTS_TITLE));
        return this;
    }

    public RegistrationPage checkResultsValue(String value){
        modal.$(".table-responsive").shouldHave(text(value));
        return this;
    }
}
