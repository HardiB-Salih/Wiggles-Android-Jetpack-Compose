package com.hardib.salih.wiggles.delegate

interface OnDayNightStateChanged {
    fun onDayNightApplied(state: Int)
    companion object{
        const val DAY = 1
        const val NIGHT = 2
    }
}