class Matrix:
    def __init__(self, listoflists):
        self.dimensions = len(listoflists)
        self.listoflists = listoflists
    
    def printMatrix(self):

        for row in self.listoflists:
            
            s = ""
            for val in row:
                s += str(val) + " "
            
            print("%s \n", s)
    
    def __add__(self, right):

        if self.dimensions != right.dimensions:
            print("Error: Dimensions don't match")
            return 0
        
        for row in self.listoflists:
            for val in row:
                self.listoflists[row][val] += right.listoflists[row][val]
        
        return self.listoflists
    
    def __str__(self): 
        
        s = ""
        for row in self.listoflists:
            for val in row:
                s += str(val) + " "
            
        return s
    
if __name__ == "__main__":
    m1 = Matrix([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
    m2 = Matrix([[2, 3, 4], [5, 6, 7], [1, 2, 3]])
    m3 = m1.__add__(m2)
    m3.printMatrix()
    print()

    print(str(m1))
    m4=Matrix([[2, 3, 4], [5, 6, 7], [1, 2, 3]])
    mofm = Matrix([[m1, m2], [m3, m4]])
    mofm2 = mofm.__add__(mofm)
    print(mofm2.printMatrix())

            

