package com.example.myapplication

import android.util.Log

typealias PersonsListener = (person: Person?) -> Unit

object PersonHolder {
    var persons = mutableListOf<Person>()
    private var listeners = mutableSetOf<PersonsListener>()

    init {
        persons.add(Person(
            name = "Анджелина Джоли",
            sex = "с Бредом Питтом",
            date = "7777-н.в.",
            info = "Анджели́на Джоли́ — американская актриса кино, " +
                    "телевидения и озвучивания, кинорежиссёр, сценаристка, продюсер, " +
                    "фотомодель, посол доброй воли ООН. ",
            image = R.drawable.angel
        ))
        persons.add(Person(
            name = "Бред Питт",
            sex = "с Анджелиной Джоли",
            date = "1234-н.в.",
            info = "Уи́льям Брэ́дли Питт — американский актёр и кинопродюсер. Лауреат двух премий «Золотой глобус»",
            image = R.drawable.bred
        ))
        persons.add(Person(
            name = "Анджелина Джоли",
            sex = "с Бредом Питтом",
            date = "7777-н.в.",
            info = "Анджели́на Джоли́ — американская актриса кино, " +
                    "телевидения и озвучивания, кинорежиссёр, сценаристка, продюсер, " +
                    "фотомодель, посол доброй воли ООН. ",
            image = R.drawable.angel
        ))
        persons.add(Person(
            name = "Бред Питт",
            sex = "с Анджелиной Джоли",
            date = "1234-н.в.",
            info = "Уи́льям Брэ́дли Питт — американский актёр и кинопродюсер. Лауреат двух премий «Золотой глобус»",
            image = R.drawable.bred
        ))
        persons.add(Person(
            name = "Анджелина Джоли",
            sex = "с Бредом Питтом",
            date = "7777-н.в.",
            info = "Анджели́на Джоли́ — американская актриса кино, " +
                    "телевидения и озвучивания, кинорежиссёр, сценаристка, продюсер, " +
                    "фотомодель, посол доброй воли ООН. ",
            image = R.drawable.angel
        ))
        persons.add(Person(
            name = "Бред Питт",
            sex = "с Анджелиной Джоли",
            date = "1234-н.в.",
            info = "Уи́льям Брэ́дли Питт — американский актёр и кинопродюсер. Лауреат двух премий «Золотой глобус»",
            image = R.drawable.bred
        ))
        persons.add(Person(
            name = "Анджелина Джоли",
            sex = "с Бредом Питтом",
            date = "7777-н.в.",
            info = "Анджели́на Джоли́ — американская актриса кино, " +
                    "телевидения и озвучивания, кинорежиссёр, сценаристка, продюсер, " +
                    "фотомодель, посол доброй воли ООН. ",
            image = R.drawable.angel
        ))
        persons.add(Person(
            name = "Бред Питт",
            sex = "с Анджелиной Джоли",
            date = "1234-н.в.",
            info = "Уи́льям Брэ́дли Питт — американский актёр и кинопродюсер. Лауреат двух премий «Золотой глобус»",
            image = R.drawable.bred
        ))
    }

    fun addListener(listener: PersonsListener) {
        listeners.add(listener)
    }

    fun sendMessage() {
        for (listener in listeners)
            listener.invoke(persons.firstOrNull())
        if (persons.count() > 0)
            persons.removeAt(0)
    }

    fun removeListener(listener: PersonsListener) {
        listeners.remove(listener)
    }
}