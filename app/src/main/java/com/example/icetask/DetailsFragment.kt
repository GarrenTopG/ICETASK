package com.example.icetask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_details, container, false)
        val title = arguments?.getString("title")
        val description = arguments?.getString("description")

        view.findViewById<TextView>(R.id.tvDetailTitle).text = title
        view.findViewById<TextView>(R.id.tvDetailDescription).text = description

        return view
    }

    companion object {
        fun newInstance(title: String, description: String): DetailsFragment {
            val fragment = DetailsFragment()
            val args = Bundle().apply {
                putString("title", title)
                putString("description", description)
            }
            fragment.arguments = args
            return fragment
        }
    }
}