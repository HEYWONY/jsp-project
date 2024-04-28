package com.parsam.service;

import com.parsam.comm.DBConnection;
import com.parsam.dao.FavDAO;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

public class FavService {

    private static FavService service = new FavService();
    public static FavService getService() {return service;}
    private FavService(){}


    public int find_fav_yn(long uid, long pid) {
        DBConnection db = DBConnection.getInstance();
        FavDAO dao = FavDAO.getDao();

        int fav_yn = 0;
        Connection conn = null;
        try {
            conn=db.getConnection();
            conn.setAutoCommit(false);
            fav_yn = dao.findFavYn(conn, uid, pid);
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
        return fav_yn;
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
