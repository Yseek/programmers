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

    @Test
    @DisplayName("나머지가 1이 되는 수 찾기")
    void test8() {
        //given
        int n = 10;
        //when
        int answer = solution.test8(n);
        //then
        assertThat(answer).isEqualTo(3);
    }

    @Test
    @DisplayName("게임 맵 최단거리")
    void test9() {
        //given
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        //when
        final int answer = solution.test9(maps);
        //then
        assertThat(answer).isEqualTo(11);
    }

    @Test
    @DisplayName("타겟 넘버")
    void test10() {
        //given
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        //when
        final int answer = solution.test10(numbers, target);
        //then
        assertThat(answer).isEqualTo(5);
    }

    @Test
    @DisplayName("[1차] 뉴스 클러스터링")
    void test11() {
        //given
        String str1 = "FRANCE";
        String str2 = "french";

        String str1_2 = "aa1+aa2";
        String str2_2 = "AAAA12";
        //when
        final int answer = solution.test11(str1, str2);
        final int answer2 = solution.test11(str1_2, str2_2);
        //then
        assertThat(answer).isEqualTo(16384);
        assertThat(answer2).isEqualTo(43690);
    }

    @Test
    @DisplayName("완전탐색 - 모음사전")
    void findWordIndex() {
        //given
        String word = "AAAAE";
        //when
        final int answer = solution.findWordIndex(word);
        //then
        assertThat(answer).isEqualTo(6);
    }

    @Test
    @DisplayName("방문 길이")
    void visitedLength() {
        //given
        String dirs = "LULLLLLLU";
        //when
        final int answer = solution.visitedLength(dirs);
        //then
        assertThat(answer).isEqualTo(7);
    }
}