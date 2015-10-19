package com.example.tests.ContactTests;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactDataGenerator {
    public static void main(String [] args) throws IOException {

        if(args.length < 3){
            System.out.println("Please specify parameters: <amount of test data> <file> <format>");
            return;
        }
        int amount = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        String format = args[2];
        if(file.exists()){
            System.out.println("File exists, please remove it manually: " + file);
            return;
        }
        List<ContactData> contacts = generateRandomContacts(amount);
        if("csv".equals(format)){
            saveContactsToCsvFile(contacts, file);
        }else if(format.equals("xml")){
            saveContactsToXmlFile(contacts, file);
        }else {
            System.out.println("Unknown format " + format);
            return;
        }
    }

    private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException{
        XStream xStream = new XStream();
        xStream.alias("contact", ContactData.class);
        String xml = xStream.toXML(contacts);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(xml);
        fileWriter.close();
    }
    public static List<ContactData> loadContactsFromXmlFile(File file) {
        XStream xStream = new XStream();
        xStream.alias("contact", ContactData.class);
        return (List<ContactData>) xStream.fromXML(file);
    }

    private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException{
        FileWriter fileWriter = new FileWriter(file);
        for(ContactData contact : contacts ){
            fileWriter.write(contact.getFirstname() + "," + contact.getLastname() + "," + contact.getAddress() + "," + contact.getHome() + ","
                    + contact.getMobile() + "," + contact.getEmail() + "," + contact.getBday() + "," + contact.getBmonth() + "," + contact.getByear() + ",!" + "\n");
        }
        fileWriter.close();
    }

    public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException{
        List<ContactData> list = new ArrayList<ContactData>();
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        while (line != null){
           String[] part = line.split(",");
            ContactData contact = new ContactData()
                    .withFirstname(part[0])
                    .withLastname(part[1])
                    .withAddress(part[2])
                    .withHome(part[3])
                    .withMobile(part[4])
                    .withEmail(part[5])
                    .withBday(part[6])
                    .withBmonth(part[7])
                    .withByear(part[8]);
            list.add(contact);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return  list;
    }

    public static List<ContactData> generateRandomContacts(int amount) {
        List<ContactData> list = new ArrayList<ContactData>();

        for (int i = 0; i < amount; i++) {

            ContactData contact = new ContactData()
                    .withFirstname(generateRandomString())
                    .withLastname(generateRandomString())
                    .withAddress(generateRandomString())
                    .withEmail(generateRandomEmail())
                    .withBday(generateRandomDay())
                    .withBmonth(generateRandomMonth())
                    .withByear(generateRandomYear());
            //contact.group = "";
            list.add(contact);
        }
        return list;
    }
    public static String generateRandomString(){
        Random random = new Random();
        if(random.nextInt(5) == 0) {
            return  "";
        } else {
            return "Newtest" + random.nextInt();
        }
    }

    public static String generateRandomEmail(){
        Random random = new Random();
        if(random.nextInt(3) == 0) {
            return  "";
        } else {
            return "test@test.test" + random.nextInt();
        }
    }


    public static String generateRandomDay(){
        Random random = new Random();
        int i = 1 + random.nextInt(30);
        String s = Integer.toString(i);

        if(random.nextInt(3) == 0) {
            return  "-";
        } else {
            return s;
        }
    }

    public static String generateRandomMonth() {
        Random random = new Random();
        String[] month = new String[]{"September", "November", "October", "December", "January", "February", "March", "April", "May", "June", "July", "August"};
        if (random.nextInt(3) == 0) {
            return "-";
        } else {
            return month[random.nextInt(month.length)];
        }
    }

    public static String generateRandomYear(){
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


