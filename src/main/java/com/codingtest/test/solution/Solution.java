package com.codingtest.test.solution;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

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

    public int test5(int n) {
        int answer = 0;
        while (n > 0) {
            // 1. 가장 마지막 자릿수를 구해서 answer에 더함
            answer += n % 10;
            // 2. 마지막 자릿수를 제거
            n /= 10;
        }
        return answer;
    }

    /**
     *  .chars()가 문자(char)들의 스트림(Stream<Character>)을 반환할 것이라고 예상하지만, 실제로는 **각 문자에 해당하는 '아스키(ASCII) 코드' 숫자의 스트림(IntStream)**을 반환
     *  즉, .chars()의 결과물은 ['5', '4', '3', '2', '1'] 이 아니라 [53, 52, 51, 50, 49].
     *
     *  Java에서는 문자(char)를 사칙연산(+, -, *, /)에 사용하면 자동으로 해당 문자의 아스키 코드 값(int)으로 변환하여 계산
     *
     *  만약 c가 문자 '5'의 아스키 코드 값인 53이라면:
     *  c - '0' => 53 - 48 => 결과는 실제 숫자 5
     *
     *  만약 c가 문자 '4'의 아스키 코드 값인 52이라면:
     *  c - '0' => 52 - 48 => 결과는 실제 숫자 4
     *
     *  만약 c가 문자 '1'의 아스키 코드 값인 49이라면:
     *  c - '0' => 49 - 48 => 결과는 실제 숫자 1
     */
    public int[] test6(long n) {
        return new StringBuilder(Long.toString(n))
                .reverse()
                .chars()
                .map(c -> c - '0')
                .toArray();
    }

    public long[] test7(int x, int n) {

/*        // 1. for 문
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = (long) x * (i + 1);
        }

        return answer;*/

        return LongStream.iterate(x, i -> i + x)
                .limit(n)
                .toArray();
    }

    public int test8(int n) {

        return IntStream.range(1, n)
                .filter(i -> n % i == 1)
                .findFirst()
                .orElse(-1);
    }

    public int test9(int[][] maps) {
        final int n = maps.length;
        final int m = maps[0].length;

        final boolean[][] visited = new boolean[n][m];
        final Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(0, 0, 1));
        visited[0][0] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            final Node node = queue.poll();

            if (node.x == n - 1 && node.y == m - 1) {
                return node.distance;
            }

            for  (int k = 0; k < dx.length; k++) {
                int x = node.x + dx[k];
                int y = node.y + dy[k];

                if (x >= 0 && x < n && y >= 0 && y < m) {
                    if (!visited[x][y] && maps[x][y] == 1) {
                        visited[x][y] = true;
                        queue.offer(new Node(x, y, node.distance + 1));
                    }
                }
            }
        }

        return -1;
    }

    static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int test10(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int index, int sum) {

        if (index == numbers.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        final int addResult = dfs(numbers, target, index + 1, sum + numbers[index]);
        final int subtractResult = dfs(numbers, target, index + 1, sum - numbers[index]);
        return addResult + subtractResult;
    }

    public int test11(String str1, String str2) {

        final List<String> multiSet1 = makeMultiSet(str1);
        final List<String> multiSet2 = makeMultiSet(str2);

        final ArrayList<String> copy1 = new ArrayList<>(multiSet1);
        final ArrayList<String> copy2 = new ArrayList<>(multiSet2);

        int intersectionSize = 0;
        for (String s : copy1) {
            if (copy2.remove(s)) {
                intersectionSize++;
            }
        }

        int unionSize = multiSet1.size() + multiSet2.size() -  intersectionSize;

        if (unionSize == 0) {
            return 65536;
        }

        final double jaccard = (double) intersectionSize / unionSize;

        return (int) (jaccard * 65536);
    }

    private List<String> makeMultiSet(String s) {
        List<String> list = new ArrayList<>();
        s = s.toLowerCase();

        for (int i = 0; i < s.length() - 1; i++) {
            if (Character.isLetter(s.charAt(i))&& Character.isLetter(s.charAt(i + 1))) {
                list.add(s.substring(i, i + 2));
            }
        }

        return list;
    }

}
