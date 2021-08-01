package io.kornatowicz.uitestshelperdemo

import io.kornatowicz.uitestshelperidlingresources.IdleStateReceiver

class AppIdleStateReceiver: IdleStateReceiver {

    fun onBusyOperationStarted() {
        onAppIsBusy("busy operation started")
    }

    fun onBusyOperationEnded() {
        onAppIsIdle("busy operation ended")
    }
}