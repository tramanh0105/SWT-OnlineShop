package Fachlogik;

public class KreditKarte extends Zahlungsmethode {
        private String karteinhaber;

        public KreditKarte(String kartennummer, String karteinhaber) {
            super(kartennummer);
            this.karteinhaber = karteinhaber;
        }

        public String getKarteinhaber() {
            return karteinhaber;
        }

        public void setKarteinhaber(String karteinhaber) {
            this.karteinhaber = karteinhaber;
        }

        @Override
        public void bezahlen(double betrag) {
            System.out.println("Bezahlt mit Kreditkarten");
            System.out.println("Bezahlt mit Kreditkarten");
        }


}
