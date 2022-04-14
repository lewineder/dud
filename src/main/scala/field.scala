
def genFieldArray(i: Int = 10): Array[Array[Int]] =
    return Array.ofDim[Int](i, i)

def passNewState(matrix: Array[Array[Int]], i: Int = 0, j: Int = 0, value: Int = 0): Array[Array[Int]] =
    matrix(i)(j) = value
    return matrix

