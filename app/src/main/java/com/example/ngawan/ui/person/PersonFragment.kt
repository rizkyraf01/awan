package com.example.ngawan.ui.person

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.ngawan.databinding.FragmentPersonBinding
import com.example.ngawan.ui.logreg.LoginActivity
import com.example.ngawan.ui.notifications.NotificationsViewModel


class PersonFragment : Fragment() {
    private var _binding: FragmentPersonBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentPersonBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btLogOut.setOnClickListener {
            val intent = Intent(this@PersonFragment.context, LoginActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}