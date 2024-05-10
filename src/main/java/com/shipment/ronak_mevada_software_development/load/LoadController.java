package com.shipment.ronak_mevada_software_development.load;

import com.shipment.ronak_mevada_software_development.common.ErrorResponseDTO;
import com.shipment.ronak_mevada_software_development.load.dto.CreateLoadRequest;
import com.shipment.ronak_mevada_software_development.load.dto.UpdateLoadRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author TedaMeda
 * @since 5/9/2024
 */
@RestController
@RequestMapping("/load")
public class LoadController {
    private final LoadService loadService;

    public LoadController(LoadService payloadService) {
        this.loadService = payloadService;
    }

    @PostMapping("")
    public ResponseEntity<String> createLoad(@RequestBody CreateLoadRequest request) {
        LoadEntity payload = loadService.createLoad(request);
        return ResponseEntity.ok("Loads details added successfully");
    }

    @GetMapping("")
    public ResponseEntity<List<LoadEntity>> getLoadByShipperId(
            @RequestParam(name = "shipperId", required = false) String shipperId
    ){
        List<LoadEntity> payloads = loadService.getLoadByShipperId(shipperId);
        return ResponseEntity.ok(payloads);
    }

    @GetMapping("/{loadId}")
    public ResponseEntity<LoadEntity> getLoadByLoadId(
            @PathVariable(name = "loadId") Long id
    ){
        LoadEntity payload = loadService.getLoadByLoadId(id);
        return ResponseEntity.ok(payload);
    }

    @PutMapping("/{loadId}")
    public ResponseEntity<LoadEntity> updateLoadByLoadId(
            @PathVariable(name = "loadId") Long id,
            UpdateLoadRequest request
    ){
        LoadEntity payload = loadService.updateLoadByLoadId(id,request);
        return ResponseEntity.ok(payload);
    }

    @DeleteMapping("/{loadId}")
    public ResponseEntity<String> deleteLoadByLoadId(
            @PathVariable(name = "loadId") Long id
    ){
        loadService.deleteLoadByLoadId(id);
        return ResponseEntity.ok("Load with loadId "+id+" deleted successfully");
    }

    @ExceptionHandler({
            LoadService.LoadIdNotFoundException.class,
            LoadService.InvalidDateFormat.class
    })
    public ResponseEntity<ErrorResponseDTO> exceptionHandler(Exception ex){
        String message;
        HttpStatus status;
        if(ex instanceof LoadService.LoadIdNotFoundException){
            message = ex.getMessage();
            status = HttpStatus.NOT_FOUND;
        }
        else if(ex instanceof LoadService.InvalidDateFormat){
            message = ex.getMessage();
            status = HttpStatus.BAD_REQUEST;
        }
        else {
            message = "Internal Server Error";
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        ErrorResponseDTO responseDTO = ErrorResponseDTO.builder().message(message).build();
        return ResponseEntity.status(status).body(responseDTO);
    }

}
