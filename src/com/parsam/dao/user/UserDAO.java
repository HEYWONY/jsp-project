package com.parsam.dao.user;

import com.parsam.dto.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    // 싱글톤
    private static UserDAO dao = new UserDAO();
    public static UserDAO getDAO() {
        return dao;
    }
    private UserDAO() {}

    /* 회원 가입 */
    public int insertUserData(Connection conn, UserDTO dto) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append("  insert  into   user (                    ");
        sql.append("                           name            ");
        sql.append("                        ,  nickname        ");
        sql.append("                        ,  id              ");
        sql.append("                        ,  pw              ");
        sql.append("                        ,  email           ");
        sql.append("                        ,  addr            ");
        sql.append("                        ,  phone           ");
        sql.append("                                    )      ");
        sql.append("  values ( ?, ?, ?, ?, ?, ?, ? )           ");

        int result = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getNickname());
            pstmt.setString(3, dto.getId());
            pstmt.setString(4, dto.getPw());
            pstmt.setString(5, dto.getEmail());
            pstmt.setString(6, dto.getAddr());
            pstmt.setString(7, dto.getPhone());
            result = pstmt.executeUpdate();
        }
        return result;
    }
}
