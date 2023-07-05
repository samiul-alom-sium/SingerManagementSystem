package com.singer.singer.util;

import com.singer.singer.entities.Singer;
import java.util.List;

public class SingerGrid {
    
    private int totalPage;
    private int currentPage;
    private long totalRecords;
    private List<Singer> singerData; 
    
    // create getter and setter for each attribute
    public int getTotalPages(){
        return totalPage;
    }
    
    public void setTotalPages(int totalPage){
        this.totalPage = totalPage;
    }
    
    public int currentPage(){
        return currentPage;
    }
    
    public void setCurrentPage(int currentPage){
        this.currentPage = currentPage;
    }
    
    public long getTotalRecords(){
        return totalRecords;
    }
    
    public void setTotalRecords(long totalRecords){
        this.totalRecords = totalRecords;
    }
    
    public List<Singer> getSingerData(){
        return singerData;
    }
    
    public void setSingerData(List<Singer> singerData){
        this.singerData = singerData;
    }
}