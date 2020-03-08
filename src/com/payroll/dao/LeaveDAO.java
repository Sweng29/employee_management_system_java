/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payroll.dao;

import com.payroll.models.Leave;
import java.sql.ResultSet;

/**
 *
 * @author Kashif Alei
 */
public interface LeaveDAO {
    
    public Integer saveLeave(Leave leave);    
    
    public Integer updateLeave(Leave leave);
    
    public Integer deleteLeave(Integer leaveId);
    
    public ResultSet findAllLeaves();
    
    public Leave findById(Integer leaveId);
}
