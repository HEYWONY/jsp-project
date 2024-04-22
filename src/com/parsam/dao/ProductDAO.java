package com.parsam.dao;

import com.parsam.dto.ProductDTO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class ProductDAO {
    private static ProductDAO dao = new ProductDAO();
    public static ProductDAO getDao() {return dao;}
    private ProductDAO(){}


    public void insertData(Connection conn, ProductDTO pdto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into product  (                               ");
        sql.append("                         p_name                       ");
        sql.append("                         , p_desc                     ");
        sql.append("                         , p_price                    ");
        sql.append("                         , p_img                      ");
        sql.append("                         , openchat                   ");
        sql.append("                         , p_date                     ");
        sql.append("                         , p_sold                     ");
        sql.append("                         , p_state                    ");
        sql.append("                         , p_cate                     ");
        sql.append("                         , p_readno                   ");
        sql.append("                         , p_fav                      ");
        sql.append("                         , p_stock                    ");
        sql.append("                         , p_place                    ");
        sql.append("                         , p_trade                    ");
        sql.append("                         , u_id    )                  ");
        sql.append(" values(?,?,?,?,?,CURDATE(),false,?,?,0,0,0,?,?,?)    ");
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql.toString());
                ){
            pstmt.setString(1, pdto.getP_name());
            pstmt.setString(2, pdto.getP_desc());
            pstmt.setInt(3, pdto.getP_price());
            pstmt.setString(4, pdto.getP_img());
            pstmt.setString(5, pdto.getP_openchat());
            pstmt.setString(6,pdto.getP_state());
            pstmt.setString(7,pdto.getP_cate());
            pstmt.setString(8, pdto.getP_place());
            pstmt.setString(9, pdto.getP_trade());
            pstmt.setLong(10, pdto.getU_id());
            pstmt.executeUpdate();
        }
    }
}
