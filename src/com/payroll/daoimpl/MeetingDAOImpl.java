/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payroll.daoimpl;

import com.payroll.business.MessageForm;
import com.payroll.connection.DBConnection;
import com.payroll.dao.GenericDAO;
import com.payroll.dao.MeetingDAO;
import com.payroll.models.Meeting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

/**
 *
 * @author Kashif Alei
 */
public class MeetingDAOImpl implements GenericDAO<Meeting>{
    
    private Connection connection = DBConnection.getInstance();
    private ResultSet resultSet;
    private PreparedStatement ps;
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    
    @Override
    public Meeting findById(Integer meetingId) {
        try {
            connection = DBConnection.getInstance();
            ps = connection.prepareStatement("Select * from meeting;");
            resultSet = ps.executeQuery();
            Meeting meeting = new Meeting();
            while(resultSet.next())
            {
              meeting.setMeetingId(resultSet.getInt(0));
              meeting.setMeetingTitle(resultSet.getString(1));
              meeting.setMeetingDate(resultSet.getDate(2));
              meeting.setMeetingAgenda(resultSet.getString(3));
            }
            return meeting;
            
        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return null;
    }

    @Override
    public Integer save(Meeting entity) {
                try {
            String date = simpleDateFormat.format(entity.getMeetingDate());
            connection = DBConnection.getInstance();
            ps = connection.prepareStatement("Insert into meeting(meeting_title,meeting_date,meeting_agenda) values(?,?,?)");
            ps.setString(1, entity.getMeetingTitle());
            ps.setString(2, date);
            ps.setString(3, entity.getMeetingAgenda());
            return ps.executeUpdate();   
            
        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return 0;
    }

    @Override
    public Integer update(Meeting entity) {
        try {
            String date = simpleDateFormat.format(entity.getMeetingDate());
            connection = DBConnection.getInstance();
            ps = connection.prepareStatement("update meeting set meeting_title =? ,meeting_date =?,meeting_agenda =? where meeting_id = ?");
            ps.setString(1, entity.getMeetingTitle());
            ps.setString(2, date);
            ps.setString(3, entity.getMeetingAgenda());
            ps.setInt(4, entity.getMeetingId());
            return ps.executeUpdate();   
            
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
            ps = connection.prepareStatement("delete from meeting where meeting_id = ?");
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
            ps = connection.prepareStatement("Select * from meeting;");
            resultSet = ps.executeQuery();
            return resultSet;
            
        } catch (Exception e) {
            e.printStackTrace();
            new MessageForm("Error", e.toString(), "error.png").setVisible(true);
        }
        return null;
    }
    
}
