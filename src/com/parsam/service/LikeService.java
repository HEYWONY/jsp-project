package com.parsam.service;

import com.parsam.comm.DBConnection;
import com.parsam.dao.FavDAO;
import com.parsam.dto.FavDTO;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

public class LikeService {
    private static LikeService service = new LikeService();
    public static LikeService getService() {return service;}
    private LikeService() {}


    public void likeChange(String id, long pid) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        FavDAO dao = FavDAO.getDao();
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);

            long favId = dao.getFav(conn, id, pid); // fid 받아오기

            System.out.println(favId);

            if (favId == 0) { // long 0이면
                // insert
                long uid = dao.getUId(conn, id); // uid 받아오기
                int insertFav = dao.insertFav(conn, uid, pid);
                dao.countaddFav(conn, pid);

            } else { // long 0 이상이면
                // delete
                dao.deleteFav(conn, favId);
                dao.countSubFav(conn, pid);
            }

            // dao.updateFav(conn, pid, result);
            conn.commit();
        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            }catch (Exception e2) {}
            System.out.println(e);
        } finally {
            db.disconn(conn);
        }
    }

    public long getFav(String id, long pid) {
        System.out.println("dd");
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        FavDAO dao = FavDAO.getDao();
        long result = 0;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);

            long uid = dao.getUId(conn, id);
            result = dao.getFavCheck(conn, pid, uid);
            conn.commit();
        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (Exception e2) {
                System.out.println(e2);
            }
        } finally {
            db.disconn(conn);
        }
        return result;
    }
}
