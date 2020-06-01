package com.skytravelr.dealership.controller;

import com.skytravelr.dealership.domain.Car;
import com.skytravelr.dealership.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @RequestMapping("/cars")
    public String listCars(Model model) {
        List<Car> list = carRepository.findAll();
        model.addAttribute("listOfCars", list);
        return "list-cars";
    }

    @RequestMapping("/dolist")
    public ModelAndView doList() {
        ModelAndView mav = new ModelAndView();
        List<Car> list = carRepository.findAll();
        mav.addObject("listOfCars", list);
        mav.setViewName("list-cars");
        return mav;
    }
}
