package com.ubivis.controller;

import com.ubivis.entity.Machine_halt;
import com.ubivis.service.MachineHaltService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/")
public class MachineHaltController {

    @Autowired
    private MachineHaltService service;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "/machine-halt", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Machine_halt> salvar(@RequestBody Machine_halt machine_halt){
        Machine_halt object = service.salvar(machine_halt);
        return ResponseEntity.status(HttpStatus.CREATED).body(object);
    }

    @GetMapping(value = "/machine-halt/list", produces = "application/json")
    public ResponseEntity<List<Machine_halt>> listar(@RequestParam(required = false) LocalTime interval_start,
                                                     @RequestParam(required = false) LocalTime interval_end,
                                                     @RequestParam(required = false) String machine_tag){
        return ResponseEntity.ok().body(service.listaMachineHalt(machine_tag, interval_start, interval_end));
    }

    @GetMapping(value = "/machine-halt/{id}", produces = "application/json")
    public ResponseEntity<Machine_halt> buscarPorId(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    @DeleteMapping(value = "/machine-halt/all")
    public ResponseEntity<Void> remover() {
        service.removerTodos();
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/machine-halt/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Machine_halt> atualizar(@PathVariable("id") Long idMachine, @RequestBody Machine_halt machine) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(idMachine, machine));
    }
}