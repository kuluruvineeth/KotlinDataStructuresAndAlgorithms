package Arrays.Medium

//Input: [-1,-2,-3,4,5,6]
//Output: [-1,4,-3,5,-2,6]
class RearrangePositiveAndNegative {

    //Approach1: sort array and use two pointers
    //Time: O(NLogN) and Space: O(N)
    fun approach1(arr: IntArray): IntArray{

        var sorted = arr.sortedArray()
        var result = IntArray(arr.size)
        var i=0
        var j=arr.size-1
        for(k in 0 until arr.size){
            if(k%2==0){
                result[k] = sorted[i]
                i++
            }else{
                result[k] = sorted[j]
                j--
            }
        }
        return result
    }

    //Approach2: Segregate neg and pos elements and use odd and even concept
    //Time: O(N) and Space: O(1)

    fun approach2(arr: IntArray): IntArray{

        var i = -1
        for(j in 0 until arr.size){
            if(arr[j]<0){
                i++
                var temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }

        var k=1
        while (k < arr.size && i < arr.size){
            val temp = arr[k]
            arr[k] = arr[i+1]
            arr[i+1] = temp
            k += 2
            i++
        }
        return arr
    }
}

fun main(){

    val rearrangePositiveAndNegative = RearrangePositiveAndNegative()

    print("Approach1 : ")
    val approach1 = rearrangePositiveAndNegative.approach1(intArrayOf(-1,-2,-3,4,5,6))
    for(i in approach1){
        print("$i ")
    }
    println()
    print("Approach2 : ")
    val approach2 = rearrangePositiveAndNegative.approach2(intArrayOf(-1,-2,-3,4,5,6))
    for(i in approach2){
        print("$i ")
    }
}