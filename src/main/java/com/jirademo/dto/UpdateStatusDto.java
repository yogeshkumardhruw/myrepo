package com.jirademo.dto;

import com.jirademo.enums.TaskStatus;
import lombok.Data;

@Data
public class UpdateStatusDto {

    private TaskStatus taskStatus;

}
