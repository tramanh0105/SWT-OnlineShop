package Fachlogik;

public enum ArtikelZustand {
    AUSVERKAUFT{
        @Override
        public ArtikelZustand changeState() {
            return AVAILABLE;
        }
    },
    AVAILABLE{
        @Override
        public ArtikelZustand changeState() {
            return AUSVERKAUFT;
        }
    }
    ;

    public abstract ArtikelZustand changeState();
    public static boolean isAvailable(ArtikelZustand state){
        boolean result = true;
        switch(state){
            case AVAILABLE:
                result = true;
                break;
            case AUSVERKAUFT:
                result =false;
                break;
        }
        return result;
    }

}
