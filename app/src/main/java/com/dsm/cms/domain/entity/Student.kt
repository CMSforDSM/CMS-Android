package com.dsm.cms.domain.entity

data class Student(
    val role: String,
    val studentNumber: String,
    val name: String,
    val club: String,
    val id: String
) {
    override fun toString(): String {
        return "$role, $studentNumber, $name, $club, $id"
    }
}