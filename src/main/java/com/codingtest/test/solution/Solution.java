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

    public int test4(int n) {
        Set<Integer> set = new HashSet<>();

        /**
         * 예를 들어, 36의 약수
         *
         * 1 * 36 = 36
         * 2 * 18 = 36
         * 3 * 12 = 36
         * 4 * 9 = 36
         * 6 * 6 = 36
         * 여기서 1을 찾으면 36도 바로 알 수 있고, 2를 찾으면 18도 바로 알 수 있다. 즉, 1, 2, 3, 4, 6까지만 확인하면 나머지 약수(36, 18, 12, 9)는 자동으로 구할 수 있다.
         *
         * 제곱근(√n) 까지만 확인. 두 쌍의 곱이 자기 자신이 되는 지점(예: 6 * 6 = 36)까지만 확인하면 그 이후로는 이미 찾았던 쌍의 순서만 바뀌어 중복되기 때문.
         *
         * 아이디어: i를 1부터 √n 까지만 증가시키면서, n % i == 0 이면 i와 n / i를 모두 약수로 추가.
         * 시간 복잡도: O(sqrt(n))
         * 숫자 n이 10억이라면, 약 31,622번의 연산만으로 충분. O(n) 방식에 비해 압도적으로 빠름.
         */

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }

        return set.stream().mapToInt(Integer::intValue).sum();
    }
}
