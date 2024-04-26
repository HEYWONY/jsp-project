package com.parsam.dao;

import com.parsam.dto.FavDTO;
import com.parsam.dto.ProductDTO;
import com.parsam.dto.UserDTO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductDAO {
    private static ProductDAO dao = new ProductDAO();
    public static ProductDAO getDao() {return dao;}
    private ProductDAO(){}


    public void insertData(Connection conn, ProductDTO pdto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into product  (                               ");
        sql.append("                         p_name                       ");
        sql.append("                         , p_desc                     ");
        sql.append("                         , p_price                    ");
        sql.append("                         , p_img                      ");
        sql.append("                         , openchat                   ");
        sql.append("                         , p_date                     ");
        sql.append("                         , p_state                    ");
        sql.append("                         , p_cate                     ");
        sql.append("                         , p_readno                   ");
        sql.append("                         , p_fav                      ");
        sql.append("                         , p_stock                    ");
        sql.append("                         , p_place                    ");
        sql.append("                         , p_trade                    ");
        sql.append("                         , u_id    )                  ");
        sql.append(" values(?,?,?,?,?,CURDATE(),?,?,0,0,?,?,?,?)    ");
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql.toString());
                ){
            pstmt.setString(1, pdto.getP_name());
            pstmt.setString(2, pdto.getP_desc());
            pstmt.setInt(3, pdto.getP_price());
            pstmt.setString(4, pdto.getP_img());
            pstmt.setString(5, pdto.getP_openchat());
            pstmt.setString(6,pdto.getP_state());
            pstmt.setString(7,pdto.getP_cate());
            pstmt.setInt(8, pdto.getP_cnt());
            pstmt.setString(9, pdto.getP_place());
            pstmt.setString(10, pdto.getP_trade());
            pstmt.setLong(11, pdto.getU_id());
            pstmt.executeUpdate();
        }
    }
  
  public List<ProductDTO> getList(Connection conn) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT   p_id                   ");
        sql.append("        , p_img                  ");
        sql.append("        , p_cate                 ");
        sql.append("        , p_name                 ");
        sql.append("        , p_price                ");
        sql.append("        , p_state                ");
        sql.append("        , p_fav                  ");
        sql.append("        , u_id                   ");
        sql.append(" FROM product                    ");

        ResultSet rs = null;
        List<ProductDTO> arr = new ArrayList<>();

        try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductDTO dto = new ProductDTO();
                dto.setP_id(rs.getLong("p_id"));
                dto.setP_img(rs.getString("p_img"));
                dto.setP_cate(rs.getString("p_cate"));
                dto.setP_name(rs.getString("p_name"));
                dto.setP_price(rs.getInt("p_price"));
                dto.setP_state(rs.getString("p_state"));
                dto.setP_fav(rs.getInt("p_fav"));
                dto.setU_id(rs.getInt("u_id"));
                arr.add(dto);
            }
        }
        return arr;
    }

    public int addReadno(Connection conn, long pid) throws SQLException{

        StringBuilder sql = new StringBuilder();
        sql.append(" update  product  set           ");
        sql.append(" p_readno=p_readno+1            ");
        sql.append(" where p_id=?                   ");
        int result = 0;
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql.toString());
                ){
            pstmt.setLong(1, pid);
            result = pstmt.executeUpdate();
        }
        return result;
    }

    public ProductDTO getDetail(Connection conn, long pid) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append(" select    p_id                                       ");
        sql.append("           ,p_name                                    ");
        sql.append("           , p_desc                                   ");
        sql.append("           , p_price                                  ");
        sql.append("           , p_img                                    ");
        sql.append("           , openchat                                 ");
        sql.append("           , p_date                                   ");
        sql.append("           , p_state                                  ");
        sql.append("           , p_cate                                   ");
        sql.append("           , p_readno                                 ");
        sql.append("           , p_fav                                    ");
        sql.append("           , p_stock                                  ");
        sql.append("           , SUBSTRING_INDEX(p_place,' ',2) AS p_place");
        sql.append("           , p_trade                                  ");
        sql.append("           , u_id                                     ");
        sql.append(" from product                                         ");
        sql.append(" where p_id=?                                         ");

        ProductDTO dto = new ProductDTO();
        ResultSet rs = null;

        try(
                PreparedStatement pstmt = conn.prepareStatement(sql.toString())
                ) {
            pstmt.setLong(1, pid);
            rs= pstmt.executeQuery();

            while (rs.next()){
                dto.setP_id(rs.getLong("p_id"));
                dto.setP_name(rs.getString("p_name"));
                dto.setP_desc(rs.getString("p_desc"));
                dto.setP_price(rs.getInt("p_price"));
                dto.setP_img(rs.getString("p_img"));
                dto.setP_openchat(rs.getString("openchat"));
                dto.setP_date(rs.getDate("p_date").toLocalDate());
                dto.setP_state(rs.getString("p_state"));
                dto.setP_cate(rs.getString("p_cate"));
                dto.setReadno(rs.getInt("p_readno"));
                dto.setP_fav(rs.getInt("p_fav"));
                dto.setP_stock(rs.getInt("p_stock"));
                dto.setP_place(rs.getString("p_place"));
                dto.setP_trade(rs.getString("p_trade"));
                dto.setU_id(rs.getLong("u_id"));
            }
        } finally {
            disconn(rs);
        }
        return dto;
    }

    public void disconn(ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public int updateData(Connection conn, ProductDTO pdto) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE product SET                                     ");
        sql.append("                         p_name=?                       ");
        sql.append("                         , p_desc=?                     ");
        sql.append("                         , p_price=?                    ");
        sql.append("                         , p_img=?                      ");
        sql.append("                         , openchat=?                   ");
        sql.append("                         , p_state=?                    ");
        sql.append("                         , p_cate=?                     ");
        sql.append("                         , p_stock=?                    ");
        sql.append("                         , p_place=?                    ");
        sql.append("                         , p_trade=?                    ");
        sql.append(" WHERE p_id=?                                           ");
        int result = 0;
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ){
            pstmt.setString(1, pdto.getP_name());
            pstmt.setString(2, pdto.getP_desc());
            pstmt.setInt(3, pdto.getP_price());
            pstmt.setString(4, pdto.getP_img());
            pstmt.setString(5, pdto.getP_openchat());
            pstmt.setString(6,pdto.getP_state());
            pstmt.setString(7,pdto.getP_cate());
            pstmt.setInt(8, pdto.getP_cnt());
            pstmt.setString(9, pdto.getP_place());
            pstmt.setString(10, pdto.getP_trade());
            pstmt.setLong(11, pdto.getP_id());
            result = pstmt.executeUpdate();
        }
        return result;
    }

    public void deleteData(Connection conn, long pid) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" delete  from  product        ");
        sql.append(" where p_id=?                 ");
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql.toString());
                ){
            pstmt.setLong(1, pid);
            pstmt.executeUpdate();
        }
    }

    // 전체 검색 필터
    public List<ProductDTO> productListResult(Connection conn, ProductDTO dto) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT   p_img                                  ");
        sql.append("        , p_name                                 ");
        sql.append("        , p_price                                ");
        sql.append("        , p_state                                ");
        sql.append("        , p_fav                                  ");
        sql.append(" from product                                    ");
        sql.append(" where p_cate = ? AND p_trade = ? AND p_state= ? ");

        ResultSet rs = null;
        List<ProductDTO> list = new ArrayList<>();

        try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setString(1, dto.getP_cate());
            pstmt.setString(2, dto.getP_trade());
            pstmt.setString(3, dto.getP_state());
            while(rs.next()) {
                while (rs.next()) {
                    ProductDTO pdto = new ProductDTO();
                    dto.setP_id(rs.getLong("p_id"));
                    dto.setP_img(rs.getString("p_img"));
                    dto.setP_cate(rs.getString("p_cate"));
                    dto.setP_name(rs.getString("p_name"));
                    dto.setP_price(rs.getInt("p_price"));
                    dto.setP_state(rs.getString("p_state"));
                    dto.setP_fav(rs.getInt("p_fav"));
                    list.add(pdto);
                }

            }
            return list;
        }
    }

    // 최신글
    public List<ProductDTO> getNewList(Connection conn) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append(" select   p_id                   ");
        sql.append("        , p_img                  ");
        sql.append("        , p_cate                 ");
        sql.append("        , p_name                 ");
        sql.append("        , p_price                ");
        sql.append("        , p_state                ");
        sql.append("        , p_fav                  ");
        sql.append(" FROM product                    ");
        sql.append(" ORDER BY p_date DESC            ");
        sql.append(" LIMIT 6                         ");

        ResultSet rs = null;
        List<ProductDTO> list = new ArrayList<>();


        try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductDTO dto = new ProductDTO();
                dto.setP_id(rs.getLong("p_id"));
                dto.setP_img(rs.getString("p_img"));
                dto.setP_cate(rs.getString("p_cate"));
                dto.setP_name(rs.getString("p_name"));
                dto.setP_price(rs.getInt("p_price"));
                dto.setP_state(rs.getString("p_state"));
                dto.setP_fav(rs.getInt("p_fav"));
                list.add(dto);
            }
        } finally {
            if(rs!=null) try{rs.close();} catch (Exception e){}
        }
        return list;

    }

    public List<ProductDTO> getPopList(Connection conn) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT   p_id          ");
        sql.append("        , p_img         ");
        sql.append("        , p_cate        ");
        sql.append("        , p_name        ");
        sql.append("        , p_price       ");
        sql.append("        , p_state       ");
        sql.append("        , p_fav         ");
        sql.append(" FROM product           ");
        sql.append(" ORDER BY p_readno desc ");

        ResultSet rs = null;
        List<ProductDTO> list = new ArrayList<>();

        try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductDTO dto = new ProductDTO();
                dto.setP_id(rs.getLong("p_id"));
                dto.setP_img(rs.getString("p_img"));
                dto.setP_cate(rs.getString("p_cate"));
                dto.setP_name(rs.getString("p_name"));
                dto.setP_price(rs.getInt("p_price"));
                dto.setP_state(rs.getString("p_state"));
                dto.setP_fav(rs.getInt("p_fav"));
                list.add(dto);
            }
        }
        return list;
    }

    // 전체 검색
    public List<ProductDTO> searchResult(Connection conn, String search) throws SQLException{
        // 전체 검색을 위한 쿼리... 어떻게 짜야 할까? ㅠㅠ ㅋㅋ 테이블을 전부 엮어서 해야 할까?
        // 일단 product 들어오는 건 확실한데, 이거하고 board하고 연관된 게 없어서 하기 애매함 ㅠ
        // 글 내용
        // % search % 해서 where 절 조건에 넣어야 하는 건 알 것 같은데... ㅠㅋㅋ
        StringBuilder sql = new StringBuilder();
        sql.append(" select   p_id                   ");
        sql.append("        , p_img                  ");
        sql.append("        , p_cate                 ");
        sql.append("        , p_name                 ");
        sql.append("        , p_price                ");
        sql.append("        , p_state                ");
        sql.append("        , p_fav                  ");
        sql.append(" FROM product                    ");
        sql.append(" WHERE p_name LIKE ?             ");

        List<ProductDTO> arr = new ArrayList<>();
        ResultSet rs = null;

        try (PreparedStatement pstmt = (conn.prepareStatement(sql.toString()))){
            pstmt.setString(1, "%" + search + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ProductDTO dto = new ProductDTO();
                dto.setP_id(rs.getLong("p_id"));
                dto.setP_img(rs.getString("p_img"));
                dto.setP_cate(rs.getString("p_cate"));
                dto.setP_name(rs.getString("p_name"));
                dto.setP_price(rs.getInt("p_price"));
                dto.setP_state(rs.getString("p_state"));
                dto.setP_fav(rs.getInt("p_fav"));
                arr.add(dto);
            }
        } finally {
            if(rs!=null) try{rs.close();} catch (Exception e) {}
        }
        return arr;
    }

    /*public String userId(String id) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append(" select id             ");
        sql.
    }*/
}


