class Solution {
  public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    
    int rows = binaryMatrix.dimensions().get(0);
    int cols = binaryMatrix.dimensions().get(1);

    // Set pointers to the top-right corner.
    int currentRow = 0;
    int currentCol = cols - 1;
    
    // Repeat the search until it goes off the grid.
    while (currentRow < rows && currentCol >= 0) {
      if (binaryMatrix.get(currentRow, currentCol) == 0) {
        currentRow++;
      } else {
        currentCol--; 
      }
    }
    
    // If we never left the last column, this is because it was all 0's.
    return (currentCol == cols - 1) ? -1 : currentCol + 1;
  }
}