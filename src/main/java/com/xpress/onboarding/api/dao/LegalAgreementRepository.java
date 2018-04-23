package com.xpress.onboarding.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xpress.onboarding.api.domain.LegalAgreements;

@Repository
public interface LegalAgreementRepository extends JpaRepository<LegalAgreements, Integer>{

}
