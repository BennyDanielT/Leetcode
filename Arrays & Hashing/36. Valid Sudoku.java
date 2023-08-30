class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Set<String> set = new HashSet<>();
        
        for(int row=0;row<9;row++)
        {
            for(int col=0;col<9;col++)
            {
                
                if(board[row][col]!='.')
                {
                    String cellValue = "(" + board[row][col] + ")";
                    
                    if(!set.add(row+cellValue) || !set.add(cellValue+col) || !set.add(row/3 + cellValue + col/3))
                        return false;
                    
                }

            }
        }
        
        return true;
        
    }
}

/*
## Special Learnings

✅ Learnt how to divide a 2D array into composite blocks. 
Example a **9\*9 Matrix into 3\*3 matrices**, using a mere "/" operator. Just divide the rows and columns by 3. 😁
*/