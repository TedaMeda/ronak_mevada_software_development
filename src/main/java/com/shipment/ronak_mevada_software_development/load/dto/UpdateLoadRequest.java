package com.shipment.ronak_mevada_software_development.load.dto;

import com.shipment.ronak_mevada_software_development.load.ProductType;
import com.shipment.ronak_mevada_software_development.load.TruckType;
import lombok.*;

/**
 * @author TedaMeda
 * @since 5/9/2024
 */
@Data
public class UpdateLoadRequest {
    @NonNull
    private String loadingPoint;
    @NonNull
    private String unloadingPoint;
    @NonNull
    private ProductType productType;
    @NonNull
    private TruckType truckType;
    @NonNull
    private Long noOfTrucks;
    @NonNull
    private Double weight;
    @NonNull
    private String comment;
    @NonNull
    private String Date;

}
