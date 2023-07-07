package com.fsi.cbs.country.dao;

import com.fsi.cbs.country.repo.CountryRepo;
import com.fsi.cbs.country.repo.entity.Countries;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author med-amine.Dahmen
 * Date 05/07/2023
 */

@Repository
@Slf4j
@RequiredArgsConstructor
public class CountryDaoImpl implements CountryDao {

    private final CountryRepo countryRepo;

    @Override
    public void save(Countries country) {
        log.info("save a country");
        countryRepo.save(country);

    }

    @Override
    public List<Countries> findAll() {
        return countryRepo.findAll();
    }






    @Override
    public Optional<Countries> selectCountryById(Long id) {
        return countryRepo.findById(id);
    }



    @Override
    public boolean existsCountryById(Long id) {
        return countryRepo.existsById(id);
    }




    @Override
    public void deleteCountryById(Long id) {
        countryRepo.deleteById(id);

    }

    @Override
    public void updateCountry(Countries newCountry) {
        countryRepo.save(newCountry);

    }



}
