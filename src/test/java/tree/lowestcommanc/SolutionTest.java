package tree.lowestcommanc;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

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
        final Node tree1 = getTree1();
        final Node tree2 = getTree2();
        final Node tree3 = getTree3();

        return new Object[] {
                new Object[] {
                        tree1,
                        1,
                        7,
                        tree1
                },
                new Object[] {
                        tree2,
                        4,
                        6,
                        tree2.right
                },
                new Object[] {
                        tree3,
                        1,
                        2,
                        tree3
                },
        };
    }

    private Node getTree3() {
        final Node root = new Node(2);
        root.left = new Node(1);
        
        return root;
    }

    private Node getTree2() {
        final Node root = new Node(2);

        final Node one = new Node(1);
        final Node three = new Node(3);
        root.left = one;
        root.right = three;

        final Node four = new Node(4);
        final Node five = new Node(5);
        three.left = four;
        three.right = five;

        five.right = new Node(6);

        return root;
    }

    private Node getTree1() {
        final Node root = new Node(4);
        
        final Node two = new Node(2);
        final Node seven = new Node(7);
        root.left = two;
        root.right = seven;

        final Node one = new Node(1);
        final Node three = new Node(3);
        two.left = one;
        two.right = three;

        seven.left = new Node(6);

        return root;
    }
    
}
