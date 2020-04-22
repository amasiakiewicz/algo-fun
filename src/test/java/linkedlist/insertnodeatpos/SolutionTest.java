package linkedlist.insertnodeatpos;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(Solution.SinglyLinkedListNode head, int data, int position, String expectedListPrint) throws IOException {
        //given

        //when
        final Solution.SinglyLinkedListNode listHead = Solution.insertNodeAtPosition(head, data, position);

        //then
        final StringWriter sw = new StringWriter();
        final BufferedWriter bufferedWriter = new BufferedWriter(sw);
        Solution.printSinglyLinkedList(listHead, " ", bufferedWriter);
        bufferedWriter.flush();
        assertThat(sw.getBuffer().toString()).isEqualTo(expectedListPrint);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        getHead1(),
                        1,
                        2,
                        "16 13 1 7"
                },
                new Object[] {
                        new Solution.SinglyLinkedListNode(5),
                        1,
                        0,
                        "1 5"
                },
                new Object[] {
                        new Solution.SinglyLinkedListNode(5),
                        1,
                        1,
                        "5 1"
                },
        };
    }

    private Solution.SinglyLinkedListNode getHead1() {
        final Solution.SinglyLinkedListNode head = new Solution.SinglyLinkedListNode(16);

        final Solution.SinglyLinkedListNode n_13 = new Solution.SinglyLinkedListNode(13);
        head.next = n_13;

        final Solution.SinglyLinkedListNode n_7 = new Solution.SinglyLinkedListNode(7);
        n_13.next = n_7;
        
        n_7.next = null;

        return head;
    }

}
