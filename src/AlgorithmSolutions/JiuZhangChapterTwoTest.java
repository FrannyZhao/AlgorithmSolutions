package AlgorithmSolutions;

import java.util.ArrayList;

public class JiuZhangChapterTwoTest {
  private static JiuZhangChapterTwoSolutions solution = new JiuZhangChapterTwoSolutions();

  public static void main(String[] args) {
    
    /*
    int[] nums = new int[]{1, 2, 3, 3, 4, 5, 10};
    int target = 6;
    System.out.println("binary search result: "+solution.binarySearch2(nums, target));
    */
    /*
    ArrayList<Integer> A = new ArrayList<Integer>();
    A.add(5);
    A.add(7);
    A.add(7);
    A.add(8);
    A.add(8);
    A.add(10);
    int target2 = 8;
    System.out.println("search range result: " + solution.searchRange(A, target2));
    */
    
    int[] A2 = new int[]{5, 7, 8, 10, 11};
    int target3 = 1;
    System.out.println(""+solution.searchInsert(A2, target3));
  }

}
