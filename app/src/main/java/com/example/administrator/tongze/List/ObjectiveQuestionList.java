package com.example.administrator.tongze.List;

import java.util.List;

public class ObjectiveQuestionList {

    /**
     * ret : 200
     * data : {"items":[{"id":"25","exam_type":"0","factor":"举止仪表","type":"0","reference":"观察法。","grade_a_desp":"仪表端正,气质让人过目难忘","grade_a":"10","grade_b_desp":"穿着得体,举止礼貌有度","grade_b":"8","grade_c_desp":"穿着简单随意","grade_c":"6","grade_d_desp":"穿着不合适,不礼貌","grade_d":"4","weight":"0.00","sort_weight":"0","delete_flag":"0"},{"id":"26","exam_type":"0","factor":"沟通表达能力","type":"0","reference":"请做下自我介绍,结合自我介绍与以下问题的回答综合评价面试者的表达能力","grade_a_desp":"有准备,有记忆点,能突出自身优势","grade_a":"10","grade_b_desp":"条理清晰 有亮点","grade_b":"8","grade_c_desp":"流畅,但比较普通","grade_c":"6","grade_d_desp":"磕磕绊绊,逻辑混乱,毫无准备","grade_d":"4","weight":"0.00","sort_weight":"0","delete_flag":"0"},{"id":"27","exam_type":"0","factor":"职位的欲望","type":"0","reference":"对我们公司/行业是否了解？","grade_a_desp":"对本单位了解全面,面试经过精心准备","grade_a":"10","grade_b_desp":"对公司及行业有了解,面试态度认真","grade_b":"8","grade_c_desp":"对公司的了解有偏差,面试准备不足","grade_c":"6","grade_d_desp":"没做过任何了解,简历海投","grade_d":"4","weight":"0.00","sort_weight":"0","delete_flag":"0"},{"id":"28","exam_type":"0","factor":"性格","type":"0","reference":"认为自己的性格是怎么样的？","grade_a_desp":"有领导力,成就导向；性格与岗位要求完全匹配","grade_a":"10","grade_b_desp":"有上进心,成就导向","grade_b":"8","grade_c_desp":"性格与岗位要求基本匹配","grade_c":"6","grade_d_desp":"性格特质不好","grade_d":"4","weight":"0.00","sort_weight":"0","delete_flag":"0"},{"id":"29","exam_type":"0","factor":"工作的看法","type":"0","reference":"你对加班有什么看法？","grade_a_desp":"加班是继续学习、完善工作的机会（有进取心、肯为公司付出）","grade_a":"10","grade_b_desp":"乐观看待加班","grade_b":"8","grade_c_desp":"有加班费可以加班","grade_c":"6","grade_d_desp":"用五花八门的理由,阐述加班的弊端、不必要性等","grade_d":"4","weight":"0.00","sort_weight":"0","delete_flag":"0"},{"id":"30","exam_type":"0","factor":"校园经历","type":"0","reference":"在校参加过什么活动？例如社团/学生会/学科竞赛/创业活动/支教/公益/马拉松等          描述一下参与的过程,你扮演的角色,是否担任组织或领导工作；最后的结果如何；取得哪些成果；同学/队友如何评价你的工作和潜力? 有什么收获？","grade_a_desp":"参加过,是核心成员,造成正面而广泛的社会影响","grade_a":"10","grade_b_desp":"参加过,是重要成员,成果有一定的社会影响力","grade_b":"8","grade_c_desp":"参与过,没有取得什么成绩或社会影响力","grade_c":"6","grade_d_desp":"从未参与过,或 经历造假,夸大,过分修饰","grade_d":"4","weight":"0.00","sort_weight":"0","delete_flag":"0"},{"id":"31","exam_type":"0","factor":"实习经历","type":"0","reference":"之前有做过实习吗？岗位职责？工作表现如何？上司/同事如何评价你的工作和潜力？通过这份实习,你有什么收获","grade_a_desp":"过往实习有出色表现,受领导、同事的认可","grade_a":"10","grade_b_desp":"岗位职责记忆清晰,实习中有一定的团队合作能力","grade_b":"8","grade_c_desp":"有实习经历,工作内容重复简单","grade_c":"6","grade_d_desp":"无实习经历,或 造假,夸大实习经历","grade_d":"4","weight":"0.00","sort_weight":"0","delete_flag":"0"},{"id":"32","exam_type":"0","factor":"可塑性","type":"0","reference":"职业发展方向的定位？你有什么样的职业规划？","grade_a_desp":"职业规划清晰科学","grade_a":"10","grade_b_desp":"有清晰的规划 但不科学","grade_b":"8","grade_c_desp":"职业规划不清晰","grade_c":"6","grade_d_desp":"无职业规划,或为了规划而规划","grade_d":"4","weight":"0.00","sort_weight":"0","delete_flag":"0"}],"count":"8"}
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
         * items : [{"id":"25","exam_type":"0","factor":"举止仪表","type":"0","reference":"观察法。","grade_a_desp":"仪表端正,气质让人过目难忘","grade_a":"10","grade_b_desp":"穿着得体,举止礼貌有度","grade_b":"8","grade_c_desp":"穿着简单随意","grade_c":"6","grade_d_desp":"穿着不合适,不礼貌","grade_d":"4","weight":"0.00","sort_weight":"0","delete_flag":"0"},{"id":"26","exam_type":"0","factor":"沟通表达能力","type":"0","reference":"请做下自我介绍,结合自我介绍与以下问题的回答综合评价面试者的表达能力","grade_a_desp":"有准备,有记忆点,能突出自身优势","grade_a":"10","grade_b_desp":"条理清晰 有亮点","grade_b":"8","grade_c_desp":"流畅,但比较普通","grade_c":"6","grade_d_desp":"磕磕绊绊,逻辑混乱,毫无准备","grade_d":"4","weight":"0.00","sort_weight":"0","delete_flag":"0"},{"id":"27","exam_type":"0","factor":"职位的欲望","type":"0","reference":"对我们公司/行业是否了解？","grade_a_desp":"对本单位了解全面,面试经过精心准备","grade_a":"10","grade_b_desp":"对公司及行业有了解,面试态度认真","grade_b":"8","grade_c_desp":"对公司的了解有偏差,面试准备不足","grade_c":"6","grade_d_desp":"没做过任何了解,简历海投","grade_d":"4","weight":"0.00","sort_weight":"0","delete_flag":"0"},{"id":"28","exam_type":"0","factor":"性格","type":"0","reference":"认为自己的性格是怎么样的？","grade_a_desp":"有领导力,成就导向；性格与岗位要求完全匹配","grade_a":"10","grade_b_desp":"有上进心,成就导向","grade_b":"8","grade_c_desp":"性格与岗位要求基本匹配","grade_c":"6","grade_d_desp":"性格特质不好","grade_d":"4","weight":"0.00","sort_weight":"0","delete_flag":"0"},{"id":"29","exam_type":"0","factor":"工作的看法","type":"0","reference":"你对加班有什么看法？","grade_a_desp":"加班是继续学习、完善工作的机会（有进取心、肯为公司付出）","grade_a":"10","grade_b_desp":"乐观看待加班","grade_b":"8","grade_c_desp":"有加班费可以加班","grade_c":"6","grade_d_desp":"用五花八门的理由,阐述加班的弊端、不必要性等","grade_d":"4","weight":"0.00","sort_weight":"0","delete_flag":"0"},{"id":"30","exam_type":"0","factor":"校园经历","type":"0","reference":"在校参加过什么活动？例如社团/学生会/学科竞赛/创业活动/支教/公益/马拉松等          描述一下参与的过程,你扮演的角色,是否担任组织或领导工作；最后的结果如何；取得哪些成果；同学/队友如何评价你的工作和潜力? 有什么收获？","grade_a_desp":"参加过,是核心成员,造成正面而广泛的社会影响","grade_a":"10","grade_b_desp":"参加过,是重要成员,成果有一定的社会影响力","grade_b":"8","grade_c_desp":"参与过,没有取得什么成绩或社会影响力","grade_c":"6","grade_d_desp":"从未参与过,或 经历造假,夸大,过分修饰","grade_d":"4","weight":"0.00","sort_weight":"0","delete_flag":"0"},{"id":"31","exam_type":"0","factor":"实习经历","type":"0","reference":"之前有做过实习吗？岗位职责？工作表现如何？上司/同事如何评价你的工作和潜力？通过这份实习,你有什么收获","grade_a_desp":"过往实习有出色表现,受领导、同事的认可","grade_a":"10","grade_b_desp":"岗位职责记忆清晰,实习中有一定的团队合作能力","grade_b":"8","grade_c_desp":"有实习经历,工作内容重复简单","grade_c":"6","grade_d_desp":"无实习经历,或 造假,夸大实习经历","grade_d":"4","weight":"0.00","sort_weight":"0","delete_flag":"0"},{"id":"32","exam_type":"0","factor":"可塑性","type":"0","reference":"职业发展方向的定位？你有什么样的职业规划？","grade_a_desp":"职业规划清晰科学","grade_a":"10","grade_b_desp":"有清晰的规划 但不科学","grade_b":"8","grade_c_desp":"职业规划不清晰","grade_c":"6","grade_d_desp":"无职业规划,或为了规划而规划","grade_d":"4","weight":"0.00","sort_weight":"0","delete_flag":"0"}]
         * count : 8
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
             * id : 25
             * exam_type : 0
             * factor : 举止仪表
             * type : 0
             * reference : 观察法。
             * grade_a_desp : 仪表端正,气质让人过目难忘
             * grade_a : 10
             * grade_b_desp : 穿着得体,举止礼貌有度
             * grade_b : 8
             * grade_c_desp : 穿着简单随意
             * grade_c : 6
             * grade_d_desp : 穿着不合适,不礼貌
             * grade_d : 4
             * weight : 0.00
             * sort_weight : 0
             * delete_flag : 0
             */

            private String id;
            private String exam_type;
            private String factor;
            private String type;
            private String reference;
            private String grade_a_desp;
            private String grade_a;
            private String grade_b_desp;
            private String grade_b;
            private String grade_c_desp;
            private String grade_c;
            private String grade_d_desp;
            private String grade_d;
            private String weight;
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

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getReference() {
                return reference;
            }

            public void setReference(String reference) {
                this.reference = reference;
            }

            public String getGrade_a_desp() {
                return grade_a_desp;
            }

            public void setGrade_a_desp(String grade_a_desp) {
                this.grade_a_desp = grade_a_desp;
            }

            public String getGrade_a() {
                return grade_a;
            }

            public void setGrade_a(String grade_a) {
                this.grade_a = grade_a;
            }

            public String getGrade_b_desp() {
                return grade_b_desp;
            }

            public void setGrade_b_desp(String grade_b_desp) {
                this.grade_b_desp = grade_b_desp;
            }

            public String getGrade_b() {
                return grade_b;
            }

            public void setGrade_b(String grade_b) {
                this.grade_b = grade_b;
            }

            public String getGrade_c_desp() {
                return grade_c_desp;
            }

            public void setGrade_c_desp(String grade_c_desp) {
                this.grade_c_desp = grade_c_desp;
            }

            public String getGrade_c() {
                return grade_c;
            }

            public void setGrade_c(String grade_c) {
                this.grade_c = grade_c;
            }

            public String getGrade_d_desp() {
                return grade_d_desp;
            }

            public void setGrade_d_desp(String grade_d_desp) {
                this.grade_d_desp = grade_d_desp;
            }

            public String getGrade_d() {
                return grade_d;
            }

            public void setGrade_d(String grade_d) {
                this.grade_d = grade_d;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
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
