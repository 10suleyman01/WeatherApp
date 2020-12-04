package ru.suleyman.data.remote.factory

import okhttp3.OkHttpClient

object OkHttpFactory {

    fun provide(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }


}
