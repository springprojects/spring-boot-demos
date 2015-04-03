package com.gaodashang.demo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * comments.
 *
 * @author eva
 */
@Entity(name = "SampleOrder")
public class Order {

    @GeneratedValue
    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineItem> items = new ArrayList<LineItem>();

    @ManyToOne
    private Customer customer;

    public Order add(LineItem item) {
        items.add(item);
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<LineItem> getItems() {
        return items;
    }

    public void setItems(List<LineItem> items) {
        this.items = items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
