package com.example.tests.GroupTests;

public class GroupData implements Comparable<GroupData>{
    private String groupName;
    private String header;
    private String footer;
    public GroupData() {

    }

    public GroupData(String groupName, String header, String footer) {
        this.groupName = groupName;
        this.header = header;
        this.footer = footer;
    }

    public String getHeader() {
        return header;
    }


    public String getFooter() {
        return footer;
    }


    public String getGroupName() {
        return groupName;
    }


    @Override
    public String toString() {
        return "GroupData{" +
                "groupName='" + groupName + '\'' +
                ", header='" + header + '\'' +
                ", footer='" + footer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupData)) return false;

        GroupData groupData = (GroupData) o;

        if (!groupName.equals(groupData.groupName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return groupName.hashCode();
    }

    @Override
    public int compareTo(GroupData other) {
        return this.groupName.toLowerCase().compareTo(other.groupName.toLowerCase());
    }

    public GroupData withGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }
}
