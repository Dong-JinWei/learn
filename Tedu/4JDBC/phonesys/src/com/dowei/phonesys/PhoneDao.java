package com.dowei.phonesys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDao {

    public void add(Phone phone){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into tb_phone value(null, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, phone.getPhoneBrand());
            pstmt.setString(2, phone.getPhoneModel());
            pstmt.setString(3, phone.getPhoneName());
            pstmt.setDouble(4, phone.getPhonePrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
    }

    public void del(int phoneId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from tb_phone where phone_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, phoneId);
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }

    }

    public int update(Phone phone){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int effect = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update tb_phone set phone_brand = ?, phone_model = ?, phone_name = ?, phone_price = ? where phone_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, phone.getPhoneBrand());
            pstmt.setString(2, phone.getPhoneModel());
            pstmt.setString(3, phone.getPhoneName());
            pstmt.setDouble(4, phone.getPhonePrice());
            pstmt.setInt(5, phone.getPhoneId());
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
        return effect;
    }

    public Phone getOne(int phoneId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Phone phone = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from tb_phone where phone_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, phoneId);
            rs = pstmt.executeQuery();
            if (rs.next()){
                String phoneBrand = rs.getString("phone_brand");
                String phoneModel = rs.getString("phone_model");
                String phoneName = rs.getString("phone_name");
                double phonePrice = rs.getDouble("phone_price");
                phone = new Phone(phoneId, phoneBrand, phoneModel, phoneName, phonePrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }

        return phone;
    }

    public List<Phone> getAll(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Phone> phones = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from tb_phone";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            Phone phone = null;
            phones = new ArrayList<>();
            while(rs.next()){
                int phoneId = rs.getInt("phone_id");
                String phoneBrand = rs.getString("phone_brand");
                String phoneModel = rs.getString("phone_model");
                String phoneName = rs.getString("phone_name");
                double phonePrice = rs.getDouble("phone_price");
                phone = new Phone(phoneId, phoneBrand, phoneModel, phoneName, phonePrice);
                phones.add(phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return phones;
    }
}
