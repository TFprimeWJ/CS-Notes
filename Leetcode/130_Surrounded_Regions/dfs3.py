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