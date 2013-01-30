package org.wai.flyway.sample.entity;

import org.wai.flyway.sample.entity.auto._TestDomainMap;

public class TestDomainMap extends _TestDomainMap {

    private static TestDomainMap instance;

    private TestDomainMap() {}

    public static TestDomainMap getInstance() {
        if(instance == null) {
            instance = new TestDomainMap();
        }

        return instance;
    }
}
