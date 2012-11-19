package org.trs.trsweb.resource;



import java.util.List;

import org.trs.entity.PersonalAction;
import org.trs.entity.key.PersonalActionKey;


/**
 * @author Lana
 * 
 */
public interface PersonalActionDao {

	public PersonalAction find(PersonalActionKey key);
	
	public List<PersonalAction> getActionList(Long ptySgt);
	
}
