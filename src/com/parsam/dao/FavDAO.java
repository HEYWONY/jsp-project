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
}
