package com.arshapshap.paymentsapp.feature.payments.presentation.screen.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.arshapshap.paymentsapp.core.presentation.utils.format
import com.arshapshap.paymentsapp.feature.payments.R
import com.arshapshap.paymentsapp.feature.payments.databinding.ItemPaymentBinding
import com.arshapshap.paymentsapp.feature.payments.domain.model.Payment

internal class PaymentsAdapter(
    private val list: MutableList<Payment> = mutableListOf()
) : RecyclerView.Adapter<PaymentsAdapter.ViewHolder>() {

    fun setList(newList: List<Payment>) {
        val diffCallback = DiffCallback(list, newList)
        val diffCourses = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(newList)
        diffCourses.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(binding = getBinding(parent))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.binding.run {
        textViewTitle.text = list[position].title
        textViewAmount.text = list[position].amount?.toBigDecimal()?.toPlainString()
            ?: root.context.getString(R.string.unknown)
        textViewDate.text = list[position].created?.format()
            ?: root.context.getString(R.string.unknown)
    }

    private fun getBinding(parent: ViewGroup): ItemPaymentBinding =
        ItemPaymentBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    class ViewHolder(val binding: ItemPaymentBinding) : RecyclerView.ViewHolder(binding.root)

    private class DiffCallback(
        private val oldList: List<Payment>,
        private val newList: List<Payment>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}