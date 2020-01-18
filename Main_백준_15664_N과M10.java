package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_백준_15664_N과M10 {
	private static int[] data;
	private static int[] res;
	private static boolean[] visit;
	private static Set<String> set;

	private static void combination(int n, int m, int depth, int start){
		if(depth == m){
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<m;i++)
				sb.append(res[i] + " ");
			sb.append("\n");

			set.add(sb.toString());

			return;
		}

		for(int i=start;i<n;i++){
			if(!visit[i]){
				visit[i] = true;
				res[depth] = data[i];

				combination(n, m, depth + 1, i);

				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		data = new int[N];
		res = new int[M];
		visit = new boolean[N];

		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++)
			data[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(data);

		set = new LinkedHashSet<>();
		combination(N, M, 0, 0);

		for(String answer:set) System.out.print(answer);
	}
}