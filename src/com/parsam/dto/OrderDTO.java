package com.parsam.dto;

import java.time.LocalDate;

public class OrderDTO {
    private long o_id;
    private String o_addr;
    private String o_memo;
    private String o_phone;
    private long p_id;
    private long u_id;
    private int o_cnt;
    private LocalDate o_date;

    public long getO_id() {
        return o_id;
    }

    public void setO_id(long o_id) {
        this.o_id = o_id;
    }

    public String getO_addr() {
        return o_addr;
    }

    public void setO_addr(String o_addr) {
        this.o_addr = o_addr;
    }

    public String getO_memo() {
        return o_memo;
    }

    public void setO_memo(String o_memo) {
        this.o_memo = o_memo;
    }

    public String getO_phone() {
        return o_phone;
    }

    public void setO_phone(String o_phone) {
        this.o_phone = o_phone;
    }

    public long getP_id() {
        return p_id;
    }

    public void setP_id(long p_id) {
        this.p_id = p_id;
    }

    public long getU_id() {
        return u_id;
    }

    public void setU_id(long u_id) {
        this.u_id = u_id;
    }

    public int getO_cnt() {
        return o_cnt;
    }

    public void setO_cnt(int o_cnt) {
        this.o_cnt = o_cnt;
    }

    public LocalDate getO_date() {
        return o_date;
    }

    public void setO_date(LocalDate o_date) {
        this.o_date = o_date;
    }
}
