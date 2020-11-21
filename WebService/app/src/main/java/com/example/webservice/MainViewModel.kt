package com.example.webservice

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.webservice.Model.Aluno
import com.example.webservice.Model.Produto
import com.example.webservice.Services.Repository
import com.example.webservice.Services.repositorio
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(repository: Repository) : ViewModel() {
    var aluno = MutableLiveData<Aluno>()
    val listAluno = MutableLiveData<MutableList<Aluno>>()
    val listaProdutos = MutableLiveData<MutableList<Produto>>()


    fun getSortAluno() {
        try {
            viewModelScope.launch {
                aluno.value = repositorio.getSortAluno()
            }

        } catch (e: Exception) {
            Log.e("MainViewModel", "Erro:  ${e.toString()}")
        }
    }

    fun getAllAluno() {
        try {
            viewModelScope.launch {
                listAluno.value = repositorio.getAlunos()
            }
        } catch (e: Exception) {
            Log.e("MainViewModel", "Erro:  ${e.toString()}")
        }
    }


    fun getAllProdutos() {
        try {
            viewModelScope.launch {
                listaProdutos.value = repositorio.getProduto().listaProdutos
            }
        } catch (e: Exception) {
            Log.e("MainViewModel", "Erro:  ${e.toString()}")
        }
    }
}
