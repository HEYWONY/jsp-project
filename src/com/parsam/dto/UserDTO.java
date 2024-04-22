package com.parsam.dto;

public class UserDTO {
    private long u_id;              // UserId
    private String id;              // 아이디
    private String pw;              // 비밀번호
    private String name;            // 이름
    private String nickname;        // 닉네임
    private String addr;            // 주소
    private String phone;           // 전화번호
    private boolean teacher_ck;     // 교사 인증 여부
    private String auth;            // 권한
    private String email;           // 이메일
    private String photo;           // 사진

    public UserDTO() {}

    // getter setter
    public long getU_id() {
        return u_id;
    }

    public void setU_id(long u_id) {
        this.u_id = u_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isTeacher_ck() {
        return teacher_ck;
    }

    public void setTeacher_ck(boolean teacher_ck) {
        this.teacher_ck = teacher_ck;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
