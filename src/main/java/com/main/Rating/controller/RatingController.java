package com.main.Rating.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.Rating.entities.Rating;
import com.main.Rating.service.RatingService;

@RestController
@RequestMapping("/rating-service")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<List<Rating>> saveRating(@RequestBody List<Rating> ratings) {
		List<Rating> lstRating =  this.ratingService.saveRating(ratings);
		return ResponseEntity.ok(lstRating);
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating() {
		List<Rating> lstOfRating = this.ratingService.fetchAllRating();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(lstOfRating);
	}
	
	@GetMapping("/rating/{ratingId}")
	public ResponseEntity<Optional<Rating>> getRatingById(@PathVariable String ratingId) {
		Optional<Rating> ratingById = this.ratingService.getRatingById(ratingId);
		return ResponseEntity.ok(ratingById);
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
		List<Rating> ratingByHotelId = this.ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(ratingByHotelId);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
		List<Rating> ratingByUserId = this.ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok(ratingByUserId);
	}
	
}
