package tree.lowestcommanc;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final Node root, final int v1, final int v2, final Node expectedLca) {
        //given

        //when
        final Node lca = Solution.lca(root, v1, v2);

        //then
        assertThat(lca).isEqualTo(expectedLca);
    }

    private Object resultParams() {
        final Node root1 = getTree1();
        return new Object[] {
                new Object[] {
                        root1,
                        1,
                        7,
                        root1
                },
        };
    }

    private Node getTree1() {
        final Node root = Solution.insert(null, 4);
        Solution.insert(root, 2);
        Solution.insert(root, 7);

        Solution.insert(root, 1);
        Solution.insert(root, 3);
        Solution.insert(root, 6);

        return root;
    }

}
