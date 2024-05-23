package com.pius.kafkatutorial.member

import com.pius.kafkatutorial.BaseEntity
import jakarta.persistence.Entity


@Entity
data class MemberEntity(
    val name:String
): BaseEntity() {
}