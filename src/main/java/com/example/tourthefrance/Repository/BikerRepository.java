package com.example.tourthefrance.Repository;

import com.example.tourthefrance.Model.Biker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikerRepository extends JpaRepository <Biker, Integer> {

//    many of them repear, written in many ways to practise

    List<Biker> findByFirstName(String firstName);
    List<Biker> findTop300ByOrderByTime();
    List<Biker> findTopByOrderByTime();
    List<Biker> findTopByOrderByMountainsPoint();
    List<Biker> findTopByOrderBySprintPointsDesc();

    @Query("from  Biker order by time asc")
    List<Biker> allBikers();

    @Query("select a from Biker a order by a.time asc")
    List<Biker> allBikers2();


    @Query(value = "select t from Biker t where t.age <= 25 order by t.time ASC")
    List<Biker> findTopWhiteJersey();

    List<Biker> findBikerByTeamId(int teamId);

    @Query("from Biker where team.id = ?1")
    List<Biker> getBikersFromTeam2(int id);

    @Query("from Biker where team.id = ?1 order by time asc")
    List<Biker> getBikersFromTeamByBestTime(int id);












}
