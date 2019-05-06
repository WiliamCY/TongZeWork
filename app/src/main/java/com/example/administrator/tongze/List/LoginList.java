package com.example.administrator.tongze.List;

public class LoginList {
    /**
     * ret : 200
     * data : {"is_first_bind":0,"user_id":"29","role_id":"0","token":"F7EC5FA8E2818A415E6D38D2BB38E03903ADF86A9CC3DDE74857E4B676C2673C"}
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
         * is_first_bind : 0
         * user_id : 29
         * role_id : 0
         * token : F7EC5FA8E2818A415E6D38D2BB38E03903ADF86A9CC3DDE74857E4B676C2673C
         */

        private int is_first_bind;
        private String user_id;
        private String role_id;
        private String token;

        public int getIs_first_bind() {
            return is_first_bind;
        }

        public void setIs_first_bind(int is_first_bind) {
            this.is_first_bind = is_first_bind;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getRole_id() {
            return role_id;
        }

        public void setRole_id(String role_id) {
            this.role_id = role_id;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
