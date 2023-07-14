package Climate;

import Terrain.Terrain;

public abstract class ClimateType {
    public abstract Terrain generateTerrain();

    private final String name;

    ClimateType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

