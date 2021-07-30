# FlexibleRecyclerView
recyclerview  做viewpager  横滑  高度随item自适应

## 思路 
照着ViewPager2的代码，监听了recyclerview的onPageScrolled(position, positionOffset, positionOffsetPixels),得到其偏移量，动态设置recyclerview的高度。
实现这个效果还需要一个前提，需要服务器返回图片的宽高，这样才能够，固定图片的大小。
![63901f8e51f2890319caa02ccb12d27b.gif](https://i.loli.net/2021/07/30/sftdzP5b89HVGru.gif)
