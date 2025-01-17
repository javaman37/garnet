package com.max.garnet.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.max.garnet.service.PartnerService;

@RestController
@RequestMapping("/affiliate")
public class PartnerController {
	@Autowired
    private PartnerService partnerService;

    @GetMapping("/lists")
    public ResponseEntity<List<PartnerDTO>> getPartnerLists() {
        List<PartnerDTO> partnerDTOs = partnerService.getAllPartners();
        return ResponseEntity.ok(partnerDTOs);
    }

}
