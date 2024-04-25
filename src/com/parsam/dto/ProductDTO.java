package com.parsam.dto;

import java.time.LocalDate;

public class ProductDTO {
    private long p_id;
    private String p_name;
    private String p_desc;
    private int p_price;
    private String p_img;
    private String p_openchat;
    private LocalDate p_date;
    private boolean p_sold;
    private String p_state;
    private String p_cate;
    private int readno;
    private int p_fav;
    private int p_stock;
    private long u_id;
    private String p_place;
    private String p_trade;
    //　ｐｏｒｄｅｒ의　ｏ＿ｄａｔｅ　추가
    private LocalDate o_date;

    public LocalDate getO_date() {
        return o_date;
    }

    public void setO_date(LocalDate o_date) {
        this.o_date = o_date;
    }


    public String getP_trade() {
        return p_trade;
    }

    public void setP_trade(String p_trade) {
        this.p_trade = p_trade;
    }

    private int p_cnt;

    public int getP_cnt() {
        return p_cnt;
    }

    public void setP_cnt(int p_cnt) {
        this.p_cnt = p_cnt;
    }

    public long getP_id() {
        return p_id;
    }

    public void setP_id(long p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_desc() {
        return p_desc;
    }

    public void setP_desc(String p_desc) {
        this.p_desc = p_desc;
    }

    public int getP_price() {
        return p_price;
    }

    public void setP_price(int p_price) {
        this.p_price = p_price;
    }

    public String getP_img() {
        return p_img;
    }

    public void setP_img(String p_img) {
        this.p_img = p_img;
    }

    public String getP_openchat() {
        return p_openchat;
    }

    public void setP_openchat(String p_openchat) {
        this.p_openchat = p_openchat;
    }

    public LocalDate getP_date() {
        return p_date;
    }

    public void setP_date(LocalDate p_date) {
        this.p_date = p_date;
    }

    public boolean isP_sold() {
        return p_sold;
    }

    public void setP_sold(boolean p_sold) {
        this.p_sold = p_sold;
    }

    public String getP_state() {
        return p_state;
    }

    public void setP_state(String p_state) {
        this.p_state = p_state;
    }

    public String getP_cate() {
        return p_cate;
    }

    public void setP_cate(String p_cate) {
        this.p_cate = p_cate;
    }

    public int getReadno() {
        return readno;
    }

    public void setReadno(int readno) {
        this.readno = readno;
    }

    public int getP_fav() {
        return p_fav;
    }

    public void setP_fav(int p_fav) {
        this.p_fav = p_fav;
    }

    public int getP_stock() {
        return p_stock;
    }

    public void setP_stock(int p_stock) {
        this.p_stock = p_stock;
    }

    public long getU_id() {
        return u_id;
    }

    public void setU_id(long u_id) {
        this.u_id = u_id;
    }

    public String getP_place() {
        return p_place;
    }

    public void setP_place(String p_place) {
        this.p_place = p_place;
    }
}
