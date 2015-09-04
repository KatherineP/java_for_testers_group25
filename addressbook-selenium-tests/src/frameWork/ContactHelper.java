package frameWork;

import com.example.tests.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase{

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void gotoNewContactPage() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.firstname);
        type(By.name("lastname"), contactData.lastname);
        type(By.name("address"), contactData.address);
        type(By.name("home"), contactData.home);
        type(By.name("mobile"), contactData.mobile);
        type(By.name("email"), contactData.email);
        selectByText(By.name("bday"), contactData.bday);
        selectByText(By.name("bmonth"), contactData.bmonth);
        type(By.name("byear"), contactData.byear);
        selectByText(By.name("new_group"), contactData.group);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }
}
