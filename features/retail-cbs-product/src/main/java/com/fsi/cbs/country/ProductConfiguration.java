package com.fsi.cbs.country;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author med-amine.Dahmen
 * Date 05/07/2023
 */
@Configuration
@ComponentScan("com.fsi.cbs.country")
@EnableJpaRepositories
@EntityScan("com.fsi.cbs.country")
public class ProductConfiguration {
}
