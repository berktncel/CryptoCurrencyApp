package com.berkt.cryptocurrencyapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.berkt.cryptocurrencyapp.adapter.CryptoAdapter
import com.berkt.cryptocurrencyapp.databinding.ActivityMainBinding
import com.berkt.cryptocurrencyapp.model.CryptoData
import com.berkt.cryptocurrencyapp.viewmodel.CryptoViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var cryptoViewModel: CryptoViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        loadData()
    }

    override fun onDestroy() {
        super.onDestroy()
        cryptoViewModel.clearComposite()
    }

    private fun loadData() {
        cryptoViewModel = ViewModelProvider(this).get(CryptoViewModel::class.java)
        cryptoViewModel.getApiData()
        cryptoViewModel.cryptoDataList.observe(this, {
            initAdapter(it)
        })
    }

    private fun initAdapter(data: List<CryptoData>?) {
        binding.rvCryptoList.layoutManager = LinearLayoutManager(this)
        val adapter = data?.let { CryptoAdapter(it, applicationContext) }
        binding.rvCryptoList.adapter = adapter
    }
}