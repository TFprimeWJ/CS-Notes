class MaximumSubarray_SimpleJava {
    public int maxSubArray (int[] A) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (sum < 0)
                sum = A[i];
            else
                sum += A[i];
            
            if (max < sum)
                max = sum;
        }
        return max;
    }
}