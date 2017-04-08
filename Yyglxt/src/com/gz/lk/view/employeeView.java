package com.gz.lk.view;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.gz.lk.dialog.TpDialog;
import com.gz.lk.editor.BuyTicket;
import com.gz.lk.editor.SeatEditor;

import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public class employeeView extends ViewPart {

	public static final String ID = "com.gz.lk.view.employeeView"; //$NON-NLS-1$

	public employeeView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setBackgroundMode(SWT.INHERIT_DEFAULT);
		container.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/\u672A\u547D\u540D1(1).jpeg"));
		
		Button btnNewButton = new Button(container, SWT.BORDER);
		btnNewButton.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/QQ\u622A\u56FE20150819124149.jpg"));
		btnNewButton.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/QQ\u622A\u56FE20150819124149.jpg"));
		
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				try {
					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(Tjview.ID));
					
					BuyTicket he = new BuyTicket();
					//不重复打开Editor，需要Editor类本身重写equals方法
					IEditorPart editor = page.findEditor(he);
					System.out.println(editor);
					if (editor != null) {
						page.bringToTop(he);
					} else {
						page.openEditor(he, BuyTicket.ID);
					}

					
					
					//PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new com.gz.lk.editor.BuyTicket(), com.gz.lk.editor.BuyTicket.ID);
			
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(welcom.ID));
				
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

			
		});
		btnNewButton.setBounds(0, 2, 103, 200);
		
		Button btnNewButton_1 = new Button(container, SWT.BORDER);
		btnNewButton_1.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/QQ20150819124149.jpg"));
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {    //退票  
				
				TpDialog ad=new TpDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);
				
				
				
				
				ad.open();
				
				
			}
		});
		
		
		btnNewButton_1.setBounds(0, 213, 103, 200);
		
		Button btnNewButton_2 = new Button(container, SWT.BORDER);
		btnNewButton_2.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/50819124149.jpg"));
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					
					
					
					
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(true);
					
					
					
					
					

					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(Tjview.ID);
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().setEditorAreaVisible(false);
					
					
					
//					IWorkbenchWindow[] ws = PlatformUI.getWorkbench().getWorkbenchWindows();
//					for (IWorkbenchWindow wworkbench : ws) {
//					   IWorkbenchPage[] pages = wworkbench.getPages();
//					   for (IWorkbenchPage page : pages) {
//					      IEditorReference[] refers = page.getEditorReferences();
//					      for (IEditorReference refer : refers) {
//					         System.out.println(refer.getName());
//					      }
//					   }
//					}
					
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(0, 424, 103, 200);

		createActions();
		initializeToolBar();
		initializeMenu();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
	}
	
	
//	public boolean equals(Object obj) {
//		boolean bEquals = false;
//		try {
//			if (obj != null && obj instanceof BuyTicket) {
//				if (getPartName().equals(((BuyTicket) obj).getName())) {
//					bEquals = true;
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return bEquals;
//	}


	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
}
