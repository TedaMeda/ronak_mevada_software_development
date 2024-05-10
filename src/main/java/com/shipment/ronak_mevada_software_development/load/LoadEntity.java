package com.shipment.ronak_mevada_software_development.load;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * @author TedaMeda
 * @since 5/9/2024
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payload")
public class LoadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "loading_point", nullable = false)
    private String loadingPoint;
    @Column(name = "unloading_point", nullable = false)
    private String unloadingPoint;
    @Column(name = "product_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    @Column(name = "truck_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TruckType truckType;
    @Column(name = "no_of_trucks", nullable = false)
    private Long noOfTrucks;
    @Column(name = "weight", nullable = false)
    private double weight;
    @Column(name = "comment", nullable = true)
    private String comment;
    @Column(name = "shipper_id", nullable = false)
    private String shipperId;
    @Column(name = "date", nullable = false)
    private Date Date;

}
