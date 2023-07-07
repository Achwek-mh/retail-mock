package com.fsi.cbs.country.api;

import com.fsi.common.dto.CountryDto;
import com.fsi.cbs.country.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author med-amine.Dahmen
 * Date 05/07/2023
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("countries")
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public HttpEntity<List<CountryDto>> listCountriess() {
        return new HttpEntity<>(countryService.findALl());
    }
  /*  @GetMapping("/{id}")
    public ResponseEntity<Object> getCountry(@PathVariable("id") Long id){
        Optional<CountryDto> countries = countryService.getCountry(id);
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }*/

    @PostMapping
    public ResponseEntity<Object> addCountry(@RequestBody CountryDto country){
        countryService.save(country);
        return new ResponseEntity<>("country added successfully", HttpStatus.CREATED);

    }
    @PutMapping("{id}")
    public ResponseEntity<Object> updateCountry(@PathVariable("id") Long id, @RequestBody CountryDto updatedCountry) {


        countryService.updateCountry(id,updatedCountry);
        return new ResponseEntity<>("country has been updated successfully", HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable("id")Long id ) {
        countryService.deleteCountry(id);
        return new ResponseEntity<>( "country is deleted successfully",HttpStatus.NO_CONTENT);

    }

    @GetMapping("/will-fail")
    public HttpEntity<List<CountryDto>> willNeverWork() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/will-succeed")
    public HttpEntity<List<CountryDto>> willAlwaysWork() {
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/will-throw-an-exception")
    @SneakyThrows
    public HttpEntity<List<CountryDto>> willThrowException() {

        throw new Exception("An Exception");
    }


}
