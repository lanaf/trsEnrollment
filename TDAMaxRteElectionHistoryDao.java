package org.trs.trsweb.resource;



import java.util.List;

import org.trs.entity.PersonalAction;
import org.trs.entity.TDAMaxRateElecHistory;
import org.trs.entity.key.PersonalActionKey;
import org.trs.entity.key.TDAMaxRateElecHistoryKey;


/**
 * @author Lana
 * Added to Git
 * 
 */
public interface TDAMaxRteElectionHistoryDao {

	public TDAMaxRateElecHistory find(TDAMaxRateElecHistoryKey key);
	
	public List<TDAMaxRateElecHistory> getMaxRateHistory(Long ptySgt);
	
}
