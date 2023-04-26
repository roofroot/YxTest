package com.test.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember

/**
 * coco man
 * 2023/4/26
 **/

import androidx.lifecycle.MutableLiveData

enum class PageName{
    FIRSTPAGE,SECONDPAGE
}

class NaviData() {
    val isv = MutableLiveData(false);
    fun onStateChange(visibility: Boolean) {
        isv.value = visibility;
    }

}

class Navigation  {
    companion object {
        val FIRSTPAGE = "FIRSTPAGE"
        val SECONDPAGE = "SECONDPAGE"
    }

    val currentPage = MutableLiveData<PageName>()
    val map: HashMap<String, NaviData> = HashMap();

    init {
        var navi = NaviData();
        map.put(FIRSTPAGE, navi)
        navi = NaviData()
        map.put(SECONDPAGE, navi)
    }

    fun onStateChange(name: String, visibility: Boolean) {
        map.get(name)?.onStateChange(visibility)
    }
    fun refreshState(key:String)
    {
        var bool=map.get(key)?.isv?.value;
        bool?.let {
            map.get(key)?.isv?.value=!bool
        }
    }
    fun changeCurrentPage(page: PageName){
        currentPage.value=page;
    }
    fun onStateChange(mapdatas: Map<String, Boolean>) {
        for (m in mapdatas) {
            map.get(m.key)?.onStateChange(m.value)
        }
    }

}