package com.ubivis.entity;



import jakarta.persistence.*;


import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class MachineHalt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column (nullable = false, length = 24)
    private String machine_tag;

    @Column (nullable = false)
    private LocalDateTime start_time;

    @Column
    private LocalDateTime end_time;

    @Column (length = 128)
    private String reason ;

    public MachineHalt() {
    }

    public MachineHalt(Long id, LocalDateTime end_time, String machine_tag, LocalDateTime start_time, String reason) {
        this.id          = id;
        this.end_time    = end_time;
        this.machine_tag = machine_tag;
        this.start_time  = start_time;
        this.reason      = reason;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMachine_tag() {
        return machine_tag;
    }

    public void setMachine_tag(String machine_tag) {
        this.machine_tag = machine_tag;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
