package com.parsam.service;

import com.parsam.comm.DBConnection;
import com.parsam.dao.FaqDAO;
import com.parsam.dto.FaqDTO;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FaqService {
    private static FaqService service = new FaqService();
    public static FaqService getService(){
        return service;
    }
    private FaqService(){}


    public List<FaqDTO> getList(int startrow, int pagesize, String search_txt) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        List<FaqDTO> arr = new ArrayList<>();

        try{
            conn = db.getConnection();
            conn.setAutoCommit(false);
            FaqDAO dao = FaqDAO.getDao();
            arr = dao.getList(conn, startrow, pagesize, search_txt);

            conn.commit();
        }catch (SQLException | NamingException e){
            System.out.println(e);
            try{conn.rollback();}catch (SQLException e2){}
        }finally {
            if(conn!=null)try{conn.close();}catch (Exception e){}
        }
        return arr;
    }

    public FaqDTO showDetail(int bno) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        FaqDAO dao = FaqDAO.getDao();
        FaqDTO dto = new FaqDTO();

        try{
            conn= db.getConnection();
            conn.setAutoCommit(false);
            int result = dao.addReadnoCount(conn, bno);
            if(result<0)
                throw new SQLException();
            dto = dao.showDetail(conn,bno);
            conn.commit();
        }catch (SQLException | NamingException e){
            try{conn.rollback();} catch (SQLException e2){}
            System.out.println(e);
        }finally {
            if(conn!=null) try{conn.close();} catch (Exception e){}
        }
        return dto;
    }

    public void deleteData(int bno){
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        FaqDAO dao = FaqDAO.getDao();
        try{
            conn= db.getConnection();
            conn.setAutoCommit(false);

            dao.deleteData(conn, bno);

            conn.commit();
        }catch (SQLException | NamingException e){
            System.out.println(e);
            try{conn.rollback();} catch (SQLException e2){}
        }finally {
            if(conn!=null) try{conn.close();} catch (Exception e){}
        }
    }

    public void insertData(FaqDTO dto) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        FaqDAO dao = FaqDAO.getDao();

        try{
            conn= db.getConnection();
            conn.setAutoCommit(false);
            dao.insertData(conn, dto);

            conn.commit();
        }catch (SQLException | NamingException e){
            System.out.println(e);
            try{conn.rollback();} catch (SQLException e2){}
        }finally {
            if(conn!=null) try{conn.close();}catch (Exception e){}
        }
    }

    public void updateData(FaqDTO dto) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        FaqDAO dao = FaqDAO.getDao();
        try{
            conn = db.getConnection();
            conn.setAutoCommit(false);
            dao.updateData(conn, dto);
            conn.commit();
        }catch (SQLException | NamingException e){
            try{conn.rollback();} catch (SQLException e2){}
            System.out.println(e);
        }finally {
            if(conn!=null) try{conn.close();} catch (Exception e){}
        }

    }

    public int getCount(String search_txt) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        FaqDAO dao = FaqDAO.getDao();
        int total_data = 0;
        try{
            conn = db.getConnection();
            conn.setAutoCommit(false);
            total_data = dao.getCount(conn, search_txt);
            conn.commit();
        }catch (SQLException | NamingException e){
            try{conn.rollback();} catch (SQLException e2){}
            System.out.println(e);
        }finally {
            if(conn!=null) try{conn.close();} catch (Exception e){}
        }
        return total_data;
    }
}
