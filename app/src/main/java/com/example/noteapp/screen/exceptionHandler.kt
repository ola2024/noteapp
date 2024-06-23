package com.example.noteapp.screen

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import kotlin.coroutines.CoroutineContext

object exceptionHandler : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        TODO("Not yet implemented")
    }

}
