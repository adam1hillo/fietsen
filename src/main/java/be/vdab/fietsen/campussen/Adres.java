package be.vdab.fietsen.campussen;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Adres {
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Adres adres)) return false;
        return postcode == adres.postcode && Objects.equals(straat, adres.straat) && Objects.equals(huisNr, adres.huisNr) && Objects.equals(gemeente, adres.gemeente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(straat, huisNr, postcode, gemeente);
    }

    private String straat;
    private String huisNr;
    private int postcode;
    private String gemeente;

    protected Adres() {
    }

    public Adres(String straat, String huisNr, int postcode, String gemeente) {
        this.straat = straat;
        this.huisNr = huisNr;
        this.postcode = postcode;
        this.gemeente = gemeente;
    }

    public String getStraat() {
        return straat;
    }

    public String getHuisNr() {
        return huisNr;
    }

    public int getPostcode() {
        return postcode;
    }

    public String getGemeente() {
        return gemeente;
    }
}
