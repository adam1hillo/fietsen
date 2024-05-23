package be.vdab.fietsen.docenten;

import be.vdab.fietsen.campussen.Adres;
import be.vdab.fietsen.campussen.Campus;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class DocentTest {
    @Test
    void jeKanMeerdereDocentenToevoegenAanEenCampus() {
        Adres adres = new Adres("test", "test", 1000, "Test");
        Campus campus = new Campus("test", adres);
        Docent docent = new Docent("test1", "test1", BigDecimal.TEN, "test1.test1@example.org", Geslacht.MAN, campus);
        campus.voegDocentToe(docent);
        Docent andereDocent = new Docent("test2", "test2", BigDecimal.TEN, "test2.test2@example.org", Geslacht.MAN, campus);
        campus.voegDocentToe(andereDocent);
    }
    @Test
    void nadatJeEenDocentOpslaatBehoortHijNogTotZijnCampus() {
        Adres adres = new Adres("test", "test", 1000, "Test");
        Campus campus = new Campus("test", adres);
        Docent docent = new Docent("test1", "test1", BigDecimal.TEN, "test1.test1@example.org", Geslacht.MAN, campus);
        campus.voegDocentToe(docent);
        ReflectionTestUtils.setField(docent, "id",1);
        assertThat(campus.getDocenten().contains(docent)).isTrue();

    }
}
