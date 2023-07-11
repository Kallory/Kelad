package springGame.Kelad;

public enum ClimateType {
    TROPICAL_WET("Tropical Wet"),
    TROPICAL_MONSOON("Tropical Monsoon"),
    TROPICAL_WET_AND_DRY("Tropical Wet and Dry"),
    DRY_ARID("Dry Arid"),
    DRY_SEMIARID("Dry Semiarid"),
    MILD_MEDITERRANEAN("Mild Mediterranean"),
    MILD_HUMID_SUBTROPICAL("Mild Humid Subtropical"),
    MILD_MARINE("Mild Marine"),
    CONTINENTAL_WARM_SUMMER("Continental Warm Summer"),
    CONTINENTAL_COOL_SUMMER("Continental Cool Summer"),
    CONTINENTAL_SUBARCTIC("Continental Subarctic"),
    POLAR_TUNDRA("Polar Tundra"),
    POLAR_ICE_CAP("Polar Ice Cap");

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

