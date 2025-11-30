package com.example.miro.domain.inquiry.repository;

import com.example.miro.domain.inquiry.dto.res.InquiryResDTO;
import com.example.miro.domain.inquiry.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

    /* 06-02: 내 문의 목록 조회 */
    @Query("""
        select new com.example.miro.domain.inquiry.dto.res.InquiryResDTO$InquiryInfoDTO(
            i.id,
            i.type,
            i.title,
            i.message,
            i.status,
            i.createdAt,
            i.updatedAt
        )
        from Inquiry i
        where i.user.id = :userId
        order by i.createdAt desc
    """)
    List<InquiryResDTO.InquiryInfoDTO> findMyInquiries(Long userId);


    /* 06-03: 문의 상세 조회 DTO */
    @Query("""
        select new com.example.miro.domain.inquiry.dto.res.InquiryResDTO$InquiryInfoDTO(
            i.id,
            i.type,
            i.title,
            i.message,
            i.status,
            i.createdAt,
            i.updatedAt
        )
        from Inquiry i
        where i.id = :inquiryId
          and i.user.id = :userId
    """)
    Optional<InquiryResDTO.InquiryInfoDTO> findInquiryInfo(Long inquiryId, Long userId);


    /* 06-04, 06-05: 엔티티 조회 (권한 체크 포함) */
    @Query("""
        select i
        from Inquiry i
        where i.id = :inquiryId
          and i.user.id = :userId
    """)
    Optional<Inquiry> findInquiryEntity(Long inquiryId, Long userId);
}
