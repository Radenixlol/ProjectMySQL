/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.first.mysql.controller;

import com.first.mysql.model.dto.ClienteDto;
import com.first.mysql.model.entity.Cliente;
import com.first.mysql.model.payload.MensajeResponse;
import com.first.mysql.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Radenixlol
 */
@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private ICliente clienteService;

    @PostMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody ClienteDto clienteDto) {
        Cliente clienteSave;
        try {
            clienteSave = clienteService.save(clienteDto);
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("Guardaddo correctamente")
                            .object(ClienteDto.builder()
                                    .idCliente(clienteSave.getIdCliente())
                                    .nombre(clienteSave.getNombre())
                                    .apellido(clienteSave.getApellido())
                                    .correo(clienteSave.getCorreo())
                                    .fechaRegistro(clienteSave.getFechaRegistro())
                                    .build())
                            .build(),
                    HttpStatus.CREATED);

        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("cliente/{id}")
    public ResponseEntity<?> update(@RequestBody ClienteDto clienteDto, @PathVariable Integer id) {
        Cliente clienteUpdate;
        try {
            Cliente findcliente = clienteService.findById(id);
            if (findcliente != null) {
                clienteUpdate = clienteService.save(clienteDto);
                return new ResponseEntity<>(
                        MensajeResponse.builder()
                                .mensaje("Guardaddo correctamente")
                                .object(ClienteDto.builder()
                                        .idCliente(clienteUpdate.getIdCliente())
                                        .nombre(clienteUpdate.getNombre())
                                        .apellido(clienteUpdate.getApellido())
                                        .correo(clienteUpdate.getCorreo())
                                        .fechaRegistro(clienteUpdate.getFechaRegistro())
                                        .build())
                                .build(),
                        HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(
                        MensajeResponse.builder()
                                .mensaje("El resgitro no encuentra")
                                .object(null)
                                .build(),
                        HttpStatus.NOT_FOUND);
            }

        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Cliente clienteDelete = clienteService.findById(id);
            clienteService.delete(clienteDelete);
            return new ResponseEntity<>(clienteDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("cliente/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);
        if (cliente == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("El registro que intenta buscar, no existe!!")
                            .object(null)
                            .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("El registro que intenta buscar, no existe!!")
                        .object(ClienteDto.builder()
                                .idCliente(cliente.getIdCliente())
                                .nombre(cliente.getNombre())
                                .apellido(cliente.getApellido())
                                .correo(cliente.getCorreo())
                                .fechaRegistro(cliente.getFechaRegistro())
                                .build())
                        .build(),
                HttpStatus.OK);
    }
}
