package org.databene.domain.vehicle;

import org.databene.benerator.util.ThreadSafeGenerator;

public abstract class AbstractRegistrationNumberGenerator extends
        ThreadSafeGenerator<String> {

    protected abstract String doGenerate();
    
    public final String generate() {
        return doGenerate();
    }

    public final Class<String> getGeneratedType() {
        return String.class;
    }

}
