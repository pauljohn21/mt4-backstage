package com.kajie88.base.dto;


public class PageInfo {

    public static final int DEFAULT_PAGE_SIZE = 10;

    private int pageSize = DEFAULT_PAGE_SIZE;
    private int prePage;
    private int nextPage;
    private int totalPage;
    private int totalCount;
    private int currentPage = 1;
    private int hasNext = 0;

    public PageInfo() {
    }

    public PageInfo(int currentPage, int pageSize){
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize){
        if(pageSize<=0) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        this.pageSize = pageSize;
    }

    public int getPrePage() {
        return currentPage-1<=0?1:currentPage-1;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return currentPage+1>=totalPage?totalPage:currentPage+1;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getTotalPage() {
        return this.totalCount/this.pageSize;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if(currentPage<=0){
            currentPage=1;
        }
        this.currentPage = currentPage;
    }

    public int getStartIndex(){
        return (currentPage-1) * pageSize;
    }

    public int getHasNext() {
        hasNext = getPageSize()*getCurrentPage()<getTotalCount()?1:0;
        return hasNext;
    }

    public void setHasNext(int hasNext) {
        this.hasNext = hasNext;
    }
}
