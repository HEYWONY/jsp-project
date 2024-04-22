package com.parsam.dao;

import com.parsam.dto.ProductDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private static ProductDAO dao = new ProductDAO();
    public static ProductDAO getDao() { return dao; }
    private ProductDAO(){}

    public List<ProductDTO> getList(Connection conn) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT   p_img                  ");
        sql.append("        , p_cate                 ");
        sql.append("        , p_name                 ");
        sql.append("        , p_price                ");
        sql.append("        , p_state                ");
        sql.append("        , p_fav                  ");
        sql.append(" FROM product                    ");

        ResultSet rs = null;
        List<ProductDTO> arr = new ArrayList<>();

        try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductDTO dto = new ProductDTO();
                dto.setP_img(rs.getString("p_img"));
                dto.setP_cate(rs.getString("p_cate"));
                dto.setP_name(rs.getString("p_name"));
                dto.setP_price(rs.getInt("p_price"));
                dto.setP_state(rs.getString("p_state"));
                dto.setP_fav(rs.getInt("p_fav"));
                arr.add(dto);
            }
        }
        return arr;
    }

}
