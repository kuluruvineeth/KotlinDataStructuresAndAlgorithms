package Arrays.Easy


//Input : [1,2,3,4,4], n=5
//Output: 5 4
class FindingMissingAndRepeating {

    //Approach1: Using extra boolean array
    //Time: O(N) and Space: O(N)
    fun approach1(nums: IntArray): Pair<Int,Int>{

        var extraArray = BooleanArray(nums.size)
        var missing = 0
        var repeating = 0

        for(i in nums){
            if(extraArray[i-1]){
                repeating = i
            }else{
                extraArray[i-1] = true
            }
        }

        for(i in extraArray.indices){
            if(!extraArray[i]){
                missing = i + 1
            }
        }

        return Pair(missing,repeating)
    }

    //Approach2: Using Hash set
    //Time: O(N) and Space: O(N)
    fun approach2(nums: IntArray): Pair<Int,Int>{

        var set = HashSet<Int>()
        var missing = 0
        var repeating = 0

        for(i in nums){
            if(set.contains(i)){
                repeating = i
            }else{
                set.add(i)
            }
        }

        for(i in 1..nums.size){
            if(!set.contains(i)){
                missing = i
            }
        }

        return Pair(missing,repeating)
    }

    //Approach3: Using Two Equations
    //Time: O(N) and Space: O(1)
    fun approach3(nums: IntArray): List<Int>{

        var missing = 0
        var repeating = 0
        var len = nums.size
        var sumN = (len * (len + 1))/2
        var sqSum = (len * (len + 1) * (2*len + 1))/6

        for(i in nums.indices){
            sumN -= nums[i]
            sqSum -= nums[i] * nums[i]
        }

        missing = (sumN + sqSum/sumN) / 2
        repeating = missing - sumN
        return listOf(missing,repeating)

    }

}

fun main(){

    val nums = intArrayOf(1,2,3,4,4)

    val findingMissingAndRepeating = FindingMissingAndRepeating()

    println("Missing and Repeating using approach1 : ${findingMissingAndRepeating.approach1(nums)}")
    println("Missing and Repeating using approach2 : ${findingMissingAndRepeating.approach2(nums)}")
    println("Missing and Repeating using approach3 : ${findingMissingAndRepeating.approach3(nums)}")



}





