package com.codingtest.test.solution;

import java.util.*;

public class Solution {

    public String test1(String s) {

        IntSummaryStatistics statistics = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .summaryStatistics();

        return statistics.getMin() + " " + statistics.getMax();
    }

    public boolean test2(String s) {

        var stack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public int test3(int[] topping) {
        int answer = 0;

        // 1. 형(older)과 동생(younger)이 가진 토핑의 종류와 개수를 저장할 Map
        Map<Integer, Integer> olderToppings = new HashMap<>();
        Map<Integer, Integer> youngerToppings = new HashMap<>();

        // 2. 처음에는 동생이 모든 토핑을 다 가지고 있음
        for (int t : topping) {
            youngerToppings.put(t, youngerToppings.getOrDefault(t, 0) + 1);
        }

        // 3. 토핑을 왼쪽부터 하나씩 형에게 넘겨주면서 종류의 개수를 비교
        for (int t : topping) {
            // 형에게 토핑 추가
            olderToppings.put(t, olderToppings.getOrDefault(t, 0) + 1);

            // 동생 토핑 감소
            youngerToppings.put(t, youngerToppings.get(t) - 1);
            // 만약 특정 토핑의 개수가 0이 되면, Map 에서 제거
            if (youngerToppings.get(t) == 0) {
                youngerToppings.remove(t);
            }

            // 4. 형과 동생의 토핑 '종류'의 개수가 같으면 answer 증가
            if (olderToppings.size() == youngerToppings.size()) {
                answer++;
            }

        }

        return answer;
    }

    public int test4(int[][] maps) {
        int answer = 0;
        return answer;
    }

}
