package com.codingtest.test.solution;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("최댓값과 최솟값")
    void test1() {
        //given
        String s = "1 2 3 4";
        //when
        String answer = solution.test1(s);
        //then
        assertThat(answer).isEqualTo("1 4");
    }

    @Test
    @DisplayName("올바른 괄호")
    void test2() {
        //given
        String s = "()()";
        //when
        boolean answer = solution.test2(s);
        //then
        assertThat(answer).isTrue();
    }

    @Test
    @DisplayName("롤케이크 자르기")
    void test3() {
        //given
        var topping = new int[]{1, 2, 1, 3, 1, 4, 1, 2};
        //when
        int answer = solution.test3(topping);
        //then
        assertThat(answer).isEqualTo(2);
    }

    @Test
    @DisplayName("게임 맵 최단거리")
    void test4() {
        //given
        int[][] map = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        //when
        int answer = solution.test4(map);
        //then
        assertThat(answer).isEqualTo(11);
    }
}