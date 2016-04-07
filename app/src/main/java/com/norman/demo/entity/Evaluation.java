package com.norman.demo.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/4/6.
 */
public class Evaluation {

    /**
     * Code : 1
     * Msg : 获取成功
     * Obj : [{"EADDTIME":"2016-03-08 18:31:09","EMESSAGE":"很好！","EVALUATIONCOUNT":"5.00","MHEADIMG":"/SXWeb/SXUpLoad/UsersImg/CQ-C-100051457432700314.JPEG","MNAME":"hooou"},{"EADDTIME":"2016-03-08 12:06:19","EMESSAGE":"这是第二次来修车了，很满意！","EVALUATIONCOUNT":"5.00","MHEADIMG":"/SXWeb/SXUpLoad/UsersImg/CQ-C-100051457432700314.JPEG","MNAME":"hooou"},{"EADDTIME":"2016-03-01 10:28:10","EMESSAGE":"服务态度很不错，修理师傅技术很好。","EVALUATIONCOUNT":"5.00","MHEADIMG":"/SXWeb/SXUpLoad/UsersImg/CQ-C-100051457432700314.JPEG","MNAME":"hooou"},{"EADDTIME":"2016-03-01 10:15:38","EMESSAGE":"速度非常给力，态度好！","EVALUATIONCOUNT":"5.00","MHEADIMG":"","MNAME":"LiMing"}]
     */

    private int Code;
    private String Msg;
    /**
     * EADDTIME : 2016-03-08 18:31:09
     * EMESSAGE : 很好！
     * EVALUATIONCOUNT : 5.00
     * MHEADIMG : /SXWeb/SXUpLoad/UsersImg/CQ-C-100051457432700314.JPEG
     * MNAME : hooou
     */

    private List<ObjEntity> Obj;

    public void setCode(int Code) {
        this.Code = Code;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public void setObj(List<ObjEntity> Obj) {
        this.Obj = Obj;
    }

    public int getCode() {
        return Code;
    }

    public String getMsg() {
        return Msg;
    }

    public List<ObjEntity> getObj() {
        return Obj;
    }

    public static class ObjEntity {
        private String EADDTIME;
        private String EMESSAGE;
        private String EVALUATIONCOUNT;
        private String MHEADIMG;
        private String MNAME;

        public void setEADDTIME(String EADDTIME) {
            this.EADDTIME = EADDTIME;
        }

        public void setEMESSAGE(String EMESSAGE) {
            this.EMESSAGE = EMESSAGE;
        }

        public void setEVALUATIONCOUNT(String EVALUATIONCOUNT) {
            this.EVALUATIONCOUNT = EVALUATIONCOUNT;
        }

        public void setMHEADIMG(String MHEADIMG) {
            this.MHEADIMG = MHEADIMG;
        }

        public void setMNAME(String MNAME) {
            this.MNAME = MNAME;
        }

        public String getEADDTIME() {
            return EADDTIME;
        }

        public String getEMESSAGE() {
            return EMESSAGE;
        }

        public String getEVALUATIONCOUNT() {
            return EVALUATIONCOUNT;
        }

        public String getMHEADIMG() {
            return MHEADIMG;
        }

        public String getMNAME() {
            return MNAME;
        }
    }
}
