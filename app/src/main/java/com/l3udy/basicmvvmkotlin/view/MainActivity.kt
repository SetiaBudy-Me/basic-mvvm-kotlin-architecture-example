package com.l3udy.basicmvvmkotlin.view

import android.os.Bundle
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

    // Setup the button in our activity to call getUpdatedText method in viewModel
    private fun setupClickListeners() {
        binding.btnUpdateText.setOnClickListener { viewModel.getUpdatedText() }
    }

    // Observer is waiting for viewModel to update our UI
    private fun setupObserver() {
        viewModel.uiTextLiveData.observe(this) { updatedText ->
            binding.textView.text = updatedText
        }
    }
}