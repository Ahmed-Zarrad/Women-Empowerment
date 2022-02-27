package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.service.CondidatService;

@RestController
public class CondidatController {

    @Autowired
    private CondidatService condidatService;

    // create
}
