package Arrays.Medium

//Input: [16,17,4,3,5,2]
//Output: [17,5,2]

class LeadersInArray {

    //Approach1: Using two loops
    //Time: O(N^2) and Space: O(1)
    fun approach1(nums: IntArray){

        for(i in 0 until nums.size){
            var isLeader = true
            for(j in i+1 until nums.size){
                if(nums[i]<nums[j]){
                    isLeader = false
                    break
                }
            }
            if(isLeader){
                println(nums[i])
            }
        }
    }

    //Approach2: Traversing from right side of the array
    //Time: O(N) and Space: O(N)
    fun approach2(nums: IntArray): List<Int>{
        var leaders = mutableListOf<Int>()
        var max = nums[nums.size-1]
        leaders.add(max)
        for(i in nums.size-2 downTo 0){
            if(nums[i] > max){
                max = nums[i]
                leaders.add(nums[i])
            }
        }
        return leaders.reversed()
    }
}

fun main(){

    val leadersInArray = LeadersInArray()

    println("Approach1 : ")
    leadersInArray.approach1(intArrayOf(16,17,4,3,5,2))

    val approach2 = leadersInArray.approach2(intArrayOf(16,17,4,3,5,2))
    println()
    println("Approach2 :")
    for(i in approach2){
        print("$i ")
    }
}