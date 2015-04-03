package com.gaodashang.demo.domain;

import javax.persistence.*;

/**
 * comments.
 *
 * @author eva
 */
@Entity
@NamedStoredProcedureQuery(name = "User.plus1", procedureName = "plus1inout", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "arg", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "res", type = Integer.class) })
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
}
