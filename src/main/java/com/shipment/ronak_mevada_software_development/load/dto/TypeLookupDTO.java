package com.shipment.ronak_mevada_software_development.load.dto;

import lombok.Data;

/**
 * @author TedaMeda
 * @since 5/11/2024
 */
@Data
public class TypeLookupDTO {
    private String type;
    private String label;

    public TypeLookupDTO(String productType, String label) {
        this.type = productType;
        this.label = label;
    }
}
