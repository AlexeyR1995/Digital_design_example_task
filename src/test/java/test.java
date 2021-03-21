import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class test {
    @Test
    public void testChangeString() {
        assertThat("", Main.changeString("3[x]").equals("xxx"));
        assertThat("", Main.changeString("11[x]").equals("xxxxxxxxxxx"));
        assertThat("", Main.changeString("ab1[x11[yt]]").equals("abxytytytytytytytytytytyt"));
        assertThat("", Main.changeString("av3[x]abc3[x3[e]]").equals("avxxxabcxeeexeeexeee"));
        assertThat("", Main.changeString("").equals(""));
    }

    @Test
    public void testIsValid() {
        assertThat("", Main.isValid("ae3[x]"));
        assertThat("", !Main.isValid("3[x][33["));
        assertThat("", !Main.isValid("--фвы3[x3[ut]]"));
        assertThat("", !Main.isValid("3[x4[fgh]]aer3er4"));
    }

}
