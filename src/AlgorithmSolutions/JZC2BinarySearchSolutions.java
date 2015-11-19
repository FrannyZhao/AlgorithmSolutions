package AlgorithmSolutions;

import java.util.ArrayList;

public class JZC2BinarySearchSolutions {

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
  
    /*
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     
    public int findFirstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (VersionControl.isBadVersion(mid)) {
                end = mid;
            } else { // VersionControl.isBadVersion(mid) == false
                start = mid;
            }
        }
        if (VersionControl.isBadVersion(start)) {
            return start;
        } else {
            return end;
        }
    }
     */
  
    /**
     * @param A: An integers array which has the following features:
     * 1. The numbers in adjacent positions are different.
     * 2. A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
     * @return: return any of peek positions P if A[P] > A[P-1] && A[P] > A[P+1].
     */
    public int findPeak(int[] A) {
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) { // ascending
                start = mid;
            } else if (A[mid] < A[mid - 1] && A[mid] > A[mid + 1]) { // descending
                end = mid;
            } else if (A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) { // bottom point
                end = mid;
            }
        }
        return -1;
    }

    /*
     * another method to find peak
     */
    public int findPeak2(int[] A) {
        int start = 1;
        int end = A.length - 2; // avoid out of range
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < A[mid - 1]) { // descending
                end = mid;
            } else if (A[mid] < A[mid + 1]) { // ascending
                start = mid;
            } else { // bottom
                end = mid;
            }
        }
        if (A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }
  
    /**
     * @param nums: The rotated sorted array
     * @return: void
     * Two steps: 1. find the axis: [0 ... axis ... end]
     *            2. reverse (0 ... axis), reverse (axis+1 ... end), reverse (0, end)
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) { // find axis
                reverse(nums, 0, i);
                reverse(nums, i + 1, nums.size() - 1);
                reverse(nums, 0, nums.size() - 1);
            }
        }
    }

    private void reverse(ArrayList<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }
  
    /**
     * @param x: An integer
     * @return: The sqrt of x
     * find the last number which square of it <= x
     */
    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int start = 1;
        int end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid < x / mid) {
                start = mid;
            } else if (mid > x / mid) {
                end = mid;
            } else {
                return mid;
            }
        }
        if (start == x / start) {
            return start;
        }
        if (end == x / end) {
            return end;
        }
        return start;
    }

    // a better solution
    public int sqrt2(int x) {
        long start = 1, end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;
    }

    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        return false;
    }
}
