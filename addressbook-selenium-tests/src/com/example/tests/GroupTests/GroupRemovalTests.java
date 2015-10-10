package com.example.tests.GroupTests;

import com.example.tests.TestBase;
import com.example.utils.SortedListOf;
import org.testng.annotations.Test;
import java.util.Random;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by Alex on 04.09.2015.
 */
public class GroupRemovalTests extends TestBase {

    @Test
    public void deleteSomeGroup(){
        SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        //actions
        app.getGroupHelper().deleteGroup(index);

        SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
        //compare states
        assertThat(newList, equalTo(oldList.without(index)));

    }
}
