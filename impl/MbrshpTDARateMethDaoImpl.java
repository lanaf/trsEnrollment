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
import org.trs.entity.MembershipTDARateMethod;
import org.trs.entity.PartyEmail;
import org.trs.entity.PersonalAction;
import org.trs.entity.TDAMaxRateElecHistory;
import org.trs.entity.enums.PartyType;
import org.trs.entity.enums.Role;
import org.trs.entity.key.BeneficiaryKey;
import org.trs.entity.key.MembershipTDARateKey;
import org.trs.entity.key.PersonalActionKey;
import org.trs.entity.key.TDAMaxRateElecHistoryKey;
import org.trs.fw.core.commons.AuditUtil;
import org.trs.trsweb.commons.TRSWEBConstants;
import org.trs.trsweb.resource.BeneficiaryDao;
import org.trs.trsweb.resource.MbrshpTDARteMethDao;
import org.trs.trsweb.resource.PersonalActionDao;
import org.trs.trsweb.resource.TDAMaxRteElectionHistoryDao;

/**
 * @author Lana
 * 
 */

@Repository
public class MbrshpTDARateMethDaoImpl implements MbrshpTDARteMethDao {

	private static final Logger logger = Logger
			.getLogger(MbrshpTDARateMethDaoImpl.class);

	@PersistenceContext(unitName = "trsEntities")
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public MembershipTDARateMethod find(MembershipTDARateKey key) {
		return em.find(MembershipTDARateMethod.class, key);
	}
	
	@SuppressWarnings("unchecked")
	public List<MembershipTDARateMethod> getTDARateMethod(Long ptySgt) {
		Query q=em.createNamedQuery("RteHistoryList");
		q.setParameter(1, ptySgt);
		q.setParameter("partyType", PartyType.PERSON.getValue());
		q.setParameter("role", Role.MEMBER.getValue());

		List<MembershipTDARateMethod> mbrshpRteHst=q.getResultList();
		
		if (mbrshpRteHst != null && !mbrshpRteHst.isEmpty()) {
			logger.debug("getTDARateMethod List from mbrshpRteHst is:" + mbrshpRteHst.size());
		  return mbrshpRteHst;
		} else {
			logger.debug("getTDARateMethod List from mbrshpRteHst is null");
		}
		return null;
		
		
	}

	

	
}
