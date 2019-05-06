package com.example.administrator.tongze.List;

import java.util.List;

public class HonorList {


    /**
     * ret : 200
     * data : [{"id":"1","post_user_id":"29","desp":"简历附件","acc_url":"https://tongzers.cyi365.com/web_18268697597_20180727175135_mfRfWe.pdf","post_timestamp":"1532571229","delete_flag":"0"},{"id":"2","post_user_id":"29","desp":"简历附件","acc_url":"https://tongzers.cyi365.com/%E6%B5%8B%E8%AF%95%E6%8C%87%E6%A0%87.docx","post_timestamp":"1532571260","delete_flag":"0"},{"id":"3","post_user_id":"29","desp":"简历附件","acc_url":"https://tongzers.cyi365.com/tzlicon.jpeg","post_timestamp":"1532571270","delete_flag":"0"}]
     * msg :
     * debug : {"stack":["[#0 - 0ms - PHALAPI_INIT]/opt/lampp/htdocs/Tongze/public/index.php(9)","[#1 - 0.3ms - PHALAPI_RESPONSE]/opt/lampp/htdocs/Tongze/vendor/phalapi/kernal/src/PhalApi.php(46)","[#2 - 13.3ms - PHALAPI_FINISH]/opt/lampp/htdocs/Tongze/vendor/phalapi/kernal/src/PhalApi.php(74)"],"sqls":["[1 - 1.94ms]SELECT * FROM t_employee WHERE (user_id = '29');","[2 - 0.65ms]SELECT * FROM t_file_acc WHERE (id IN ('1', '2', '3')) AND (delete_flag = 0);"],"version":"2.2.3"}
     */

    private int ret;
    private String msg;
    private DebugBean debug;
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

    public DebugBean getDebug() {
        return debug;
    }

    public void setDebug(DebugBean debug) {
        this.debug = debug;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DebugBean {
        /**
         * stack : ["[#0 - 0ms - PHALAPI_INIT]/opt/lampp/htdocs/Tongze/public/index.php(9)","[#1 - 0.3ms - PHALAPI_RESPONSE]/opt/lampp/htdocs/Tongze/vendor/phalapi/kernal/src/PhalApi.php(46)","[#2 - 13.3ms - PHALAPI_FINISH]/opt/lampp/htdocs/Tongze/vendor/phalapi/kernal/src/PhalApi.php(74)"]
         * sqls : ["[1 - 1.94ms]SELECT * FROM t_employee WHERE (user_id = '29');","[2 - 0.65ms]SELECT * FROM t_file_acc WHERE (id IN ('1', '2', '3')) AND (delete_flag = 0);"]
         * version : 2.2.3
         */

        private String version;
        private List<String> stack;
        private List<String> sqls;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public List<String> getStack() {
            return stack;
        }

        public void setStack(List<String> stack) {
            this.stack = stack;
        }

        public List<String> getSqls() {
            return sqls;
        }

        public void setSqls(List<String> sqls) {
            this.sqls = sqls;
        }
    }

    public static class DataBean {
        /**
         * id : 1
         * post_user_id : 29
         * desp : 简历附件
         * acc_url : https://tongzers.cyi365.com/web_18268697597_20180727175135_mfRfWe.pdf
         * post_timestamp : 1532571229
         * delete_flag : 0
         */

        private String id;
        private String post_user_id;
        private String desp;
        private String acc_url;
        private String post_timestamp;
        private String delete_flag;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPost_user_id() {
            return post_user_id;
        }

        public void setPost_user_id(String post_user_id) {
            this.post_user_id = post_user_id;
        }

        public String getDesp() {
            return desp;
        }

        public void setDesp(String desp) {
            this.desp = desp;
        }

        public String getAcc_url() {
            return acc_url;
        }

        public void setAcc_url(String acc_url) {
            this.acc_url = acc_url;
        }

        public String getPost_timestamp() {
            return post_timestamp;
        }

        public void setPost_timestamp(String post_timestamp) {
            this.post_timestamp = post_timestamp;
        }

        public String getDelete_flag() {
            return delete_flag;
        }

        public void setDelete_flag(String delete_flag) {
            this.delete_flag = delete_flag;
        }
    }
}
