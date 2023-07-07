package com.fsi.cbs.customer.repo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author med-amine.Dahmen
 * Date 05/07/2023
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customers {


    @Id

    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)

    private String code;
    @Column(nullable = false)

    private String name;


}
