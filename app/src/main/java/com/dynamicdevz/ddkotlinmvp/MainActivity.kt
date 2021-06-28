package com.dynamicdevz.ddkotlinmvp

import android.location.Location
import android.location.LocationListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.dynamicdevz.ddkotlinmvp.model.JikanResponse
import com.dynamicdevz.ddkotlinmvp.model.network.JikanRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//class MainActivity extends AppCompatActivity
class MainActivity : AppCompatActivity() {

    private var name: Int = "47".toInt()
    private var wallet = null

    //@Override
    //pulbic void onCreate(Bundle onSavedInstanceState)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if(savedInstanceState != null){
//            savedInstanceState.get("")
//        }

        JikanRetrofit.getJikan("Broly").enqueue(object: Callback<JikanResponse>{
            override fun onResponse(call: Call<JikanResponse>, response: Response<JikanResponse>) {
                response.body()?.let { resp ->
                    resp.results.forEach { jikanResult ->
                        Log.d("TAG_X", jikanResult.title)
                    }
                }?: Toast.makeText(this@MainActivity, "Results empty.", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<JikanResponse>, t: Throwable) {
                Log.d("TAG_X", "${t.localizedMessage}")
            }

        })

        savedInstanceState?.let {

        } ?: Log.d("TAG_X", "bundle is null")

        val name = savedInstanceState?.getString("Name") ?: "Unknown"
        Log.d("TAG_X", "name is ${name.uppercase()}")
        //(left) ?: (right)

        val bear = Animal(40, "Mammal")
        var lion = AnimalKT(25, "Mammal")

        bear.lifeSpan

        for(i in 0 until 10){//0->9

        }

        for(i in 1..10){//1->10

        }

    }

    /*private boolean isPalindrome(String input){
    *
    *
    *   for(int i = 0, j = input.length()-1; j > i; i++,j--){
    *       if(input.charAt(i) != input.charAt(j)){
    *       return false;
    *   }
    * }
    *
    *   return true
    * }
    *
    * */
    private fun isPalindrome(input: String) : Boolean {
        var left = 0
        var right = input.length - 1

        while(left < right){
            if(input[left] != input[right]) {
                return false
            }
            left++
            right--
        }

        return true
    }












}