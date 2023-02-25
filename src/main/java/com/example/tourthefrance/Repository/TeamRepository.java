package com.example.tourthefrance.Repository;

import com.example.tourthefrance.Model.Biker;
import com.example.tourthefrance.Model.Team;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository <Team, Integer> {

}
