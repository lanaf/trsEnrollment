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
import org.trs.entity.enums.PartyType;
import org.trs.entity.enums.Role;
import org.trs.entity.key.BeneficiaryKey;
import org.trs.entity.key.PersonalActionKey;
import org.trs.fw.core.commons.AuditUtil;
import org.trs.trsweb.commons.TRSWEBConstants;
import org.trs.trsweb.resource.BeneficiaryDao;
import org.trs.trsweb.resource.PersonalActionDao;

/**
 * @author Lana
 * 
 */

@Repository
public class PersonalActionDaoImpl implements PersonalActionDao {

	private static final Logger logger = Logger
			.getLogger(PersonalActionDaoImpl.class);

	@PersistenceContext(unitName = "trsEntities")
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public PersonalAction find(PersonalActionKey key) {
		return em.find(PersonalAction.class, key);
	}
	
	public List<PersonalAction> getActionList(Long ptySgt) {
		Query q=em.createNamedQuery("PersonalActList");
		
		q.setParameter(1, ptySgt);
		q.setParameter(2, PartyType.PERSON);
		q.setParameter(3, Role.MEMBER);
		List<PersonalAction> personalActions=q.getResultList();
	
		if (personalActions != null && !personalActions.isEmpty()) {

			logger.debug("*******Inside PersonalActionDaoImpl.getActionList personalActions.size() is " + personalActions.size());
		  return personalActions;
		} else {
			logger.debug("Inside PersonalActionDaoImpl.getActionList personalActions is null");
		}
		return null;
		
		
	}
	
}
