package com.example.administrator.tongze.List;

public class MainList {
    private String MainName;
    private String come_time, work_years, manage_years, school, education_name, major, sendout, adjust, post_name, skills, mainName;
   public  MainList(String come_time,String work_years,String manage_years,String school,String education_name,String major,String sendout,String adjust,String post_name,String skills){

       this.come_time = come_time;
       this.work_years = work_years;
       this.manage_years = manage_years;
       this.school = school;
       this.education_name = education_name;
       this.major = major;
       this.sendout = sendout;
       this.adjust = adjust;
       this.post_name = post_name;

       this.skills = skills;
       this.mainName = mainName;
   }
    public String getMainName() {
        return MainName;
    }

    public void setMainName(String mainName) {
        MainName = mainName;
    }

    public String getAdjust() {
        return adjust;
    }


    public String getCome_time() {
        return come_time;
    }

    public String getEducation_name() {
        return education_name;
    }

    public String getMajor() {
        return major;
    }

    public String getManage_years() {
        return manage_years;
    }

    public String getPost_name() {
        return post_name;
    }

    public String getSchool() {
        return school;
    }

    public String getSendout() {
        return sendout;
    }

    public String getSkills() {
        return skills;
    }

    public String getWork_years() {
        return work_years;
    }

    public void setAdjust(String adjust) {
        this.adjust = adjust;
    }


    public void setCome_time(String come_time) {
        this.come_time = come_time;
    }

    public void setEducation_name(String education_name) {
        this.education_name = education_name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setManage_years(String manage_years) {
        this.manage_years = manage_years;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setSendout(String sendout) {
        this.sendout = sendout;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setWork_years(String work_years) {
        this.work_years = work_years;
    }

}
