package com.parsam.service;

import com.parsam.comm.DBConnection;
import com.parsam.dao.BoardDAO;
import com.parsam.dto.BoardDTO;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardService {
    private static BoardService service = new BoardService();
    public static BoardService getService(){
        return service;
    }
    private BoardService(){}


    public List<BoardDTO> getList(int startrow, int pagesize, String search_txt) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        List<BoardDTO> arr = new ArrayList<>();

        try{
            conn = db.getConnection();
            conn.setAutoCommit(false);
            BoardDAO dao = BoardDAO.getDao();
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

    public BoardDTO showDetail(int bno) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        BoardDAO dao = BoardDAO.getDao();
        BoardDTO dto = new BoardDTO();

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
        BoardDAO dao = BoardDAO.getDao();
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

    public void insertData(BoardDTO dto) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        BoardDAO dao = BoardDAO.getDao();

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

    public void updateData(BoardDTO dto) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        BoardDAO dao = BoardDAO.getDao();
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
        BoardDAO dao = BoardDAO.getDao();
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
