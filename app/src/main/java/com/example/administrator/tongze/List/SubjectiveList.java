package com.example.administrator.tongze.List;

import java.util.List;

public class SubjectiveList {

    /**
     * ret : 200
     * data : {"items":[{"id":"61","exam_type":"0","reference":"根据上述问题的回答，应聘者最突出的一项或几项特质是：（选择其他可输入）\t\t\t\t \t\t\t\t","iq_words":"反应敏捷,思路清晰,分析全面 透彻,学习能力强,眼界开阔,专业知识","eq_words":"自控力,沟通力,情绪化严重,理性客观,感性,礼貌谦逊,善于说服,积极乐观","work_words":"领导力,应变力,执行力强,抗压能力强,计划长远,主动,勤奋努力,周到细致,分清轻重缓急","common_words":"自信,骄傲,温和,火爆,慢热,直爽,惜字如金,滔滔不绝","delete_flag":"0"}],"count":"1"}
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
         * items : [{"id":"61","exam_type":"0","reference":"根据上述问题的回答，应聘者最突出的一项或几项特质是：（选择其他可输入）\t\t\t\t \t\t\t\t","iq_words":"反应敏捷,思路清晰,分析全面 透彻,学习能力强,眼界开阔,专业知识","eq_words":"自控力,沟通力,情绪化严重,理性客观,感性,礼貌谦逊,善于说服,积极乐观","work_words":"领导力,应变力,执行力强,抗压能力强,计划长远,主动,勤奋努力,周到细致,分清轻重缓急","common_words":"自信,骄傲,温和,火爆,慢热,直爽,惜字如金,滔滔不绝","delete_flag":"0"}]
         * count : 1
         */

        private String count;
        private List<ItemsBean> items;

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * id : 61
             * exam_type : 0
             * reference : 根据上述问题的回答，应聘者最突出的一项或几项特质是：（选择其他可输入）
             * iq_words : 反应敏捷,思路清晰,分析全面 透彻,学习能力强,眼界开阔,专业知识
             * eq_words : 自控力,沟通力,情绪化严重,理性客观,感性,礼貌谦逊,善于说服,积极乐观
             * work_words : 领导力,应变力,执行力强,抗压能力强,计划长远,主动,勤奋努力,周到细致,分清轻重缓急
             * common_words : 自信,骄傲,温和,火爆,慢热,直爽,惜字如金,滔滔不绝
             * delete_flag : 0
             */

            private String id;
            private String exam_type;
            private String reference;
            private String iq_words;
            private String eq_words;
            private String work_words;
            private String common_words;
            private String delete_flag;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getExam_type() {
                return exam_type;
            }

            public void setExam_type(String exam_type) {
                this.exam_type = exam_type;
            }

            public String getReference() {
                return reference;
            }

            public void setReference(String reference) {
                this.reference = reference;
            }

            public String getIq_words() {
                return iq_words;
            }

            public void setIq_words(String iq_words) {
                this.iq_words = iq_words;
            }

            public String getEq_words() {
                return eq_words;
            }

            public void setEq_words(String eq_words) {
                this.eq_words = eq_words;
            }

            public String getWork_words() {
                return work_words;
            }

            public void setWork_words(String work_words) {
                this.work_words = work_words;
            }

            public String getCommon_words() {
                return common_words;
            }

            public void setCommon_words(String common_words) {
                this.common_words = common_words;
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
