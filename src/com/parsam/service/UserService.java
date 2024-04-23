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
}
