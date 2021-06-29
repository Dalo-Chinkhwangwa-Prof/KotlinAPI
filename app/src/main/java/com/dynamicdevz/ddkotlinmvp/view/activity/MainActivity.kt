package com.dynamicdevz.ddkotlinmvp.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dynamicdevz.ddkotlinmvp.R
import com.dynamicdevz.ddkotlinmvp.databinding.ActivityMainBinding
import com.dynamicdevz.ddkotlinmvp.model.Result
import com.dynamicdevz.ddkotlinmvp.presenter.JikanPresenter
import com.dynamicdevz.ddkotlinmvp.presenter.PresenterContract
import com.dynamicdevz.ddkotlinmvp.util.State
import com.dynamicdevz.ddkotlinmvp.view.adapter.KJikanAdapter
import com.dynamicdevz.ddkotlinmvp.view.fragment.ImageFragment
import com.google.android.material.snackbar.Snackbar

//class MainActivity extends AppCompatActivity
class MainActivity : AppCompatActivity(), PresenterContract.View, KJikanAdapter.JikanDelegate {

    private lateinit var binding: ActivityMainBinding
    private val adapter = KJikanAdapter(this)
    private val presenter = JikanPresenter(this)

    private val fragment:  ImageFragment = ImageFragment()

    //@Override
    //pulbic void onCreate(Bundle onSavedInstanceState)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.jikanRecyclerview.adapter = adapter

        binding.searchButton.setOnClickListener{
            val query = binding.searchEdittext.text.toString().trim()
            binding.searchEdittext.text.clear()
            presenter.searchAnime(query)
        }
    }

    override fun displayResults(jikans: List<Result>) {
        adapter.jikans = jikans
    }

    override fun updateState(state: State) {
        when(state){
            State.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            State.ERROR -> {
                binding.progressBar.visibility = View.GONE
            }
            else -> {
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    override fun showError(message: String) {
        Snackbar.make(binding.root, "Error occurred: $message", Snackbar.LENGTH_LONG).show()
    }

    override fun selectImage(url: String) {
        val bundle = Bundle()
        bundle.putString("KEY", url)
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frame, fragment)
            .addToBackStack(fragment.tag)
            .commit()

    }


}