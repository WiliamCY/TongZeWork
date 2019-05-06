package com.example.administrator.tongze.List;

import java.util.List;

public class UserMessageList {

    /**
     * ret : 200
     * data : [{"user_id":"37","name":"曹坚立","come_time":"随时到岗","work_years":"3.0","manage_years":"3.0","school":"浙江大学","major":"软件工程","education_name":"硕士","sendout":"1","adjust":"1","skills":"擅长呢,哈哈哈","post_name":"总经理","adjustPos":["应收","主管"],"interview_flow_id":"27","interview_level":"1"},{"user_id":"29","name":"张三","come_time":"一周内到岗","work_years":"3.0","manage_years":"1.0","school":"浙江大学1111","major":"计算机","education_name":"高中","sendout":"1","adjust":"1","skills":"会玩1111","post_name":"策划","adjustPos":["策划"],"interview_flow_id":"13","interview_level":"1"},{"user_id":"28","name":"夏童豪","come_time":"随时到岗","work_years":"3.0","manage_years":"2.0","school":"宁波理工","major":"信息与计算科学","education_name":"高中","sendout":"1","adjust":"1","skills":"技能特长","post_name":"总经理","adjustPos":["策划","行政"],"interview_flow_id":"26","interview_level":"1"}]
     * msg :
     */

    private int ret;
    private String msg;
    private List<DataBean> data;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user_id : 37
         * name : 曹坚立
         * come_time : 随时到岗
         * work_years : 3.0
         * manage_years : 3.0
         * school : 浙江大学
         * major : 软件工程
         * education_name : 硕士
         * sendout : 1
         * adjust : 1
         * skills : 擅长呢,哈哈哈
         * post_name : 总经理
         * adjustPos : ["应收","主管"]
         * interview_flow_id : 27
         * interview_level : 1
         */

        private String user_id;
        private String name;
        private String come_time;
        private String work_years;
        private String manage_years;
        private String school;
        private String major;
        private String education_name;
        private String sendout;
        private String adjust;
        private String skills;
        private String post_name;
        private String interview_flow_id;
        private String interview_level;
        private List<String> adjustPos;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCome_time() {
            return come_time;
        }

        public void setCome_time(String come_time) {
            this.come_time = come_time;
        }

        public String getWork_years() {
            return work_years;
        }

        public void setWork_years(String work_years) {
            this.work_years = work_years;
        }

        public String getManage_years() {
            return manage_years;
        }

        public void setManage_years(String manage_years) {
            this.manage_years = manage_years;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public String getEducation_name() {
            return education_name;
        }

        public void setEducation_name(String education_name) {
            this.education_name = education_name;
        }

        public String getSendout() {
            return sendout;
        }

        public void setSendout(String sendout) {
            this.sendout = sendout;
        }

        public String getAdjust() {
            return adjust;
        }

        public void setAdjust(String adjust) {
            this.adjust = adjust;
        }

        public String getSkills() {
            return skills;
        }

        public void setSkills(String skills) {
            this.skills = skills;
        }

        public String getPost_name() {
            return post_name;
        }

        public void setPost_name(String post_name) {
            this.post_name = post_name;
        }

        public String getInterview_flow_id() {
            return interview_flow_id;
        }

        public void setInterview_flow_id(String interview_flow_id) {
            this.interview_flow_id = interview_flow_id;
        }

        public String getInterview_level() {
            return interview_level;
        }

        public void setInterview_level(String interview_level) {
            this.interview_level = interview_level;
        }

        public List<String> getAdjustPos() {
            return adjustPos;
        }

        public void setAdjustPos(List<String> adjustPos) {
            this.adjustPos = adjustPos;
        }
    }
}
