package AlgorithmSolutions;

import java.util.ArrayList;

public class JiuZhangChapterTwoSolutions {

  /**
   * @param nums: The integer array.
   * @param target: Target to find.
   * @return: The first position of target. Position starts from 0 to (nums.length -1).
   */
  public int binarySearch(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int start = 0;
    int end = nums.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        end = mid;
      } else if (nums[mid] < target) {
        start = mid;
      } else if (nums[mid] > target) {
        end = mid;
      }
    }
    if (nums[start] == target) {
      return start;
    }
    if (nums[end] == target) {
      return end;
    }
    return -1;
  }

  /**
   * @param nums: The integer array.
   * @param target: Target to find.
   * @return: The last position of target. Position starts from 0 to (nums.length -1).
   */
  public int binarySearch2(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int start = 0;
    int end = nums.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        start = mid;
      } else if (nums[mid] < target) {
        start = mid;
      } else { // nums[mid] > target
        end = mid;
      }
    }
    if (nums[end] == target) {
      return end;
    }
    if (nums[start] == target) {
      return start;
    }
    return -1;
  }

  /**
   * @param A : an integer sorted array
   * @param target : the starting and ending position of a given target value
   * @return : a list of length 2, [starting_index, ending_index]
   * Two steps: 1. find the first index of target
   *            2. find the last index of target
   */
  public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    int firstTarget = -1;
    int lastTarget = -1;
    result.add(firstTarget);
    result.add(lastTarget);
    if (A != null && A.size() != 0) {
      // find the first index of target
      int start = 0;
      int end = A.size() - 1;
      while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        if (A.get(mid) == target) {
          end = mid;
        } else if (A.get(mid) < target) {
          start = mid;
        } else { // A.get(mid) > target
          end = mid;
        }
      }
      if (A.get(start) == target) {
        firstTarget = start;
      } else if (A.get(end) == target) {
        firstTarget = end;
      } else { // can't find target
        result.set(0, firstTarget);
        result.set(1, lastTarget);
        return result;
      }

      // find the last index of target
      start = firstTarget;
      end = A.size() - 1;
      while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        if (A.get(mid) == target) {
          start = mid;
        } else if (A.get(mid) < target) {
          start = mid;
        } else { // A.get(mid) > target
          end = mid;
        }
      }
      if (A.get(end) == target) {
        lastTarget = end;
      } else if (A.get(start) == target) {
        lastTarget = start;
      }
    }
    result.set(0, firstTarget);
    result.set(1, lastTarget);
    return result;
  }

  /**
   * @param A : an integer sorted array
   * @param target : an integer to be inserted
   * @return : an integer
   */
  public int searchInsert(int[] A, int target) {
    if (A == null) {
      return -1;
    }
    if (A.length == 0) {
      return 0;
    }
    int start = 0;
    int end = A.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (A[mid] == target) {
        return mid;
      } else if (A[mid] < target) {
        start = mid;
      } else { // A[mid] > target
        end = mid;
      }
    }
    if (A[start] >= target) {
      return start;
    }
    if (A[end] < target) {
      return end + 1;
    }
    if (A[start] < target && A[end] >= target) {
      return end;
    }
    return -1;
  }
}
