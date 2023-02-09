package com.ubivis.controller;

import com.ubivis.entity.MachineHalt;
import com.ubivis.entity.dto.MachineHaltDTO;
import com.ubivis.service.MachineHaltService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
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
    public ResponseEntity<MachineHalt> salvar(@RequestBody MachineHalt machine_halt){
        MachineHalt object = service.salvar(machine_halt);
        return ResponseEntity.status(HttpStatus.CREATED).body(object);
    }

    @GetMapping(value = "/machine-halt/list", produces = "application/json")
    public ResponseEntity<List<MachineHalt>> listar(@RequestParam("interval_start")
                                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                            ZonedDateTime intervalStart,
                                                     @RequestParam("interval_end")
                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                            ZonedDateTime intervalEnd,
                                                     @RequestParam("machine_tag") String machine_tag) {
        return ResponseEntity.ok().body(service.listaMachineHalt(machine_tag, intervalStart.toLocalDateTime(), intervalEnd.toLocalDateTime()));
    }

    @GetMapping(value = "/machine-halt/{id}", produces = "application/json")
    public ResponseEntity<MachineHalt> buscarPorId(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    @DeleteMapping(value = "/machine-halt/all")
    public ResponseEntity<Void> remover() {
        service.removerTodos();
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/machine-halt", consumes = "application/json", produces = "application/json")
    public ResponseEntity<MachineHalt> atualizar(@RequestBody MachineHaltDTO machine) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(machine));
    }
}