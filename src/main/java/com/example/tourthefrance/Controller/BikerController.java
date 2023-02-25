package com.example.tourthefrance.Controller;


import com.example.tourthefrance.Exception.BikerNotFoundException;
import com.example.tourthefrance.Model.Biker;
import com.example.tourthefrance.Repository.BikerRepository;
import com.example.tourthefrance.Service.BikerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bikers")
@CrossOrigin
public class BikerController {

    private BikerService bikerService;
    private BikerRepository repo;

    @Autowired
    public BikerController(BikerService bikerService, BikerRepository repo) {
        this.bikerService = bikerService;
        this.repo = repo;
    }

    @GetMapping("/top4Time/riders")
    public List<Biker> getRiderTop4Times(){
        return repo.findTop300ByOrderByTime();
    }

    @GetMapping
    public List<Biker> getAll(){
         return bikerService.getAll();
    }

    @GetMapping("/{id}")
    public Biker getBikerByID(@PathVariable int id){
        return bikerService.getById(id).orElseThrow(() -> new BikerNotFoundException(id));
    }


    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    private Biker addBiker(@RequestBody Biker biker){
        return bikerService.add(biker);
    }

    @DeleteMapping("/{id}")
    private void deleteBikerById(@PathVariable("id") int id){
        bikerService.deleteById(id);
    }

    @PutMapping("/{id}")
    private Biker updateBiker(@PathVariable("id") int id,@RequestBody Biker biker){
        return bikerService.updateBiker(id,biker);
    }

    @GetMapping("/mountain")
    public List<Biker> getTopMountain(){
        return repo.findTopByOrderByMountainsPoint();
    }

    @GetMapping("/search/name/{name}")
    public List<Biker> findBYName(@PathVariable("name") String name){
        return repo.findByFirstName(name);
    }


    @GetMapping("/white")
    public List<Biker> getTopWhiteJersey(){
        return repo.findTopWhiteJersey();
    }


    //get all bikers from a given team
    @GetMapping("/team/rider/{teamId}")
    public List<Biker> getRidersFromTeam(@PathVariable("teamId") int teamId) {
        List<Biker> riderList = repo.findAll();
        List<Biker> riderListResult = new ArrayList<>();
        if (!riderList.isEmpty()) {
            for (Biker rider : riderList) {
                if (rider.getTeam().getId() == teamId) {
                    riderListResult.add(rider);
                }
            }
        }
        return riderListResult;
    }
    @GetMapping("/team/{id}")
    public List<Biker> getBikersTeam(@PathVariable("id") int id){
        return repo.findBikerByTeamId(id);
    }

    @GetMapping("/sprint")
    public  List<Biker> getTopSprinter(){
        return repo.findTopByOrderBySprintPointsDesc();
    }


    @GetMapping("/sort/{field}")
    private List<Biker> getIt(@PathVariable String field){
        return bikerService.findProductsWithSorting(field);
    }
    @GetMapping("/sort/high/{field}")
    private List<Biker> getIt2(@PathVariable String field){

        return bikerService.findProductsWithSortingHighest(field);

    }

}
