package com.example.tourthefrance.config;

import com.example.tourthefrance.Model.Biker;
import com.example.tourthefrance.Model.Team;
import com.example.tourthefrance.Repository.BikerRepository;
import com.example.tourthefrance.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartAndSave implements CommandLineRunner {


    TeamRepository teamRepository;
    BikerRepository bikerRepository;

    public StartAndSave(TeamRepository teamRepository, BikerRepository bikerRepository) {
        this.teamRepository = teamRepository;
        this.bikerRepository = bikerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Team team = new Team("Saxo-bank");
        Team team1 = new Team("Astana");

        teamRepository.save(team);
        teamRepository.save(team1);


        Biker biker1 = new Biker("JAkub", "patelski", 12.02, 12,10, 35,"Poland");
        Biker biker2 = new Biker("Mikel", "Probierz", 13.02,12,20, 30, "Germany" );
        biker1.setTeam(team);
        biker2.setTeam(team);
        Biker biker3 = new Biker("Jorge", "Frank", 13.02,12,20, 30, "Germany" );
        biker3.setTeam(team1);


        bikerRepository.save(biker1);
        bikerRepository.save(biker2);
        bikerRepository.save(biker3);



        teamRepository.save(team);
        Biker biker10 = new Biker("Valeino", "Rosso", 12.55,20, 30, 25,"Germany",team1);
        Biker biker11 = new Biker("Marko", "Polo", 15.55,20, 30, 29,"Germany",team1);
        Biker biker12 = new Biker("Florian", "Ring", 11.55,20, 35, 35,"Germany",team1);


        bikerRepository.save(biker10);
        bikerRepository.save(biker11);
        bikerRepository.save(biker12);





    }
}
