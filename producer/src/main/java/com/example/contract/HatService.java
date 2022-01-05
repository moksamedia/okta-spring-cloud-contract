package com.example.contract;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HatService {
    private final Map<Long, Hat> hatMap;
    public HatService() {
        hatMap = new HashMap<>();
        hatMap.put(1L, new Hat(1L, "Sombrero", 30L, "red"));
        hatMap.put(2L, new Hat(2L, "Beanie", 5L, "blue"));
    }
    Hat findHatById(Long id) {
        return hatMap.get(id);
    }
}
