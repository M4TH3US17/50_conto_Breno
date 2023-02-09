package com.ubivis.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.time.LocalTime;

/*@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder*/
@Entity
public class Machine_halt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column (nullable = false, length = 24)
    private String machine_tag;

    @Column (nullable = false)
    private LocalTime start_time;

    @Column
    private LocalTime end_time;

    @Column (length = 128)
    private String reason ;

    public Machine_halt() {
    }

    public Machine_halt(Long id, LocalTime end_time, String machine_tag, LocalTime start_time, String reason) {
        this.id          = id;
        this.end_time    = end_time;
        this.machine_tag = machine_tag;
        this.start_time  = start_time;
        this.reason      = reason;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setMachine_tag(String machine_tag) {
        this.machine_tag = machine_tag;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

    public LocalTime getStart_time() {
        return start_time;
    }

    public String getReason() {
        return reason;
    }

    public String getMachine_tag() {
        return machine_tag;
    }

    public Long getId() {
        return id;
    }

    public LocalTime getEnd_time() {
        return end_time;
    }



}
