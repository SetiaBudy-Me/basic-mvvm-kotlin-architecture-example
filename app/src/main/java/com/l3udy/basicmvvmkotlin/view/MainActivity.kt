package com.l3udy.basicmvvmkotlin.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.l3udy.basicmvvmkotlin.databinding.ActivityMainBinding
import com.l3udy.basicmvvmkotlin.viewmodel.MainViewModel

/*
 *  MainActivity:
 *  - Shows the UI
 *  - Listens to viewModel for updates on UI
 */
class MainActivity : AppCompatActivity() {
    private val tag = this::class.java.simpleName

    // View Binding
    private lateinit var binding: ActivityMainBinding

    // Create a viewModel
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setupClickListeners()
        setupObserver()
    }

    // Setup the button in our activity
    private fun setupClickListeners() {
        binding.btnCount.setOnClickListener {
            try {
                // Initialize the number to be calculated
                val number1 = binding.etNumber1.text.toString().toInt()
                val number2 = binding.etNumber2.text.toString().toInt()

                // Calling a function inside the presenter
                viewModel.count(number1, number2)
            } catch (e: Exception) {
                Log.e(tag, "Error Exception -> ${e.localizedMessage}")
                Toast.makeText(this, "Oops something wrong..!!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Observer is waiting for viewModel to update our UI
    private fun setupObserver() {
        viewModel.resultCount.observe(this) { data ->
            binding.tvResult.text = data.result.toString()
        }
    }
}