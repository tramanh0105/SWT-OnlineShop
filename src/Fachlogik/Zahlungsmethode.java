package Fachlogik;

public abstract class Zahlungsmethode {
    private String kartennummer;
    private double zuzahlenBetrag;
    private BestellungStatus status;

    public Zahlungsmethode(String kartennummer ) {
        this.kartennummer = kartennummer;
    }

    public BestellungStatus getStatus() {
        return status;
    }

    public void setStatus(BestellungStatus status) {
        this.status = status;
    }

    public double getZuzahlenBetrag() {
        return zuzahlenBetrag;
    }

    public void setZuzahlenBetrag(double zuzahlenBetrag) {
        this.zuzahlenBetrag = zuzahlenBetrag;
    }

    public String getKartennummer() {
        return kartennummer;
    }

    public void setKartennummer(String kartennummer) {
        this.kartennummer = kartennummer;
    }

//    public  void bezahlen(){
//
//        if(this.status == BestellungStatus.BEARBEITET) {
//            this.status = this.status.changeState();
//
//        }
//    }
}
