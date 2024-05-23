package com.pius.kafkatutorial.member

import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<MemberEntity, Long> {
}