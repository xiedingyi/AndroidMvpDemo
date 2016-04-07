package com.norman.demo.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/4/6.
 */
public class sd {

    /**
     * events : 1
     * msg : 获取成功
     * objs : null
     * objLists : [{"ROWNUM":"1","VID":"1","VNUMBER":"1.1","VDES":"1.修复板块\n2.修补Bug","VADDTIME":"2015-12-03 10:27:51","VTYPE":"1","VISUSE":"0","VURL":"/SXWeb/SXUpLoad/Soft/lfhsx_1.1.apk","VCHANNL":""},{"ROWNUM":"2","VID":"2","VNUMBER":"1.0","VDES":"1.修复板块\n2.公积金\n3.家法国恢复规划\n4.修补Bug ","VADDTIME":"2015-12-03 10:32:52","VTYPE":"2","VISUSE":"1","VURL":"/SXWeb/SXUpLoad/Soft/lfhsxbusiness_fuwuqi_1.0.apk","VCHANNL":"fuwuqi"},{"ROWNUM":"3","VID":"3","VNUMBER":"1.1","VDES":"1.修复板块\n2.发广告哈哈\n3.其他\n4.修补Bug ","VADDTIME":"2015-12-04 11:52:52","VTYPE":"2","VISUSE":"0","VURL":"/SXWeb/SXUpLoad/Soft/lfhsxbusiness_1.1.apk","VCHANNL":""}]
     * currentPage : 1
     * pageSize : 3
     * maxCount : 10
     * maxPage : 4
     */

    private String events;
    private String msg;
    private Object objs;
    private int currentPage;
    private int pageSize;
    private int maxCount;
    private int maxPage;
    /**
     * ROWNUM : 1
     * VID : 1
     * VNUMBER : 1.1
     * VDES : 1.修复板块
     2.修补Bug
     * VADDTIME : 2015-12-03 10:27:51
     * VTYPE : 1
     * VISUSE : 0
     * VURL : /SXWeb/SXUpLoad/Soft/lfhsx_1.1.apk
     * VCHANNL :
     */

    private List<ObjListsEntity> objLists;

    public void setEvents(String events) {
        this.events = events;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setObjs(Object objs) {
        this.objs = objs;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public void setObjLists(List<ObjListsEntity> objLists) {
        this.objLists = objLists;
    }

    public String getEvents() {
        return events;
    }

    public String getMsg() {
        return msg;
    }

    public Object getObjs() {
        return objs;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public List<ObjListsEntity> getObjLists() {
        return objLists;
    }

    public static class ObjListsEntity {
        private String ROWNUM;
        private String VID;
        private String VNUMBER;
        private String VDES;
        private String VADDTIME;
        private String VTYPE;
        private String VISUSE;
        private String VURL;
        private String VCHANNL;

        public void setROWNUM(String ROWNUM) {
            this.ROWNUM = ROWNUM;
        }

        public void setVID(String VID) {
            this.VID = VID;
        }

        public void setVNUMBER(String VNUMBER) {
            this.VNUMBER = VNUMBER;
        }

        public void setVDES(String VDES) {
            this.VDES = VDES;
        }

        public void setVADDTIME(String VADDTIME) {
            this.VADDTIME = VADDTIME;
        }

        public void setVTYPE(String VTYPE) {
            this.VTYPE = VTYPE;
        }

        public void setVISUSE(String VISUSE) {
            this.VISUSE = VISUSE;
        }

        public void setVURL(String VURL) {
            this.VURL = VURL;
        }

        public void setVCHANNL(String VCHANNL) {
            this.VCHANNL = VCHANNL;
        }

        public String getROWNUM() {
            return ROWNUM;
        }

        public String getVID() {
            return VID;
        }

        public String getVNUMBER() {
            return VNUMBER;
        }

        public String getVDES() {
            return VDES;
        }

        public String getVADDTIME() {
            return VADDTIME;
        }

        public String getVTYPE() {
            return VTYPE;
        }

        public String getVISUSE() {
            return VISUSE;
        }

        public String getVURL() {
            return VURL;
        }

        public String getVCHANNL() {
            return VCHANNL;
        }
    }
}
