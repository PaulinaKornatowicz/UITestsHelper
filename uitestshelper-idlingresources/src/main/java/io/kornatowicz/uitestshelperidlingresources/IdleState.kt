package io.kornatowicz.uitestshelperidlingresources

import java.io.Serializable

class Busy(val message: String): IdleState

class Idle(val message: String): IdleState

interface IdleState: Serializable