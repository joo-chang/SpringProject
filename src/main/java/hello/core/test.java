package hello.core;


import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        System.out.println("solution = " + solution(5, new int[] {3,4,5}, new int[] {1, 3, 2}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int good = 0;
        int reserveCount = 0;
        //정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] - 1 == reserve[reserveCount] || lost[i] + 1 == reserve[reserveCount] || lost[i] == reserve[reserveCount]) {
                reserveCount++;
                good++;
                if (reserveCount >= reserve.length) {
                    break;
                }
                continue;
            }
            for (int j = reserveCount; j < reserve.length; j++) {
                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    reserveCount++;
                    good++;
                }else if (lost[i] + 2 <= reserve[j]){
                    break;
                }
            }
        }
        return n - lost.length + good;
    }

    public static int solution3(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        System.out.println("people = " + Arrays.toString(people));
        int first = 0, end = people.length - 1;

        while (first <= end) {
            if (people[first] + people[end] <= limit) {
                first++;
            }
            answer++;
            end--;
            System.out.println("answer = " + answer);
        }
        return answer;
    }
    public static int solution2(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        System.out.println("people = " + Arrays.toString(people));
        for (int i = people.length - 1; i >= 0 ; i--) {
            int count = 0;
            int total = 0;
            for (int j = i; j >= 0; j--) {
                // 1. total에 people[j] 더한 값이 limit 보다 작아야됨
                // 2. 최대 2명
                // 3. 한바퀴 다돌고 횟수 증가
                if (total + people[j] <= limit) {
                    System.out.println("people = " + people[j]);
                    total += people[j];
                    count++;
                    System.out.println("count = " + count);
                }
                if (count == 2 || total >= limit) {
                    break;
                }
            }
            answer++;
            System.out.println("answer = " + answer);
        }


        return answer;
    }


}
