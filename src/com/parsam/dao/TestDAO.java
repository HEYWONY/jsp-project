package com.parsam.dao;

import com.parsam.dto.TestDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {

    private static TestDAO dao = new TestDAO();
    public static TestDAO getDao() { return dao; }
    private TestDAO(){}


    public List<TestDTO> getList(Connection conn) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" select * from porder2");
        List<TestDTO> arr = new ArrayList<>();
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql.toString());
                ResultSet rs = pstmt.executeQuery();
                ){
            while (rs.next()){
                TestDTO dto = new TestDTO();
                dto.setO_id(rs.getLong("o_id"));
                dto.setO_addr(rs.getString("o_addr"));
                dto.setO_memo(rs.getString("o_memo"));
                dto.setO_phone(rs.getString("o_phone"));
                dto.setP_id(rs.getLong("p_id"));
                dto.setU_id(rs.getLong("u_id"));
                dto.setO_cnt(rs.getInt("o_cnt"));
                dto.setO_date(rs.getDate("o_date").toLocalDate());
                arr.add(dto);
            }
        }
        return arr;
    }
}
