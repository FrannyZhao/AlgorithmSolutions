package AlgorithmSolutions;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;

public class JiuZhangChapterOneTest {
	
	private static JiuZhangChapterOneSolutions solution = new JiuZhangChapterOneSolutions();
	private static ArrayList<Integer> S = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String source = "";
		String target = "";
		System.out.println("result="+solution.strStr(source,target));
		
		S.add(4); S.add(1); S.add(0); S.add(0);
		/*
		for (int i = 0; i < 3; i++) {
			S.add(i);
		}
		long start = System.currentTimeMillis();
		System.out.println("start = "+start);
		System.out.println(solution.subSets(S));
		long end = System.currentTimeMillis();
		System.out.println("end = "+end);
		System.out.println("Spend time 1: "+(end-start)+" ms");
		*/
		/*
		start = System.currentTimeMillis();
		System.out.println(solution.subSets2(S));
		end = System.currentTimeMillis();
		System.out.println("Spend time 2: "+(end-start)+" ms");
		*/
		System.out.println(solution.subsetsWithDup(S));
	}

}
