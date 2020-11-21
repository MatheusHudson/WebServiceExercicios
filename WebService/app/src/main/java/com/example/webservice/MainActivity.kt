package com.example.webservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.webservice.Services.repositorio

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>() {
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repositorio) as T
            }

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewModel.getSortAluno()
        viewModel.getAllProdutos()

        viewModel.listaProdutos.observe(this) {
            it.forEach {
                Log.i("MainActivity", it.toString())
            }
        }


/*
        viewModel.aluno.observe(this) {
            Log.i("MainActivity", it.toString())

        }
*/
    }
}