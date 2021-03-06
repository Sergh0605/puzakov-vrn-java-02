package ru.dataart.academy.java;

public class TwoSums {
    /**
     * @param nums   - sorted in ascending order array of integer values >=0
     * @param target - integer value >= 0
     * @return - array of two numbers from nums which sum equals to target
     * Example: nums = [1, 4, 6, 7, 10], target = 10
     * Result - [4, 6]
     * Example: nums = [1, 4, 6, 7, 10], target = 2
     * Result - []
     */
    public int[] getTwoSum(int[] nums, int target) {
        // Special cases check
        if (nums.length < 2) return new int[]{};
        if (nums.length == 2) {
            if (nums[0] + nums[1] == target) return new int[]{nums[0], nums[1]};
            else return new int[]{};
        }
        if (target == 0 && nums[0] + nums[1] == target) return new int[]{nums[0], nums[1]};

        // Searching
        int indexOfFirstSmallerOrEqualElement = getIndexOfFirstSmallerOrEqualElement(nums, target);
        if (indexOfFirstSmallerOrEqualElement == -1) return new int[]{};
        for (int i = 0; i < indexOfFirstSmallerOrEqualElement; i++) {
            for (int k = indexOfFirstSmallerOrEqualElement; k > i; k--) {
                if (nums[i] + nums[k] == target) return new int[]{nums[i], nums[k]};
            }
        }
        return new int[]{};
    }

    private static int getIndexOfFirstSmallerOrEqualElement(int arr[], int elementToSearch) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        // Special cases check
        if (arr[arr.length-1] < elementToSearch) return arr.length-1;
        if (arr[0] >= elementToSearch) return -1;

        //binary search for the first smaller or equal element
        while(firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;

            if (arr[middleIndex] == elementToSearch) {
                if (arr[middleIndex - 1] < elementToSearch) return middleIndex;
                lastIndex =  middleIndex - 1;
            }
            else if (arr[middleIndex] < elementToSearch) {
                if (arr[middleIndex + 1] > elementToSearch) return middleIndex;
                if (arr[middleIndex + 1] == elementToSearch) return middleIndex + 1;
                firstIndex = middleIndex + 1;
            }
            else if (arr[middleIndex] > elementToSearch) {
                if (arr[middleIndex - 1] < elementToSearch) return middleIndex - 1;
                lastIndex = middleIndex - 1;
            }
        }
        // all elements bigger than elementToSearch
        return -1;
    }
}
