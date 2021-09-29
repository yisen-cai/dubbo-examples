package com.glancebar.example.provider.service;

import com.glancebar.example.api.service.IDemoService;
import com.glancebar.example.api.service.Person;

import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "0.0.1", group = "cn")
public class NormalDemoService implements IDemoService {

    @Override
    public Person get(int id) {
        return new Person(id, "charles'son", 4);
    }

}
