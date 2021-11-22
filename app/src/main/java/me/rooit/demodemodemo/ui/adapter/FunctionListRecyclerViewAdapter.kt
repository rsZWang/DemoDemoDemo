package me.rooit.demodemodemo.ui.adapter

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.parcelize.Parcelize
import me.rooit.demodemodemo.databinding.ViewHolderFunctionBinding

class FunctionListRecyclerViewAdapter : RecyclerView.Adapter<FunctionListRecyclerViewAdapter.ViewHolder>() {

    interface Delegate {
        fun onSelected(name: String)
    }

    @Parcelize
    data class Function(
        val name: String
    ): Parcelable

    val functionList = ArrayList<Function>()
    lateinit var delegate: Delegate

    override fun getItemCount(): Int = functionList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ViewHolderFunctionBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(functionList[position])
    }

    inner class ViewHolder(private val binding: ViewHolderFunctionBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(function: Function) {
            binding.nameTextView.text = function.name
            binding.root.setOnClickListener {
                delegate.onSelected(function.name)
            }
        }

    }

}