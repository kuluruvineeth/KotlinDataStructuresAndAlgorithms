package Arrays.Easy

//Input : [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target=20
//Output : true/false
class SearchElementInMatrix {

    //Approach1: Using two loops
    //Time: O(N^2) and Space: O(1)
    fun approach1(matrix: List<List<Int>>, target: Int): Boolean{

        for(i in matrix.indices){
            for(j in matrix[i].indices){
                if(matrix[i][j] == target){
                    return true
                }
            }
        }
        return false
    }

    //Approach2: Using binary search along with two pointers
    //Time: O(M+N) and Space: O(1)
    fun approach2(matrix: List<List<Int>>, target: Int): Boolean{

        val m = matrix.size
        val n = matrix[0].size

        var row = 0
        var col = n-1

        while (row < m && col > 0){
            var current = matrix[row][col]
            if(current == target){
                return true
            }else if(current < target){
                row++
            }else{
                col--
            }
        }
        return false
    }

    //Approach3: Using binarySearch() function
    //Time: O(MLogN) and Space: O(1)
    fun approach3(matrix: List<List<Int>>, target: Int): Boolean{

        for(i in matrix.indices){
            if(matrix[i].binarySearch(target) >= 0){
                return true
            }
        }
        return false
    }

}

fun main(){

    val searchElementInMatrix = SearchElementInMatrix()

    println("Approach1 : ${searchElementInMatrix.approach1(listOf(listOf(1,3,5,7), listOf(10,11,16,20), listOf(23,30,34,60)),20)}")
    println("Approach2 : ${searchElementInMatrix.approach2(listOf(listOf(1,3,5,7), listOf(10,11,16,20), listOf(23,30,34,60)),20)}")
    println("Approach3 : ${searchElementInMatrix.approach3(listOf(listOf(1,3,5,7), listOf(10,11,16,20), listOf(23,30,34,60)),20)}")

}
