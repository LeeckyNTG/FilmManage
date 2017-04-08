package com.gz.lk.core;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import com.gz.lk.Action.openAdminMenu;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.actions.ActionFactory;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	openAdminMenu action1;
	private IAction closeAction;
	private IAction helpSearchAction;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(IWorkbenchWindow window) {
		action1=new openAdminMenu(window);
		action1.setText("«–ªª”√ªß");
		{
			closeAction = ActionFactory.CLOSE.create(window);
			register(closeAction);
		}
		{
			helpSearchAction = ActionFactory.HELP_SEARCH.create(window);
			register(helpSearchAction);
		}
	}

	protected void fillMenuBar(IMenuManager menuBar) {
	}
	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
		IToolBarManager tb=new ToolBarManager();
		tb.add(action1);
		coolBar.add(tb);
	}

}
