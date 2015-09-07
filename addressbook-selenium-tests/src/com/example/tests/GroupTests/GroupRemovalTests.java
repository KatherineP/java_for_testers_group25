package com.example.tests.GroupTests;

import com.example.tests.TestBase;
import org.testng.annotations.Test;

/**
 * Created by Alex on 04.09.2015.
 */
public class GroupRemovalTests extends TestBase {

    @Test
    public void deleteSomeGroup(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().goToGroupsPage();
        app.getGroupHelper().deleteGroup(1);
        app.getGroupHelper().returnToGroupPage();
    }
}
