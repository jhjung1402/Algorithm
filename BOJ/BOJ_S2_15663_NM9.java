import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
* @author JUNG
* @name BOJ_S3_15663_N과M(9)
* @date 2020.09.04
* @link https://www.acmicpc.net/problem/15663
* @mem
* @time
* @caution
* [고려사항] 
* [입력사항] 자연수 N과 M / N개의 숫자 정보
* [출력사항] N개의 자연수 중에서 중복 없이 M개를 고른 순열
* 
* 중복된 숫자가 여러개 있을 수 있는데, 중복되는 수열을 여러번 출력해서는 안된다.
* 수열은 사전 순으로 증가하는 순서로 출력 -> 수열 만들기 전 정렬
* 
* 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다. -> 10,000+1 크기의 방문여부 배열 생성 or 중복관리를 위한 set 생성
* 
*/

public class BOJ_S2_15663_NM9 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens = null;
    static StringBuilder output = null;
    static int N, M;
    static int[] numbers;
    
    public static void main(String[] args) throws Exception {
        tokens = new StringTokenizer(input.readLine(), " ");
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        
        numbers = new int[N];
        tokens = new StringTokenizer(input.readLine(), " ");
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(tokens.nextToken());
        }
        
        output = new StringBuilder();
        Arrays.sort(numbers); //사전 순 증가를 위해 미리 오름차순 정렬
        makePermutation(0, new int[M], new boolean[N]);
        System.out.println(output);

    }

    public static void makePermutation(int m, int[] temp, boolean[] visited) {
        if(m == M) {            
            for(int t : temp) {
                output.append(t).append(" ");
            }
            output.append("\n");
            return;
        }
        
        Set<Integer> dup = new HashSet<Integer>();
        for(int i = 0; i < N; i++) {
            if(!dup.contains(numbers[i]) && !visited[i]) {
                visited[i] = true;
                dup.add(numbers[i]);
                temp[m] = numbers[i];
                makePermutation(m+1, temp, visited); 
                visited[i] = false;
            }

        }
        
    }
}
