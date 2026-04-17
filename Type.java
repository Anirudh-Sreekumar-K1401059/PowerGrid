public enum Type {
    COAL,
    OIL,
    GARBAGE,
    URANIUM,
    FREE;

    @Override
    public String toString() {
        switch (this) {
            case COAL:
                return "Coal";
            case OIL:
                return "Oil";
            case GARBAGE:
                return "GARBAGE";
            case URANIUM:
                return "Uranium";
            case FREE:
                return "Free";
            default:
                return super.toString();
        }
    }
}
