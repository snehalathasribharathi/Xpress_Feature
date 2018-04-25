package com.xpress.onboarding.api.services;

import java.util.List;
import java.util.Optional;

import com.xpress.onboarding.api.domain.LegalAgreements;

public interface ILegalAgreementService {

	List<LegalAgreements> getAllLegalAgreements();

	Optional<LegalAgreements> getLegalAgreementsById(Integer id);

	LegalAgreements addLegalAgreements(LegalAgreements legalAgreements);

	LegalAgreements updateLegalAgreements(int id, LegalAgreements legalAgreements);

	void deleteLegalAgreements(Integer id);

	void deleteAllLegalAgreements();
}
