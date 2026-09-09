package com.example.icetask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        val email = arguments?.getString(ARG_EMAIL) ?: "Unknown User"
        val tvUserEmail = view.findViewById<TextView>(R.id.tvUserEmail)
        val btnSignOut = view.findViewById<Button>(R.id.btnSignOut)

        tvUserEmail.text = "Signed in as: $email"

        btnSignOut.setOnClickListener {
            // Return to LoginFragment
            parentFragmentManager.popBackStack()
        }

        return view
    }

    companion object {
        private const val ARG_EMAIL = "arg_email"

        fun newInstance(email: String): WelcomeFragment {
            val fragment = WelcomeFragment()
            val args = Bundle()
            args.putString(ARG_EMAIL, email)
            fragment.arguments = args
            return fragment
        }
    }
}