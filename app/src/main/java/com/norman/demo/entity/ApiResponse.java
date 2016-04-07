package com.norman.demo.entity;


import java.io.Serializable;
import java.util.List;

/**
 * Api响应结果的封装类.
 *
 */
public class ApiResponse<T> implements Serializable{

    private String events;   // 返回码，1为成功
    private String msg;      // 返回信息
    private T objsg;         // 单个对象
    private List<T> objLists;      // 数组对象
    private int currentPage; // 当前页数
    private int pageSize;    // 每页显示数量
    private int maxCount;    // 总条数
    private int maxPage;     // 总页数

    public ApiResponse(String event, String msg) {
        this.events = event;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return events.equals("0");
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T>  getObjLists() {
        return objLists;
    }

    public void setObjLists(List<T>  objLists) {
        this.objLists = objLists;
    }

    public T getObjsg() {
        return objsg;
    }

    public void setObjsg(T objs) {
        this.objsg = objs;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}