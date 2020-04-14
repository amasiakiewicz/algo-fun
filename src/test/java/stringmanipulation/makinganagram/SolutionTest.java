package stringmanipulation.makinganagram;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(String a, String b, int expectedNrOfDelCharacters) {
        //given

        //when
        final int nrOfDelCharacters = Solution.makeAnagram(a, b);

        //then
        assertThat(nrOfDelCharacters).isEqualTo(expectedNrOfDelCharacters);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        "cde",
                        "abc",
                        4
                },
                new Object[] {
                        "c",
                        "c",
                        0
                },
                new Object[] {
                        "c",
                        "a",
                        2
                },
                new Object[] {
                        "cde",
                        "cde",
                        0
                },
                new Object[] {
                        "cde",
                        "fgh",
                        6
                },
                new Object[] {
                        "cde",
                        "fg",
                        5
                },
                new Object[] {
                        "cde",
                        "efg",
                        4
                },
                new Object[] {
                        "cde",
                        "cdh",
                        2
                },
                new Object[] {
                        "cde",
                        "edcf",
                        1
                },
                new Object[] {
                        "edcf",
                        "cde",
                        1
                },
                new Object[] {
                        "fcrxzwscanmligyxyvym",
                        "jxwtrhvujlmrpdoqbisbwhmgpmeoke",
                        30
                },
        };
    }

}
