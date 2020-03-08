/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payroll.daoimpl;

import com.payroll.business.MessageForm;
import com.payroll.connection.DBConnection;
import com.payroll.dao.GenericDAO;
import com.payroll.dao.UserDAO;
import com.payroll.models.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Kashif Ali
 */
public class UserDaoImpl implements UserDAO,GenericDAO<User>{

    @Override
    public Boolean checkUsernameAvailbility(String username) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("select * from users where user_name = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return true;
    }
    @Override
    public Boolean checkEmailAvailbility(String email) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("select * from users where email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return true;
    }

    @Override
    public Integer registerUser(User userModel) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("Insert into users(user_name,password,first_name,last_name,email,address,phone_no,designation,status) values(?,?,?,?,?,?,?,?,?)");
            if(!checkUsernameAvailbility(userModel.getUserName()))
            {
                new MessageForm("Error", "Username already exists.", "error.png").setVisible(true);
                return 0;
            }
            if(!checkEmailAvailbility(userModel.getEmail()))
            {
                new MessageForm("Error", "Email address already exists.", "error.png").setVisible(true);
                return 0;
            }
            ps.setString(1, userModel.getUserName());
            ps.setString(2, userModel.getPassword());
            ps.setString(3, userModel.getFirstName());
            ps.setString(4, userModel.getLastName());
            ps.setString(5, userModel.getEmail());
            ps.setString(6, userModel.getAddress());
            ps.setString(7, userModel.getPhoneNumber());
            ps.setString(8, userModel.getDesignation());
            ps.setString(9, userModel.getStatus());
       
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return 0;
    }
    

    @Override
    public Integer changePassword(User user) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("Update users set password = ? where user_id = ?");

            ps.setString(1, user.getPassword());
            ps.setInt(2, user.getUserId());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return 0;
    }

    @Override
    public User loginUser(User user) {
        User userModel = null;
        try {
            String query = "";
            String userName;
            PreparedStatement ps;
            if(user.getUserName()!=null)
            {
                query = "select * from users where user_name = ? AND password =?";
                userName = user.getUserName();
            }else if(user.getEmail()!=null)
            {
                query = "select * from users where email = ? AND password =?";
                userName = user.getEmail();
            }else{
                return null;
            }
            ps = DBConnection.getInstance().prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, user.getPassword());
            // ps.setInt(3, 1);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                userModel = new User();
                userModel.setUserId(rs.getInt("user_id"));
                userModel.setUserName(rs.getString("user_name"));
                userModel.setPassword(rs.getString("password"));
                userModel.setAddress(rs.getString("address"));
                userModel.setEmail(rs.getString("email"));
                userModel.setFirstName(rs.getString("first_name"));
                userModel.setLastName(rs.getString("last_name"));
                userModel.setPhoneNumber(rs.getString("phone_no"));
                userModel.setStatus(rs.getString("password"));
                userModel.setDesignation(rs.getString("designation"));
                userModel.setStatus(rs.getString("status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return userModel;
    }


    @Override
    public User findById(Integer userId) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("Select * from users u where u.user_id = ?");
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            User user = new User();
            while(rs.next())
            {
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setFirstName(rs.getString(3));
                user.setLastName(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setAddress(rs.getString(6));
                user.setPhoneNumber(rs.getString(7));
                user.setDesignation(rs.getString(8));
                user.setPassword(rs.getString(9));
                user.setStatus(rs.getString(10));
            }
            return user;

        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }

        return null;
    }

    @Override
    public Integer save(User entity) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("Insert into users(user_name,password,first_name,last_name,email,address,phone_no,designation,status) values(?,?,?,?,?,?,?,?,?)");
            if(!checkUsernameAvailbility(entity.getUserName()))
            {
                new MessageForm("Error", "Username already exists.", "error.png").setVisible(true);
                return 0;
            }
            if(!checkEmailAvailbility(entity.getEmail()))
            {
                new MessageForm("Error", "Email address already exists.", "error.png").setVisible(true);
                return 0;
            }
            ps.setString(1, entity.getUserName());
            ps.setString(2, entity.getPassword());
            ps.setString(3, entity.getFirstName());
            ps.setString(4, entity.getLastName());
            ps.setString(5, entity.getEmail());
            ps.setString(6, entity.getAddress());
            ps.setString(7, entity.getPhoneNumber());
            ps.setString(8, entity.getDesignation());
            ps.setString(9, entity.getStatus());
       
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return 0;
    }

    @Override
    public Integer update(User entity) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("Update users set user_name =?,password =?,first_name =?,last_name =?,email=?,address=?,phone_no=?,designation=?,status =? where user_id = ?");
            ps.setString(1, entity.getUserName());
            ps.setString(2, entity.getPassword());
            ps.setString(3, entity.getFirstName());
            ps.setString(4, entity.getLastName());
            ps.setString(5, entity.getEmail());
            ps.setString(6, entity.getAddress());
            ps.setString(7, entity.getPhoneNumber());
            ps.setString(8, entity.getDesignation());
            ps.setString(9, entity.getStatus());
            ps.setInt(10, entity.getUserId());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            //  new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return 0;
    }

    @Override
    public Integer delete(Integer id) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("Delete from users where user_id = ?");
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return 0;
    }

    @Override
    public ResultSet findAll() {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("Select * from users");
            ResultSet rs = ps.executeQuery();

            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }

        return null;
    }

}
