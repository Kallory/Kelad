package Climate;

import Terrain.*;

public class TropicalWetClimate extends ClimateType {
    public TropicalWetClimate(String name) {
        super(name);
    }

    @Override
    public Terrain generateTerrain() {
        // Logic to generate terrain for tropical wet climate
        return new SaltWater();
    }
}
