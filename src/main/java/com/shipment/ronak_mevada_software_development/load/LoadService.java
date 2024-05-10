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
    private final LoadRepository LoadRepository;
    private final ModelMapper modelMapper;
    public LoadService(LoadRepository payloadRepository, ModelMapper modelMapper) {
        this.LoadRepository = payloadRepository;
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
        LoadEntity LoadEntity = modelMapper.map(request, LoadEntity.class);
        return LoadRepository.save(LoadEntity);
    }

    public List<LoadEntity> getLoadByShipperId(String shipperId){
        List<LoadEntity> Loads = shipperId==null? LoadRepository.findAll() : LoadRepository.findAllByShipperId(shipperId);
        return Loads;
    }

    public LoadEntity getLoadByLoadId(Long loadId){
        LoadEntity Load = LoadRepository.findById(loadId).orElseThrow(()->new LoadIdNotFoundException(loadId));
        return Load;
    }

    public LoadEntity updateLoadByLoadId(Long loadId, UpdateLoadRequest request) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = simpleDateFormat.parse(request.getDate());
        } catch (ParseException e) {
            throw new InvalidDateFormat();
        }

        LoadEntity payload = getLoadByLoadId(loadId);
        payload.setLoadingPoint(request.getLoadingPoint());
        payload.setUnloadingPoint(request.getUnloadingPoint());
        payload.setProductType(request.getProductType());
        payload.setTruckType(request.getTruckType());
        payload.setNoOfTrucks(request.getNoOfTrucks());
        payload.setWeight(request.getWeight());
        payload.setComment(request.getComment());
        payload.setDate(date);

        return LoadRepository.save(payload);
    }

    public void deleteLoadByLoadId(Long loadId){
        LoadEntity payload = getLoadByLoadId(loadId);
        LoadRepository.delete(payload);
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
