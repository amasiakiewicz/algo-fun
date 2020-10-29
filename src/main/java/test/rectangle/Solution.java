package test.rectangle;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {

    static int[][] image = {
            { 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 0, 0, 0, 1 },
            { 1, 0, 1, 0, 0, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 1 },
            { 1, 0, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 0, 0, 1, 1 },
            { 1, 1, 1, 0, 0, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1 },
    };

    static Set<Rectangle> getRectangles(final int[][] image) {
        final Set<Rectangle> rectangles = new HashSet<>();

        final int imageWidth = image.length;
        final int imageHeight = image[0].length;

        final Rectangle[][] rectanglesImage = new Rectangle[imageWidth][imageHeight];

        for (int i = 0; i < imageWidth; i++) {
            for (int j = 0; j < imageHeight; j++) {
                final int pixel = image[i][j];

                if (pixel == 1) {
                    continue;
                }

                if ((i - 1 < 0 || image[i - 1][j] == 1) && (j - 1 < 0 || image[i][j - 1] == 1)) { //it's a new rectangle

                    final Coord startPos = new Coord(i, j);
                    final Rectangle rectangle = new Rectangle(startPos);
                    rectanglesImage[i][j] = rectangle;
                    rectangles.add(rectangle);

                    continue;
                }

                final Rectangle currentRectangle = (i - 1 >= 0 && rectanglesImage[i - 1][j] != null)
                        ? rectanglesImage[i - 1][j]
                        : rectanglesImage[i][j - 1];

                rectanglesImage[i][j] = currentRectangle;
                currentRectangle.endPos = new Coord(i, j);
            }
        }

        return rectangles;
    }

    static class Rectangle {

        private final Coord startPos;
        private Coord endPos;

        static Rectangle create(final int startPosX, final int startPosY, final int endPosX, final int endPosY) {
            final Coord startPos = new Coord(startPosX, startPosY);
            final Coord endPos = new Coord(endPosX, endPosY);
            return new Rectangle(startPos, endPos);
        }

        Rectangle(final Coord startPos) {
            this.startPos = startPos;
        }

        Rectangle(final Coord startPos, final Coord endPos) {
            this.startPos = startPos;
            this.endPos = endPos;
        }

        @Override
        public String toString() {
            return "startPos = " + startPos + ", endPos = " + endPos;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Rectangle rectangle = (Rectangle) o;

            if (!Objects.equals(startPos, rectangle.startPos)) return false;
            return Objects.equals(endPos, rectangle.endPos);
        }

        @Override
        public int hashCode() {
            int result = startPos != null ? startPos.hashCode() : 0;
            result = 31 * result + (endPos != null ? endPos.hashCode() : 0);
            return result;
        }
    }

    private static class Coord {

        private final int x;
        private final int y;

        Coord(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Coord coord = (Coord) o;

            if (x != coord.x) return false;
            return y == coord.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return "[" + x + ", " + y + "]";
        }
    }

    public static void main(String[] args) {
        final Set<Rectangle> rectangles = getRectangles(image);

        int[] ind = { 0 };
        rectangles.forEach(rectangle -> {
            ind[0]++;
            System.out.println("Rectangle " + ind[0] + " " + rectangle);
        });
    }
}