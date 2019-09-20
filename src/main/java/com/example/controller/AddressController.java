package com.example.controller;

import brave.ScopedSpan;
import brave.Span;
import brave.Tracer;
import com.example.model.Address;
import com.example.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "address", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressController {

    private static Logger log = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    @Autowired
    private Tracer tracer;

    @GetMapping("{id}")
    public Address get(@PathVariable("id") final String id) {

        final Span s = this.tracer.currentSpan();
        try {
            return this.addressService.get(id);
        } catch (Exception e) {
            s.error(e);
            e.printStackTrace();
            return null;
        } finally {
            s.finish();
        }
    }

}
