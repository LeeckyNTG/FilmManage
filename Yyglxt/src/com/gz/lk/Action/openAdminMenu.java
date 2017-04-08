package com.gz.lk.Action;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;


import com.gz.lk.core.Application;
import com.gz.lk.shell.Login;
import com.gz.lk.view.Adminview;
import com.gz.lk.view.employeeView;
import com.gz.lk.view.welcom;

public class openAdminMenu extends Action {
	IWorkbenchWindow window;
	public openAdminMenu(IWorkbenchWindow window) {
		// TODO Auto-generated constructor stub
		this.window=window;
	}
	public void run() {				
			PlatformUI.getWorkbench().restart();	
	}

}
