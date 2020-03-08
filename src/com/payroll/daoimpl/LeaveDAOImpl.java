/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payroll.daoimpl;

import com.payroll.business.MessageForm;
import com.payroll.connection.DBConnection;
import com.payroll.dao.GenericDAO;
import com.payroll.dao.LeaveDAO;
import com.payroll.models.Leave;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

/**
 *
 * @author Kashif Alei
 */
public class LeaveDAOImpl implements GenericDAO<Leave>{

    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement ps;
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    @Override
    public Leave findById(Integer leaveId) {
        try {
            connection = DBConnection.getInstance();
            ps = connection.prepareStatement("Select * from leave_table where leave_id = ? ");
            ps.setInt(1, leaveId);
            resultSet = ps.executeQuery();
            
            Leave leave = new Leave();
            
            while(resultSet.next())
            {
                leave.setLeaveId(resultSet.getInt(1));
                leave.setLeaveDate(resultSet.getDate(2));
                leave.setLeaveReason(resultSet.getString(3));
                leave.setUserName(resultSet.getString(4));
                leave.setLeaveStatus(resultSet.getString(5));
            }
            
            return leave;
        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return null;
    }

    public ResultSet findAllLeavesByUserId(Integer userId) {
        try {
            connection = DBConnection.getInstance();
            ps = connection.prepareStatement("Select * from leave_table where user_id = ? ");
            ps.setInt(1, userId);
            resultSet = ps.executeQuery();
            return resultSet;
        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return null;
    }
    
        public Integer updateLeaveForAdmin(Leave leave) {
        try {
            connection = DBConnection.getInstance();

                System.out.println("Updating record..");
                String date = simpleDateFormat.format(leave.getLeaveDate());
                ps = connection.prepareStatement("update leave_table set leave_date =?,reason =?,user_id = ?,status=? where leave_id=?");
                ps.setString(1, date);
                ps.setString(2, leave.getLeaveReason());
                ps.setString(3, leave.getUserName());
                ps.setString(4, leave.getLeaveStatus());
                ps.setInt(5, leave.getLeaveId());
                return ps.executeUpdate();   

        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return 0;
    }

    @Override
    public Integer save(Leave entity) {
        try {
            connection = DBConnection.getInstance();
            ps = connection.prepareStatement("Select * from users where user_name = ? ");
            ps.setString(1, entity.getUserName());
            resultSet = ps.executeQuery();
            Integer userId = -1;
            while (resultSet.next()) {
               userId = resultSet.getInt(1);
            }
            if(userId>0)
            {
                String date = simpleDateFormat.format(entity.getLeaveDate());
                ps = connection.prepareStatement("Insert into leave_table(leave_date,reason,user_id,status) values(?,?,?,?)");
                ps.setString(1, date);
                ps.setString(2, entity.getLeaveReason());
                ps.setInt(3, userId);
                ps.setString(4, entity.getLeaveStatus());
                return ps.executeUpdate();   
            }else{
                return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return 0;
    }

    @Override
    public Integer update(Leave entity) {
        try {
            connection = DBConnection.getInstance();
            ps = connection.prepareStatement("Select * from users where user_name = ? ");
            ps.setString(1, entity.getUserName());
            resultSet = ps.executeQuery();
            Integer userId = -1;
            while (resultSet.next()) {
               userId = resultSet.getInt(1);
            }
            if(userId>0)
            {
                System.out.println("Updating record..");
                String date = simpleDateFormat.format(entity.getLeaveDate());
                ps = connection.prepareStatement("update leave_table set leave_date =?,reason =?,user_id = ?,status=? where leave_id=?");
                ps.setString(1, date);
                ps.setString(2, entity.getLeaveReason());
                ps.setInt(3, userId);
                ps.setString(4, entity.getLeaveStatus());
                ps.setInt(5, entity.getLeaveId());
                return ps.executeUpdate();   
            }else{
                return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return 0;
    }

    @Override
    public Integer delete(Integer id) {
        try {
            connection = DBConnection.getInstance();
                ps = connection.prepareStatement("DELETE from leave_table where leave_id=?");
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
            connection = DBConnection.getInstance();
            ps = connection.prepareStatement("select l.leave_id,l.leave_date,l.reason,concat(u.first_name,\" \",u.last_name) as 'Name',l.status \n" +
                                            "from leave_table l inner join users u on l.user_id = u.user_id;");
            resultSet = ps.executeQuery();
            return resultSet;   
        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return null;
    }
    
}
