package dynamic.abbreviation;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final String a, final String b, final String expectedAbbreviation) {
        //given

        //when
        final String abbreviation = Solution.abbreviation(a, b);

        //then
        assertThat(abbreviation).isEqualTo(expectedAbbreviation);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        "abABcbbdEe",
                        "ABDE",
                        "YES"
                },
                new Object[] {
                        "AbbDE",
                        "ABDE",
                        "YES"
                },
                new Object[] {
                        "acAbBC",
                        "ABC",
                        "YES"
                },
                new Object[] {
                        "AbcDE",
                        "AFDE",
                        "NO"
                },
                new Object[] {
                        "beFgH",
                        "EFG",
                        "NO"
                },
                new Object[] {
                        "EEfg",
                        "EFG",
                        "NO"
                },                  
                new Object[] {
                        "ADbbDE",
                        "ABDE",
                        "NO"
                },         
                new Object[] {
                        "AbcDE",
                        "ABDE",
                        "YES"
                },               
                new Object[] {
                        "AcDEb",
                        "ABDE",
                        "NO"
                },
                new Object[] {
                        "AbcDE",
                        "AFDE",
                        "NO"
                },
                new Object[] {
                        "daBcd",
                        "ABC",
                        "YES"
                },
                new Object[] {
                        "aB",
                        "ABC",
                        "NO"
                },
        };
    }

}
