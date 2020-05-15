package sorting.comparator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class CheckerTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(List<Player> players, List<Player> expectedPlayersOrder) {
        //given
        final Checker checker = new Checker();

        //when
        players.sort(checker);

        //then
        assertThat(players).isEqualTo(expectedPlayersOrder);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        Arrays.asList(
                                new Player("amy", 100),
                                new Player("david", 100),
                                new Player("heraldo", 50),
                                new Player("aakansha", 75),
                                new Player("aleksa", 150)
                        ),
                        Arrays.asList(
                                new Player("aleksa", 150),
                                new Player("amy", 100),
                                new Player("david", 100),
                                new Player("aakansha", 75),
                                new Player("heraldo", 50)
                        )
                },
        };
    }

}
