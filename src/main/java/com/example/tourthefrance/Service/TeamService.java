package com.example.tourthefrance.Service;

import com.example.tourthefrance.Model.Team;
import com.example.tourthefrance.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAll(){
        return teamRepository.findAll();
    }

    public void deleteById(int id){
         teamRepository.deleteById(id);
    }

    public Optional<Team> getById(int id){
        return teamRepository.findById(id);
    }
    public Team addOrUpdate(Team team){
        return teamRepository.save(team);
    }

    public Team update(int id,Team team) {

        if (teamRepository.findById(id).isPresent()) {
            return teamRepository.save(team);
        } else {
            return null;
        }
    }

    public Team getActivityById(int id) {
        return teamRepository.findById(id).orElse(null);
    }
}
