package com.pichincha.fcpp.gestiondecuentes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pichincha.fcpp.gestiondecuentes.entity.AccountEntity;
import com.pichincha.fcpp.gestiondecuentes.entity.MovementsEntity;
import com.pichincha.fcpp.gestiondecuentes.service.AccountService;
import com.pichincha.fcpp.gestiondecuentes.service.MovementService;

@Controller
@RequestMapping("/movement")
public class MovementController {
	
	@Autowired
	private MovementService movementService;
	
	@PostMapping(path = "/create")
	public ResponseEntity<?> createAccount(@RequestBody MovementsEntity  movementsEntity) {

		try {
			MovementsEntity movementsEntityAfter = movementService.createMovement(movementsEntity);
			return new ResponseEntity<>(movementsEntityAfter, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping(path = "/delete/{movementId}")
	public ResponseEntity<?> deleteMovement(@PathVariable Integer movementId) {

		try {
			String resonse = movementService.deleteMovement(movementId);
			return new ResponseEntity<>(resonse, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}