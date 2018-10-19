package com.example.hotels.repository;

import com.example.hotels.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
