package com.gz.lk.shell;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.gz.lk.core.Application;
import com.gz.lk.dialog.Xxts;
import com.gz.lk.tools.DB;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.ui.PlatformUI;

public class Login extends Shell {
	private Text txtAdmin;
	private Text txtAdmin_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Login shell = new Login(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public Login(Display display) {
		super(display, SWT.SHELL_TRIM | SWT.BORDER);
		setBounds(300,170,100,100);
		setBackgroundMode(SWT.INHERIT_DEFAULT);
		setImage(ResourceManager.getPluginImage("Yyglxt", "icons/tb.png"));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setFont(SWTResourceManager.getFont("隶书", 12, SWT.NORMAL));
		composite.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/loginbound.png"));
		composite.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite.setBounds(0, 0, 666, 393);
		
		txtAdmin = new Text(composite, SWT.BORDER);
		txtAdmin.setText("admin");
		txtAdmin.setFont(SWTResourceManager.getFont("楷体", 8, SWT.NORMAL));
		txtAdmin.setBounds(315, 162, 105, 15);
		
		txtAdmin_1 = new Text(composite, SWT.BORDER | SWT.PASSWORD);
		txtAdmin_1.setText("admin");
		txtAdmin_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 8, SWT.NORMAL));
		txtAdmin_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode==13){
					String un=txtAdmin.getText();
					String pw=txtAdmin_1.getText();
					String sql="select *from user where userName='"+un+"' and password='"+pw+"'";
					DB db=new DB();
					ArrayList<String []> arr=db.arrQuery(sql);
					if (arr.size()==1) {
						Application.bol=Integer.parseInt(arr.get(0)[3]);
						Login.this.close();
					}else {
//						MessageBox mb=new MessageBox(Login.this,SWT.NONE);
//						mb.setText("提示信息");
//						mb.setMessage("你的用户名或密码不正确！");
//						mb.open();
						String str="你的用户名或密码不正确";
						String str2="请从新输入！";
						Xxts xx=new Xxts(Login.this, SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);
						xx.open(str,str2);
					
					}		
				}
			}
		});
		txtAdmin_1.setBounds(315, 185, 105, 15);
		
		Button btnNewButton = new Button(composite, SWT.CHECK | SWT.RIGHT);
		btnNewButton.setBounds(440, 154, 63, 51);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				
				
				
				
				String un=txtAdmin.getText();
				String pw=txtAdmin_1.getText();
				String sql="select *from user where userName='"+un+"' and password='"+pw+"'";
				DB db=new DB();
				ArrayList<String []> arr=db.arrQuery(sql);
				if (arr.size()==1) {
					Application.bol=Integer.parseInt(arr.get(0)[3]);
					Login.this.close();
				}else {
//					MessageBox mb=new MessageBox(Login.this,SWT.NONE);
//					mb.setText("提示信息");
//					mb.setMessage("你的用户名或密码不正确！");
//					mb.open();
					String str="你的用户名或密码不正确";
					String str2="请从新输入！";
					Xxts xx=new Xxts(Login.this, SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);
					xx.open(str,str2);
				}
			}
		});
		
		btnNewButton.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/loginBound.jpg"));
		btnNewButton.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/login.png"));
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 16, SWT.BOLD));
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel.setBounds(264, 106, 191, 28);
		lblNewLabel.setText("\u5929\u5929\u5F71\u9662\u7BA1\u7406\u7CFB\u7EDF");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		setSize(682, 432);

	}
	public void setBounds(int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		super.setBounds(x, y, width, height);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
