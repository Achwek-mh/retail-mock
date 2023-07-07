package com.fsi.cbs.country.service;

import com.fsi.cbs.country.dao.CountryDao;
import com.fsi.cbs.country.exception.ResourceNotFoundException;
import com.fsi.cbs.country.exception.RequestException;


import com.fsi.cbs.country.repo.entity.Countries;
import com.fsi.common.dto.CountryDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author med-amine.Dahmen
 * Date 05/07/2023
 */

@RequiredArgsConstructor
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryDao countryrepo;
    private final ModelMapper countryDTOMapper;


    @Override
    public void save(CountryDto countryDto) {
        countryrepo.save(countryDTOMapper.map(countryDto, Countries.class));
    }

    @Override
    public List<CountryDto> findALl() {
        return countryrepo.findAll().stream().map(x -> countryDTOMapper.map(x, CountryDto.class)).toList();
    }



    ;

/*    @Override
    public Optional<CountryDto> getCountry(Long countryID) {
        return Optional.ofNullable(countryrepo.selectCountryById(countryID).map(country -> new CountryDto(country.getId())).orElseThrow(() -> new ResourceNotFoundException(
                "country with id [%s] not found".formatted(countryID)
        )));
    }*/



    @Override

    public void deleteCountry(Long countryID) {
        checkIfCountryExistsOrThrow(countryID);

        countryrepo.deleteCountryById(countryID);
    }


    @Override
    public void checkIfCountryExistsOrThrow(Long countryID) {
        if (!countryrepo.existsCountryById(countryID)) {
            throw new ResourceNotFoundException("country with id [%s] not found".formatted(countryID));
        }
    }

    @Override
    public void updateCountry(Long countryID, CountryDto update) {
        Countries country = countryrepo.selectCountryById(countryID).orElseThrow(() -> new ResourceNotFoundException("country with id [%s] not found".formatted(countryID)));
        boolean changes = false;
        if (update.label != null && !update.label.equals(country.getLabel())) {
            country.setLabel(update.label);
            changes = true;
        }
        if (update.code != null && !update.code.equals(country.getCode())) {
            country.setCode(update.code);
            changes = true;
        }
        if (!changes) {
            throw new RequestException("no data changes found");
        }
        countryrepo.updateCountry(country);
    }
}
