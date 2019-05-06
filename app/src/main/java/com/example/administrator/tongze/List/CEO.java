package com.example.administrator.tongze.List;

import java.util.List;

public class CEO {

    /**
     * ret : 200
     * data : [{"interviewer_user_id":"28","name":"夏童豪","main":"0","duty":null,"position":null},{"interviewer_user_id":"29","name":"张三","main":"1","duty":null,"position":null}]
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
         * interviewer_user_id : 28
         * name : 夏童豪
         * main : 0
         * duty : null
         * position : null
         */

        private String interviewer_user_id;
        private String name;
        private String main;
        private Object duty;
        private Object position;

        public String getInterviewer_user_id() {
            return interviewer_user_id;
        }

        public void setInterviewer_user_id(String interviewer_user_id) {
            this.interviewer_user_id = interviewer_user_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public Object getDuty() {
            return duty;
        }

        public void setDuty(Object duty) {
            this.duty = duty;
        }

        public Object getPosition() {
            return position;
        }

        public void setPosition(Object position) {
            this.position = position;
        }
    }
}
