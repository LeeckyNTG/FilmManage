package com.gz.lk.view;

import java.applet.AudioClip;
import java.net.URL;

import javax.swing.JApplet;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.gz.lk.core.Activator;
import org.eclipse.swt.widgets.Link;

public class welcom extends ViewPart {
	
	
	static AudioClip  snd ;
	public static int num=0;
	public static String sql="select * from upfilm";
	public static final String ID = "com.gz.lk.view.welcom"; //$NON-NLS-1$

	public welcom() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setForeground(SWTResourceManager.getColor(255, 204, 51));
		container.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/\u672A\u547D\u540D1(1).jpeg"));
		container.setBackgroundMode(SWT.INHERIT_DEFAULT);
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(51, 153, 255));
		lblNewLabel.setFont(SWTResourceManager.getFont("华文行楷", 26, SWT.NORMAL));
		lblNewLabel.setBounds(342, 134, 449, 49);
		lblNewLabel.setText("\u6B22\u8FCE\u4F7F\u7528\u5929\u5929\u5F71\u9662\u7BA1\u7406\u7CFB\u7EDF");
		
		Button button = new Button(container, SWT.BORDER);
		button.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/bfzn_004.png"));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Play();
			}
		});
		button.setBounds(410, 315, 55, 55);
		
		Button button_1 = new Button(container, SWT.BORDER);
		button_1.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/stop.png"));
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Stop();
			}
		});
		button_1.setBounds(638, 315, 55, 55);
		
		Link link = new Link(container, SWT.NONE);
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				PlatformUI.getWorkbench().restart();	
				
				
				
				
				
				
				
				
			}
		});
		link.setBounds(1028, 0, 53, 17);
		link.setText("<a>\u5207\u6362\u7528\u6237</a>");

		createActions();
		initializeToolBar();
		initializeMenu();
	}
	
	
	
	public AudioClip Play() {
		// URL mus=this.getClass().getResource("/music/Keepup.wav");

		
		
		
		
		URL url = Activator.getDefault().getBundle().getResource("3.wav");	
		System.out.println("点击play111111");
	
		System.out.println(url);
		snd = JApplet.newAudioClip(url);
		snd.loop(); // 循环播放
		snd.play();// 开始播放
		System.out.println("点击play222222");
		// 停止播放
		return snd;
	}				
	public void Stop(){
		System.out.println("点击stop");
		snd.stop();
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
