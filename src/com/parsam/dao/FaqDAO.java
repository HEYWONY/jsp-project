package com.parsam.dao;

import com.parsam.dto.FaqDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FaqDAO {
    private static FaqDAO dao = new FaqDAO();
    public static FaqDAO getDao(){
        return dao;
    }
    private FaqDAO(){}


    public List<FaqDTO> getList(Connection conn, int startrow, int pagesize, String search_txt) throws SQLException {
        StringBuilder sql= new StringBuilder();
        sql.append("  select         f_no         ");
        sql.append("                 , title      ");
        sql.append("                 , content    ");
        sql.append("                 , writer     ");
        sql.append("                 , writedate  ");
        sql.append("                 , readno     ");
        sql.append("  from  faq                 ");
        if (!"".equals(search_txt)){
            sql.append(" where title like ? or content like ? ");
        }
        sql.append("  limit ?, ?                  ");;

        ResultSet rs = null;
        List<FaqDTO> arr = new ArrayList<>();
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            if(!"".equals(search_txt)){
                pstmt.setString(1, "%"+search_txt+"%");
                pstmt.setString(2, "%"+search_txt+"%");
                pstmt.setInt(3, startrow);
                pstmt.setInt(4, pagesize);
            }else {
                pstmt.setInt(1, startrow);
                pstmt.setInt(2, pagesize);
            }

            rs = pstmt.executeQuery();
            while (rs.next()){
                FaqDTO dto = new FaqDTO();
                dto.setF_no(rs.getLong("f_no"));
                dto.setTitle(rs.getString("title"));
                dto.setWritedate(rs.getDate("writedate").toLocalDate());
                arr.add(dto);
            }
        }finally {
            if(rs!=null) try {rs.close();} catch (Exception e){}
        }
        return arr;
    }

    public FaqDTO showDetail(Connection conn, int bno) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append("  select         f_no        ");
        sql.append("                 , title     ");
        sql.append("                 , content   ");
        sql.append("                 , writer    ");
        sql.append("                 , writedate ");
        sql.append("                 , readno    ");
        sql.append("  from  faq                  ");
        sql.append("  where f_no= ?              ");
        ResultSet rs = null;

        FaqDTO dto = new FaqDTO();
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            pstmt.setInt(1, bno);
            rs=pstmt.executeQuery();
            while (rs.next()){
                dto.setF_no(rs.getLong("f_no"));
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

    public void deleteData(Connection conn, int bno) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append("  delete   from faq           ");
        sql.append("  where f_no = ?              ");

        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            pstmt.setInt(1, bno);
            pstmt.executeUpdate();
        }
    }

    public void insertData(Connection conn, FaqDTO dto) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into  faq  ( title        ");
        sql.append("                     , content    ");
        sql.append("                     , writer     ");
        sql.append("                     , writedate  ");
        sql.append("                     , readno )   ");
        sql.append(" values ( ?, ?, ?, curdate(), 0 ) ");

        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            pstmt.setString(1, dto.getTitle());
            pstmt.setString(2, dto.getContent());
            pstmt.setString(3, dto.getWriter());
            pstmt.executeUpdate();
        }
    }

    public void updateData(Connection conn, FaqDTO dto) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append("  update  faq              ");
        sql.append("  set                      ");
        sql.append("          title = ?        ");
        sql.append("          , content = ?    ");
        sql.append("  where  f_no = ?          ");

        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            pstmt.setString(1, dto.getTitle());
            pstmt.setString(2, dto.getContent());
            pstmt.setLong(3, dto.getF_no());
            pstmt.executeUpdate();
        }
    }

    public int addReadnoCount(Connection conn, int bno) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append("  update  faq                 ");
        sql.append("  set                           ");
        sql.append("      readno=ifnull(readno,0)+1 ");
        sql.append("  where f_no = ?                ");

        int result= 0;
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            pstmt.setLong(1, bno);
            result = pstmt.executeUpdate();
        }
        return result;
    }

    public int getCount(Connection conn, String search_txt) throws SQLException{
        StringBuilder sql=new StringBuilder();
        sql.append("  select   count(*)         ");
        sql.append("  from     faq            ");
        if (!"".equals(search_txt)){
            sql.append(" where title like ? or content like ? ");
        }

        ResultSet rs= null;
        int total_data = 0;
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            if(!"".equals(search_txt)){
                pstmt.setString(1, "%"+search_txt+"%");
                pstmt.setString(2, "%"+search_txt+"%");
            }
            rs=pstmt.executeQuery();
            while (rs.next()){
                total_data = rs.getInt(1);

            }
        }finally {
            if(rs!=null) try{rs.close();} catch (Exception e){}
        }
        return total_data;
    }
}
