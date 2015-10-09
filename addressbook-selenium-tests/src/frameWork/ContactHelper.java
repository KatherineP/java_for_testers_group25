package frameWork;

import com.example.tests.ContactTests.ContactData;
import com.example.utils.SortedListOf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

    public static boolean CREATION = true;
    public static boolean MODIFICATION = false;

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    private List<ContactData> cachedContacts;


    public List<ContactData> getContacts() {
        if (cachedContacts == null){
            rebuildCache();
        } return  new ArrayList<ContactData>(cachedContacts);
    }

    private void rebuildCache() {
       cachedContacts = new ArrayList<ContactData>();
        manager.navigateTo().mainPage();
        List<WebElement> rows = getContactRows();
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            String firstname = columns.get(2).getText();
            String lastname = columns.get(1).getText();
            //String ID = row.getAttribute("id");
            String ID = columns.get(0).findElement(By.tagName("input")).getAttribute("value");
            cachedContacts.add(new ContactData().withFirstname(firstname).withLastname(lastname).withID(ID));
        }
    }

    public ContactHelper createContact(ContactData contact) {
        manager.navigateTo().mainPage();
        gotoNewContactPage();
        fillContactForm(contact, CREATION);
        submitContactCreation();
        returnToHomePage();
        rebuildCache();
        return this;
    }

    public ContactHelper removeContact(Integer index) {
        manager.navigateTo().mainPage();
        submitContactDelition(index);
        returnToHomePage();
        rebuildCache();
        return this;
    }

    public ContactHelper modifyContact(Integer index, ContactData contact) {
        manager.navigateTo().mainPage();
        initContactModification(index);
        fillContactForm(contact, true);
        updateContactModification();
        returnToHomePage();
        rebuildCache();
        return this;
    }
//----------------------------------------------------------------------------------------------------------------------
    public ContactHelper gotoNewContactPage() {
        manager.navigateTo().mainPage();
        click(By.linkText("add new"));
        return this;
    }

    public void submitContactDelition(int index) {
        selectAndEditContactByIndex(index);
        click(By.xpath("(//input[@name='update'])[2]"));
        //cachedContacts = null;
    }

    public ContactHelper fillContactForm(ContactData contactData, boolean formType) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHome());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
        selectByText(By.name("bday"), contactData.getBday());
        selectByText(By.name("bmonth"), contactData.getBmonth());
        type(By.name("byear"), contactData.getByear());
        if (formType == CREATION){
            //selectByText(By.name("new_group"), "Newtest");
        } else {
            if( driver.findElements(By.name("new_group")).size() != 0);
            throw new Error("Group selector exists is contact modification form");
        }
        return this;
    }

    public ContactHelper submitContactCreation() {

        click(By.name("submit"));
        cachedContacts = null;
        return this;
    }

    public ContactHelper returnToHomePage() {
        click(By.linkText("home page"));
        return this;
    }

    public void initContactModification(int index) {
        selectAndEditContactByIndex(index);
    }

    public void updateContactModification() {
        click(By.xpath("//input[11]"));
        //cachedContacts = null;
    }

    private void selectAndEditContactByIndex(int index) {
            click(By.xpath("//tr[@name='entry'][" + (index + 1) + "]/td/a/img[@title='Edit']"));  // почему тут нужно писать (index + 1)? а не просто index.
        //cachedContacts = null;
    }

    private List<WebElement> getContactRows() {      //находим строки
        return driver.findElements(By.name("entry"));
    }

}
