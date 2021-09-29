package com.glancebar.example.consumer.callback;

import java.util.HashMap;
import java.util.Map;

import com.glancebar.example.api.service.Person;
import com.glancebar.example.callback.Notify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "demoCallback")
public class NotifyImpl implements Notify {
    private final Logger logger = LoggerFactory.getLogger(NotifyImpl.class);
    public Map<Integer, Person> ret = new HashMap<>();
    public Map<Integer, Throwable> errors = new HashMap<>();

    @Override
    public void onReturn(Person msg, Integer id) {
        logger.info("On return: {}", msg);
        ret.put(id, msg); 
    }

    @Override
    public void onThrow(Throwable ex, Integer id) {
       errors.put(id, ex); 
    }
    
}
