package com.parsam.service;

import com.parsam.comm.DBConnection;
import com.parsam.dao.ProductDAO;
import com.parsam.dto.ProductDTO;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private static ProductService service = new ProductService();
    public static ProductService getService() {return service;}
    private ProductService(){}

    public List<ProductDTO> productListService(){
        DBConnection db = DBConnection.getInstance();
        ProductDAO dao = ProductDAO.getDao();
        List<ProductDTO> arr = new ArrayList<>();
        try (Connection conn = db.getConnection()){
            arr = dao.getList(conn);
        } catch (SQLException | NamingException e){
            System.out.println(e);
        }
        return arr;
    }

}
