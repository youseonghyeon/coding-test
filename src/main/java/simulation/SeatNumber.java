package simulation;

public class SeatNumber {

    public int[] proceed(int c, int r, int k) {
        if (k > c*r) {
            return new int[]{0, 0};
        }

        int[][] seat = new int[r][c];
        seat[0][0] = 1;
        int x = 0, y = 0;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int d = 0;

        int cnt = 1;

        while (cnt < k) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < c && nx >= 0 && ny < r && ny >= 0 && seat[ny][nx] == 0) {
                seat[ny][nx] = 1;
                x = nx;
                y = ny;
                cnt++;
            } else {
                d = (d + 1) % 4;
            }
        }

        return new int[]{x+1, y+1 };


    }


    public static void main(String[] args) {
        SeatNumber app = new SeatNumber();

        int[] answer = app.proceed(6, 5, 31);
        System.out.println(answer[0] + " " + answer[1]);
    }
}
