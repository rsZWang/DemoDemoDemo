package me.rooit.demodemodemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import me.rooit.demodemodemo.R
import me.rooit.demodemodemo.databinding.FragmentFunctionListBinding
import me.rooit.demodemodemo.ui.adapter.FunctionListRecyclerViewAdapter

class FunctionListFragment: Fragment(), FunctionListRecyclerViewAdapter.Delegate {

    companion object {
        const val DRAGGABLE_TEXT = "Draggable Text"
    }

    private lateinit var binding: FragmentFunctionListBinding

    private val functionListAdapter by lazy {
        FunctionListRecyclerViewAdapter().also {
            it.delegate = this
            it.functionList.add(FunctionListRecyclerViewAdapter.Function(DRAGGABLE_TEXT))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFunctionListBinding.inflate(inflater, container, false)
        return binding.root.apply {
            binding.recyclerView.let {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.adapter = functionListAdapter
            }
        }
    }

    override fun onSelected(name: String) {
        when (name) {
            DRAGGABLE_TEXT -> {
                findNavController().navigate(R.id.draggableTextDemoFragment)
            }
        }
    }

}