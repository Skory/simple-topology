package com.mintdata.simple;

import com.mintdata.simple.topology.Emitter;
import com.mintdata.simple.topology.Printer;
import mint.model.flow.FlowModel;
import mint.model.flow.FlowModelBuilder;
import mint.model.flow.support.FlowModelFactoryImpl;
import mint.runtime.distribution.Disposition;
import mint.runtime.distribution.DistributionType;
import mint.runtime.spearmint.bootstrap.SpearmintRuntime;

public class Topology {
    public static void main(String[] args) throws Exception {
        FlowModelBuilder builder = new FlowModelFactoryImpl().createBuilder();
        builder.addBlock(new Emitter(), "emitter");
        builder.addBlock(new Printer(), "printer");

        builder.addConnection("emitter", "data", "printer", "data");

        FlowModel model = builder.build();
        SpearmintRuntime runtime = SpearmintRuntime.create();

        Disposition<FlowModel> simple = new Disposition<>("simple", model, DistributionType.flow());
        runtime.topologyApi().submit(simple, true);
    }
}
