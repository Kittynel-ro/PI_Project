package org.example;

import java.util.ArrayList;
import java.util.List;

public class Student {
    String name;
    int studID;
    List < Course > attCourses;

    public Student(){
        name = "STUDENT-NAME";
        studID = 1;
        attCourses = new ArrayList<>();
    }

    public Student(String name, int studID, List < Course > attCourses){
        this.name = name;
        this.studID = studID;
        this.attCourses = attCourses;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getStudID() {
        return studID;
    }
    public void setStudID(int studID) {
        this.studID = studID;
    }
    public List<Course> getAttCourses() {
        return attCourses;
    }
    public void setAttCourses(List<Course> attCourses) {
        this.attCourses = attCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studID=" + studID +
                ", attCourses=" + attCourses +
                '}';
    }
}
