package com.kdjd.code;

import java.util.Objects;

/**
 * <a href="https://leetcode.cn/problems/validate-binary-search-tree/?favorite=2cktkvj"/>
 */
public class TreeTest {

    public static void main(String[] args) {
        Integer[] root = new Integer[]{2, 1, 3};
        System.out.println(tree(root));

        root = new Integer[]{5, 1, 4, null, null, 3, 6};
        System.out.println(tree(root));

        root = new Integer[]{5, 1, 4, null, null, 3, 6, null, null, null, null, 3, 4, 5, 6};
        System.out.println(tree(root));


    }


    public static boolean tree(Integer[] root) {
        for (int i = 0; i < root.length; i++) {
            Integer r = root[i];
            if (Objects.isNull(r)) {
                continue;
            }
            int idx = 2 * i + 1;
            if (idx >= root.length) {
                continue;
            }

            Integer left = root[idx];
            Integer right = root[idx + 1];
            if (!Objects.isNull(left) && left > r) {
                return false;
            }
            if (!Objects.isNull(right) && right < r) {
                return false;
            }
        }
        return true;
    }
}
