package com.example.project.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TimesDTO {
    LocalDate startTime;
    LocalDate endTime;
}
