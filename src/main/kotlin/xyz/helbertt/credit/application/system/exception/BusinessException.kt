package xyz.helbertt.credit.application.system.exception

data class BusinessException(override val message: String?) : RuntimeException(message)