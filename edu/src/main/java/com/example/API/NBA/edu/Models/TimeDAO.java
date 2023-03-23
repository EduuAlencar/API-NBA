package com.example.API.NBA.edu.Models;

import com.example.API.NBA.edu.DAO.TimeDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "NBA")

public class TimeDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idHooper;


    private String name;

    private int idade;

    private String timeNBA;

    private String jogadorFav;

    private int titulosTime;



    public TimeDTO toDTO(){
        return TimeDTO
                .builder()
                .idHooper(idHooper)
                .name(name)
                .idade(idade)
                .timeNBA(timeNBA)
                .jogadorFav(jogadorFav)
                .titulosTime(titulosTime)
                .build();
    }
}
