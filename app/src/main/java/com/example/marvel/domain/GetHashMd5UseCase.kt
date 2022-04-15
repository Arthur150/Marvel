package com.example.marvel.domain

import java.math.BigInteger
import java.security.MessageDigest

class GetHashMd5UseCase {
    operator fun invoke(strToHash: String): Result<String> {
        return try {
            val md = MessageDigest.getInstance("MD5")
            Result.success(
                (BigInteger(1, md.digest(strToHash.toByteArray())).toString(16).padStart(32, '0'))
            )
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}