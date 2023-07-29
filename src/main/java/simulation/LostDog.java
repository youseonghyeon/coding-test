package simulation;

public class LostDog {

    public int proceed(int[][] board) {
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                if (board[y][x] == 2) {
                    x1 = x;
                    y1 = y;
                    board[y][x] = 0;
                }
                if (board[y][x] == 3) {
                    x2 = x;
                    y2 = y;
                    board[y][x] = 0;
                }
            }
        }

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{-1, 0, 1, 0};
        int d1 = 0, d2 = 0;
        int n = board.length;

        for (int cnt = 0; cnt < 10000; cnt++) {
            int nx1 = x1 + dx[d1];
            int ny1 = y1 + dy[d1];

            int nx2 = x2 + dx[d2];
            int ny2 = y2 + dy[d2];

            // person
            if (nx1 < n && nx1 >= 0 && ny1 < n && ny1 >= 0) {
                if (board[ny1][nx1] == 0) {
                    x1 = nx1;
                    y1 = ny1;
                } else if (board[ny1][nx1] == 1) {
                    d1 = (d1 + 1) % 4;
                }
            } else {
                // turn
                d1 = (d1 + 1) % 4;
            }

            // dog
            if (nx2 < n && nx2 >= 0 && ny2 < n && ny2 >= 0) {
                if (board[ny2][nx2] == 0) {
                    x2 = nx2;
                    y2 = ny2;
                } else if (board[ny2][nx2] == 1) {
                    d2 = (d2 + 1) % 4;
                }
            } else {
                //turn
                d2 = (d2 + 1) % 4;
            }

            if (x1 == x2 && y1 == y2) {
                return cnt + 1;
            }
        }
        return 0;


    }


    public static void main(String[] args) {
        LostDog app = new LostDog();

        int[][] board = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}
        };
        int answer = app.proceed(board);
        System.out.println(answer);
    }

}
