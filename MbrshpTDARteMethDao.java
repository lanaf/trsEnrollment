package org.trs.trsweb.resource;



import java.util.List;

import org.trs.entity.MembershipTDARateMethod;
import org.trs.entity.PersonalAction;
import org.trs.entity.TDAMaxRateElecHistory;
import org.trs.entity.key.MembershipTDARateKey;
import org.trs.entity.key.PersonalActionKey;
import org.trs.entity.key.TDAMaxRateElecHistoryKey;


/**
 * @author Lana
 * 
 */
public interface MbrshpTDARteMethDao {

	public MembershipTDARateMethod find(MembershipTDARateKey key);
	
	public List<MembershipTDARateMethod> getTDARateMethod(Long ptySgt);
	
}
