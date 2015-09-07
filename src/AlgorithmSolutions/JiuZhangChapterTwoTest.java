package AlgorithmSolutions;

public class JiuZhangChapterTwoTest {
	private static JiuZhangChapterTwoSolutions solution = new JiuZhangChapterTwoSolutions();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1, 2, 3, 3, 4, 5, 10};
		int target = 6;
		System.out.println(""+solution.binarySearch2(nums, target));
	}

}
