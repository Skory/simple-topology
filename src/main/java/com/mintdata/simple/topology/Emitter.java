package com.mintdata.simple.topology;

import java.util.concurrent.TimeUnit;

import mint.api.annotation.Component;
import mint.api.annotation.OnTick;
import mint.api.annotation.Output;
import mint.api.component.output.Out;

@Component
public class Emitter {
    private transient long counter;

    @Output
    private transient Out<String> data;

    @OnTick(interval = 5, unit = TimeUnit.SECONDS)
    public void tick() {
        data.emit("Data-" + ++counter);
    }
}
