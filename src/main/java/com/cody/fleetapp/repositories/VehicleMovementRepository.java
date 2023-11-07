package com.cody.fleetapp.repositories;

import com.cody.fleetapp.models.VehicleMovement;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EntityScan("com.*")
public interface VehicleMovementRepository extends JpaRepository<VehicleMovement, Integer> {

}
