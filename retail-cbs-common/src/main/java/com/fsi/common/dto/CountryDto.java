package com.fsi.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author med-amine.Dahmen
 * Date 05/07/2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {

    private Long id;

    public String code;

    public String label;



}
