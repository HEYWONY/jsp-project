package com.parsam.dao.user;

import com.parsam.dto.ProductDTO;
import com.parsam.dto.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        sql.append("            , u_id          ");
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
                dto.setU_id(rs.getLong("u_id"));
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

    public long getUid(Connection conn, String id) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT u_id             ");
        sql.append(" FROM user               ");
        sql.append(" WHERE id=?              ");
        ResultSet rs = null;
        long uid=0;
        try(
            PreparedStatement pstmt = conn.prepareStatement(sql.toString())
                ){
            pstmt.setString(1,id);
            rs = pstmt.executeQuery();
            while (rs.next()){
                uid = rs.getInt(1);
            }
        } finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        }
        return uid;
     }

    /* 사용자 판매 내역(판매중) 목록 */
    public List<ProductDTO> getUserSaleList(Connection conn, long u_id) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" select    p_cate       ");
        sql.append("         , p_id         ");
        sql.append("         , p_name       ");
        sql.append("         , p_price      ");
        sql.append("         , p_date       ");
        sql.append("         , p_readno     ");
        sql.append("         , p_fav        ");
        sql.append("         , p_stock      ");
        sql.append(" from     product       ");
        sql.append(" where     u_id   =  ?  ");
        sql.append(" and     p_stock <> 0   ");

        ResultSet rs = null;
        List<ProductDTO> arr = new ArrayList<>();
        try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            pstmt.setLong(1, u_id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductDTO dto = new ProductDTO();
                dto.setP_cate(rs.getString("p_cate"));
                dto.setP_id(rs.getLong("p_id"));
                dto.setP_name(rs.getString("p_name"));
                dto.setP_price(rs.getInt("p_price"));
                dto.setP_date(rs.getDate("p_date").toLocalDate());
                dto.setReadno(rs.getInt("p_readno"));
                dto.setP_fav(rs.getInt("p_fav"));
                dto.setP_stock(rs.getInt("p_stock"));
                arr.add(dto);
            }
        }finally {
            if(rs!=null) try {
                rs.close();
            }catch (SQLException e){}
        }
        return arr;
    }

    /* 사용자 판매내역(거래완료) 목록 */
    public List<ProductDTO> getUserSoldList(Connection conn, Long u_id) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" select    p_cate                             ");
        sql.append("         , p.p_id                             ");
        sql.append("         , p_name                             ");
        sql.append("         , p_price                            ");
        sql.append("         , p_date                             ");
        sql.append("         , o_date                             ");
        sql.append("         , p_readno                           ");
        sql.append("         , p_fav                              ");
        sql.append("         , p_stock                            ");
        sql.append(" from      product p inner join porder o      ");
        sql.append(" on        p.p_id = o.p_id                    ");
        sql.append(" where     p_stock =  0                       ");
        sql.append(" and       p.u_id = ?                         ");

        ResultSet rs = null;
        List<ProductDTO> arr = new ArrayList<>();
        try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            pstmt.setLong(1, u_id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductDTO dto = new ProductDTO();
                dto.setP_cate(rs.getString("p_cate"));
                dto.setP_id(rs.getLong("p_id"));
                dto.setP_name(rs.getString("p_name"));
                dto.setP_price(rs.getInt("p_price"));
                dto.setP_date(rs.getDate("p_date").toLocalDate());
                dto.setO_date(rs.getDate("o_date").toLocalDate());
                dto.setReadno(rs.getInt("p_readno"));
                dto.setP_fav(rs.getInt("p_fav"));
                dto.setP_stock(rs.getInt("p_stock"));
                arr.add(dto);
            }
        }finally {
            if(rs!=null) try {
                rs.close();
            }catch (SQLException e){}
        }
        return arr;
    }
}
