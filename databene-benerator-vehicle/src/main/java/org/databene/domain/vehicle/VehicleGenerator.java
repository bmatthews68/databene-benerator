package org.databene.domain.vehicle;

import org.databene.benerator.util.ThreadSafeGenerator;

public class VehicleGenerator extends ThreadSafeGenerator<Vehicle> {

    public Vehicle generate() {
        // TODO Auto-generated method stub
        return new VehicleImpl();
    }

    public Class<Vehicle> getGeneratedType() {
        // TODO Auto-generated method stub
        return Vehicle.class;
    }

}
