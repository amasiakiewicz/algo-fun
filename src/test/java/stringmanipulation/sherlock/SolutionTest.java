package stringmanipulation.sherlock;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final String s, final String expectedValid) {
        //given

        //when
        final String valid = Solution.isValid(s);

        //then
        assertThat(valid).isEqualTo(expectedValid);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        "ababcd",
                        "NO",
                },
                new Object[] {
                        "aabbcd",
                        "NO",
                },
                new Object[] {
                        "aabbccddeefghi",
                        "NO",
                },
                new Object[] {
                        "abcdefghhgfedecba",
                        "YES",
                },
                new Object[] {
                        "a",
                        "YES",
                },
                new Object[] {
                        "aabbcccddd",
                        "NO",
                },
                new Object[] {
                        "aaad",
                        "YES",
                },
        };
    }

}
