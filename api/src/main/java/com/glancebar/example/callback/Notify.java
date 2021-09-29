package com.glancebar.example.callback;

import com.glancebar.example.api.service.Person;

public interface Notify {
    public void onReturn(Person msg, Integer id);

    public void onThrow(Throwable ex, Integer id);
}
