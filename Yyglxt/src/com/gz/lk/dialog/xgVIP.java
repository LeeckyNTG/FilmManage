package com.gz.lk.dialog;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Group;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.PlatformUI;

import com.gz.lk.core.Activator;
import com.gz.lk.tools.DB;

public class xgVIP extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	
	Label lblNewLabel_2;
	
	String str1;
	String target;
	
	Button button_1,button;
	private Text text_2;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public xgVIP(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open(String id) {
		createContents(id);
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents(String id) {
		shell = new Shell(getParent(), getStyle());
		shell.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/tb.png"));
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/666627.jpg"));
		shell.setSize(810, 499);
		shell.setText("\u4F1A\u5458\u4FE1\u606F\u4FEE\u6539");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
		label_1.setFont(SWTResourceManager.getFont("����", 24, SWT.NORMAL));
		label_1.setBounds(187, 22, 403, 43);
		label_1.setText("��     Ϣ     ��     ��");
		
		Group group = new Group(shell, SWT.BORDER);
		group.setText("\u4FE1\u606F\u586B\u5199");
		group.setBounds(61, 105, 669, 250);
		
		text = new Text(group, SWT.BORDER);
		text.setBounds(154, 75, 188, 23);
		
		button_1 = new Button(group, SWT.RADIO);
		button_1.setBounds(284, 122, 45, 17);
		button_1.setText("\u5973");
		
		
		
		button = new Button(group, SWT.RADIO);
		button.setBounds(173, 122, 45, 17);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button.setText("\u7537");
		
		Label label = new Label(group, SWT.NONE);
		label.setBounds(44, 122, 45, 17);
		label.setText("\u6027\u522B\uFF1A");
		
		text_1 = new Text(group, SWT.BORDER);
		text_1.setBounds(154, 164, 188, 23);
		
		Label lblNewLabel_1 = new Label(group, SWT.NONE);
		lblNewLabel_1.setBounds(44, 167, 61, 17);
		lblNewLabel_1.setText("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		
		lblNewLabel_2 = new Label(group, SWT.NONE);
		lblNewLabel_2.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/1cd11bae456f04dfad319d1c8851b86a.jpg"));
		lblNewLabel_2.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/1cd11bae456f04dfad319d1c8851b86a.jpg"));
		lblNewLabel_2.setBounds(468, 30, 136, 157);
		
		
		
		
		
		
		
		
		
		
		
		Link link = new Link(group, SWT.NONE);
		link.setFont(SWTResourceManager.getFont("����", 10, SWT.NORMAL));
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {    //�ϴ�ͼƬ
				FileDialog fd = new FileDialog(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell(), SWT.NONE);
				String str = fd.open();// ��ȡ�ļ�·��

				lblNewLabel_2.setImage(SWTResourceManager.getImage(str));// ////

				URL url = Activator.getDefault().getBundle().getResource("img");
				try {
					String targetPath = FileLocator.toFileURL(url).toString();

					String hz = str.substring(str.lastIndexOf("."));

					long wjm = new Date().getTime();
					target = targetPath.substring(6) + wjm + hz;
					str1 = wjm + hz;
					FileInputStream fis = new FileInputStream(str);
					FileOutputStream fos = new FileOutputStream(targetPath
							.substring(6) + wjm + hz);

					String target = targetPath.substring(6) + wjm + hz;
					System.out.println(target);

					byte[] b = new byte[1024];

					int num = 0;
					while ((num = fis.read(b)) != -1) {
						fos.write(b, 0, num);
					}
					fis.close();
					fos.close();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
			}
		});
		link.setBounds(551, 223, 69, 17);
		link.setText("<a>\u4E0A\u4F20\u56FE\u7247</a>");
		
		Label label_2 = new Label(group, SWT.NONE);
		label_2.setBounds(44, 30, 61, 17);
		label_2.setText("\u4F1A\u5458\u7F16\u53F7\uFF1A");
		
		Label label_3 = new Label(group, SWT.NONE);
		label_3.setBounds(44, 75, 61, 17);
		label_3.setText("\u59D3\u540D\uFF1A");
		
		text_2 = new Text(group, SWT.BORDER);
		text_2.setBounds(154, 24, 188, 23);		
		
		DB db=new DB();
		ArrayList<String []> arr=db.arrQuery("select *from vip where id="+id);
		System.out.println(id);
		text_2.setText(id);	
		text.setText(arr.get(0)[1]);
		text_1.setText(arr.get(0)[5]);
		String imgName=arr.get(0)[6];
		lblNewLabel_2.setImage(ResourceManager.getPluginImage("Yyglxt", "img/"+imgName+""));
		
		String sex=arr.get(0)[2];
		if (sex.equals("��")) {
			button.setSelection(true);
		}else {
			button.setSelection(false);
		}
		

		
		
		Button button_2 = new Button(shell, SWT.BORDER);
		button_2.setFont(SWTResourceManager.getFont("����", 10, SWT.BOLD));
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {    
				
				
				String id=text_2.getText();
				
				
				String name = text.getText();

				String tel = text_1.getText();
				
				String sex=null;
				

				System.out.println(button.getSelection());
				System.out.println(button_1.getSelection());
				
				if (button.getSelection()) {
					sex=button.getText();
				}else {
					sex=button_1.getText();
				}

				

				boolean bol = true;

				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/yyglxt", "root",
							"mysql");
					PreparedStatement ps=con.prepareStatement("update vip set name='"+name+"',sex='"+sex+"',tel='"+tel+"',imgName='"+str1+"',img=? where id="+id);
					
					System.out.println("update vip set name='"+name+"',sex='"+sex+"',tel='"+tel+"',imgName='"+str1+"',img=? where id="+id);
					
					FileInputStream fis = new FileInputStream(target);


					ps.setBinaryStream(1, fis, fis.available());

					bol = ps.execute();

					System.out.println(bol);
					con.close();
					fis.close();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					if (!bol) {
						MessageBox mb = new MessageBox(PlatformUI
								.getWorkbench().getActiveWorkbenchWindow()
								.getShell(), SWT.NONE);
						mb.setText("��Ϣ��ʾ");
						mb.setMessage("����ɹ�");
						mb.open();
					} else {
						MessageBox mb = new MessageBox(PlatformUI
								.getWorkbench().getActiveWorkbenchWindow()
								.getShell(), SWT.NONE);
						mb.setText("��Ϣ��ʾ");
						mb.setMessage("����ʧ�ܣ��������ݡ�");
						mb.open();
					}
				}

				shell.close();	

			}
		});
		button_2.setBounds(650, 407, 80, 27);
		button_2.setText("\u4FEE\u6539");
		
		Button button_3 = new Button(shell, SWT.BORDER);
		button_3.setFont(SWTResourceManager.getFont("����", 10, SWT.BOLD));
		button_3.setBounds(468, 407, 80, 27);
		button_3.setText("\u8FD4\u56DE");
		button.getSelection();

	}
}
