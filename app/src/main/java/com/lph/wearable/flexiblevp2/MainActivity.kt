package com.lph.wearable.flexiblevp2

import android.os.Bundle
import android.util.Log
import android.util.SparseIntArray
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.lph.wearable.flexiblevp2.adapter.RVAdapter

class MainActivity : AppCompatActivity() {
    val images = listOf<String>(
        "https://img.haohaozhu.cn/App-imageShow/o_phone/7c1/e75cc20ti1880Ao00qn2h9tarr2?w=1080&h=1618.9830508475&iv=1",
        "https://img.haohaozhu.cn/App-imageShow/o_phone/c47/56d10217g0t10H400qn2h9sarr2?w=1080&h=721.61125319693&iv=1",
        "https://img.haohaozhu.cn/App-imageShow/o_phone/b19/8b387218w0u00WS00qn2h9warr2?w=1080&h=721.78217821782&iv=1",
    )

    val ratio = intArrayOf()
    var mViewHeightList : FloatArray?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var isFirstTime = true


        val screenWidth = windowManager.defaultDisplay.width
        Log.e("screenWidth","screenWidth:$screenWidth")
        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val tvPage = findViewById<TextView>(R.id.tvPage)
        val linearLayoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false);
        val mAdapter = RVAdapter(images,this)
        recyclerView.apply {

            layoutManager =linearLayoutManager
            adapter = mAdapter

            PagerSnapHelper().attachToRecyclerView(this)
        }
        val scrollEventAdapter1 = ScrollEventAdapter1(recyclerView)
        mAdapter.setHeightChangeListener(object: RVAdapter.HeightMapChangeListener{
            override fun setMapChangeListener(heightsMap: FloatArray) {
                mViewHeightList = heightsMap
//                if (isFirstTime){
//                    recyclerView.scrollTo(1,0)
//                    isFirstTime = false
//                }
            }

        })
        scrollEventAdapter1.setOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tvPage.text = "${position+1}/12"
            }
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                if (positionOffset==0.toFloat()&&positionOffsetPixels==0)     return
                Log.e("onPageScrolled","position:$position,positionOffset:$positionOffset,positionOffsetPixels:$positionOffsetPixels")
                mViewHeightList?.apply {
                    val finalHeight = (mViewHeightList!![position].toFloat()) * (1 - positionOffset) + (mViewHeightList!![position + 1].toFloat()) * positionOffset
                    //为ViewPager设置高度
                    recyclerView.layoutParams = recyclerView.layoutParams.apply {
                        height = finalHeight.toInt()
                        width = 1176  //宽度也得固定
                    }
                }

            }


        })
        recyclerView.addOnScrollListener(scrollEventAdapter1)
    }


}