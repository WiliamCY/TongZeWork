package com.example.administrator.tongze.List;

import java.util.List;

public class BasicInformationList {


    /**
     * ret : 200
     * data : {"id":"6","user_id":"28","name":"夏童豪","identity_card":"330283199603132758","email":"caojianli1989@126.com","native_place":"浙江宁波","nationality_id":"1","nationality":"汉族","politics":"2","stature":"180","weight":"60","married":"0","birth":"0","phone":"18268697597","sex":"0","school":"宁波理工","major":"信息与计算科学","entrance_timestamp":"1409500800","graduate_timestamp":"1527782400","education_id":"1","education":"高中","full_time":"1","employ_post_id":"1","employ_post":"总经理","work_years":"3.0","manage_years":"2.0","come_time":"随时到岗","sendout":"1","adjust":"1","driving_license":"1","driving_years":"5.0","english_level_id":"1","english_level":"雅思7","foreign_languages":"","skills":"技能特长","emp_type":"0","referrals":"0","referrals_name":"","native_location_id":"330212","native_address":"世纪大道","current_location_id":"310300","current_address":"中山路","emergency_contact":"张三","emergency_relation":"兄弟","emergency_phone":"17682453143","emergency_address":"宁波奉化","native_location_detail":[{"id":"330000","name":"浙江省","arealevel":"1","parent_id":"0"},{"id":"330200","name":"宁波市","arealevel":"2","parent_id":"330000"},{"id":"330212","name":"鄞州区","arealevel":"3","parent_id":"330200"}],"native_location_name":"浙江省_宁波市_鄞州区","current_location_detail":[{"id":"310000","name":"上海市","arealevel":"1","parent_id":"0"},{"id":"310300","name":"长宁区","arealevel":"2","parent_id":"310000"}],"current_location_name":"上海市_长宁区","birthday":"19960313","animal":"鼠","constellation":"双鱼座","education_his":[{"id":"5","user_id":"28","school":"浙江大学","education_id":"1","major":"计算机","full_time":"1","start_timestamp":"1409500800","finish_timestamp":"1527782400","highest":"0","delete_flag":"0","education":"高中"},{"id":"10","user_id":"28","school":"宁波理工","education_id":"1","major":"信息与计算科学","full_time":"1","start_timestamp":"1409500800","finish_timestamp":"1527782400","highest":"0","delete_flag":"0","education":"高中"},{"id":"33","user_id":"28","school":"宁波理工","education_id":"1","major":"信息与计算科学","full_time":"1","start_timestamp":"1409500800","finish_timestamp":"1527782400","highest":"1","delete_flag":"0","education":"高中"}],"family_member":[{"id":"5","user_id":"28","relation":"1","name":"王五","work":"员工","work_place":"宁波鄞州区","phone":"17682453143","delete_flag":"0"},{"id":"6","user_id":"28","relation":"3","name":"李四","work":"老板老板","work_place":"宁波江北区江北区","phone":"15258209684","delete_flag":"0"}],"award_punishment":[{"id":"1","user_id":"28","type":"1","desp":"2010年获得国家奖学金","delete_flag":"0"},{"id":"2","user_id":"28","type":"1","desp":"2010年获得省奖学金","delete_flag":"0"}]}
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
        /**
         * id : 6
         * user_id : 28
         * name : 夏童豪
         * identity_card : 330283199603132758
         * email : caojianli1989@126.com
         * native_place : 浙江宁波
         * nationality_id : 1
         * nationality : 汉族
         * politics : 2
         * stature : 180
         * weight : 60
         * married : 0
         * birth : 0
         * phone : 18268697597
         * sex : 0
         * school : 宁波理工
         * major : 信息与计算科学
         * entrance_timestamp : 1409500800
         * graduate_timestamp : 1527782400
         * education_id : 1
         * education : 高中
         * full_time : 1
         * employ_post_id : 1
         * employ_post : 总经理
         * work_years : 3.0
         * manage_years : 2.0
         * come_time : 随时到岗
         * sendout : 1
         * adjust : 1
         * driving_license : 1
         * driving_years : 5.0
         * english_level_id : 1
         * english_level : 雅思7
         * foreign_languages :
         * skills : 技能特长
         * emp_type : 0
         * referrals : 0
         * referrals_name :
         * native_location_id : 330212
         * native_address : 世纪大道
         * current_location_id : 310300
         * current_address : 中山路
         * emergency_contact : 张三
         * emergency_relation : 兄弟
         * emergency_phone : 17682453143
         * emergency_address : 宁波奉化
         * native_location_detail : [{"id":"330000","name":"浙江省","arealevel":"1","parent_id":"0"},{"id":"330200","name":"宁波市","arealevel":"2","parent_id":"330000"},{"id":"330212","name":"鄞州区","arealevel":"3","parent_id":"330200"}]
         * native_location_name : 浙江省_宁波市_鄞州区
         * current_location_detail : [{"id":"310000","name":"上海市","arealevel":"1","parent_id":"0"},{"id":"310300","name":"长宁区","arealevel":"2","parent_id":"310000"}]
         * current_location_name : 上海市_长宁区
         * birthday : 19960313
         * animal : 鼠
         * constellation : 双鱼座
         * education_his : [{"id":"5","user_id":"28","school":"浙江大学","education_id":"1","major":"计算机","full_time":"1","start_timestamp":"1409500800","finish_timestamp":"1527782400","highest":"0","delete_flag":"0","education":"高中"},{"id":"10","user_id":"28","school":"宁波理工","education_id":"1","major":"信息与计算科学","full_time":"1","start_timestamp":"1409500800","finish_timestamp":"1527782400","highest":"0","delete_flag":"0","education":"高中"},{"id":"33","user_id":"28","school":"宁波理工","education_id":"1","major":"信息与计算科学","full_time":"1","start_timestamp":"1409500800","finish_timestamp":"1527782400","highest":"1","delete_flag":"0","education":"高中"}]
         * family_member : [{"id":"5","user_id":"28","relation":"1","name":"王五","work":"员工","work_place":"宁波鄞州区","phone":"17682453143","delete_flag":"0"},{"id":"6","user_id":"28","relation":"3","name":"李四","work":"老板老板","work_place":"宁波江北区江北区","phone":"15258209684","delete_flag":"0"}]
         * award_punishment : [{"id":"1","user_id":"28","type":"1","desp":"2010年获得国家奖学金","delete_flag":"0"},{"id":"2","user_id":"28","type":"1","desp":"2010年获得省奖学金","delete_flag":"0"}]
         */

        private String id;
        private String user_id;
        private String name;
        private String identity_card;
        private String email;
        private String native_place;
        private String nationality_id;
        private String nationality;
        private String politics;
        private String stature;
        private String weight;
        private String married;
        private String birth;
        private String phone;
        private String sex;
        private String school;
        private String major;
        private String entrance_timestamp;
        private String graduate_timestamp;
        private String education_id;
        private String education;
        private String full_time;
        private String employ_post_id;
        private String employ_post;
        private String work_years;
        private String manage_years;
        private String come_time;
        private String sendout;
        private String adjust;
        private String driving_license;
        private String driving_years;
        private String english_level_id;
        private String english_level;
        private String foreign_languages;
        private String skills;
        private String emp_type;
        private String referrals;
        private String referrals_name;
        private String native_location_id;
        private String native_address;
        private String current_location_id;
        private String current_address;
        private String emergency_contact;
        private String emergency_relation;
        private String emergency_phone;
        private String emergency_address;
        private String native_location_name;
        private String current_location_name;
        private String birthday;
        private String animal;
        private String constellation;
        private List<NativeLocationDetailBean> native_location_detail;
        private List<CurrentLocationDetailBean> current_location_detail;
        private List<EducationHisBean> education_his;
        private List<FamilyMemberBean> family_member;
        private List<AwardPunishmentBean> award_punishment;

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

        public String getIdentity_card() {
            return identity_card;
        }

        public void setIdentity_card(String identity_card) {
            this.identity_card = identity_card;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNative_place() {
            return native_place;
        }

        public void setNative_place(String native_place) {
            this.native_place = native_place;
        }

        public String getNationality_id() {
            return nationality_id;
        }

        public void setNationality_id(String nationality_id) {
            this.nationality_id = nationality_id;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public String getPolitics() {
            return politics;
        }

        public void setPolitics(String politics) {
            this.politics = politics;
        }

        public String getStature() {
            return stature;
        }

        public void setStature(String stature) {
            this.stature = stature;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getMarried() {
            return married;
        }

        public void setMarried(String married) {
            this.married = married;
        }

        public String getBirth() {
            return birth;
        }

        public void setBirth(String birth) {
            this.birth = birth;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
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

        public String getEntrance_timestamp() {
            return entrance_timestamp;
        }

        public void setEntrance_timestamp(String entrance_timestamp) {
            this.entrance_timestamp = entrance_timestamp;
        }

        public String getGraduate_timestamp() {
            return graduate_timestamp;
        }

        public void setGraduate_timestamp(String graduate_timestamp) {
            this.graduate_timestamp = graduate_timestamp;
        }

        public String getEducation_id() {
            return education_id;
        }

        public void setEducation_id(String education_id) {
            this.education_id = education_id;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getFull_time() {
            return full_time;
        }

        public void setFull_time(String full_time) {
            this.full_time = full_time;
        }

        public String getEmploy_post_id() {
            return employ_post_id;
        }

        public void setEmploy_post_id(String employ_post_id) {
            this.employ_post_id = employ_post_id;
        }

        public String getEmploy_post() {
            return employ_post;
        }

        public void setEmploy_post(String employ_post) {
            this.employ_post = employ_post;
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

        public String getCome_time() {
            return come_time;
        }

        public void setCome_time(String come_time) {
            this.come_time = come_time;
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

        public String getDriving_license() {
            return driving_license;
        }

        public void setDriving_license(String driving_license) {
            this.driving_license = driving_license;
        }

        public String getDriving_years() {
            return driving_years;
        }

        public void setDriving_years(String driving_years) {
            this.driving_years = driving_years;
        }

        public String getEnglish_level_id() {
            return english_level_id;
        }

        public void setEnglish_level_id(String english_level_id) {
            this.english_level_id = english_level_id;
        }

        public String getEnglish_level() {
            return english_level;
        }

        public void setEnglish_level(String english_level) {
            this.english_level = english_level;
        }

        public String getForeign_languages() {
            return foreign_languages;
        }

        public void setForeign_languages(String foreign_languages) {
            this.foreign_languages = foreign_languages;
        }

        public String getSkills() {
            return skills;
        }

        public void setSkills(String skills) {
            this.skills = skills;
        }

        public String getEmp_type() {
            return emp_type;
        }

        public void setEmp_type(String emp_type) {
            this.emp_type = emp_type;
        }

        public String getReferrals() {
            return referrals;
        }

        public void setReferrals(String referrals) {
            this.referrals = referrals;
        }

        public String getReferrals_name() {
            return referrals_name;
        }

        public void setReferrals_name(String referrals_name) {
            this.referrals_name = referrals_name;
        }

        public String getNative_location_id() {
            return native_location_id;
        }

        public void setNative_location_id(String native_location_id) {
            this.native_location_id = native_location_id;
        }

        public String getNative_address() {
            return native_address;
        }

        public void setNative_address(String native_address) {
            this.native_address = native_address;
        }

        public String getCurrent_location_id() {
            return current_location_id;
        }

        public void setCurrent_location_id(String current_location_id) {
            this.current_location_id = current_location_id;
        }

        public String getCurrent_address() {
            return current_address;
        }

        public void setCurrent_address(String current_address) {
            this.current_address = current_address;
        }

        public String getEmergency_contact() {
            return emergency_contact;
        }

        public void setEmergency_contact(String emergency_contact) {
            this.emergency_contact = emergency_contact;
        }

        public String getEmergency_relation() {
            return emergency_relation;
        }

        public void setEmergency_relation(String emergency_relation) {
            this.emergency_relation = emergency_relation;
        }

        public String getEmergency_phone() {
            return emergency_phone;
        }

        public void setEmergency_phone(String emergency_phone) {
            this.emergency_phone = emergency_phone;
        }

        public String getEmergency_address() {
            return emergency_address;
        }

        public void setEmergency_address(String emergency_address) {
            this.emergency_address = emergency_address;
        }

        public String getNative_location_name() {
            return native_location_name;
        }

        public void setNative_location_name(String native_location_name) {
            this.native_location_name = native_location_name;
        }

        public String getCurrent_location_name() {
            return current_location_name;
        }

        public void setCurrent_location_name(String current_location_name) {
            this.current_location_name = current_location_name;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getAnimal() {
            return animal;
        }

        public void setAnimal(String animal) {
            this.animal = animal;
        }

        public String getConstellation() {
            return constellation;
        }

        public void setConstellation(String constellation) {
            this.constellation = constellation;
        }

        public List<NativeLocationDetailBean> getNative_location_detail() {
            return native_location_detail;
        }

        public void setNative_location_detail(List<NativeLocationDetailBean> native_location_detail) {
            this.native_location_detail = native_location_detail;
        }

        public List<CurrentLocationDetailBean> getCurrent_location_detail() {
            return current_location_detail;
        }

        public void setCurrent_location_detail(List<CurrentLocationDetailBean> current_location_detail) {
            this.current_location_detail = current_location_detail;
        }

        public List<EducationHisBean> getEducation_his() {
            return education_his;
        }

        public void setEducation_his(List<EducationHisBean> education_his) {
            this.education_his = education_his;
        }

        public List<FamilyMemberBean> getFamily_member() {
            return family_member;
        }

        public void setFamily_member(List<FamilyMemberBean> family_member) {
            this.family_member = family_member;
        }

        public List<AwardPunishmentBean> getAward_punishment() {
            return award_punishment;
        }

        public void setAward_punishment(List<AwardPunishmentBean> award_punishment) {
            this.award_punishment = award_punishment;
        }

        public static class NativeLocationDetailBean {
            /**
             * id : 330000
             * name : 浙江省
             * arealevel : 1
             * parent_id : 0
             */

            private String id;
            private String name;
            private String arealevel;
            private String parent_id;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getArealevel() {
                return arealevel;
            }

            public void setArealevel(String arealevel) {
                this.arealevel = arealevel;
            }

            public String getParent_id() {
                return parent_id;
            }

            public void setParent_id(String parent_id) {
                this.parent_id = parent_id;
            }
        }

        public static class CurrentLocationDetailBean {
            /**
             * id : 310000
             * name : 上海市
             * arealevel : 1
             * parent_id : 0
             */

            private String id;
            private String name;
            private String arealevel;
            private String parent_id;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getArealevel() {
                return arealevel;
            }

            public void setArealevel(String arealevel) {
                this.arealevel = arealevel;
            }

            public String getParent_id() {
                return parent_id;
            }

            public void setParent_id(String parent_id) {
                this.parent_id = parent_id;
            }
        }

        public static class EducationHisBean {
            /**
             * id : 5
             * user_id : 28
             * school : 浙江大学
             * education_id : 1
             * major : 计算机
             * full_time : 1
             * start_timestamp : 1409500800
             * finish_timestamp : 1527782400
             * highest : 0
             * delete_flag : 0
             * education : 高中
             */

            private String id;
            private String user_id;
            private String school;
            private String education_id;
            private String major;
            private String full_time;
            private String start_timestamp;
            private String finish_timestamp;
            private String highest;
            private String delete_flag;
            private String education;

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

            public String getSchool() {
                return school;
            }

            public void setSchool(String school) {
                this.school = school;
            }

            public String getEducation_id() {
                return education_id;
            }

            public void setEducation_id(String education_id) {
                this.education_id = education_id;
            }

            public String getMajor() {
                return major;
            }

            public void setMajor(String major) {
                this.major = major;
            }

            public String getFull_time() {
                return full_time;
            }

            public void setFull_time(String full_time) {
                this.full_time = full_time;
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

            public String getHighest() {
                return highest;
            }

            public void setHighest(String highest) {
                this.highest = highest;
            }

            public String getDelete_flag() {
                return delete_flag;
            }

            public void setDelete_flag(String delete_flag) {
                this.delete_flag = delete_flag;
            }

            public String getEducation() {
                return education;
            }

            public void setEducation(String education) {
                this.education = education;
            }
        }

        public static class FamilyMemberBean {
            /**
             * id : 5
             * user_id : 28
             * relation : 1
             * name : 王五
             * work : 员工
             * work_place : 宁波鄞州区
             * phone : 17682453143
             * delete_flag : 0
             */

            private String id;
            private String user_id;
            private String relation;
            private String name;
            private String work;
            private String work_place;
            private String phone;
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

            public String getRelation() {
                return relation;
            }

            public void setRelation(String relation) {
                this.relation = relation;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getWork() {
                return work;
            }

            public void setWork(String work) {
                this.work = work;
            }

            public String getWork_place() {
                return work_place;
            }

            public void setWork_place(String work_place) {
                this.work_place = work_place;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getDelete_flag() {
                return delete_flag;
            }

            public void setDelete_flag(String delete_flag) {
                this.delete_flag = delete_flag;
            }
        }

        public static class AwardPunishmentBean {
            /**
             * id : 1
             * user_id : 28
             * type : 1
             * desp : 2010年获得国家奖学金
             * delete_flag : 0
             */

            private String id;
            private String user_id;
            private String type;
            private String desp;
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

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getDesp() {
                return desp;
            }

            public void setDesp(String desp) {
                this.desp = desp;
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
