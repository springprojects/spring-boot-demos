package com.gaodashang.demo.repository;

import com.gaodashang.demo.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

/**
 * comments.
 *
 * @author eva
 */
public interface BookingRepository extends JpaRepository<Booking, Long> {

    Collection<Booking> findByBookingName(@Param("bookingName") String bookingName);

}
