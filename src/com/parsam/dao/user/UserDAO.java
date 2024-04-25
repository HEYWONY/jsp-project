package com.parsam.dao.user;

import com.parsam.dto.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    /* 회원 정보 가져오기(수정 화면) */
    public UserDTO getModifyList(Connection conn, String id) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append(" select       id            ");
        sql.append("            , name          ");
        sql.append("            , nickname      ");
        sql.append("            , addr          ");
        sql.append("            , phone         ");
        sql.append("            , email         ");
        sql.append("            , photo         ");
        sql.append("  from        user          ");
        sql.append("  where       id = ?        ");

        ResultSet rs = null;
        UserDTO dto = new UserDTO();
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                dto.setId(rs.getString("id"));
                dto.setName(rs.getString("name"));
                dto.setNickname(rs.getString("nickname"));
                dto.setAddr(rs.getString("addr"));
                dto.setPhone(rs.getString("phone"));
                dto.setEmail(rs.getString("email"));
                dto.setPhoto(rs.getString("photo"));
            }
        }finally {
            if(rs!=null) try {
                rs.close();
            }catch (Exception e) {}
        }
        return dto;
    }

    /* 회원정보 수정 */
    public int updateUserData(Connection conn, UserDTO dto) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append("  update         user    ");
        sql.append("  set                    ");
        sql.append("          name = ?       ");
        sql.append("        , nickname = ?   ");
        sql.append("        , addr = ?       ");
        sql.append("        , phone = ?      ");
        sql.append("        , email = ?      ");
        sql.append("  where    id  =  ?      ");

        int result = 0;
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getNickname());
            pstmt.setString(3, dto.getAddr());
            pstmt.setString(4, dto.getPhone());
            pstmt.setString(5, dto.getEmail());
            pstmt.setString(6, dto.getId());
            result = pstmt.executeUpdate();
        }

        return result;
    }

    /* 로그인 */
    public boolean doLogin(Connection conn, String id, String pw) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("   select           id         ");
        sql.append("                  , pw         ");
        sql.append("  from   user                  ");
        sql.append("  where  id= ?   and pw = ?    ");
        ResultSet rs = null;

        boolean result = false;

        try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            rs = pstmt.executeQuery();

            result = rs.next();
        }
        return result;
    }

    public String  findId(Connection conn, String name, String email) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("   select       id              ");
        sql.append("   from   user                  ");
        sql.append("   where name= ? and email= ?   ");

        ResultSet rs = null;
        //UserDTO dto = new UserDTO();

        String id = null;
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            rs = pstmt.executeQuery();

            if(rs.next()){
                id = rs.getString("id");
            }

        }finally {
            if(rs!=null) try {rs.close();}catch (Exception e){}
        }
        return id;
    }
}
