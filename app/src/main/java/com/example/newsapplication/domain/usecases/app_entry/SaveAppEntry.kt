package com.example.newsapplication.domain.usecases.app_entry

import com.example.newsapplication.domain.manger.LocalUserManger
import javax.inject.Inject

class SaveAppEntry @Inject constructor(
    private val localUserManger :LocalUserManger
) {
    suspend operator fun invoke (){
        localUserManger.saveAppEntry()
    }
}