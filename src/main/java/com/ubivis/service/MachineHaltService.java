package com.ubivis.service;

import com.ubivis.entity.Machine_halt;
import com.ubivis.repository.MachineHaltRepository;
import com.ubivis.service.exceptions.MachineNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MachineHaltService {

    @Autowired
    private MachineHaltRepository repository;

    public Machine_halt salvar(Machine_halt machine_Halt){
        return repository.save(machine_Halt);
    }

    public List<Machine_halt> listaMachineHalt(String machine_tag, LocalTime interval_start, LocalTime interval_end){
        List<Machine_halt> list           = repository.findAll();
        List<Machine_halt> lista_filtrada = new ArrayList<>();

        if(machine_tag != null) {
           lista_filtrada.addAll(list.stream()
                   .filter(x -> x.getMachine_tag().equalsIgnoreCase(machine_tag)).collect(Collectors.toList()));
        }
        if(interval_start != null) {
            lista_filtrada
                    .addAll(list.stream().filter(x -> x.getStart_time() == interval_start).collect(Collectors.toList()));
        }
        if(interval_end != null) {
            lista_filtrada
                    .addAll(list.stream().filter(x -> x.getEnd_time() == interval_end).collect(Collectors.toList()));
        }
        return lista_filtrada;
    }

    public Machine_halt buscarPorId(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new MachineNotFoundException("Machine com id " + id + " não foi encontrada."));
    }

    public void removerTodos(){
        repository.deleteAll();
    }

    public Machine_halt atualizar(Long id, Machine_halt obj) throws Exception {
        Machine_halt entidade = repository.findById(id)
                .orElseThrow(() -> new MachineNotFoundException("Machine com id " + id + " não foi encontrada."));
        updateData(entidade, obj);

        return repository.save(entidade);
    }

    private void updateData(Machine_halt entidade, Machine_halt obj) {

        entidade.setMachine_tag(obj.getMachine_tag());
        entidade          .setReason(obj.getReason());
        entidade      .setEnd_time(obj.getEnd_time());
        entidade  .setStart_time(obj.getStart_time());
    }
}