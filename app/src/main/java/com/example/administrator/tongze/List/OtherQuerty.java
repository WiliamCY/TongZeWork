package com.example.administrator.tongze.List;

import java.util.List;

public class OtherQuerty {


    /**
     * ret : 200
     * data : {"items":[{"id":"24","exam_type":"1","factor":"离职原因\t\t","reference":"上一份工作的离职原因是什么？\t","words":"住址变动,原公司倒闭,不满意薪资福利,晋升空间,家庭原因,健康问题,压力过大,人际关系问题,其他","sort_weight":"0","delete_flag":"0"},{"id":"26","exam_type":"1","factor":"期望薪资\t\t","reference":"期望薪资\t\t","words":"3k以下,3-4k,4-5k,5-6k,6-7k,7-8k,8k以上,不关注薪资,其他","sort_weight":"0","delete_flag":"0"},{"id":"27","exam_type":"1","factor":"应聘者关注的问题\t\t","reference":"你对公司或工作有什么问题？\t","words":"职业发展,薪资,年终奖,社保,公司福利,工作时间,工作环境,培训机会,公司前景,晋升空间,绩效考评,直属领导,试用期,其他","sort_weight":"0","delete_flag":"0"}],"count":"3"}
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
         * items : [{"id":"24","exam_type":"1","factor":"离职原因\t\t","reference":"上一份工作的离职原因是什么？\t","words":"住址变动,原公司倒闭,不满意薪资福利,晋升空间,家庭原因,健康问题,压力过大,人际关系问题,其他","sort_weight":"0","delete_flag":"0"},{"id":"26","exam_type":"1","factor":"期望薪资\t\t","reference":"期望薪资\t\t","words":"3k以下,3-4k,4-5k,5-6k,6-7k,7-8k,8k以上,不关注薪资,其他","sort_weight":"0","delete_flag":"0"},{"id":"27","exam_type":"1","factor":"应聘者关注的问题\t\t","reference":"你对公司或工作有什么问题？\t","words":"职业发展,薪资,年终奖,社保,公司福利,工作时间,工作环境,培训机会,公司前景,晋升空间,绩效考评,直属领导,试用期,其他","sort_weight":"0","delete_flag":"0"}]
         * count : 3
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
             * id : 24
             * exam_type : 1
             * factor : 离职原因
             * reference : 上一份工作的离职原因是什么？
             * words : 住址变动,原公司倒闭,不满意薪资福利,晋升空间,家庭原因,健康问题,压力过大,人际关系问题,其他
             * sort_weight : 0
             * delete_flag : 0
             */

            private String id;
            private String exam_type;
            private String factor;
            private String reference;
            private String words;
            private String sort_weight;
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

            public String getFactor() {
                return factor;
            }

            public void setFactor(String factor) {
                this.factor = factor;
            }

            public String getReference() {
                return reference;
            }

            public void setReference(String reference) {
                this.reference = reference;
            }

            public String getWords() {
                return words;
            }

            public void setWords(String words) {
                this.words = words;
            }

            public String getSort_weight() {
                return sort_weight;
            }

            public void setSort_weight(String sort_weight) {
                this.sort_weight = sort_weight;
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
