package com.example.ngawan.ui.detect

import androidx.lifecycle.ViewModel
import com.example.ngawan.ui.utils.dataDummy
import com.example.ngawan.ui.utils.cloudsEntity

class DetailViewModel : ViewModel() {
    private lateinit var cloudsId: String

    fun setSelectedCloud(cloudsId: String){
        this.cloudsId = cloudsId
    }

    fun getCloud(): cloudsEntity? {
        var cloud: cloudsEntity? =null
        val cloudsEntity = dataDummy.generateDummyClouds()
        for (cloudsEntity in cloudsEntity) {
            if (cloudsEntity.name == cloudsId) {
                cloud = cloudsEntity
            }
//            else {
//                val intent = Intent(Intent.ACTION_WEB_SEARCH)
//                intent.putExtra(SearchManager.QUERY, cloudsIdcloudsId)
//                startActivity(intent)
//            }
        }
        return cloud

    }

}