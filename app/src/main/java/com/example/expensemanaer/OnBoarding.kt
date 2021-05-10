package com.example.expensemanaer

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_on_boarding.*


class OnBoarding : Fragment() {

    lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        sharedPreferences =
                this.requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)
        continu.setOnClickListener {
            findNavController().navigate(OnBoardingDirections.actionOnBoardingToUpcomingFragment())
            val name = Name.editText?.text.toString()
            val budget = user_month_budget.editText?.text.toString()
            val income = monthlyincome.editText?.text.toString()
            saveCredentials(name, budget, income)


            
        }

    }

    private fun saveCredentials(name: String, budget: String, income: String) {
        sharedPreferences.edit().putString("Name", name).apply()
        sharedPreferences.edit().putString("Budget", budget).apply()
        sharedPreferences.edit().putString("Income", income).apply()
    }
}