package tree.heightofbtree;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final Node root, int expectedHeight) {
        //given

        //when
        final int height = Solution.height(root);

        //then
        assertThat(height).isEqualTo(expectedHeight);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        getTree1(),
                        3
                },
                new Object[] {
                        getTree2(),
                        0
                },
                new Object[] {
                        getTree3(),
                        1
                },
                new Object[] {
                        getTree4(),
                        1
                },
                new Object[] {
                        getTree5(),
                        2
                },
        };
    }

    private Node getTree5() {
        final Node root = Solution.insert(null, 3);

        Solution.insert(root, 2);
        
        Solution.insert(root, 1);

        return root;
    }

    private Node getTree4() {
        final Node root = Solution.insert(null, 3);

        Solution.insert(root, 2);
        Solution.insert(root, 5);

        return root;
    }

    private Node getTree3() {
        final Node root = Solution.insert(null, 3);

        Solution.insert(root, 2);
        
        return root;
    }

    private Node getTree2() {
        return Solution.insert(null, 3);
    }

    private Node getTree1() {
        final Node root = Solution.insert(null, 3);
        Solution.insert(root, 2);
        Solution.insert(root, 5);
        
        Solution.insert(root, 1);
        Solution.insert(root, 4);
        Solution.insert(root, 6);

        Solution.insert(root, 7);
        
        return root;
    }

}
