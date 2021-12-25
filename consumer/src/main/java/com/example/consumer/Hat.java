package com.example.consumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor // needed for Jackson serialization
public class Hat {
    private Long id;
    private String name;
    private Long size;
    private String color;
}
