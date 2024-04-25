package com.parsam.service;

import com.parsam.comm.DBConnection;
import com.parsam.dao.ProductDAO;
import com.parsam.dto.ProductDTO;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchProductService {

    private static SearchProductService service = new SearchProductService();
    public static SearchProductService getService() {return  service; }
    private SearchProductService(){}

    // 서비스 만들고 자료 만들어서 매소드 호출하기
    public List<ProductDTO> searchResult(String search) {
        DBConnection db = DBConnection.getInstance();
        ProductDAO dao = ProductDAO.getDao();
        List<ProductDTO> arr = new ArrayList<>();
        Connection conn = null;

        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            arr = dao.searchResult(conn, search);
            conn.commit();
        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println(e2);
            }
            System.out.println(e);
        } finally {
            db.disconn(conn);
        }
        return arr;
    }


}
