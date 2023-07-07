package com.fsi.cbs.country.repo;

import com.fsi.cbs.country.repo.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Countries, Long> {
}
