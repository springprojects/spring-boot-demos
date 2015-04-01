package com.gaodashang.demo.endpoint;

import com.gaodashang.demo.repository.BookingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * comments.
 *
 * @author eva
 */
@Controller
public class BookingHtmlController {

    @Resource
    private BookingRepository bookingRepository;

    @RequestMapping(value = "/bookings.html", method = RequestMethod.GET)
    public String all(Model model) {
        model.addAttribute("bookings", bookingRepository.findAll());
        return "bookings";
    }
}
