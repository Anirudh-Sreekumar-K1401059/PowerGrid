public enum Type {
    COAL,
    OIL,
    TRASH,
    URANIUM;

    @Override
    public String toString() {
        switch (this) {
            case COAL:
                return "Coal";
            case OIL:
                return "Oil";
            case TRASH:
                return "Trash";
            case URANIUM:
                return "Uranium";
            default:
                return super.toString();
        }
    }
}
