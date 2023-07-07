package com.fsi.cbs.country.service;

import com.fsi.common.dto.CountryDto;

import java.util.List;
import java.util.Optional;

/**
 * @author med-amine.Dahmen
 * Date 05/07/2023
 */
public interface CountryService {

    void save(CountryDto countryDto);

    List<CountryDto> findALl();


   // Optional<CountryDto> getCountry(Long countryID);

    void deleteCountry(Long countryID);

    void checkIfCountryExistsOrThrow(Long countryID);


    void updateCountry(Long countryID, CountryDto update);
}
