package com.shipment.ronak_mevada_software_development.load;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author TedaMeda
 * @since 5/9/2024
 */
public interface LoadRepository extends JpaRepository<LoadEntity, Long> {
    List<LoadEntity> findAllByShipperId(String shipperId);
}
