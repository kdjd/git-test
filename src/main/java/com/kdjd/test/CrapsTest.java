package com.kdjd.test;

import java.util.Random;

/**
 * CRAPS又称花旗骰，是美国拉斯维加斯非常受欢迎的一种的桌上赌博游戏。该游戏使用两粒骰子，玩家通过摇两粒骰子获得点数进行游戏。
 * 简单的规则是：玩家第一次摇骰子如果摇出了7点或11点，玩家胜；
 * 玩家第一次如果摇出2点、3点或12点，庄家胜；
 * 其他点数玩家继续摇骰子，如果玩家摇出了7点，庄家胜；
 * 如果玩家摇出了第一次摇的点数，玩家胜；
 * 其他点数，玩家继续要骰子，直到分出胜负。
 */
public class CrapsTest {

    public static void main(String[] args) {
        int wj = 0, zj = 0;

        for (int i = 0; i < 100000000; i++) {
            Random random = new Random();
            int a, b, f = 0;
            boolean flag = true, continued = false;
            while (flag) {
                a = random.nextInt(6) + 1;
                b = random.nextInt(6) + 1;
                int r = a + b;
                if (r == 7 || r == 11) {
                    wj++;
                    flag = false;
                } else if (r == 2 || r == 3 || r == 12) {
                    zj++;
                    flag = false;
                } else {
                    f = r;
                    continued = true;
                }
                while (continued) {
                    a = random.nextInt(6) + 1;
                    b = random.nextInt(6) + 1;
                    r = a + b;
                    continued = false;
                    if (r == f) {
                        wj++;
                        flag = false;
                    } else if (r == 7) {
                        zj++;
                        flag = false;
                    } else {
                        continued = true;
                    }
                }
            }
        }
        System.out.println("wj:" + wj + ",zj:" + zj);
    }
}
