package Arrays.Medium

//Input: [[1,2,3],[4,5,6],[7,8,9]]
//Output: [[7,4,1],[8,5,2],[9,6,3]]
/*
    1 2 3      7 4 1
    4 5 6  ->  8 5 2
    7 8 9      9 6 3
*/
class RotateMatrixBy90 {

    //Approach1: Using extra matrix
    //Time: O(N^2) and Space: O(N^2)
    fun approach1(matrix: Array<IntArray>){

        var n = matrix.size
        var newMatrix = Array(n){IntArray(n)}

        for(i in matrix.indices){
            for(j in matrix[i].indices){
                newMatrix[j][n-i-1] = matrix[i][j]
            }
        }

        for(i in matrix.indices){
            for (j in matrix[i].indices){
                matrix[i][j] = newMatrix[i][j]
            }
        }

        for(i in matrix.indices){
            for(j in matrix[i].indices){
                print("${matrix[i][j]} ")
            }
            println()
        }
    }

    //Approach2: Kind of Spiral traversal and swapping
    //Time: O(N^2) and Space: O(1)

    /*

        1 2 3    7 2 1    7 4 1
        4 5 6 -> 4 5 6 -> 8 5 2
        7 8 9    9 8 3    9 6 3
    */
    fun approach2(matrix: Array<IntArray>){
        var n = matrix.size

        for(i in 0 until n/2){
            for(j in i until n-i-1){
                var temp = matrix[i][j]
                matrix[i][j] = matrix[n-j-1][i]
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1]
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1]
                matrix[j][n-i-1] = temp
            }
        }

        for(i in matrix.indices){
            for(j in matrix[i].indices){
                print("${matrix[i][j]} ")
            }
            println()
        }
    }

    //Approach3: swap row and col elements and then reverse each row
    //Time: O(N^2) and Space: O(1)
    fun approach3(matrix: Array<IntArray>){
        var n = matrix.size

        for(i in matrix.indices){
            for(j in 0 until i){
                var temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }

        for(i in 0 until n){
            matrix[i].reverse()
        }

        for(i in matrix.indices){
            for(j in matrix[i].indices){
                print("${matrix[i][j]} ")
            }
            println()
        }
    }

}

fun main(){

    val rotateMatrixBy90 = RotateMatrixBy90()

    print("Approach1: ")
    println()
    rotateMatrixBy90.approach1(arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9)))

    print("Approach2: ")
    println()
    rotateMatrixBy90.approach2(arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9)))

    print("Approach3: ")
    println()
    rotateMatrixBy90.approach3(arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9)))
}

