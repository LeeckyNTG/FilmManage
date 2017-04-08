package com.gz.lk.dialog;

import java.util.ArrayList;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;

import com.gz.lk.tools.DB;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;

public class TpDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public TpDialog(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
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
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/8c68791c42fc01cf87a018f01cbe8da1.jpg"));
		shell.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/8c68791c42fc01cf87a018f01cbe8da1.jpg"));
		shell.setSize(452, 300);
		shell.setText("\u9000\u7968");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(39, 43, 61, 17);
		label.setText("\u4F1A\u5458\u5361\u53F7\uFF1A");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("\u7535\u5F71\u7968\u7F16\u53F7\uFF1A");
		label_1.setBounds(39, 95, 72, 17);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("\u9000\u7968\u91D1\u989D\uFF1A");
		label_2.setBounds(39, 144, 61, 17);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(127, 40, 234, 23);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode==13) {
					String vipnum=text.getText();
					String filmnum=text_1.getText();
					DB db=new DB();
					ArrayList<String []> arr=db.arrQuery("select *from vip where id="+vipnum);
					ArrayList<String []> arr1=db.arrQuery("select *from filmticket where id="+filmnum);
					String grade=arr.get(0)[4];
					
					double dz=1;
					if (grade.equals("钻石")) {
						dz=0.8;
					}else 
						if (grade.equals("铂金")) {
							dz=0.85;
					}else if (grade.equals("黄金")) {
						dz=0.9;
					}else if (grade.equals("白银")) {
						dz=0.95;
						
					}else if (grade.equals("青铜")) {
						dz=0.98;
					}else {
						dz=1;
					}
					text_2.setText(((Double.parseDouble(arr1.get(0)[6]))*dz)+"");	
					
				}
			}
		});
		text_1.setBounds(127, 92, 234, 23);
		
		text_2 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_2.setBounds(127, 141, 234, 23);
		
		Button button = new Button(shell, SWT.BORDER);
		button.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {         //确定
				String vipnum=text.getText();
				String filmnum=text_1.getText();
				DB db=new DB();
				ArrayList<String []> arr=db.arrQuery("select *from vip where id="+vipnum);
				ArrayList<String []> arr1=db.arrQuery("select *from filmticket where id="+filmnum);
				
				
				String grade=arr.get(0)[4];
				
				double dz=1;
				if (grade.equals("钻石")) {
					dz=0.8;
				}else 
					if (grade.equals("铂金")) {
						dz=0.85;
				}else if (grade.equals("黄金")) {
					dz=0.9;
				}else if (grade.equals("白银")) {
					dz=0.95;
					
				}else if (grade.equals("青铜")) {
					dz=0.98;
				}else {
					dz=1;
				}
				text_2.setText(((Double.parseDouble(arr1.get(0)[6]))*dz)+"");				
				int i=db.update("delete from filmticket where id="+filmnum);
				
				
				System.out.println("delete from filmticket where id="+filmnum);
				if (i>0) {
					MessageBox mb=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
					mb.setMessage("退票成功！");
					mb.setText("消息提示！");
					mb.open();
				}else {
					MessageBox mb=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
					mb.setMessage("退票失败！");
					mb.setText("消息提示！");
					mb.open();
				}	
				
				
				shell.close();
			}
		});
		button.setBounds(281, 207, 80, 27);
		button.setText("\u786E\u5B9A");

	}

}
