package com.parsam.service;

import com.parsam.comm.DBConnection;
import com.parsam.dao.OrderDAO;
import com.parsam.dao.ProductDAO;
import com.parsam.dto.OrderDTO;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

public class OrderService {
    private static OrderService service = new OrderService();
    public static OrderService getService() {return service;}
    private OrderService(){}

    public void insertOrder(OrderDTO odto) {
        DBConnection db = DBConnection.getInstance();
        OrderDAO dao = OrderDAO.getDao();

        Connection conn = null;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            dao.insertOrder(conn, odto);
            conn.commit();
        } catch (SQLException | NamingException e){
            try {
                conn.rollback();
            } catch (SQLException e2){
                System.out.println(e2);
            }
            System.out.println(e);
        } finally {
            disconn(conn);
        }
    }

    public void subStock(OrderDTO odto) {
        DBConnection db = DBConnection.getInstance();
        OrderDAO dao = OrderDAO.getDao();

        Connection conn = null;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            dao.subStock(conn, odto);
            conn.commit();
        } catch (SQLException | NamingException e){
            try {
                conn.rollback();
            } catch (SQLException e2){
                System.out.println(e2);
            }
            System.out.println(e);
        } finally {
            disconn(conn);
        }
    }

    private void disconn(Connection conn){
        if (conn!= null){
            try {
                conn.close();
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }

}
