package me.leep.wf.test.actions;

import me.leep.wf.actions.system.UserListAction;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.junit.Test;

import com.opensymphony.xwork2.ActionProxy;

public class AllUserListActionTest extends BaseActionTest {

	private final Logger log = Logger.getLogger(this.getClass());
	
	@Test
	public void testExecute() throws Exception {
		
		ActionMapping mapping = getActionMapping("/system/user-list");
        assertNotNull(mapping);
        assertEquals("/system", mapping.getNamespace());
        assertEquals("user-list", mapping.getName());
        
        log.info("Answer value is " + mapping.getName());
		
		
		ActionProxy proxy = getActionProxy("/system/user-list");
		
		UserListAction action =  (UserListAction) proxy.getAction() ;
		
		assertNotNull(action);
		
		String result = proxy.execute() ;
		
		assertEquals("Result of calling execute method is not success but it should be.", "success", result);
		
		
		
		
		
	}

}
