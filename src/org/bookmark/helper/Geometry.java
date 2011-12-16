package org.bookmark.helper;

public class Geometry {
    private final static int P1              = 1;
    private final static int P2              = 2;
    private final static int P3              = 3;
    private final static int P4              = 4;
    public final static int  RIGHT_DIRECTION = 1;
    public final static int  LEFT_DIRECTION  = 2;

    /**
     * Ham nay de tinh xem diem x2 y2 so voi tam x1 y1 la goc bao nhieu do
     * 
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public static float calDegree(final float x1, final float y1, final float x2, final float y2,
            final int direction) {
        final float x3 = x2 - x1;
        final float y3 = y2 - y1;
        final double rs = y3 / x3;
        float temp = (float) Math.toDegrees(Math.atan(rs));
        final int quadran = Geometry.getQuadrant(x1, y1, x2, y2);
        temp = Geometry.calRealDegree(Math.abs(temp), quadran, direction);
        return temp;
    }

    /**
     * Kiem tra xem toa do diem x2,y2 thuoc goc phan tu nao cua tam x1,y1
     * 
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    private static int getQuadrant(final float x1, final float y1, final float x2, final float y2) {
        final float x = x2 - x1;
        final float y = 0 - (y2 - y1);

        if (x >= 0 && y > 0) return Geometry.P1;
        else if (x < 0 && y >= 0) return Geometry.P2;
        else if (x <= 0 && y < 0) return Geometry.P3;
        else if (x > 0 && y <= 0) return Geometry.P4;
        return 0;
    }

    /**
     * Tinh toan xem goc nay bao nhieu do tren duong tron va luu vao degree
     * 
     * @param degree
     *            // goc beta
     * @param quadrant
     *            //goc phan tu orgDegree :alpha
     * @return
     */
    private static float calRealDegree(float degree, final int quadrant, final int direction) {
        switch (quadrant) {
            case P1:
                if (direction != Geometry.RIGHT_DIRECTION) degree = 180 - degree;
                else degree = -degree;
                break;
            case P2:
                if (direction == Geometry.RIGHT_DIRECTION) {
                    degree = 180 - degree;
                    degree = -degree;
                }
                break;
            case P3:
                if (direction == Geometry.RIGHT_DIRECTION) {
                    degree = 180 - degree;
                    break;
                } else {
                    degree = 180 + degree;
                    degree = 180 - degree;
                    break;
                }
            case P4:
                if (direction != Geometry.RIGHT_DIRECTION) {
                    degree = 180 - degree;
                    degree = 180 + degree;
                    degree = 180 - degree;
                }
                break;
        }
        return degree;
    }
}
