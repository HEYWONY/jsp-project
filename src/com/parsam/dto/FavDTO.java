package com.parsam.dto;

import java.time.LocalDate;

public class FavDTO {
    private float f_id;
    private float u_id;
    private float p_id;
    private LocalDate fav_date;

    public FavDTO(float f_id, float u_id, float p_id, LocalDate fav_date) {
        this.f_id = f_id;
        this.u_id = u_id;
        this.p_id = p_id;
        this.fav_date = fav_date;
    }

    public FavDTO(){}

    public float getF_id() {
        return f_id;
    }

    public void setF_id(float f_id) {
        this.f_id = f_id;
    }

    public float getU_id() {
        return u_id;
    }

    public void setU_id(float u_id) {
        this.u_id = u_id;
    }

    public float getP_id() {
        return p_id;
    }

    public void setP_id(float p_id) {
        this.p_id = p_id;
    }

    public LocalDate getFav_date() {
        return fav_date;
    }

    public void setFav_date(LocalDate fav_date) {
        this.fav_date = fav_date;
    }
}
