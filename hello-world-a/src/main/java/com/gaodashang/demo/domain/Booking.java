package com.gaodashang.demo.domain;

/**
 * comments.
 *
 * @author eva
 */

import javax.persistence.*;


@Entity
@Table(name="T_BOOKING")
public class Booking {

    public Booking() {
    }

    public Booking(String bookingName) {
        this.bookingName = bookingName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "BOOKING_NAME")
    private String bookingName;

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", bookingName='" + bookingName + '\'' +
                '}';
    }
}
