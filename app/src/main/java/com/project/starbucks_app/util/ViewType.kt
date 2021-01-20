package com.project.starbucks_app.util

import androidx.annotation.IntDef
import androidx.annotation.StringDef



interface ViewType {
    companion object{
        const val COFFEE = "coffee"
        const val FRAPUCCINO = "frapuccino"
        const val BLENDED = "blended"
    }

    @Target(AnnotationTarget.EXPRESSION, AnnotationTarget.FUNCTION)
    @Retention(AnnotationRetention.SOURCE)
    @StringDef(value = [COFFEE, FRAPUCCINO, BLENDED])
    annotation class CoffeeType
}





