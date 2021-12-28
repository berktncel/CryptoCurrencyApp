package com.berkt.cryptocurrencyapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.berkt.cryptocurrencyapp.databinding.ItemCryptoListBinding
import com.berkt.cryptocurrencyapp.model.CryptoData

class CryptoAdapter(
    private val mList: List<CryptoData>,
    private val context: Context
): RecyclerView.Adapter<CryptoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCryptoListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount() = mList.size

    inner class ViewHolder(private val binding: ItemCryptoListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: CryptoData) {
            binding.tvCurrency.text = data.currency
            binding.tvPrice.text = data.price

            binding.cardView.setOnClickListener {
                Toast.makeText(context,"Clicked: ${data.currency}", Toast.LENGTH_LONG).show()
            }
        }

    }

}