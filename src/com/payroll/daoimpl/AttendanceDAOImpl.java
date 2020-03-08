/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payroll.daoimpl;

import com.payroll.business.MessageForm;
import com.payroll.connection.DBConnection;
import com.payroll.dao.AttendanceDAO;
import com.payroll.dao.GenericDAO;
import com.payroll.models.Attendance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kashif Alei
 */
public class AttendanceDAOImpl implements GenericDAO<Attendance>{

    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement ps;
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    @Override
    public Attendance findById(Integer attendanceId) {
        try {
            connection = DBConnection.getInstance();
            ps = connection.prepareStatement("Select * from attendance where attendance_id=?;");
            ps.setInt(1, attendanceId);
            resultSet = ps.executeQuery();
            Attendance attendance = new Attendance();
            while(resultSet.next())
            {
                attendance.setAttendanceId(resultSet.getInt(1));
                attendance.setAttendanceDate(resultSet.getDate(2));
            }
            return attendance;
        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return null;
    }
    
    public ResultSet findAllAttendancesByUserName(String userName) {
        try {
                connection = DBConnection.getInstance();
                ps = connection.prepareStatement("select a.attendance_id,attendance_date,concat(u.first_name,\" \",u.last_name) as 'Name'\n" +
                                                "from attendance a inner join users u on a.user_id = u.user_id where u.user_name = ?;");
                ps.setString(1, userName);
                return ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return null;
    }
    
    public ResultSet findByMostPresentEmployee() {
        try {
                connection = DBConnection.getInstance();
                ps = connection.prepareStatement("select a.attendance_id,concat(u.first_name,\" \",u.last_name) as 'Name',count(*) as 'Days Present' from attendance a\n" +
                                                "inner join users u on a.user_id = u.user_id \n" +
                                                "group by u.user_id order by u.user_id;");
                return ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return null;
    }
    
    public ResultSet findByMostAbsentEmployees() {
        try {
                connection = DBConnection.getInstance();
                ps = connection.prepareStatement("select a.attendance_id,concat(u.first_name,\" \",u.last_name) as 'Name',count(*) as 'Days Present' from attendance a\n" +
                                                 "inner join users u on a.user_id = u.user_id \n" +
                                                 "group by u.user_id order by u.user_id desc;");
                return ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return null;
    }
    
    public boolean checkCurrentDayAttendanceExists(String userName) {
        try {
            String date = simpleDateFormat.format(new Date());
            connection = DBConnection.getInstance();
            ps = connection.prepareStatement("Select * from users where user_name = ? ");
            ps.setString(1, userName);
            resultSet = ps.executeQuery();
            Integer userId = -1;
            while (resultSet.next()) {
                userId = resultSet.getInt(1);
            }
            if (userId > 0) {
                ps = connection.prepareStatement("select a.attendance_id,attendance_date\n" +
                                                 "from attendance a where a.attendance_date = ? and a.user_id = ?;");
                ps.setString(1, date);
                ps.setInt(2, userId);
                resultSet = ps.executeQuery();
                boolean check = false;
                if(resultSet.next()) {
                    check = true;
                }
                return check;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Integer save(Attendance entity) {
    try {
            String date = simpleDateFormat.format(entity.getAttendanceDate());
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
                if(checkCurrentDayAttendanceExists(entity.getUserName()))
                {
                    return 0;
                }
                ps = connection.prepareStatement("Insert into attendance(attendance_date,user_id) values(?,?)");
                ps.setString(1, date);
                ps.setInt(2, userId);
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
    public Integer update(Attendance entity) {
        try {
            String date = simpleDateFormat.format(entity.getAttendanceDate());
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
                ps = connection.prepareStatement("update attendance set attendance_date =? ,user_id = ? where attendance_id=?");
                ps.setString(1, date);
                ps.setInt(2, userId);
                ps.setInt(3, entity.getAttendanceId());
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
                ps = connection.prepareStatement("Delete from attendance where attendance_id=?");
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
                ps = connection.prepareStatement("select a.attendance_id,attendance_date,concat(u.first_name,\" \",u.last_name) as 'Name'\n" +
                                                "from attendance a inner join users u on a.user_id = u.user_id;");
                return ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return null;
    }
    
}
