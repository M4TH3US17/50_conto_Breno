package com.ubivis.entity.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.ZonedDateTime;

public record MachineHaltDTO(
        Long id,
        String reason,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        ZonedDateTime end_time
) {
}
