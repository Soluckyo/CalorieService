package org.lib.calorieservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SumReportDTO {
    private LocalDateTime date;
    private Long userId;

}
