package com.example.hotels.controller;

import com.example.hotels.exception.ResourceNotFoundException;
import com.example.hotels.model.Hotel;
import com.example.hotels.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    HotelRepository hotelRepository;

    @GetMapping("/notes")
    public List<Hotel> getAllNotes() {
        return hotelRepository.findAll();
    }

    @PostMapping("/notes")
    public Hotel createNote(@Valid @RequestBody Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @GetMapping("/notes/{id}")
    public Hotel getNoteById(@PathVariable(value = "id") Long noteId) {
        return hotelRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel", "id", noteId));
    }

    @PutMapping("/notes/{id}")
    public Hotel updateNote(@PathVariable(value = "id") Long noteId,
                            @Valid @RequestBody Hotel hotelDetails) {

        Hotel hotel = hotelRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel", "id", noteId));

        hotel.setTitle(hotelDetails.getTitle());
        hotel.setContent(hotelDetails.getContent());

        Hotel updatedHotel = hotelRepository.save(hotel);
        return updatedHotel;
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Hotel hotel = hotelRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel", "id", noteId));

        hotelRepository.delete(hotel);

        return ResponseEntity.ok().build();
    }
}
