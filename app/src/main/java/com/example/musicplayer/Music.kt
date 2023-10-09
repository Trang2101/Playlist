package com.example.musicplayer

import java.io.Serializable

class Music(val name: String, val author: String, val music: Int) :
    Serializable {
    companion object {
        fun getList(): List<Music> {
            val m1 = Music(
                "Bên Trái",
                "Kiên",
                R.raw.ben_trai
            )
            val m2 = Music(
                "Đôi mình",
                "Chuột sấm sét",
                R.raw.doi_minh
            )
            val m3 = Music(
                    "Em không",
                    "Vân",
                    R.raw.em_khong)
            return listOf(m1, m2, m3)
        }
    }
}




