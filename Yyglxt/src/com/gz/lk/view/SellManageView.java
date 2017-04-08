package com.gz.lk.view;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.ResourceManager;

public class SellManageView extends ViewPart {

	public static final String ID = "com.gz.lk.view.SellManageView"; //$NON-NLS-1$

	public SellManageView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.BORDER);
		container.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/\u672A\u547D\u540D1(1).jpeg"));
		
		Composite composite = new Composite(container, SWT.BORDER);
		composite.setBounds(39, 258, 375, 218);
		{
			Button button = new Button(composite, SWT.BORDER);
			button.setBounds(0, 0, 375, 218);
			button.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/QQ\u622A\u56FE20150818132446.png"));
			{
				Composite composite_1 = new Composite(container, SWT.BORDER);
				composite_1.setBounds(384, 21, 375, 218);
				{
					Button button_1 = new Button(composite_1, SWT.BORDER);
					button_1.setBounds(0, 0, 375, 218);
					button_1.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/QQ\u622A\u56FE20150818132937.png"));
					{
						Composite composite_2 = new Composite(container, SWT.BORDER);
						composite_2.setBounds(648, 319, 375, 218);
						{
							Button button_2 = new Button(composite_2, SWT.BORDER);
							button_2.setBounds(0, 0, 375, 218);
							button_2.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/QQ\u622A\u56FE20150818133320.png"));
							button_2.addSelectionListener(new SelectionAdapter() {
								@Override
								public void widgetSelected(SelectionEvent e) {
									
									
									try {
										PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(DownFilm.ID);
									} catch (PartInitException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
									
									
									
								}
							});
						}
					}
					button_1.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							

							try {
								PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(DeleteAllUpfilm.ID);
							} catch (PartInitException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
						}
					});
				}
			}
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					
					try {
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(UpFilmView.ID);
					} catch (PartInitException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
		}

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
