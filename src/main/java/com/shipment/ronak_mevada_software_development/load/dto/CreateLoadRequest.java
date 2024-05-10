package com.shipment.ronak_mevada_software_development.load.dto;

import jakarta.annotation.Nullable;
import lombok.*;

/**
 * @author TedaMeda
 * @since 5/9/2024
 */

@Data
public class CreateLoadRequest {
    @NonNull
    private String loadingPoint;
    @NonNull
    private String unloadingPoint;
    @NonNull
    private String productType;
    @NonNull
    private String truckType;
    @NonNull
    private Long noOfTrucks;
    @NonNull
    private Double weight;
    @Nullable
    private String comment;
    @NonNull
    private String shipperId;
    @NonNull
    private String Date;
}
