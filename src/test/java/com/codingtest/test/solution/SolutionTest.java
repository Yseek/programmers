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
    @DisplayName("약수의 합")
    void test4() {
        //given
        int n = 12;
        //when
        int answer = solution.test4(n);
        //then
        assertThat(answer).isEqualTo(28);
    }

    @Test
    @DisplayName("자릿수 더하기")
    void test5() {
        //given
        int n = 123;
        //when
        int answer = solution.test5(n);
        //then
        assertThat(answer).isEqualTo(6);
    }

    @Test
    @DisplayName("자연수 뒤집어 배열로 만들기")
    void test6() {
        //given
        long n = 12345;
        //when
        int[] answer = solution.test6(n);
        //then
        assertThat(answer).containsExactly(5, 4, 3, 2, 1);
    }

    @Test
    @DisplayName("x만큼 간격이 있는 n개의 숫자")
    void test7() {
        //given
        int x = 2;
        int n = 5;
        //when
        long[] answer = solution.test7(x, n);
        //then
        assertThat(answer).containsExactly(2, 4, 6, 8, 10);
    }
}