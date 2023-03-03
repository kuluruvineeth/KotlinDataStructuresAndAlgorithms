package Arrays.Easy

//Input : [[0,0,1,1],[0,1,1,1],[1,1,1,1]]
//Output: 2(row number)
class RowsWithMax1s {


    //Approach1: Keeping track of counts of ones in each row
    //Time: O(N^2) and Space: O(N)
    fun approach1(nums: List<List<Int>>): List<Int>{

        var map = mutableMapOf<Int,Int>()

        for(i in nums.indices){
            var count=0
            for(num in nums[i]){
                if(num==1){
                    count++
                }
            }
            map[i] = count
        }
        var maxCount = map.values.max()
        return map.filter { it.value == maxCount }.keys.toList()
    }

    //Approach2: Traversing from right end of matrix
    //Time: O(M+N) and Space: O(1)
    fun approach2(nums: List<List<Int>>): Int{
        var j=nums[0].size-1
        var row = -1
        for(i in 0 until nums.size){
            while (j>=0 && nums[i][j]==1){
                j--
                row=i
            }
        }
        return row
    }
}

fun main(){

    val rowsWithMax1s = RowsWithMax1s()

    val approach1 = rowsWithMax1s.approach1(listOf(listOf(0,0,1,1), listOf(0,1,1,1), listOf(1,1,1,1)))
    print("Approach1 : ")
    for (i in approach1){
        print(" $i")
    }

    println()
    println("Approach2 : ${rowsWithMax1s.approach2(listOf(listOf(0,0,1,1), listOf(0,1,1,1), listOf(1,1,1,1)))}")
}