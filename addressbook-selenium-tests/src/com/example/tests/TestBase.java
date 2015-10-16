package com.example.tests;

import com.example.tests.ContactTests.ContactData;
import com.example.tests.GroupTests.GroupData;
import static com.example.tests.GroupTests.GroupDataGenerator.generateRandomGroups;
import frameWork.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.util.*;

public class TestBase {

    protected ApplicationManager app;

    @BeforeTest
    public void setUp() throws Exception {
        String configFile = System.getProperty("configFile", "application.properties");
        Properties properties = new Properties();
             properties.load(new FileReader(new File(configFile)));
        app = new ApplicationManager(properties);

    }

    @AfterTest
    public void tearDown() throws Exception {
        app.stop();

    }

    @DataProvider
    public Iterator<Object[]> randomValidGroupsGenerator() {
        return wrapGropsForDataProvider(generateRandomGroups(5)).iterator();
    }

    public static List<Object[]> wrapGropsForDataProvider(List<GroupData> groups) {
        List<Object[]> list = new ArrayList<Object[]>();
        for(GroupData group : groups ){
            list.add(new Object[]{group});
        }
        return list;
    }


    @DataProvider
    public Iterator<Object[]> randomValidContactsGenerator(){
        List<Object[]> list = new ArrayList<Object[]>();

        for (int i = 0; i < 3; i++) {

            ContactData contact = new ContactData()
                    .withFirstname(generateRandomString())
                    .withLastname(generateRandomString())
                    .withAddress(generateRandomString())
                    .withEmail(generateRandomEmail())
                    .withBday(generateRandomDay())
                    .withBmonth(generateRandomMonth())
                    .withByear(generateRandomYear());
            //contact.group = "";
            list.add(new Object[]{contact});
        }
        return list.iterator();
    }

    public String generateRandomString(){
        Random random = new Random();
        if(random.nextInt(5) == 0) {
            return  "";
        } else {
            return "Newtest" + random.nextInt();
        }
    }

    public String generateRandomEmail(){
        Random random = new Random();
        if(random.nextInt(3) == 0) {
            return  "";
        } else {
            return "test@test.test" + random.nextInt();
        }
    }


    public String generateRandomDay(){
        Random random = new Random();
        int i = 1 + random.nextInt(30);
        String s = Integer.toString(i);

        if(random.nextInt(3) == 0) {
            return  "-";
        } else {
            return s;
        }
    }

    public String generateRandomMonth() {
        Random random = new Random();
        String[] month = new String[]{"September", "November", "October", "December", "January", "February", "March", "April", "May", "June", "July", "August"};
        if (random.nextInt(3) == 0) {
            return "-";
        } else {
            return month[random.nextInt(month.length)];
        }
    }

    public String generateRandomYear(){
        Random random = new Random();
        int i = 1930 + random.nextInt(85);
        String s = Integer.toString(i);

        if(random.nextInt(3) == 0) {
            return  "";
        } else {
            return s;
        }
    }




}
