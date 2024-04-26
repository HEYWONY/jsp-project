package com.parsam.dto;

import java.time.LocalDate;

public class FaqDTO {
    private long f_no;
    private String title;
    private String content;
    private String writer;
    private LocalDate writedate;
    private int readno;

    public long getF_no() {
        return f_no;
    }

    public void setF_no(long f_no) {
        this.f_no = f_no;
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
