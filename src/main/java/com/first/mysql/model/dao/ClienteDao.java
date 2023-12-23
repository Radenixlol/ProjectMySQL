/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.mysql.model.dao;

import com.first.mysql.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Radenixlol
 */
public interface ClienteDao extends CrudRepository<Cliente, Integer>{
    
}
