package com.berkt.cryptocurrencyapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.berkt.cryptocurrencyapp.R
import com.berkt.cryptocurrencyapp.databinding.ItemCryptoListBinding
import com.berkt.cryptocurrencyapp.model.Crypto

class CryptoAdapter(
    private val mList: List<Crypto>,
    private val context: Context
): RecyclerView.Adapter<CryptoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val binding = DataBindingUtil.inflate<ItemCryptoListBinding>(inflater, R.layout.item_crypto_list, parent, false)
        //return ViewHolder(binding)
        return ViewHolder(ItemCryptoListBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.crypto = mList[position]
    }

    override fun getItemCount() = mList.size

    inner class ViewHolder(internal val binding: ItemCryptoListBinding) : RecyclerView.ViewHolder(binding.root)

}