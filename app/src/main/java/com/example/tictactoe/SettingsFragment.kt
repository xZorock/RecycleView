package com.example.tictactoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tictactoe.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var optionsArrayList: ArrayList<Options>
    private lateinit var adapter: OptionsAdapter
    private lateinit var btnImageID: Array<Int>

    private var _binding: FragmentSettingsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialized()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.RvSettings)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = OptionsAdapter(optionsArrayList)
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun dataInitialized() {

        optionsArrayList = arrayListOf()
        btnImageID = arrayOf(
            R.drawable.blue_button,
            R.drawable.blue_button,
            R.drawable.blue_button,
            R.drawable.blue_button,
            R.drawable.blue_button,
            R.drawable.blue_button,
            R.drawable.blue_button
        )
        val optionTitles =
            arrayOf("Audio", "Video", "Brightness", "Contrast", "Color", "Language", "Difficulty")
        val backgroundID = arrayOf(
            R.drawable.blue_button,
            R.drawable.blue_button,
            R.drawable.blue_button,
            R.drawable.blue_button,
            R.drawable.blue_button,
            R.drawable.blue_button,
            R.drawable.blue_button
        )
        for (i in btnImageID.indices) {
            val item = Options(btnImageID[i], optionTitles[i], backgroundID[i])
            optionsArrayList.add(item)
        }
    }
}