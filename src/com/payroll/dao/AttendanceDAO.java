/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payroll.dao;

import com.payroll.models.Attendance;
import java.sql.ResultSet;

/**
 *
 * @author Kashif Alei
 */
public interface AttendanceDAO {
  
    public Integer saveAttendance(Attendance attendance);    
    
    public Integer updateAttendance(Attendance attendance);
    
    public Integer deleteAttendance(Integer attendanceId);
    
    public ResultSet findAllAttendances();
    
    public Attendance findById(Integer attendanceId);
    
}
