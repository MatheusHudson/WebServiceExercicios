package com.example.webservice.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Msg(@SerializedName("produtos") @Expose var listaProdutos: MutableList<Produto>)  {
}