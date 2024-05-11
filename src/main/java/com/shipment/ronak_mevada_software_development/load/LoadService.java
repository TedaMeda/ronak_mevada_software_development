package com.shipment.ronak_mevada_software_development.load;

import com.shipment.ronak_mevada_software_development.load.dto.CreateLoadRequest;
import com.shipment.ronak_mevada_software_development.load.dto.UpdateLoadRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author TedaMeda
 * @since 5/9/2024
 */
@Service
public class LoadService {
    private final LoadRepository loadRepository;
    private final ModelMapper modelMapper;
    public LoadService(LoadRepository loadRepository, ModelMapper modelMapper) {
        this.loadRepository = loadRepository;
        this.modelMapper = modelMapper;
    }

    public LoadEntity createLoad(CreateLoadRequest request) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = simpleDateFormat.parse(request.getDate());
        } catch (ParseException e) {
            throw new InvalidDateFormat();
        }
        LoadEntity loadEntity = modelMapper.map(request, LoadEntity.class);
        loadEntity.setDate(date);
        return loadRepository.save(loadEntity);
    }

    public List<LoadEntity> getLoadByShipperId(String shipperId){
        List<LoadEntity> loads = shipperId==null? loadRepository.findAll() : loadRepository.findAllByShipperId(shipperId);
        return loads;
    }

    public LoadEntity getLoadByLoadId(Long loadId){
        LoadEntity load = loadRepository.findById(loadId).orElseThrow(()->new LoadIdNotFoundException(loadId));
        return load;
    }

    public LoadEntity updateLoadByLoadId(Long loadId, UpdateLoadRequest request) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = simpleDateFormat.parse(request.getDate());
        } catch (ParseException e) {
            throw new InvalidDateFormat();
        }

        LoadEntity load = getLoadByLoadId(loadId);
        load.setLoadingPoint(request.getLoadingPoint());
        load.setUnloadingPoint(request.getUnloadingPoint());
        load.setProductType(request.getProductType());
        load.setTruckType(request.getTruckType());
        load.setNoOfTrucks(request.getNoOfTrucks());
        load.setWeight(request.getWeight());
        load.setComment(request.getComment());
        load.setDate(date);

        return loadRepository.save(load);
    }

    public void deleteLoadByLoadId(Long loadId){
        LoadEntity load = getLoadByLoadId(loadId);
        loadRepository.delete(load);
    }

    public static class LoadIdNotFoundException extends IllegalArgumentException{
        public LoadIdNotFoundException(Long loadId){
            super("Load with loadId: " + loadId + " not found");
        }
    }

    public static class InvalidDateFormat extends IllegalArgumentException{
        public InvalidDateFormat(){
            super("Invalid date format");
        }
    }
}
