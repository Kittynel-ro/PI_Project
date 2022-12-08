package org.example;

public class Course {
    String title;
    int curAtt;
    int minCourseAtt;
    int minLabAtt;

    public Course(){
        title = "Course-title";
        curAtt = 0;
        minCourseAtt = 0;
        minLabAtt = 0;
    }

    public Course(String title, int curAtt, int minCourseAtt, int minLabAtts){
        this.title = title;
        this.minCourseAtt = minCourseAtt;
        this.minLabAtt = minLabAtts;
        this.curAtt = curAtt;
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", curAtt=" + curAtt +
                ", minCourseAtt=" + minCourseAtt +
                ", minLabAtt=" + minLabAtt +
                '}';
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getCurAtt() {
        return curAtt;
    }
    public void setCurAtt(int curAtt) {
        this.curAtt = curAtt;
    }
    public int getMinCourseAtt() {
        return minCourseAtt;
    }
    public void setMinCourseAtt(int minCourseAtt) {
        this.minCourseAtt = minCourseAtt;
    }
    public int getMinLabAtt() {
        return minLabAtt;
    }
    public void setMinLabAtt(int minLabAtt) {
        this.minLabAtt = minLabAtt;
    }


}
