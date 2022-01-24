package com.example.contract;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Hat {
    private Long id;
    private String name;
    private Long size;
    private String color;
}
