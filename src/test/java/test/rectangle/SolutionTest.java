package test.rectangle;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.rectangle.Solution.Rectangle;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final int[][] image, final Collection<Rectangle> expectedRectangles) {
        //given

        //when
        final Collection<Rectangle> rectangles = Solution.getRectangles(image);

        //then
        assertThat(rectangles).containsOnlyElementsOf(expectedRectangles);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        new int[][] {
                                { 0, 0, 1, 1, 0, 0, 1, 1 },
                                { 0, 0, 1, 1, 0, 0, 1, 1 },
                                { 0, 0, 1, 1, 1, 1, 1, 1 },
                                { 0, 0, 1, 1, 0, 0, 0, 1 },
                                { 1, 1, 1, 1, 0, 0, 0, 1 },
                                { 1, 0, 1, 1, 0, 0, 0, 1 },
                                { 1, 0, 1, 1, 1, 1, 1, 1 },
                                { 1, 0, 1, 1, 1, 1, 1, 1 },
                                { 1, 1, 1, 1, 0, 0, 1, 1 },
                                { 0, 0, 1, 1, 0, 0, 1, 1 },
                                { 1, 1, 1, 1, 1, 1, 1, 1 },
                                { 0, 1, 1, 1, 1, 1, 1, 1 },
                                { 0, 1, 1, 1, 1, 1, 1, 1 },
                                { 1, 1, 1, 1, 1, 1, 1, 1 },
                        },
                        Lists.newArrayList(
                                Rectangle.create(0, 0, 3, 1),
                                Rectangle.create(0, 4, 1, 5),
                                Rectangle.create(3, 4, 5, 6),
                                Rectangle.create(5, 1, 7, 1),
                                Rectangle.create(8, 4, 9, 5),
                                Rectangle.create(9, 0, 9, 1),
                                Rectangle.create(11, 0, 12, 0)
                        )
                },
                new Object[] {
                        new int[][] {
                                { 1, 1, 1, 1, 1, 1, 1 },
                                { 1, 1, 1, 1, 1, 1, 1 },
                                { 1, 1, 1, 0, 0, 0, 1 },
                                { 1, 0, 1, 0, 0, 0, 1 },
                                { 1, 0, 1, 1, 1, 1, 1 },
                                { 1, 0, 1, 1, 1, 1, 1 },
                                { 1, 1, 1, 0, 0, 1, 1 },
                                { 1, 1, 1, 0, 0, 1, 1 },
                                { 1, 1, 1, 1, 1, 1, 1 },
                        },
                        Lists.newArrayList(
                                Rectangle.create(2, 3, 3, 5),
                                Rectangle.create(3, 1, 5, 1),
                                Rectangle.create(6, 3, 7, 4)
                        )
                },
        };
    }

}
