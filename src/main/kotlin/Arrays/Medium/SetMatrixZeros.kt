package Arrays.Medium

//Input: [[1,1,1],[1,0,1],[1,1,1]]
//Output: [[1,0,1],[0,0,0],[1,0,1]]
class SetMatrixZeros {


    //Approach1: Using sets for rows and columns
    //Time: O(N^2) and Space: O(N)
    fun approach1(matrix: Array<IntArray>){

        val rowsSet = mutableSetOf<Int>()
        val colsSet = mutableSetOf<Int>()

        for(i in matrix.indices){
            for(j in matrix[i].indices){
                if(matrix[i][j]==0){
                    rowsSet.add(i)
                    colsSet.add(j)
                }
            }
        }

        for(i in matrix.indices){
            for(j in matrix[i].indices){
                if(i in rowsSet || j in colsSet){
                    matrix[i][j] = 0
                }
            }
        }

        for(i in matrix.indices){
            for(j in matrix[i].indices){
                print("${matrix[i][j]} ")
            }
            println()
        }
    }

    //Approach2: Using first row and first column
    //Time: O(N^2) and Space: O(1)
    fun approach2(matrix: Array<IntArray>){

        var rowHasZero = false
        var colHasZero = false

        for(i in matrix.indices){
            if(matrix[i][0]==0){
                colHasZero = true
            }
        }

        for(j in matrix[0].indices){
            if(matrix[0][j]==0){
                rowHasZero = true
            }
        }

        for (i in matrix.indices){
            for(j in matrix[i].indices){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0
                    matrix[0][j] = 0
                }
            }
        }

        for(i in matrix.indices){
            for(j in matrix[i].indices){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j] = 0
                }
            }
        }

        if(rowHasZero){
            for(i in matrix.indices){
                matrix[i][0] = 0
            }
        }

        if(colHasZero){
            for(j in matrix[0].indices){
                matrix[0][j] = 0
            }
        }

        for (i in matrix.indices){
            for(j in matrix[i].indices){
                print("${matrix[i][j]} ")
            }
            println()
        }
    }

}

fun main(){

    val setMatrixZeros = SetMatrixZeros()

    setMatrixZeros.approach1(arrayOf(intArrayOf(1,1,1), intArrayOf(1,0,1), intArrayOf(1,1,1)))
    setMatrixZeros.approach2(arrayOf(intArrayOf(1,1,1), intArrayOf(1,0,1), intArrayOf(1,1,1)))

}