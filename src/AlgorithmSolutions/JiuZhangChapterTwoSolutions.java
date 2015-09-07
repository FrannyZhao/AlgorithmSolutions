package AlgorithmSolutions;

public class JiuZhangChapterTwoSolutions {
	
	/*
	 * find the first index of target
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
	
	/*
	 * find the last index of target
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
        	} else if (nums[mid] > target) {
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

}
