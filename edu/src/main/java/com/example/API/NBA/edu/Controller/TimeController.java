package com.example.API.NBA.edu.Controller;


import com.example.API.NBA.edu.DAO.TimeDTO;
import com.example.API.NBA.edu.Models.TimeDAO;
import com.example.API.NBA.edu.Repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController

public class TimeController {

    @Autowired
    private TimeRepository timeRepository;
    public List<TimeDTO> timeLista = new ArrayList<TimeDTO>();


    public HashMap<Integer, TimeDTO> times = new HashMap<Integer, TimeDTO>();


    @PostMapping("/times-NBA")
    public ResponseEntity<TimeDTO> addTime(@RequestBody TimeDTO t){
        TimeDAO timesPersisted = timeRepository.save(t.toDAO());
        return new ResponseEntity<TimeDTO>(timesPersisted.toDTO(), HttpStatus.OK);
    }


    @GetMapping("/times")
    public ResponseEntity<List<TimeDTO>> todosTimes() {
        return ResponseEntity.ok().body(timeRepository.findAll()
                .stream()
                .map(timeDAO -> timeDAO.toDTO())
                .collect(Collectors.toList()));

    }

    @PutMapping("/times/{id}/atualiza")
    public ResponseEntity<TimeDTO> atualizaNBA(@PathVariable("id") Long id, @RequestBody TimeDTO t){
        t.setIdHooper(id);
        System.out.println("O usuario foi atualizado");
        TimeDAO nbaUp = timeRepository.save(t.toDAO());
        return new ResponseEntity<TimeDTO>(nbaUp.toDTO(), HttpStatus.OK);
    }

    @DeleteMapping ("/time/{id}/deletar")
    public ResponseEntity<TimeDTO> deletarTime(@PathVariable("id") Long id){
        TimeDAO time = new TimeDAO();
        time.setIdHooper(id);
        timeRepository.delete(time);
        return ResponseEntity.noContent().build();
    }


}

