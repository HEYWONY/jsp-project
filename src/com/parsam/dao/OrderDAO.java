package com.parsam.dao;

import com.parsam.dto.OrderDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDAO {
    private static OrderDAO dao = new OrderDAO();
    public static OrderDAO getDao() {return dao;}
    private OrderDAO(){}


    public void insertOrder(Connection conn, OrderDTO odto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into porder (                   ");
        sql.append("                      o_addr            ");
        sql.append("                      , o_memo          ");
        sql.append("                      , o_phone         ");
        sql.append("                      , p_id            ");
        sql.append("                      , u_id            ");
        sql.append("                      , o_cnt           ");
        sql.append("                      , o_date )        ");
        sql.append(" values(?,?,?,?,?,?,CURDATE())          ");

        try (
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ){
            pstmt.setString(1, odto.getO_addr());
            pstmt.setString(2, odto.getO_memo());
            pstmt.setString(3, odto.getO_phone());
            pstmt.setLong(4, odto.getP_id());
            pstmt.setLong(5, odto.getU_id());
            pstmt.setInt(6, odto.getO_cnt());
            pstmt.executeUpdate();
        }
    }

    public void subStock(Connection conn, OrderDTO odto) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE product SET                 ");
        sql.append(" p_stock = p_stock - ?              ");
        sql.append(" WHERE p_id = ?                     ");
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql.toString())
                ){
            pstmt.setInt(1, odto.getO_cnt());
            pstmt.setLong(2, odto.getP_id());
            pstmt.executeUpdate();
        }
    }
}
