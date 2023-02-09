package com.ubivis.repository;

import com.ubivis.entity.MachineHalt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MachineHaltRepository extends JpaRepository <MachineHalt, Long> {

    @Query("SELECT m FROM MachineHalt m WHERE m.machine_tag = :Machine_tag AND " +
            "(m.start_time between :Start_time AND :End_time " +
            "OR m.end_time between :Start_time AND :End_time)")
    List<MachineHalt> findAllBy(@Param("Machine_tag") String machine_tag,
                                @Param("Start_time") LocalDateTime start_time,
                                @Param("End_time") LocalDateTime end_time);
}
