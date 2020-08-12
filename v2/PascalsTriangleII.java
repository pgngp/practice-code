/* https://leetcode.com/problems/pascals-triangle-ii/ */
class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        }
        
        int[] arr = new int[rowIndex + 1];
        arr[0] = 1;
        arr[1] = 1;
        int prev = 1;
        for (int i = 2; i <= rowIndex; i++) {
            prev = arr[0] + arr[1];
            for (int j = 2; j < i; j++) {
                int curr = arr[j - 1] + arr[j];
                arr[j - 1] = prev;
                prev = curr;
            }
            arr[i - 1] = prev;
            arr[i] = 1;
            // System.out.println("arr: " + Arrays.toString(arr));
        }
        
        List<Integer> result = new ArrayList<>();
        for (int num : arr) {
            result.add(num);
        }
        
        return result;
    }
}
