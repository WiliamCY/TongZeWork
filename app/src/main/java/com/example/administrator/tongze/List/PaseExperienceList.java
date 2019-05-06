package com.example.administrator.tongze.List;

import java.util.List;

public class PaseExperienceList {

    /**
     * ret : 200
     * data : {"workExperienceHis":[{"id":"4","user_id":"28","company":"林枫科技","duty":"web前端","company_phone":"18268697597","salary":"6000","start_timestamp":"1454256000","finish_timestamp":"1535731200","dimission_reason":"离职原因离职原因","delete_flag":"0"}],"impoProjectHis":[{"id":"14","user_id":"28","name":"母婴App","company":"林枫科技","certifier":"王五","cer_phone":"13429313170","desp":"项目描述项目描述项目描述","result":"项目心得项目心得项目心得项目心得项目心得项目心得项目心得","start_timestamp":"1533052800","finish_timestamp":"1543593600","delete_flag":"0"},{"id":"13","user_id":"28","name":"商城App","company":"林枫科技","certifier":"李四","cer_phone":"17606568212","desp":"项目描述项目描述项目描述","result":"项目心得项目心得项目心得项目心得项目心得项目心得项目心得","start_timestamp":"1469980800","finish_timestamp":"1535731200","delete_flag":"0"}],"impoWorkHis":[{"id":"5","user_id":"28","name":"web前端","company":"林枫科技","certifier":"王五","cer_phone":"15258209684","desp":"工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述","result":"工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得","start_timestamp":"1493568000","finish_timestamp":"1533052800","delete_flag":"0"},{"id":"4","user_id":"28","name":"web前端","company":"野果网络科技","certifier":"张三","cer_phone":"18906625981","desp":"工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述","result":"工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得","start_timestamp":"1462032000","finish_timestamp":"1490976000","delete_flag":"0"}]}
     * msg :
     */

    private int ret;
    private DataBean data;
    private String msg;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        private List<WorkExperienceHisBean> workExperienceHis;
        private List<ImpoProjectHisBean> impoProjectHis;
        private List<ImpoWorkHisBean> impoWorkHis;

        public List<WorkExperienceHisBean> getWorkExperienceHis() {
            return workExperienceHis;
        }

        public void setWorkExperienceHis(List<WorkExperienceHisBean> workExperienceHis) {
            this.workExperienceHis = workExperienceHis;
        }

        public List<ImpoProjectHisBean> getImpoProjectHis() {
            return impoProjectHis;
        }

        public void setImpoProjectHis(List<ImpoProjectHisBean> impoProjectHis) {
            this.impoProjectHis = impoProjectHis;
        }

        public List<ImpoWorkHisBean> getImpoWorkHis() {
            return impoWorkHis;
        }

        public void setImpoWorkHis(List<ImpoWorkHisBean> impoWorkHis) {
            this.impoWorkHis = impoWorkHis;
        }

        public static class WorkExperienceHisBean {
            /**
             * id : 4
             * user_id : 28
             * company : 林枫科技
             * duty : web前端
             * company_phone : 18268697597
             * salary : 6000
             * start_timestamp : 1454256000
             * finish_timestamp : 1535731200
             * dimission_reason : 离职原因离职原因
             * delete_flag : 0
             */

            private String id;
            private String user_id;
            private String company;
            private String duty;
            private String company_phone;
            private String salary;
            private String start_timestamp;
            private String finish_timestamp;
            private String dimission_reason;
            private String delete_flag;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getDuty() {
                return duty;
            }

            public void setDuty(String duty) {
                this.duty = duty;
            }

            public String getCompany_phone() {
                return company_phone;
            }

            public void setCompany_phone(String company_phone) {
                this.company_phone = company_phone;
            }

            public String getSalary() {
                return salary;
            }

            public void setSalary(String salary) {
                this.salary = salary;
            }

            public String getStart_timestamp() {
                return start_timestamp;
            }

            public void setStart_timestamp(String start_timestamp) {
                this.start_timestamp = start_timestamp;
            }

            public String getFinish_timestamp() {
                return finish_timestamp;
            }

            public void setFinish_timestamp(String finish_timestamp) {
                this.finish_timestamp = finish_timestamp;
            }

            public String getDimission_reason() {
                return dimission_reason;
            }

            public void setDimission_reason(String dimission_reason) {
                this.dimission_reason = dimission_reason;
            }

            public String getDelete_flag() {
                return delete_flag;
            }

            public void setDelete_flag(String delete_flag) {
                this.delete_flag = delete_flag;
            }
        }

        public static class ImpoProjectHisBean {
            /**
             * id : 14
             * user_id : 28
             * name : 母婴App
             * company : 林枫科技
             * certifier : 王五
             * cer_phone : 13429313170
             * desp : 项目描述项目描述项目描述
             * result : 项目心得项目心得项目心得项目心得项目心得项目心得项目心得
             * start_timestamp : 1533052800
             * finish_timestamp : 1543593600
             * delete_flag : 0
             */

            private String id;
            private String user_id;
            private String name;
            private String company;
            private String certifier;
            private String cer_phone;
            private String desp;
            private String result;
            private String start_timestamp;
            private String finish_timestamp;
            private String delete_flag;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

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

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getCertifier() {
                return certifier;
            }

            public void setCertifier(String certifier) {
                this.certifier = certifier;
            }

            public String getCer_phone() {
                return cer_phone;
            }

            public void setCer_phone(String cer_phone) {
                this.cer_phone = cer_phone;
            }

            public String getDesp() {
                return desp;
            }

            public void setDesp(String desp) {
                this.desp = desp;
            }

            public String getResult() {
                return result;
            }

            public void setResult(String result) {
                this.result = result;
            }

            public String getStart_timestamp() {
                return start_timestamp;
            }

            public void setStart_timestamp(String start_timestamp) {
                this.start_timestamp = start_timestamp;
            }

            public String getFinish_timestamp() {
                return finish_timestamp;
            }

            public void setFinish_timestamp(String finish_timestamp) {
                this.finish_timestamp = finish_timestamp;
            }

            public String getDelete_flag() {
                return delete_flag;
            }

            public void setDelete_flag(String delete_flag) {
                this.delete_flag = delete_flag;
            }
        }

        public static class ImpoWorkHisBean {
            /**
             * id : 5
             * user_id : 28
             * name : web前端
             * company : 林枫科技
             * certifier : 王五
             * cer_phone : 15258209684
             * desp : 工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述
             * result : 工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得
             * start_timestamp : 1493568000
             * finish_timestamp : 1533052800
             * delete_flag : 0
             */

            private String id;
            private String user_id;
            private String name;
            private String company;
            private String certifier;
            private String cer_phone;
            private String desp;
            private String result;
            private String start_timestamp;
            private String finish_timestamp;
            private String delete_flag;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

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

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getCertifier() {
                return certifier;
            }

            public void setCertifier(String certifier) {
                this.certifier = certifier;
            }

            public String getCer_phone() {
                return cer_phone;
            }

            public void setCer_phone(String cer_phone) {
                this.cer_phone = cer_phone;
            }

            public String getDesp() {
                return desp;
            }

            public void setDesp(String desp) {
                this.desp = desp;
            }

            public String getResult() {
                return result;
            }

            public void setResult(String result) {
                this.result = result;
            }

            public String getStart_timestamp() {
                return start_timestamp;
            }

            public void setStart_timestamp(String start_timestamp) {
                this.start_timestamp = start_timestamp;
            }

            public String getFinish_timestamp() {
                return finish_timestamp;
            }

            public void setFinish_timestamp(String finish_timestamp) {
                this.finish_timestamp = finish_timestamp;
            }

            public String getDelete_flag() {
                return delete_flag;
            }

            public void setDelete_flag(String delete_flag) {
                this.delete_flag = delete_flag;
            }
        }
    }
}
