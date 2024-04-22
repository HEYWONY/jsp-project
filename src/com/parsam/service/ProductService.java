package com.parsam.service;

import com.parsam.comm.DBConnection;
import com.parsam.dao.ProductDAO;
import com.parsam.dto.ProductDTO;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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

    public List<ProductDTO> productListService(){
        DBConnection db = DBConnection.getInstance();
        ProductDAO dao = ProductDAO.getDao();
        List<ProductDTO> arr = new ArrayList<>();
        try (Connection conn = db.getConnection()){
            arr = dao.getList(conn);
        } catch (SQLException | NamingException e){
            System.out.println(e);
        }
        return arr;
    }

    public ProductDTO showDetail(long pid) {
        DBConnection db = DBConnection.getInstance();
        ProductDAO dao = ProductDAO.getDao();
        ProductDTO dto = new ProductDTO();
        Connection conn = null;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            int result = dao.addReadno(conn, pid);

            if (result<0){
                throw new SQLException();
            }

            dto = dao.getDetail(conn, pid);

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

        return dto;

    }
}
