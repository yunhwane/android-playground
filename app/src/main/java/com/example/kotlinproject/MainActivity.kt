package com.example.kotlinproject



import com.example.kotlinproject.databinding.ActivityMainBinding

import android.os.Bundle
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {

    // 뷰 바인딩을 위한 변수 선언
    private lateinit var binding: ActivityMainBinding

    // 앱이 최초 실행되었을 때 수행되는 역할
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰 바인딩 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 이제 binding 객체를 사용하여 뷰에 접근할 수 있습니다
        binding.tvTitle.text = "하이요!"
    }
}