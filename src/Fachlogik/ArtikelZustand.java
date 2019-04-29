package Fachlogik;

public enum ArtikelZustand {
    AUSVERKAUFT,
    AVAILABLE
    ;


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
