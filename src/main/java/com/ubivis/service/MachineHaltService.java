package com.ubivis.service;

import com.ubivis.entity.MachineHalt;
import com.ubivis.entity.dto.MachineHaltDTO;
import com.ubivis.repository.MachineHaltRepository;
import com.ubivis.service.exceptions.MachineNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MachineHaltService {

    @Autowired
    private MachineHaltRepository repository;

    public MachineHalt salvar(MachineHalt machine_Halt){
        return repository.save(machine_Halt);
    }

    public List<MachineHalt> listaMachineHalt(String machine_tag, LocalDateTime interval_start, LocalDateTime interval_end) {

        return repository.findAllBy(machine_tag, interval_start, interval_end);
    }

    public MachineHalt buscarPorId(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new MachineNotFoundException("Machine com id " + id + " não foi encontrada."));
    }

    public void removerTodos(){
        repository.deleteAll();
    }

    public MachineHalt atualizar(MachineHaltDTO obj) throws Exception {
        MachineHalt entidade = repository.findById(obj.id())
                .orElseThrow(() -> new MachineNotFoundException("Machine com id " + obj.id() + " não foi encontrada."));

        updateData(entidade, obj);

        return repository.save(entidade);
    }

    private void updateData(MachineHalt entidade, MachineHaltDTO obj) {

        if(obj.end_time() != null) {
            entidade      .setEnd_time(obj.end_time().toLocalDateTime());
        }

        if(obj.reason() != null) {
            entidade          .setReason(obj.reason());
        }
    }
}