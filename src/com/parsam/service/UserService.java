package com.parsam.service;

import com.parsam.comm.DBConnection;
import com.parsam.dao.user.UserDAO;
import com.parsam.dto.ProductDTO;
import com.parsam.dto.ReviewDTO;
import com.parsam.dto.UserDTO;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    // 싱글톤
    private static UserService service = new UserService();

    public static UserService getService() {
        return service;
    }

    private UserService() {
    }

    /* 회원 가입 */
    public int insertUserData(UserDTO dto) {

        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        UserDAO dao = UserDAO.getDAO();

        int result = 0;

        try {
            conn = db.getConnection();  // DB 연결
            conn.setAutoCommit(false);

            result = dao.insertUserData(conn, dto);
            conn.commit();
        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println(e2);
            }
            System.out.println(e);
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return result;
    }

    /* 회원 정보 리스트 - 회원 정보 수정에 사용 */
    public UserDTO getModifyList(Long u_id) {

        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        UserDAO dao = UserDAO.getDAO();
        UserDTO dto = new UserDTO();

        try {
            conn = db.getConnection();  // db 연결
            conn.setAutoCommit(false);
            dto = dao.getModifyList(conn, u_id);
            conn.commit();
        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println(e2);
            }
            System.out.println(e);
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (Exception e) {
            }
        }

        return dto;
    }

    /* 회원정보 수정 */
    public int updateUserData(UserDTO dto) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        UserDAO dao = UserDAO.getDAO();
        int result = 0;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            result = dao.updateUserData(conn, dto);
            conn.commit();
        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println(e2);
            }
            System.out.println(e);
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return result;
    }

    /* 로그인 */
    public boolean doLogin(String id, String pw) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        UserDAO dao = UserDAO.getDAO();

        boolean result = false;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            result = dao.doLogin(conn, id, pw);

            conn.commit();
        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (SQLException e2) {
            }
            System.out.println(e);
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return result;
    }

    /* 아이디 찾기 */
    public String findId(String name, String email) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        UserDAO dao = UserDAO.getDAO();
        //UserDTO dto = new UserDTO();

        String id = null;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            id = dao.findId(conn, name, email);

            conn.commit();
        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (SQLException e2) {
            }
            System.out.println(e);
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return id;
    }


    public long getUid(String id) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        UserDAO dao = UserDAO.getDAO();

        long uid = 0;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            uid = dao.getUid(conn, id);
            conn.commit();
        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println(e2);
            }
            System.out.println(e);
        } finally {
            disconn(conn);
        }
        return uid;
    }

    private void disconn(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }


    /* 사용자 핀매내역(판매중) 내역 가져오기 */
    public List<ProductDTO> getUserSaleList(long u_id) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        List<ProductDTO> arr = new ArrayList<>();

        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            UserDAO dao = UserDAO.getDAO();
            arr = dao.getUserSaleList(conn, u_id);
            conn.commit();

        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (SQLException e2) {
            }
            System.out.println(e);
        } finally {
            db.disconn(conn);
        }
        return arr;
    }

    /* 사용자 판매내역(거래완료) 내역 가져오기*/
    public List<ProductDTO> getUserSoldList(Long u_id) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        List<ProductDTO> arr = new ArrayList<>();

        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            UserDAO dao = UserDAO.getDAO();
            arr = dao.getUserSoldList(conn, u_id);
            conn.commit();
        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (SQLException e2) {
            }
            System.out.println(e);
        } finally {
            db.disconn(conn);
        }
        return arr;
    }

    /* 사용자 구매내역 가져오기 */
    public List<ProductDTO> getUserShoppingList(Long u_id) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        List<ProductDTO> arr = new ArrayList<>();

        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            UserDAO dao = UserDAO.getDAO();
            arr = dao.getUserShoppingList(conn, u_id);
            conn.commit();
        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (SQLException e2) {
            }
            System.out.println(e);
        } finally {
            db.disconn(conn);
        }
        return arr;
    }

    /* 리뷰하기 */
    public int getReview(int rank, String id, Long u_id, Long pid) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        int result = 0;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            UserDAO dao = UserDAO.getDAO();
            result = dao.getReview(conn, id, u_id, pid, rank);

            conn.commit();
        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (SQLException e2) {
            }
            System.out.println(e);
        } finally {
            db.disconn(conn);
        }
        return result;
    }


    /* 교사 승인여부 */
    public List<UserDTO> teacherCK() {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        UserDAO dao = UserDAO.getDAO();
        List<UserDTO> arr = new ArrayList<>();

        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            arr = dao.teacherCK(conn);

            conn.commit();
        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (SQLException e2) {
            }
            System.out.println(e);
        } finally {
            db.disconn(conn);
        }
        return arr;
    }

    /* 관리자페이지 유저리스트 */
    public List<UserDTO> userlist() {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        UserDAO dao = UserDAO.getDAO();
        List<UserDTO> arr = new ArrayList<>();

        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            arr = dao.userlist(conn);

            conn.commit();
        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println(e2);
            }
            System.out.println(e);
        } finally {
            disconn(conn);
        }
        return arr;
    }

    public int userDelete(String id) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        UserDAO dao = UserDAO.getDAO();
        int result = 0;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            result = dao.userDelete(conn, id);
            conn.commit();
        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (SQLException e2) {
            }
            System.out.println(e);
        } finally {
            disconn(conn);
        }
        System.out.println(result + ".........User Service");
        return result;

    }

    public void teacherCK_Ok(String id) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        UserDAO dao = UserDAO.getDAO();

        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            dao.teacherCK_Ok(conn, id);
            conn.commit();
        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (SQLException e2) {
            }
            System.out.println(e);
        } finally {
            disconn(conn);
        }
    }


    /* 아이디 중복 확인 */
    public boolean getIdCheck(String id) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        UserDAO dao = UserDAO.getDAO();
        boolean result = true;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            result = dao.getIdCheck(conn, id);
            conn.commit();
        } catch (SQLException | NamingException e) {
            try {
                conn.rollback();
            } catch (SQLException e2) {
            }
            System.out.println(e);
        }
        return result;
    }



    /* 판매자 리뷰 평점 평균 */
    public ReviewDTO getReviewAvg(Long u_id) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        ReviewDTO dto = new ReviewDTO();
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            UserDAO dao = UserDAO.getDAO();
            dto = dao.getReviewAvg(conn, u_id);
            conn.commit();
        }catch (SQLException | NamingException e) {
            try{conn.rollback();} catch (SQLException e2){}
            System.out.println(e);
        }finally {
            db.disconn(conn);
        }
        return dto;

    }

    public int getTcCheck(long uid) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        int teacher_ck = 0;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            UserDAO dao = UserDAO.getDAO();
            teacher_ck= dao.getTcCheck(conn, uid);
            conn.commit();
        }catch (SQLException | NamingException e) {
            try{conn.rollback();} catch (SQLException e2){}
            System.out.println(e);
        } finally {
            db.disconn(conn);
        }
        return teacher_ck;
    }
}

