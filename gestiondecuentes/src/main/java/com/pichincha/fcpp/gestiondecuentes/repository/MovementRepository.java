package com.pichincha.fcpp.gestiondecuentes.repository;

import org.springframework.data.repository.CrudRepository;

import com.pichincha.fcpp.gestiondecuentes.entity.MovementsEntity;

public interface MovementRepository extends CrudRepository<MovementsEntity, Integer> {

}