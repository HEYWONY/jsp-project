package com.parsam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FavDAO {
    private static FavDAO dao = new FavDAO();
    public static FavDAO getDao() {return dao;}
    private FavDAO(){}

    public int getFavCnt(Connection conn, long pid) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT COUNT(*)         ");
        sql.append(" FROM fav                ");
        sql.append(" WHERE p_id=?            ");

        int favcnt = 0;
        ResultSet rs = null;
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql.toString());
                ){
            pstmt.setLong(1, pid);
            rs = pstmt.executeQuery();
            while (rs.next()){
                favcnt = rs.getInt(1);
            }
        } finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        }
        return favcnt;
    }

    public int likeChange(Connection conn, long pid) throws SQLException {

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT p_fav          ");
        sql.append(" FROM           ");
        sql.append(" WHERE p_id = ?        ");

        ResultSet rs = null;
        int countFav = 0; // fav가 0이라면...

        try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setLong(1, pid);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                countFav = rs.getInt("p_fav");
            }

        } finally {
            if(rs!=null) try{rs.close();}catch (Exception e) {}
        }
        return 0;
    }

    public long getFav(Connection conn, String id, long pid) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append(" select f_id                  ");
        sql.append(" from user u inner join fav f ");
        sql.append("      on u.u_id = f.u_id      ");
        sql.append(" where id = ?                 ");
        sql.append("       and p_id = ?           ");

        ResultSet rs = null;
        long result = 0;

        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setString(1, id);
            pstmt.setLong(2, pid);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                result = rs.getLong("f_id");
            }

        }finally {
            if(rs!=null) try{rs.close();} catch (Exception e) {}
        }
        return result;
    }

    public long getUId(Connection conn, String id) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append(" select u_id          ");
        sql.append(" from user            ");
        sql.append(" where id = ?         ");

        ResultSet rs = null;
        long result = 0;

        try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                result = rs.getLong("u_id");
            }

        } finally {
            if(rs!=null) try{rs.close();} catch (Exception e) {}
        }
        return result;
    }

    public int insertFav(Connection conn, long uid, long pid) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into fav (           ");
        sql.append("                   u_id      ");
        sql.append("                 , p_id      ");
        sql.append("                 , fav_date) ");
        sql.append(" values (?, ?, CURDATE())    ");
        int result = 0;

        try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setLong(1, uid);
            pstmt.setLong(2, pid);
            result = pstmt.executeUpdate(); // 리턴값 int
        }
        return result;
    }

    public void deleteFav(Connection conn, long favId) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append(" DELETE from fav      ");
        sql.append(" where f_id = ?       ");

        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setLong(1, favId);
            pstmt.executeUpdate();
        }
    }

    public void countaddFav(Connection conn, long pid) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" update product            ");
        sql.append("    set p_fav = p_fav + 1  ");
        sql.append(" where p_id = ?            ");

        try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
            pstmt.setLong(1, pid);
            pstmt.executeUpdate();
        }
    }

    public void countSubFav(Connection conn, long pid) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" update product            ");
        sql.append("    set p_fav = p_fav - 1  ");
        sql.append(" where p_id = ?            ");

        try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
            pstmt.setLong(1, pid);
            pstmt.executeUpdate();
        }
    }
}
