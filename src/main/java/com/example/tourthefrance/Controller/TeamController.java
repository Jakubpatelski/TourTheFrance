package com.example.tourthefrance.Controller;

import com.example.tourthefrance.Model.Biker;
import com.example.tourthefrance.Model.Team;
import com.example.tourthefrance.Repository.TeamRepository;
import com.example.tourthefrance.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
@CrossOrigin
public class TeamController {

    private TeamService teamService;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getall(){
        return teamService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Team> getTeam(@PathVariable("id") int id){
        return teamService.getById(id);
    }
    @PostMapping
    public Team addTeam(@RequestBody Team team){
        return teamService.addOrUpdate(team);
    }

    @DeleteMapping("/{id}")
    private void deleteTeamById(@PathVariable("id") int id){
        teamService.deleteById(id);
    }

    @PutMapping("/{id}")
    private Team updateBiker(@PathVariable("id") int id,@RequestBody Team team){
        return teamService.update(id,team);
    }




}
