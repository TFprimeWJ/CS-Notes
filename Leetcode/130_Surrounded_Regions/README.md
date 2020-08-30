# 130 Surrounded Regions

## 题目

在一个二维平面上，与外界相连的"O"成为outer O，被"X"包围的"O"成为inner O，我们要做的就是把inner O找出来变成X。

## 解法

这道题解法上我浏览了一下discussion，我觉得本质上大家的想法都是一样的，那就是先从最外围了一圈outer O找起，然后用dfs不停的寻找与其相邻的outer O，最后将这些outer O用一个新的符号替代，剩下的O就全部都是inner O了，最后遍历整个二维数组，将所有的O变成X，再将outer O变回O。

### 解法一：使用`collections.deque`

```python
# dfs
class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # queue: outer 'O'
        queue = collections.deque([])
        for r in range(len(board)):
            for c in range(len(board[0])):
                if((r in [0, len(board)-1] or c in [0, len(board[0])-1]) and board[r][c] == 'O'):
                    queue.append((r, c))
        
        # dfs
        while(queue):
            r, c = queue.pop()
            if(0 <= r < len(board) and 0 <= c < len(board[0]) and board[r][c] == 'O'):
                board[r][c] = 'Y'
                queue.append((r-1, c))
                queue.append((r+1, c))
                queue.append((r, c-1))
                queue.append((r, c+1))
        
        # get result
        for r in range(len(board)):
            for c in range(len(board[0])):
                if(board[r][c] == 'O'):
                    board[r][c] = 'X'
                if(board[r][c] == 'Y'):
                    board[r][c] = 'O'
```

### 解法二：代码较为简洁的dfs

```python
class Solution:
    def solve(self, board: List[List[str]]) -> None:
        # DFS
        def markNotSurrounded(board: [[str]], i: int, j: int):
            if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] != 'O':
                return
            board[i][j] = 'v'
            markNotSurrounded(board, i - 1, j) # north
            markNotSurrounded(board, i, j + 1) # east
            markNotSurrounded(board, i + 1, j) # south
            markNotSurrounded(board, i , j - 1) # west
            board[i][j] = 'o'
        if len(board) == 0:
            return
        lastRow = len(board) - 1
        lastCol = len(board[0]) - 1 
        for col in range(0, lastCol + 1):
            markNotSurrounded(board, 0, col)
            markNotSurrounded(board, lastRow, col)
        for row in range(0, lastRow + 1):
            markNotSurrounded(board, row, 0)
            markNotSurrounded(board, row, lastCol)
        for row in range(0, lastRow + 1):
            for col in range(0, lastCol + 1):
                if board[row][col] == 'o':
                    board[row][col] = 'O'
                else:
                    board[row][col] = 'X'
```

### 解法三：我的第一次自己尝试的解法

```python
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
```