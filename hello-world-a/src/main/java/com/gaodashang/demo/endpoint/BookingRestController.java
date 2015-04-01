package com.gaodashang.demo.endpoint;

import com.gaodashang.demo.domain.Booking;
import com.gaodashang.demo.repository.BookingRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * comments.
 *
 * @author eva
 */
@RestController
@RequestMapping(value = "/bookings")
public class BookingRestController {

    @Resource
    private BookingRepository bookingRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Booking add(@RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Booking> all() {
        return bookingRepository.findAll();
    }
}
