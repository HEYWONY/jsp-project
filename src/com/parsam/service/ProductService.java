package com.parsam.service;

import com.parsam.comm.DBConnection;
import com.parsam.dao.FavDAO;
import com.parsam.dao.ProductDAO;
import com.parsam.dao.user.UserDAO;
import com.parsam.dto.ProductDTO;
import com.parsam.dto.UserDTO;

import javax.naming.NamingException;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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
        Connection conn = null;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            arr = dao.getList(conn);
            conn.commit();
        } catch (SQLException | NamingException e){
            try {
                conn.rollback();
            } catch (SQLException e2){
                System.out.println(e2);
            }
            System.out.println(e);
        } finally {
            db.disconn(conn);
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

    public void updateData(ProductDTO pdto) {
        DBConnection db = DBConnection.getInstance();
        ProductDAO dao = ProductDAO.getDao();
        Connection conn = null;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);

            int result = dao.updateData(conn, pdto);

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

    public void deleteData(long pid, String imgpath){
        DBConnection db = DBConnection.getInstance();
        ProductDAO dao = ProductDAO.getDao();
        Connection conn = null;

        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            dao.deleteData(conn, pid);

            File f = new File(imgpath);
            if (f.isFile()){
                if (f.exists()){
                    f.delete();
                }
            }
            conn.commit();
        } catch (Exception e){
            try {
                conn.rollback();
            } catch (SQLException e2){
                System.out.println(e2);
            }
        } finally {
            disconn(conn);
        }
    }

    // 최신 리스트
    public List<ProductDTO> productNewListService(){
        DBConnection db = DBConnection.getInstance();
        ProductDAO dao = ProductDAO.getDao();
        List<ProductDTO> arr = new ArrayList<>();
        Connection conn = null;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            arr = dao.getNewList(conn);
            conn.commit();
        } catch (SQLException | NamingException e){
            try {
                conn.rollback();
            } catch (SQLException e2){
                System.out.println(e2);
            }
            System.out.println(e);
        } finally {
            db.disconn(conn);
        }
        return arr;
    }

    // 검색 기능
    public List<ProductDTO> productListResult(ProductDTO dto) {
        DBConnection db = DBConnection.getInstance();
        ProductDAO dao = ProductDAO.getDao();
        List<ProductDTO> arr = new ArrayList<>();
        Connection conn = null;

        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            arr = dao.productListResult(conn, dto);
            conn.commit();
        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (SQLException e2){
                System.out.println(e2);
            }
            System.out.println(e);
        } finally {
            db.disconn(conn);
        }
        return arr;
    }

    public List<ProductDTO> productPopularListService() {
        DBConnection db = DBConnection.getInstance();
        ProductDAO dao = ProductDAO.getDao();
        List<ProductDTO> arr = new ArrayList<>();
        Connection conn = null;

        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            arr = dao.getPopList(conn);
            conn.commit();
        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (SQLException e2){
                System.out.println(e2);
            }
            System.out.println(e);
        } finally {
            db.disconn(conn);
        }
        return arr;
    }

    public int getFavCnt(long pid) {
        DBConnection db = DBConnection.getInstance();
        FavDAO dao = FavDAO.getDao();
        int favcnt = 0;

        Connection conn = null;
        try {
            conn=db.getConnection();
            conn.setAutoCommit(false);
            favcnt=dao.getFavCnt(conn, pid);
            conn.commit();
        } catch (SQLException | NamingException e){
            try {
                conn.rollback();
            } catch (SQLException e2){
                System.out.println(e2);
            }
            System.out.println(e);
        } finally {
            db.disconn(conn);
        }
        return  favcnt;
    }

    /* 찜 목록 */
    public List<ProductDTO> getFavList(Long u_id) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        UserDAO dao = UserDAO.getDAO();
        List<ProductDTO> arr = new ArrayList<>();

        try{
            conn = db.getConnection();
            conn.setAutoCommit(false);
            arr = dao.getFavList(conn, u_id);
            conn.commit();
        }catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (SQLException e2){
                System.out.println(e2);
            }
            System.out.println(e);
        }finally {
            db.disconn(conn);
        }

        return arr;
    }

    public List<ProductDTO> getadisList(){
        DBConnection db = DBConnection.getInstance();
        ProductDAO dao = ProductDAO.getDao();
        List<ProductDTO> arr = new ArrayList<>();
        Connection conn = null;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            arr = dao.getadisList(conn);
            conn.commit();
        } catch (SQLException | NamingException e){
            try {
                conn.rollback();
            } catch (SQLException e2){
                System.out.println(e2);
            }
            System.out.println(e);
        } finally {
            db.disconn(conn);
        }
        return arr;
    }

    public List<ProductDTO> getEtcList() {
        DBConnection db = DBConnection.getInstance();
        ProductDAO dao = ProductDAO.getDao();
        List<ProductDTO> arr = new ArrayList<>();
        Connection conn = null;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            arr = dao.getEtcList(conn);
            conn.commit();
        } catch (SQLException | NamingException e){
            try {
                conn.rollback();
            } catch (SQLException e2){
                System.out.println(e2);
            }
            System.out.println(e);
        } finally {
            db.disconn(conn);
        }
        return arr;
    }

    public List<ProductDTO> getHandoutList() {
        DBConnection db = DBConnection.getInstance();
        ProductDAO dao = ProductDAO.getDao();
        List<ProductDTO> arr = new ArrayList<>();
        Connection conn = null;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            arr = dao.getHandoutList(conn);
            conn.commit();
        } catch (SQLException | NamingException e){
            try {
                conn.rollback();
            } catch (SQLException e2){
                System.out.println(e2);
            }
            System.out.println(e);
        } finally {
            db.disconn(conn);
        }
        return arr;
    }

    public List<ProductDTO> getTextbookList() {
        DBConnection db = DBConnection.getInstance();
        ProductDAO dao = ProductDAO.getDao();
        List<ProductDTO> arr = new ArrayList<>();
        Connection conn = null;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            arr = dao.getTextbookList(conn);
            conn.commit();
        } catch (SQLException | NamingException e){
            try {
                conn.rollback();
            } catch (SQLException e2){
                System.out.println(e2);
            }
            System.out.println(e);
        } finally {
            db.disconn(conn);
        }
        return arr;
    }
}
