package com.parsam.service;

import com.parsam.comm.DBConnection;
import com.parsam.dao.TestDAO;
import com.parsam.dto.TestDTO;
import org.junit.Test;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestService {
    private static TestService service = new TestService();

    public static TestService getService() {return service;}

    private TestService(){}

    public List<TestDTO> listService(){
        DBConnection db = DBConnection.getInstance();
        TestDAO dao = TestDAO.getDao();
        List<TestDTO> arr = new ArrayList<>();
        try (
                Connection conn = db.getConnection();
        ){
            arr = dao.getList(conn);
        } catch (SQLException | NamingException e){
            System.out.println(e);
        }
        return arr;
    }
}
