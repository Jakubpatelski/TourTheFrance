package com.example.tourthefrance.Service;

import com.example.tourthefrance.Model.Biker;
import com.example.tourthefrance.Model.Team;
import com.example.tourthefrance.Repository.BikerRepository;
import com.example.tourthefrance.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BikerService {
    private BikerRepository bikerRepository;

    @Autowired
    public BikerService(BikerRepository bikerRepository) {
        this.bikerRepository = bikerRepository;
    }

    public List<Biker> getAll(){
        return bikerRepository.findAll();
    }

    public void deleteById(int id){
        bikerRepository.deleteById(id);
    }

    public Optional<Biker> getById(int id){
        return bikerRepository.findById(id);
    }
    public Biker add(Biker bike){
        return bikerRepository.save(bike);
    }

    public Biker updateBiker(int id, Biker biker){
        if (bikerRepository.findById(id).isPresent()){
            return bikerRepository.save(biker);
        }
            return null;
        }


    //Sorting With a Sort Parameter

    public List<Biker> findProductsWithSorting(String field){
        return  bikerRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }
    public List<Biker> findProductsWithSortingHighest(String field){
        return  bikerRepository.findAll(Sort.by(Sort.Direction.DESC,field));
    }


    public Biker getBikeByID(int id){
        return bikerRepository.findById(id).orElseThrow();
    }


}
