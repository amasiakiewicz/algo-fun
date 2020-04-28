package dict.sherlock;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(String s, int expectedSherlockAndAnagrams) {
        //given

        //when
        final int sherlockAndAnagrams = Solution.sherlockAndAnagrams(s);

        //then
        assertThat(sherlockAndAnagrams).isEqualTo(expectedSherlockAndAnagrams);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        "abba",
                        4
                },
                new Object[] {
                        "abcd",
                        0
                },
                new Object[] {
                        "ifailuhkqq",
                        3
                },
                new Object[] {
                        "kkkk",
                        10
                },
                new Object[] {
                        "cdcd",
                        5
                },
                new Object[] {
                        "cd",
                        0
                },
                new Object[] {
                        "cc",
                        1
                },
        };
    }

}
