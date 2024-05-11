package com.shipment.ronak_mevada_software_development.load;

import lombok.Getter;

/**
 * @author TedaMeda
 * @since 5/9/2024
 */
@Getter
public enum TruckType {
        Pickup("pickup"),
        SemiTruck("semi truck"),
        DumpTruck("dump truck"),
        BoxTruck("box truck"),
        TowTruck("tow truck"),
        TankerTruck("tanker truck"),
        FlatbedTruck("flatbed truck"),
        RefrigeratedTruck("refrigerated truck"),
        OffRoadTruck("off road truck"),
        Canter("canter"),
        GarbageTruck("garbage truck"),
        FireTruck("fire truck"),
        LoggingTruck("logging truck"),
        UtilityTruck("utility truck"),
        ArmoredTruck("armored truck"),
        CarTransporter("car transporter");

        private String lable;

        TruckType(String lable) {
                this.lable = lable;
        }
}
