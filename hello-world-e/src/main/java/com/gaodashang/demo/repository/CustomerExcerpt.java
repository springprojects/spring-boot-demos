package com.gaodashang.demo.repository;

import com.gaodashang.demo.domain.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 * comments.
 *
 * @author eva
 */
@Projection(name = "excerpt", types = Customer.class)
public interface CustomerExcerpt {

    public String getFirstname();

    public String getLastname();

    @Value("#{target.address.toString()}")
    public String getAddress();
}
