package com.gz.lk.core;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IViewLayout;

import com.gz.lk.view.Adminview;
import com.gz.lk.view.employeeView;
import com.gz.lk.view.welcom;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		
		
		
		if(Application.bol==1){
			layout.addView(Adminview.ID, layout.LEFT, 0.18f, layout.getEditorArea());
			layout.addView(welcom.ID, layout.RIGHT, 0.82f, layout.getEditorArea());
			IViewLayout viewLayout = layout.getViewLayout(Adminview.ID);
			viewLayout.setCloseable(false);
			viewLayout.setMoveable(false);
			
			IViewLayout viewLayout1 = layout.getViewLayout(welcom.ID);
			viewLayout1.setCloseable(false);
			viewLayout1.setMoveable(false);

		}else {
			layout.addView(employeeView.ID, layout.LEFT, 0.01f, layout.getEditorArea());
			layout.addView(welcom.ID, layout.RIGHT, 0.99f, layout.getEditorArea());
			IViewLayout viewLayout = layout.getViewLayout(employeeView.ID);
			viewLayout.setCloseable(false);
			viewLayout.setMoveable(false);
			
			IViewLayout viewLayout1 = layout.getViewLayout(welcom.ID);
			viewLayout1.setCloseable(false);
			viewLayout1.setMoveable(false);

		}
		layout.setEditorAreaVisible(false);
	}
}
