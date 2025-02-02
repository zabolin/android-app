package net.ivpn.core.v2.network

/*
 IVPN Android app
 https://github.com/ivpn/android-app
 
 Created by Oleksandr Mykhailenko.
 Copyright (c) 2020 Privatus Limited.
 
 This file is part of the IVPN Android app.
 
 The IVPN Android app is free software: you can redistribute it and/or
 modify it under the terms of the GNU General Public License as published by the Free
 Software Foundation, either version 3 of the License, or (at your option) any later version.
 
 The IVPN Android app is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
 details.
 
 You should have received a copy of the GNU General Public License
 along with the IVPN Android app. If not, see <https://www.gnu.org/licenses/>.
*/

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import net.ivpn.core.IVPNApplication
import net.ivpn.core.databinding.ViewWifiItemBinding
import net.ivpn.core.v2.dialog.DialogBuilderK.openChangeNetworkStatusDialogue
import net.ivpn.core.v2.network.dialog.NetworkChangeDialogViewModel
import net.ivpn.core.vpn.model.NetworkState
import net.ivpn.core.vpn.model.WifiItem
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class NetworkRecyclerViewAdapter(context: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val WIFI_ITEM = 0
        private val LOGGER = LoggerFactory.getLogger(NetworkViewModel::class.java)
    }

    private val defaultState = NetworkState.NONE
    private var wifiItemList: List<WifiItem> = LinkedList()

    private val formatter: NetworkStateFormatter = NetworkStateFormatter(context!!)

    @Inject
    lateinit var network: NetworkViewModel

    init {
        IVPNApplication.appComponent.provideActivityComponent().create().inject(this)
    }

    override fun getItemViewType(position: Int): Int {
        return WIFI_ITEM
    }

    override fun getItemCount(): Int {
        return wifiItemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewWifiItemBinding.inflate(layoutInflater, parent, false)
        return WifiItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is WifiItemViewHolder) {
            holder.bind(wifiItemList[position])
        }
    }

    fun setWiFiList(wifiItemList: List<WifiItem>) {
        val oldList = this.wifiItemList
        this.wifiItemList = ArrayList(wifiItemList)
        notifyChanges(oldList, wifiItemList)
    }

    private fun notifyChanges(oldList: List<WifiItem>, newList: List<WifiItem>) {
        val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldList[oldItemPosition].ssid == newList[newItemPosition].ssid
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldList[oldItemPosition] == newList[newItemPosition]
            }

            override fun getOldListSize() = oldList.size
            override fun getNewListSize() = newList.size
        })
        diff.dispatchUpdatesTo(this)
    }

    inner class WifiItemViewHolder(
            private val binding: ViewWifiItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private var item: WifiItem? = null

        init {
            binding.viewmodel = network
            binding.formatter = formatter
            binding.contentLayout.setOnClickListener {
                openChangeNetworkStatusDialogue(binding.root.context,
                        object : NetworkChangeDialogViewModel(item!!.networkState.get()!!) {
                            override fun apply() {
                                network.setWifiStateAs(item!!, selectedState.get())
                                item!!.networkState.set(selectedState.get())
                            }
                        })
            }
        }

        fun bind(wifiItem: WifiItem) {
            item = wifiItem
            binding.wifi = wifiItem
        }
    }
}