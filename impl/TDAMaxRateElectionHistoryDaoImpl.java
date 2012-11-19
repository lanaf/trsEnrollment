package org.trs.trsweb.resource.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.trs.entity.Beneficiary;
import org.trs.entity.PartyEmail;
import org.trs.entity.PersonalAction;
import org.trs.entity.TDAMaxRateElecHistory;
import org.trs.entity.enums.PartyType;
import org.trs.entity.enums.Role;
import org.trs.entity.key.BeneficiaryKey;
import org.trs.entity.key.PersonalActionKey;
import org.trs.entity.key.TDAMaxRateElecHistoryKey;
import org.trs.fw.core.commons.AuditUtil;
import org.trs.trsweb.commons.TRSWEBConstants;
import org.trs.trsweb.resource.BeneficiaryDao;
import org.trs.trsweb.resource.PersonalActionDao;
import org.trs.trsweb.resource.TDAMaxRteElectionHistoryDao;

/**
 * @author Lana
 * 
 */

@Repository
public class TDAMaxRateElectionHistoryDaoImpl implements TDAMaxRteElectionHistoryDao {

	private static final Logger logger = Logger
			.getLogger(PersonalActionDaoImpl.class);

	@PersistenceContext(unitName = "trsEntities")
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public TDAMaxRateElecHistory find(TDAMaxRateElecHistoryKey key) {
		return em.find(TDAMaxRateElecHistory.class, key);
	}
	
	@SuppressWarnings("unchecked")
	public List<TDAMaxRateElecHistory> getMaxRateHistory(Long ptySgt) {
		Query q=em.createNamedQuery("RteHistoryList");
		
		q.setParameter(1, ptySgt);
		q.setParameter("partyType", PartyType.PERSON.getValue());
		q.setParameter("role", Role.MEMBER.getValue());
		
		List<TDAMaxRateElecHistory> rteHistoryList=q.getResultList();
		
		if (rteHistoryList != null && !rteHistoryList.isEmpty()) {
			logger.debug("TDAMaxRteElectionHistoryDao.getMaxRateHistory List rteHistoryList is:" + rteHistoryList.size());
		  return rteHistoryList;
		} else {
			logger.debug("TDAMaxRteElectionHistoryDao.getMaxRateHistory List  rteHistoryList is null");
		}
		return null;
		
		
	}

	
}
