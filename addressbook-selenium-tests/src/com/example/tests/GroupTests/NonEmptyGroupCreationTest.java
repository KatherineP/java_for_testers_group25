package com.example.tests.GroupTests;
import com.example.tests.TestBase;
import com.example.utils.SortedListOf;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import static com.example.tests.GroupTests.GroupDataGenerator.loadGroupsFromCsvFile;
import static com.example.tests.GroupTests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class NonEmptyGroupCreationTest extends  TestBase{

    @DataProvider
    public Iterator<Object[]> groupsFromFile() throws IOException {
        return wrapGroupsForDataProvider(loadGroupsFromCsvFile(new File("groups.txt"))).iterator();
        //return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
    }



   @Test(dataProvider = "groupsFromFile")
        public void GroupCreationWithValidData (GroupData group)throws Exception {
            SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
            //actions
            app.getGroupHelper().createGroup(group);
            SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
            //compare states
            assertThat(newList, equalTo(oldList.withAdded(group)));
        }


    }

