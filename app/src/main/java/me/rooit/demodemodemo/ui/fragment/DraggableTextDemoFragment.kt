package me.rooit.demodemodemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.rooit.demodemodemo.databinding.FragmentDraggableTextDemoBinding

class DraggableTextDemoFragment: BaseFragment() {

    private lateinit var binding: FragmentDraggableTextDemoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDraggableTextDemoBinding.inflate(inflater, container, false)
        return binding.root.apply {

        }
    }


}