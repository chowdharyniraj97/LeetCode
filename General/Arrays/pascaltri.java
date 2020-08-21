class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new LinkedList<>();
        if (numRows == 0) {
            return rows;
        }
        List<Integer> first = new LinkedList<>();
        first.add(1);
        rows.add(first);
        for (int n = 2; n <= numRows; n++) {
            List<Integer> row = new LinkedList<>();
            List<Integer> lastRow = rows.get(n - 2);
            row.add(1);
            for (int i = 1; i < n - 1; i++) {
                row.add(lastRow.get(i-1) + lastRow.get(i));
            }
            row.add(1);
            rows.add(row);
        }
        return rows;
    }
}
