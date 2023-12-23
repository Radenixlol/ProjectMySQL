/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.mysql.service.impl;

import com.first.mysql.model.dao.ClienteDao;
import com.first.mysql.model.entity.Cliente;
import com.first.mysql.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Radenixlol
 */
@Service
public class ClienteImpl implements ICliente{
    
    @Autowired
    private ClienteDao clienteDao;
    
    @Override
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    public Cliente findById(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }
    
}
