class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if(len(board) == 0):
            return []
        
        # Parameters
        nRow = len(board)
        nCol = len(board[0])
        
        # Date Structure
        # -1: this point has not been grouped
        #  0: 'O' connected to outer space
        #  1: 'X' all X
        #  2: 'O' all 'O' inside 'X'
        l = [[-1 for i in range(nCol)] for i in range(nRow)]
        
        def dfs_otterO(row, col):
            if(row >= 0 and row < nRow and col >= 0 and col < nCol):
                if(board[row][col] == 'O' and l[row][col] == -1):
                    l[row][col] = 0
                    dfs_otterO(row-1, col)
                    dfs_otterO(row+1, col)
                    dfs_otterO(row, col-1)
                    dfs_otterO(row, col+1)
                    
        def dfs_X(row, col):
            if(row >= 0 and row < nRow and col >= 0 and col < nCol):
                if(board[row][col] == 'X' and l[row][col] == -1):
                    l[row][col] = 1
                    dfs_X(row-1, col)
                    dfs_X(row+1, col)
                    dfs_X(row, col-1)
                    dfs_X(row, col+1)
                    
        # Assign group value
        
        # Four edges
        ## Up
        row = 0
        for col in range(nCol):
            dfs_otterO(row, col)
        ## Left
        col = 0
        for row in range(nRow):
            dfs_otterO(row, col)
        ## Right
        col = nCol - 1
        for row in range(nRow):
            dfs_otterO(row, col)
        ## Bottom
        row = nRow - 1
        for col in range(nCol):
            dfs_otterO(row, col)
            
        # 'X'
        for row in range(nRow):
            for col in range(nCol):
                dfs_X(row, col)
        
        # change inner 'O' into 'X'
        for row in range(nRow):
            for col in range(nCol):
                if(l[row][col] == -1):
                    board[row][col] = 'X'
            
                