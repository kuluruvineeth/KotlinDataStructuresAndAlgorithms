package Arrays.Easy

//Input: [1,3,5,7,9] , [0,1,2,3,4,6,8,10,12]
//Output : 0 1 2 3 4 5 6 7 8 9 10 12
class FindingUnionOfTwoSorted {

    //Approach1: Traverse both arrays and keep pushing to extra array
    //Time: O(N^2) and Space: O(N)
    fun approach1(nums1: List<Int>, nums2: List<Int>): List<Int>{

        var union = mutableListOf<Int>()

        for(i in nums1){
            if(!union.contains(i)){
                union.add(i)
            }
        }

        for(i in nums2){
            if(!union.contains(i)){
                union.add(i)
            }
        }

        return union
    }

    //Approach2: Using Two Pointers
    //Time: O(N) and Space: O(N)
    fun approach2(nums1: List<Int>, nums2: List<Int>): List<Int>{

        var union = mutableListOf<Int>()

        var i = 0
        var j = 0

        while(i < nums1.size && j < nums2.size){
            when{
                nums1[i] < nums2[j] -> {
                    union.add(nums1[i])
                    i++
                }
                nums1[i] > nums2[j] -> {
                    union.add(nums2[j])
                    j++
                }
                else -> {
                    union.add(nums1[i])
                    i++
                    j++
                }
            }
        }

        while (i < nums1.size){
            union.add(nums1[i])
            i++
        }

        while (j < nums2.size){
            union.add(nums2[j])
            j++
        }

        return union
    }


    //Approach3: Using union function
    //Time: O(N) and Space: O(1)
    fun approach3(nums1: List<Int>, nums2: List<Int>): List<Int>{

        return nums1.toSet().union(nums2.toSet()).toList()
    }

}

fun main(){

    val nums1 = listOf<Int>(1,3,5,7,9)
    val nums2 = listOf<Int>(0,1,2,3,4,6,8,10,12)

    val findingUnionOfTwoSorted = FindingUnionOfTwoSorted()

    val approach1 = findingUnionOfTwoSorted.approach1(nums1,nums2)
    print("Approach1 : ")
    for(i in approach1){
        print("$i ")
    }
    println()
    val approach2 = findingUnionOfTwoSorted.approach2(nums1,nums2)
    print("Approach2 : ")
    for(i in approach2){
        print("$i ")
    }
    println()
    val approach3 = findingUnionOfTwoSorted.approach3(nums1,nums2)
    print("Approach3 : ")
    for(i in approach3){
        print("$i ")
    }
}