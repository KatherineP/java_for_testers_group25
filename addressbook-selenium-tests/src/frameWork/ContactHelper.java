package frameWork;

import com.example.tests.ContactTests.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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


    public void deleteGroup(int index) {
        selectAndEditContactByIndex(index);
      click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void initContactModification(int index) {
        selectAndEditContactByIndex(index);
    }

    public void updateContactModification() {
        click(By.xpath("//input[11]"));
    }

    private void selectAndEditContactByIndex(int index) {
        click(By.xpath("//tr[" + index + "]/td[7]/a"));
    }


    public List<ContactData> getContacts() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> checkboxes =  driver.findElements(By.name("selected[]"));

        for (WebElement checkbox : checkboxes){
            ContactData contact = new ContactData();
            String accept = checkbox.getAttribute("accept");
            contact.email= accept.substring(accept.length());
            contacts.add(contact);
        }

        return contacts;
    }
}
