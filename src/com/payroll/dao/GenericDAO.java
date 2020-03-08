/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payroll.dao;


import java.sql.ResultSet;

/**
 *
 * @author Kashif Alei
 */
public interface GenericDAO<T> {
    public Integer save(T entity);    
    
    public Integer update(T entity);
    
    public Integer delete(Integer id);
    
    public ResultSet findAll();
    
    public T findById(Integer id);
}
