package com.example.tests.GroupTests;

public class GroupData implements Comparable<GroupData>{
    public String groupName;
    public String header;
    public String footer;
    public GroupData() {

    }

    public GroupData(String groupName, String header, String footer) {
        this.groupName = groupName;
        this.header = header;
        this.footer = footer;
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
}
