package com.parsam.dto;

import java.time.LocalDate;

public class BoardDTO {
    private long b_no;
    private String title;
    private String content;
    private String writer;
    private LocalDate writedate;
    private int readno;

    public long getB_no() {
        return b_no;
    }

    public void setB_no(long b_no) {
        this.b_no = b_no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public LocalDate getWritedate() {
        return writedate;
    }

    public void setWritedate(LocalDate writedate) {
        this.writedate = writedate;
    }

    public int getReadno() {
        return readno;
    }

    public void setReadno(int readno) {
        this.readno = readno;
    }
}
