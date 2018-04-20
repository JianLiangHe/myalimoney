package edu.myalimoney.util;

import java.io.Serializable;

/**
 * 分页查询工具类
 */
public class PageQueryUtil implements Serializable, IPage {

    private int pageSize = 10;//每页显示条数
    private int currentPage = 1;//当前页
    private int totalPage;//总页数
    private int totalSize;//总数据条数
    private int showPageNum = 5;//显示出来的页面数
    private int start = 1;
    private int end = 1;
    private int page;
    private int rows;

    public PageQueryUtil() {
    }

    public PageQueryUtil(int pageSize, int currentPage) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }

    public PageQueryUtil(int pageSize, int currentPage, int totalPage, int totalSize) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.totalSize = totalSize;
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

    /**
     * 获取总页数
     * @return
     */
    public int getTotalPage() {
        this.totalPage = this.totalSize % this.pageSize == 0 ?
                this.totalSize / this.pageSize : (this.totalSize / this.pageSize + 1);
        this.totalPage = this.totalPage == 0 ? 1 : 0;
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getShowPageNum() {
        return showPageNum;
    }

    public void setShowPageNum(int showPageNum) {
        this.showPageNum = showPageNum;
    }

    /**
     * 获取分页开始位置
     * @return
     */
    public int getStart() {
        this.start = (getPage() - 1) * getRows();
        return this.start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    /**
     * 获取分页结束位置
     * @return
     */
    public int getEnd() {
        this.end = getPage() * getRows();
        return this.end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * 获取每页第一条记录码
     * @return
     */
    @Override
    public int getFirstResult() {
        return (currentPage - 1) * pageSize;
    }
}
