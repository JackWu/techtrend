package com.techtrend.web.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techtrend.dataaccess.VehicleDao;
import com.techtrend.domain.Vehicle;
import com.techtrend.service.VehicleService;
import com.techtrend.web.model.CreateVehicleForm;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {
	
	
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @RequestMapping("/form")
    public String createEventForm(@ModelAttribute CreateVehicleForm createVehicleForm) {
        return "vehicle/create";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createEvent(@Valid CreateVehicleForm createVehicleForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "vehicle/create";
        }

        Vehicle vehicle = new Vehicle();
        vehicle.setColor(createVehicleForm.getColor());
        vehicle.setWheel(createVehicleForm.getWheel());
        vehicle.setSeat(createVehicleForm.getSeat());
        vehicleService.createVehicle(vehicle);
        model.addAttribute("message", "Successfully added the new event");

        return "vehicle/success";
    }

}