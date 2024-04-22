package com.parsam.service;

import com.parsam.comm.DBConnection;
import com.parsam.dao.ProductDAO;
import com.parsam.dto.ProductDTO;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

public class ProductService {
    private static ProductService service = new ProductService();
    public static ProductService getService() {return service;}
    private ProductService(){}


    public void insertData(ProductDTO pdto) {
        DBConnection db = DBConnection.getInstance();
        ProductDAO dao = ProductDAO.getDao();

        Connection conn = null;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            dao.insertData(conn, pdto);
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

    public void disconn(Connection conn){
        if (conn != null){
            try {
                conn.close();
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
