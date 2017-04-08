package com.gz.lk.dialog;

import java.util.ArrayList;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import com.gz.lk.editor.BuyTicket;
import com.gz.lk.tools.DB;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TicketXxxx extends Dialog {

	protected Object result;
	protected Shell shell;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public TicketXxxx(Shell parent, int style) {
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
		shell.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/666627.jpg"));
		shell.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/666627.jpg"));
		shell.setSize(552, 371);
		shell.setText("\u7535\u5F71\u7968");
		DB db=new DB();
		
		
		int j=Integer.parseInt(BuyTicket.data1);
		ArrayList<String []> arr=db.arrQuery("select *from upfilm");
		
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("楷体", 14, SWT.NORMAL));
		label.setBounds(133, 24, 150, 24);
		label.setText("\u5929\u5929\u5F71\u9662\u7535\u5F71\u7968");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(34, 152, 61, 17);
		lblNewLabel.setText("电影名：");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(34, 204, 61, 17);
		lblNewLabel_1.setText("时间：");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(34, 251, 61, 17);
		lblNewLabel_2.setText("地点：");
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setBounds(104, 152, 202, 17);
		lblNewLabel_4.setText(arr.get(j)[1]);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText(arr.get(j)[5]);
		label_1.setBounds(104, 204, 202, 17);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("第"+arr.get(j)[2]+"影厅");
		label_2.setBounds(104, 251, 202, 17);
		
	
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(34, 100, 61, 17);
		label_4.setText("\u7F16\u53F7\uFF1A");
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setBounds(104, 100, 188, 17);
		lblNewLabel_5.setText(arr.get(j)[0]);
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setImage(ResourceManager.getPluginImage("Yyglxt", "img/"+arr.get(j)[9]));
		lblNewLabel_3.setBounds(315, 76, 160, 221);
		
		Button button = new Button(shell, SWT.BORDER);
		button.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shell.close();
			}
		});
		button.setBounds(395, 303, 80, 27);
		button.setText("\u786E\u5B9A");
		
		
		
		
		
		
		

	}

}
