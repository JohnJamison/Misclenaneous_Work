#                       ~~~~~ Eight Queens Problem ~~~~~
#            By: John Jamison, Santa Clara University, 2/10/2026
# 
#   In this classic problem, I challenge myself to use recursion to try to find a single
#   solution to the Eight Queens Problem. This problem was first inspired by my Programming
#   languages class assigment.
#
# ======================================================================================

import time

class board():
    board = []
    #minefield = []
    
    def __init__(self):

        #fill the board with 0's
        i = 0
        while i < 64:
            board.board.append(0)
            #board.minefield.append()
            i+=1

    #Check for potential queens left of current position
    def checkHorizontal(self, col, p):
        c = col
        pos = p
        while c > 0:
            pos -= 1
            if self.board[pos] == 1:
                return False
            c-=1
        return True

    #Check if there are any queens diagnol and left of checked position
    def checkDiagonal(self, col, pos):
        up = pos - 9
        down = pos + 7
        c = col
        
        while c > -1:
            #Check upwards diagonal
            if up > -1:
                if self.board[up] == 1:
                    return False
            
            #Check lower diagonal
            if down < 64:
                if self.board[down] == 1:
                    return False
            up -= 9
            down += 7
            c -= 1
        
        return True
    
    #Display Board
    def printBoard(self):
        
        for r in range(8):
            rowSlice = self.board[r*8 : (r+1)*8]
            print(f"[{' '.join(map(str, rowSlice))}]")


    #Recursive Solution Algorithm
    def solveProblem(self, column, row):
        #Base Cases

        #If column has exceeded 7, then it has found a state
        if column > 7:
            print("\nFOUND IT!!\n")
            return True
        
        #If row exceeds 7, no row in a column was feasible, so it fails
        elif row > 7:
            return False
        
        else:
            # Check if this position can hold a piece
            pos = 8*row + column
            if self.checkHorizontal(column, pos) and self.checkDiagonal(column, pos):
                
                #If it can, set the position to 1 
                self.board[pos] = 1

                # Move onto the next columns or undo unfeaible board position
                if not self.solveProblem(column + 1, 0):
                    self.board[pos] = 0
                    return self.solveProblem(column, row + 1)
                
                #Notify if a state is found and end the program
                else:
                   return True
                
            #If so, and nothing can be placed in the column, erase the previous 1 and move on
            else:
                return self.solveProblem(column, row + 1)

  

# =====================   Main Program   ====================
if __name__ == "__main__":
    startTime = time.perf_counter()
    queensProblem = board()
    queensProblem.solveProblem(0,0)
    endTime = time.perf_counter()
    queensProblem.printBoard()
    print("\n")
    totalTime =  endTime - startTime
    print(f"Total Time to compute: {totalTime} \n")
