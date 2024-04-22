package com.parsam.dao;

import com.parsam.dto.BoardDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    private static BoardDAO dao = new BoardDAO();
    public static BoardDAO getDao(){
        return dao;
    }
    private BoardDAO(){}


    public List<BoardDTO> getList(Connection conn) throws SQLException {
        StringBuilder sql= new StringBuilder();
        sql.append("  select         b_no         ");
        sql.append("                 , title      ");
        sql.append("                 , content    ");
        sql.append("                 , writer     ");
        sql.append("                 , writedate  ");
        sql.append("                 , readno     ");
        sql.append("  from  board                 ");
        ResultSet rs = null;

        List<BoardDTO> arr = new ArrayList<>();
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            rs = pstmt.executeQuery();
            while (rs.next()){
                BoardDTO dto = new BoardDTO();
                dto.setB_no(rs.getLong("b_no"));
                dto.setTitle(rs.getString("title"));
                arr.add(dto);
            }
        }finally {
            if(rs!=null) try {rs.close();} catch (Exception e){}
        }
        return arr;
    }

    public BoardDTO showDetail(Connection conn, int bno) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append("  select         b_no        ");
        sql.append("                 , title     ");
        sql.append("                 , content   ");
        sql.append("                 , writer    ");
        sql.append("                 , writedate ");
        sql.append("                 , readno    ");
        sql.append("  from  board                ");
        sql.append("  where b_no= ?              ");
        ResultSet rs = null;

        BoardDTO dto = new BoardDTO();
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            pstmt.setInt(1, bno);
            rs=pstmt.executeQuery();
            while (rs.next()){
                dto.setB_no(rs.getLong("b_no"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWriter(rs.getString("writer"));
                dto.setWritedate(rs.getDate("writedate").toLocalDate());
                dto.setReadno(rs.getInt("readno"));
            }
        }finally {
            if(rs!=null) try{rs.close();} catch (Exception e){}
        }
        return dto;
    }
}
