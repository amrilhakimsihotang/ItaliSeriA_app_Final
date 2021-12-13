package com.amrilhs.italiaseria.core.utils

import androidx.annotation.VisibleForTesting
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject

class AppExcecutors @VisibleForTesting constructor(
    private val diskIO: Executor
) {
//    companion object {
//        private const val THREAD_COUNT = 3
//    }

    @Inject
    constructor() : this(
        Executors.newSingleThreadExecutor()
    )

    fun diskIO(): Executor = diskIO

//    private class MainThreadExecutor : Executor {
//        private val mainThreadHandler = Handler(Looper.getMainLooper())
//
//        override fun execute(command: Runnable) {
//            mainThreadHandler.post(command)
//        }
//    }
}