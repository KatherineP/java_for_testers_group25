package com.example.tests.GroupTests;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Alex on 10.10.2015.
 */
public class GroupDataGenerator {
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
        List<GroupData> groups = generateRandomGroups(amount);
        if("csv".equals(format)){
            saveGroupsToCsvFile(groups, file);
        }else if(format.equals("xml")){
            saveGroupsToXmlFile(groups, file);
        }else {
            System.out.println("Unknown format " + format);
            return;
        }
    }

    public static void saveGroupsToXmlFile(List<GroupData> groups, File file) throws IOException {
    XStream xStream = new XStream();
        String xml = xStream.toXML(groups);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(xml);
        fileWriter.close();
    }

    public static List<GroupData> loadGroupsFromXmlFile(File file) {
return  null;
    }

    public static void saveGroupsToCsvFile(List<GroupData> groups, File file) throws IOException{

          FileWriter fileWriter = new FileWriter(file);
        for(GroupData group : groups ){
            fileWriter.write(group.getGroupName() + "," + group.getHeader() + "," + group.getFooter() + ",!" + "\n");
        }
        fileWriter.close();
    }

    public static List<GroupData> loadGroupsFromCsvFile(File file) throws IOException {
        List<GroupData> list = new ArrayList<GroupData>();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.readLine();
        String line = bufferedReader.readLine();
        while(line != null){
           String[] part =  line.split(",");
            GroupData groupData = new GroupData()
                    .withGroupName(part[0])
                    .withHeader(part[1])
                    .withFooter(part[2]);
            list.add(groupData);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return list;
    }


    public static List<GroupData> generateRandomGroups(int amount) {
        List<GroupData> list = new ArrayList<GroupData>();

        for (int i = 0; i < amount; i++) {

            GroupData group = new GroupData()
                    .withGroupName(generateRandomString())
                    .withHeader(generateRandomString())
                    .withFooter(generateRandomString());
            list.add(group);
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
}
