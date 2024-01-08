/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.first.mysql.service;

import com.first.mysql.model.dto.ClienteDto;
import com.first.mysql.model.entity.Cliente;

/**
 *
 * @author Radenixlol
 */
public interface ICliente {
    
    Cliente save(ClienteDto cliente);
    
    Cliente findById(Integer id);
    
    void delete(Cliente cliente);
    
    boolean existsById(Integer id);
}

