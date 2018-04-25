package com.xpress.onboarding.api.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.xpress.onboarding.api.dao.LegalAgreementRepository;
import com.xpress.onboarding.api.domain.LegalAgreements;

@Service
public class LegalAgreementServiceImpl implements ILegalAgreementService {

	private static final Logger logger = LoggerFactory.getLogger(LegalAgreementServiceImpl.class);

	@Autowired
	LegalAgreementRepository legalAgreementDao;

	public List<LegalAgreements> getAllLegalAgreements() {
		logger.info("inside LegalAgreements Service.getAllLegalAgreements");
		return (List<LegalAgreements>) legalAgreementDao.findAll();
	}

	public Optional<LegalAgreements> getLegalAgreementsById(Integer id) {
		logger.info("Getting LegalAgreements details for ID " + id);
		return legalAgreementDao.findById(id);
	}

	public LegalAgreements addLegalAgreements(LegalAgreements legalAgreements) {
		logger.info("Adding LegalAgreements " + legalAgreements);
		return legalAgreementDao.save(legalAgreements);
	}

	public LegalAgreements updateLegalAgreements(int id, LegalAgreements legalAgreements) {
		logger.info("Updating LegalAgreements for ID " + legalAgreements);
		//legalAgreementDao.save(legalAgreements);
		LegalAgreements updatedgreements=null;
        if(id== legalAgreements.getAgreementId()) {
        	updatedgreements=legalAgreementDao.save(legalAgreements);
        }
        return updatedgreements;
	}

	public void deleteLegalAgreements(Integer id) {
		logger.info("Deleting LegalAgreements for ID " + id);
		legalAgreementDao.deleteById(id);
	}

	public void deleteAllLegalAgreements() {
		logger.info("Deleting all LegalAgreements ");
		legalAgreementDao.deleteAll();
	}
}
