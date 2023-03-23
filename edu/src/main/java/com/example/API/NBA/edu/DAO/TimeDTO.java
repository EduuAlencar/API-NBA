package com.example.API.NBA.edu.DAO;


import com.example.API.NBA.edu.Models.TimeDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TimeDTO {


    private Long idHooper;

    private String name;
    private int idade;
    private String timeNBA;
    private String jogadorFav;

    private int titulosTime;


    public TimeDAO toDAO(){
        return TimeDAO
                .builder()
                .idHooper(idHooper)
                .jogadorFav(jogadorFav)
                .titulosTime(titulosTime)
                .name(name)
                .idade(idade)
                .timeNBA(timeNBA)
                .build();
    }

}
