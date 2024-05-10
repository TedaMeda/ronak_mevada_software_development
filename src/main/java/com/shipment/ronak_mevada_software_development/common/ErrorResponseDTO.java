package com.shipment.ronak_mevada_software_development.common;

import lombok.Builder;
import lombok.Data;

/**
 * @author TedaMeda
 * @since 5/9/2024
 */
@Data
@Builder
public class ErrorResponseDTO {
    private String message;
}
