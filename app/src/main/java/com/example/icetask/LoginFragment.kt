package com.example.icetask

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val tilEmail = view.findViewById<TextInputLayout>(R.id.tilEmail)
        val etEmail = view.findViewById<TextInputEditText>(R.id.etEmail)
        val btnSso = view.findViewById<Button>(R.id.btnSso)
        val btnGoogle = view.findViewById<Button>(R.id.btnGoogle)
        val btnMicrosoft = view.findViewById<Button>(R.id.btnMicrosoft)

        btnSso.setOnClickListener {
            val email = etEmail.text.toString().trim()
            tilEmail.error = null

            if (email.isEmpty()) {
                tilEmail.error = "Email address cannot be empty"
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tilEmail.error = "A valid email address is required (e.g. user@domain.com)"
            } else {
                // Navigate to WelcomeFragment with arguments
                val welcomeFragment = WelcomeFragment.newInstance(email)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, welcomeFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }

        btnGoogle.setOnClickListener {
            Toast.makeText(requireContext(), "Google SSO selected", Toast.LENGTH_SHORT).show()
        }

        btnMicrosoft.setOnClickListener {
            Toast.makeText(requireContext(), "Microsoft SSO selected", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}