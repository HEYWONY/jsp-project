package com.parsam.service;

import com.parsam.comm.DBConnection;
import com.parsam.controller.board.BoardListAction;
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


    public List<BoardDTO> getList() {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        List<BoardDTO> arr = new ArrayList<>();

        try{
            conn = db.getConnection();
            conn.setAutoCommit(false);
            BoardDAO dao = BoardDAO.getDao();
            arr = dao.getList(conn);

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

            dto = dao.showDetail(conn,bno);
            System.out.println(dto.getTitle()+"dfdf");
            conn.commit();
        }catch (SQLException | NamingException e){
            System.out.println(e);
            try{conn.rollback();} catch (SQLException e2){}
        }finally {
            if(conn!=null) try{conn.close();} catch (Exception e){}
        }
        return dto;
    }
}
