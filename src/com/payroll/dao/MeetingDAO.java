/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payroll.dao;

import com.payroll.models.Meeting;
import java.sql.ResultSet;

/**
 *
 * @author Kashif Alei
 */
public interface MeetingDAO {
 
    public Integer saveMeeting(Meeting meeting);    
    public Integer updateMeeting(Meeting meeting);
    public Integer deleteMeeting(Integer meetingId);
    public ResultSet findAllMeetings();
    public Meeting findById(Integer meetingId);
    
}
