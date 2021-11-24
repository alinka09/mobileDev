package com.example.firstlesson

import androidx.annotation.VisibleForTesting

object UserHolder {

    private val map = mutableMapOf<String, User>()
    private val phoneFormat = Regex("""^[+][\d]{11}""")
    private val phoneValid = Regex("""^(?:\+|\d)[\d\-\(\) ]{9,}\d""")

    fun registerUser(
        fullName: String,
        email: String,
        password: String
    ): User = User.makeUser(fullName, email = email, password = password)
        .also { user ->
            if (map.containsKey(user.login)) throw IllegalArgumentException("A user with this email already exists")
            else map[user.login] = user
        }

    fun loginUser(login: String, password: String): String? {
        val phoneLogin = cleanPhone(login)
        return if (phoneLogin.isNotEmpty()) {
            map[phoneLogin]
        } else {
            map[login.trim()]
        }?.let {
            if (it.checkPassword(password)) it.userInfo
            else null
        }
    }


    fun registerUserByPhone(fullName: String, rawPhone: String): User {
        val cleanphone = cleanPhone(rawPhone)
        if (!isNumberValid(rawPhone))
            throw IllegalArgumentException("Invalid number! ")
        if (map[cleanphone] != null)
            throw IllegalArgumentException("Current number already registered!")

        val user: User = User.makeUser(fullName, null, null, cleanphone)
        map[cleanphone] = user
        return user
    }

    private fun isNumberValid(rawPhone: String): Boolean {
        return rawPhone.matches(phoneValid)
    }

    fun requestAccessCode(login: String) {
        val phone: String = cleanPhone(login)
        map[phone]?.let {
            val code: String = it.generateAccessCode()
            it.passwordHash = it.encrypt(code)
            it.accessCode = code
            it.sendAccessCodeToUser(phone, code)
        }
    }

    @VisibleForTesting(otherwise = VisibleForTesting.NONE)
    fun clearHolder() {
        map.clear()
    }

    private fun cleanPhone(phone: String): String {
        return phone.replace("""[^+\d]""".toRegex(), "")
    }

}