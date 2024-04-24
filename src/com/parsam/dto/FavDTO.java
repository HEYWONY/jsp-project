package com.parsam.dto;

import java.time.LocalDate;

public class FavDTO {
    private long u_id;
    private long p_id;
    private LocalDate fav_date;

    public long getU_id() {
        return u_id;
    }

    public void setU_id(long u_id) {
        this.u_id = u_id;
    }

    public long getP_id() {
        return p_id;
    }

    public void setP_id(long p_id) {
        this.p_id = p_id;
    }

    public LocalDate getFav_date() {
        return fav_date;
    }

    public void setFav_date(LocalDate fav_date) {
        this.fav_date = fav_date;
    }
}
