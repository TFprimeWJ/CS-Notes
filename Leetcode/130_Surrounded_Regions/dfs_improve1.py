class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # if(len(board) == 0):
        #     return []
        if not any(board): return []
        
        # Parameters
        nRow, nCol = len(board), len(board[0])
        
        # Date Structure
        # -1: this point has not been grouped
        #  0: 'O' connected to outer space
        #  1: 'X' all X
        #  2: 'O' all 'O' inside 'X'
        l = [[-1 for i in range(nCol)] for i in range(nRow)]
        
        def dfs(row, col, sym):
            if(row >= 0 and row < nRow and col >= 0 and col < nCol):
                if(board[row][col] == sym and l[row][col] == -1):
                    l[row][col] = 0
                    dfs(row-1, col, sym)
                    dfs(row+1, col, sym)
                    dfs(row, col-1, sym)
                    dfs(row, col+1, sym)
                    
        # Assign group value
        
        # Four edges
        ## Up
        row = 0
        sym = 'O'
        for col in range(nCol):
            dfs(row, col, sym)
        ## Left
        col = 0
        for row in range(nRow):
            dfs(row, col, sym)
        ## Right
        col = nCol - 1
        for row in range(nRow):
            dfs(row, col, sym)
        ## Bottom
        row = nRow - 1
        for col in range(nCol):
            dfs(row, col, sym)
            
        # 'X'
        sym = 'X'
        for row in range(nRow):
            for col in range(nCol):
                dfs(row, col, sym)
        
        # change inner 'O' into 'X'
        for row in range(nRow):
            for col in range(nCol):
                if(l[row][col] == -1):
                    board[row][col] = 'X'
            
                