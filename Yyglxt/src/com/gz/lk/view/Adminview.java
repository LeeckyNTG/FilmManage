package com.gz.lk.view;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;

public class Adminview extends ViewPart {

	public static final String ID = "com.gz.lk.view.Adminview"; //$NON-NLS-1$

	public Adminview() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		parent.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/\u672A\u547D\u540D1(1).jpeg"));
		parent.setBackgroundMode(SWT.INHERIT_DEFAULT);
		parent.setLayout(null);
		
		Composite composite = new Composite(parent, SWT.BORDER);
		composite.setBounds(37, 47, 145, 34);
		
		Button button = new Button(composite, SWT.NONE);
		button.setBounds(0, 0, 145, 34);
		button.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/\u5458\u5DE5\u7BA1\u7406.png"));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {     //员工管理
				
				try {

					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(FilmManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(SellManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(fytManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(Tjview.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(VIPManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(employeeManageView.ID));
					
					
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(employeeManageView.ID);
					
					
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		Composite composite_1 = new Composite(parent, SWT.BORDER);
		composite_1.setBounds(37, 139, 145, 34);
		
		Button button_1 = new Button(composite_1, SWT.FLAT | SWT.TOGGLE);
		button_1.setBounds(0, 0, 145, 34);
		button_1.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/\u5F71\u7247\u7BA1\u7406.png"));
		
		Composite composite_2 = new Composite(parent, SWT.BORDER);
		composite_2.setBounds(37, 231, 145, 34);
		
		Button btnNewButton = new Button(composite_2, SWT.TOGGLE);
		btnNewButton.setBounds(0, 0, 145, 34);
		btnNewButton.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/\u9500\u552E\u7BA1\u7406.png"));
		
		Composite composite_3 = new Composite(parent, SWT.BORDER);
		composite_3.setBounds(37, 323, 145, 34);
		
		Button button_2 = new Button(composite_3, SWT.NONE);
		button_2.setBounds(0, 0, 145, 34);
		button_2.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/\u5F71\u5385\u7BA1\u7406.png"));
		
		Composite composite_4 = new Composite(parent, SWT.BORDER);
		composite_4.setBounds(37, 415, 145, 34);
		
		Button button_3 = new Button(composite_4, SWT.NONE);
		button_3.setBounds(0, 0, 145, 34);
		button_3.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/\u9500\u552E\u7EDF\u8BA1.png"));
		
		Composite composite_5 = new Composite(parent, SWT.BORDER);
		composite_5.setBounds(37, 507, 145, 34);
		
		Button btnNewButton_1 = new Button(composite_5, SWT.NONE);
		btnNewButton_1.setBounds(0, 0, 145, 34);
		btnNewButton_1.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/\u4F1A\u5458\u7BA1\u7406.png"));
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					

					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(FilmManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(SellManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(fytManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(Tjview.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(VIPManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(employeeManageView.ID));
					
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(VIPManageView.ID);
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					

					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(FilmManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(SellManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(fytManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(Tjview.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(VIPManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(employeeManageView.ID));
					
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(Tjview.ID);
			
		
				
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				try {
					

					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(FilmManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(SellManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(fytManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(Tjview.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(VIPManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(employeeManageView.ID));
					
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(fytManageView.ID);
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {     //销售管理页面
				try {
					

					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(FilmManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(SellManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(fytManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(Tjview.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(VIPManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(employeeManageView.ID));
					
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(SellManageView.ID);
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
				
			}
		});
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {    //影片管理
				
				try {
					

					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(FilmManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(SellManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(fytManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(Tjview.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(VIPManageView.ID));
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(employeeManageView.ID));
					
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(FilmManageView.ID);
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

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
