package com.example.ngawan.ui.notifications

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngawan.R
import com.example.ngawan.ui.notifications.NotificationsAdapter.Data
import com.example.ngawan.databinding.FragmentNotificationsBinding


class NotificationsFragment : Fragment() {

    private val list = ArrayList<Data>()
    private lateinit var adapter: NotificationsAdapter
    private lateinit var notificationsViewModel: NotificationsViewModel

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentNotificationsBinding.bind(view)
        adapter = NotificationsAdapter(list)

        notificationsViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(NotificationsViewModel::class.java)

        binding.tvHelp.text = resources.getString(R.string.how_to_use)
        binding.rvNotification.layoutManager = LinearLayoutManager(activity)
        adapter.notifyDataSetChanged()
        binding.rvNotification.adapter = adapter

        adapter.setData(listSets)

    }

    private val listSets: ArrayList<Data>
        @SuppressLint("Recycle")
        get() {
            val dataHeadline = resources.getStringArray(R.array.first_look)
            val dataCaption = resources.getStringArray(R.array.fast_caption)
            val dataDescription = resources.getStringArray(R.array.detail_look_here)
            val dataPhoto = resources.obtainTypedArray(R.array.data_image)
            val listSet = ArrayList<Data>()
            for (i in dataHeadline.indices) {
                val data = Data(dataHeadline[i], dataCaption[i], dataDescription[i],dataPhoto.getResourceId(i, -1))
                listSet.add(data)
            }
            return listSet
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}