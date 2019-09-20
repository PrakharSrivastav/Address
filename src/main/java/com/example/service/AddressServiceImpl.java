package com.example.service;

import brave.ScopedSpan;
import brave.Span;
import brave.Tracer;
import com.example.model.Address;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class AddressServiceImpl implements AddressService {

    private static Faker f = new Faker();
    @Autowired
    private Tracer tracer;

    @Override
    public Address get(String PersonID) {
        Span s = this.tracer.currentSpan();
        try {
            //return new Address(f.address().city(), f.address().streetAddress(), f.address().country(), f.address().zipCode());
            throw new Exception("adfasdfas");
        } catch (Exception e) {
            s.error(e);
            e.printStackTrace();
            return null;
        } finally {
            s.finish();
        }

    }
}
