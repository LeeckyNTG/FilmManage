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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.ResourceManager;

public class Tjview extends ViewPart {

	public static final String ID = "com.gz.lk.view.Tjview"; //$NON-NLS-1$

	public Tjview() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/\u672A\u547D\u540D1(1).jpeg"));
		
		Button button = new Button(container, SWT.BORDER);
		button.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/QQ\u622A\u56FE20150818144204.png"));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {         //销售明细查询
				

				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(XstjView.ID);
			
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(Tjview.ID));
				
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		button.setBounds(130, 72, 370, 191);
		
		Button btnNewButton = new Button(container, SWT.BORDER);
		btnNewButton.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/QQ\u622A\u56FE20150818145224.png"));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				

				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(YttjView.ID);
			
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(Tjview.ID));
				
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setBounds(599, 72, 370, 191);
		
		Button button_1 = new Button(container, SWT.BORDER);
		button_1.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/QQ\u622A\u56FE20150818145917.png"));
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				

				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(RmdyVeiw.ID);
			
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(Tjview.ID));
				
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		button_1.setBounds(599, 338, 370, 191);
		
		Button btnNewButton_1 = new Button(container, SWT.BORDER);
		btnNewButton_1.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/QQ\u622A\u56FE20150818145616.png"));
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {          //销售额统计
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(XsetjView.ID);
			
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(Tjview.ID));
				
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(130, 338, 370, 191);

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
