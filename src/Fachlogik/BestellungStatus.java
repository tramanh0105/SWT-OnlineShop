package Fachlogik;

import java.util.Observable;

public enum BestellungStatus {

    BEARBEITET{
        @Override
        public BestellungStatus changeState() {
            return BEZAHLT;
        }


    }, BEZAHLT{
        @Override
        public BestellungStatus changeState() {
            return GELIEFERT;
        }
    }, GELIEFERT{
        @Override
        public BestellungStatus changeState(){
            return ZUGESTELLT;
        }


    }, ZUGESTELLT {

        @Override
        public BestellungStatus changeState() {
            return this;

        }
    };

    public abstract BestellungStatus changeState();

}
