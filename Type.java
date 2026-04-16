public enum Type {
    COAL,
    OIL,
    GARBAGE,
    URANIUM;

    @Override
    public String toString() {
        switch (this) {
            case COAL:
                return "Coal";
            case OIL:
                return "Oil";
            case GARBAGE:
                return "Garbage";
            case URANIUM:
                return "Uranium";
            default:
                return super.toString();
        }
    }
}
