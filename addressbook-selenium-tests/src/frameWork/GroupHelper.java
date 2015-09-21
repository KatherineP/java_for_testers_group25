package frameWork;

import com.example.tests.GroupTests.GroupData;
import com.example.utils.ListOf;
import com.example.utils.SortedListOf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends  HelperBase{
    public GroupHelper(ApplicationManager manager){
        super(manager);
    }

   private SortedListOf<GroupData> cachedGroups;


    public SortedListOf<GroupData> getGroups() {
        if (cachedGroups == null){
            rebuildCache();
        } return  cachedGroups;

    }

    private void rebuildCache() {

        cachedGroups = new SortedListOf<GroupData>();

        manager.navigateTo().groupsPage();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@name='selected[]']"));

        for (WebElement checkbox : checkboxes){

            String title = checkbox.getAttribute("title");
            String groupName = title.substring("Select (".length(), title.length() - ")".length());
            cachedGroups.add(new GroupData().withGroupName(groupName));
        }
    }

    public GroupHelper createGroup(GroupData group) {
        manager.navigateTo().groupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
        rebuildCache();
        return this;
    }
    public GroupHelper modifyGroup(int index, GroupData group) {
        manager.navigateTo().groupsPage();
        initGroupModification(index);
        fillGroupForm(group);
        submitGroupModification();
        returnToGroupPage();
        rebuildCache();
        return this;
    }
    public GroupHelper deleteGroup(int index) {
        selectGroupByIndex(index);
        submitGroupDelition();
        returnToGroupPage();
        rebuildCache();
        return this;
    }

    //-----------------------------------------------------------------------------------------------------------------


    public GroupHelper initGroupCreation() {
        manager.navigateTo().groupsPage();
        click(By.name("new"));
        return this;
    }

    public GroupHelper fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.getGroupName());
        type(By.name("group_header"), group.getHeader());
        type(By.name("group_footer"), group.getFooter());
        return this;
    }

    public GroupHelper submitGroupCreation() {
        click(By.name("submit"));
        cachedGroups = null;
        return this;
    }

    public GroupHelper returnToGroupPage() {
        click(By.linkText("group page"));
        return this;
    }


    public GroupHelper initGroupModification(int index) {
        selectGroupByIndex(index);
        click(By.name("edit"));
        return this;
    }

    public GroupHelper submitGroupModification() {
        click(By.name("update"));
        cachedGroups = null;
        return this;
    }

    private GroupHelper selectGroupByIndex(int index) {
        click(By.xpath("//input[@name='selected[]'][" + (index + 1) + "]"));
        return this;
    }

    public GroupHelper submitGroupDelition() {
        click(By.name("delete"));
        cachedGroups = null;
        return this;
    }


}
