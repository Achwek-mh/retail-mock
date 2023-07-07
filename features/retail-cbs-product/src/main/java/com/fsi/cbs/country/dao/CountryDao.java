package com.fsi.cbs.country.dao;

import com.fsi.cbs.country.repo.entity.Countries;

import java.util.List;
import java.util.Optional;

public interface CountryDao {

    void save(Countries country);


    List<Countries> findAll();
    public Optional<Countries> selectCountryById(Long countryId);

    public boolean existsCountryById(Long countryId);
    public void deleteCountryById(Long countryId);
    public void updateCountry(Countries newCountry);

}
