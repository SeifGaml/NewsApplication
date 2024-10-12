package com.example.newsapplication.domain.usecases.app_entry

import com.example.newsapplication.domain.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadAppEntry @Inject constructor(
    private val localUserManger: LocalUserManger
) {
    operator fun invoke(): Flow<Boolean>{
        return localUserManger.readAppEntry()
    }
}