package com.example.studyingmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.studyingmvvm.databinding.ActivityStandardCalcBinding

class StandardCalcActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStandardCalcBinding
    private lateinit var viewModel: StandardCalcViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Initialising viewModel
        viewModel =  ViewModelProviders.of(this@StandardCalcActivity)[StandardCalcViewModel::class.java]

        DataBindingUtil.setContentView<ActivityStandardCalcBinding>(
            this,
            R.layout.activity_standard_calc
        )
            .apply {
                binding = this
                viewModelx = this@StandardCalcActivity.viewModel
                lifecycleOwner = this@StandardCalcActivity
            }

    }
}
