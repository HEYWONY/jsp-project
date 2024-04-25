package com.parsam.service;

import com.parsam.comm.DBConnection;
import com.parsam.dao.user.UserDAO;
import com.parsam.dto.UserDTO;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

public class UserService {
    // 싱글톤
    private static UserService service = new UserService();
    public static UserService getService(){
        return service;
    }
    private UserService() {}

    /* 회원 가입 */
    public int insertUserData(UserDTO dto) {

        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        UserDAO dao = UserDAO.getDAO();

        int result = 0;

        try {
            conn = db.getConnection();  // DB 연결

            result = dao.insertUserData(conn, dto);

        }catch (SQLException | NamingException e){
            System.out.println(e);
        }finally {
            if (conn!=null) try {
                conn.close();
            }catch (Exception e) {}
        }
        return result;
    }

    /* 회원 정보 리스트 - 회원 정보 수정에 사용 */
    public UserDTO getModifyList(String id) {

        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        UserDAO dao = UserDAO.getDAO();
        UserDTO dto = new UserDTO();

        try {
            conn = db.getConnection();  // db 연결
            dto = dao.getModifyList(conn, id);

        }catch (SQLException | NamingException e) {
            System.out.println(e);
        }finally {
            if(conn!=null) try {
                conn.close();
            }catch (Exception e) {}
        }

        return dto;
    }

    /* 회원정보 수정 */
    public int updateUserData(UserDTO dto) {
        DBConnection db =  DBConnection.getInstance();
        Connection conn = null;
        UserDAO dao = UserDAO.getDAO();
        int result = 0;
        try {
            conn = db.getConnection();
            result = dao.updateUserData(conn, dto);
        }catch (SQLException | NamingException e) {
            System.out.println(e);
        }finally {
            if(conn!=null) try {
                conn.close();
            }catch (Exception e) {}
        }
        return result;
    }

    public boolean doLogin(String id, String pw) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        UserDAO dao = UserDAO.getDAO();

        boolean result = false;
        try{
            conn=db.getConnection();
            conn.setAutoCommit(false);
            result = dao.doLogin(conn, id, pw);

            conn.commit();
        }catch (SQLException | NamingException e){
            try{conn.rollback();} catch (SQLException e2){}
            System.out.println(e);
        }finally {
            if(conn!=null) try{conn.close();} catch (Exception e){}
        }
        return result;
    }

    public String findId(String name, String email) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        UserDAO dao = UserDAO.getDAO();
        //UserDTO dto = new UserDTO();

        String id =null;
        try{
            conn= db.getConnection();
            conn.setAutoCommit(false);
            id = dao.findId(conn, name, email);

            conn.commit();
        }catch (SQLException | NamingException e){
            try{conn.rollback();} catch (SQLException e2){}
            System.out.println(e);
        }finally {
            if(conn!=null) try{conn.close();} catch (Exception e){}
        }
        return id;
    }
}
