package com.example.contract;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class HatController {
    private final HatService hatService;

    public HatController(HatService hatService) {
        this.hatService = hatService;
    }

    @GetMapping("hat/{id}")
    public Hat findHatById(@PathVariable("id") Long id) {
        Hat hat = hatService.findHatById(id);
        if (hat == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found"
            );
        }
        return hat;
    }
}