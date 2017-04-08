package com.gz.lk.dialog;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.gz.lk.tools.DB;
import org.eclipse.wb.swt.ResourceManager;

public class SzlcxDialog1 extends Dialog {

	protected Object result;
	protected Shell shell;
	
	
	String [] id;
	DateTime dateTime;


	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public SzlcxDialog1(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open(String [] id) {
		this.id=id;
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
		shell.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/tb.png"));
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/8c68791c42fc01cf87a018f01cbe8da1.jpg"));
		shell.setSize(450, 300);
		shell.setText("\u4E0A\u5EA7\u7387\u67E5\u8BE2");
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("楷体", 13, SWT.NORMAL));
		label.setBounds(83, 100, 186, 17);
		label.setText("\u8BF7\u9009\u62E9\u8981\u67E5\u8BE2\u7684\u6708\u4EFD\uFF1A");
		
		
		dateTime = new DateTime(shell, SWT.BORDER | SWT.DROP_DOWN | SWT.SHORT);
		dateTime.setBounds(275, 100, 100, 24);
		
		
		Button button = new Button(shell, SWT.BORDER | SWT.TOGGLE);
		button.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int y=dateTime.getYear();	
				int m=dateTime.getMonth()+1;
				
				System.out.println(y+"-"+(m > 9 ? m : "0"+m));
				
				
				DB db=new DB();
			
				
				ArrayList<String []> arr1=db.arrQuery("select *from fyt where id="+id[0]);
				
				String str=arr1.get(0)[1];
				
				System.out.println("第"+str.substring(1, 2)+"大厅");
				
				System.out.println("select *from filmticket where filmName='"+id[1]+"' and time like '%"+y+"-"+m+"%' and address like '%"+"第"+str.substring(1, 2)+"大厅"+"%'");
				
				ArrayList<String []> arr=db.arrQuery("select *from filmticket where filmName='"+id[1]+"' and time like '%"+y+"-"+m+"%' and address like '%"+"第"+str.substring(1, 2)+"大厅"+"%'");
				
				
				
				ArrayList<String []> arr2=db.arrQuery("select *from upfilm where filmName='"+id[1]+"' and startTime like '%"+y+"-"+m +"%' and fyt like '%"+str.substring(1, 2)+"%'");
		//		System.out.println("select *from upfilm where startTime like '%"+y+"-"+m +"%' and fyt like '%"+str.substring(1, 2)+"%'");
				
				String str1=arr1.get(0)[3];
				
				String [] sz=str1.split("-");
				
				int max=Integer.parseInt(sz[0])*Integer.parseInt(sz[1])*arr2.size();
				
				double xsb=(double)(arr.size()*100)/(double)max;
				
				DefaultPieDataset dpd = new DefaultPieDataset();
				
				//设置数据集一参数为String课动态设置二参数为double为站饼图的比例为多少
				dpd.setValue("销售量",xsb);
				dpd.setValue("空位数",100-xsb);
				
				
				System.out.println(arr.size()+"----"+max);
				
				//基于char工厂显示有5个参数一为设置显示的标题二为现实的图形数据
				//三未知四为鼠标触碰图片是是否会产生提示	
				//五位URL最要的参数点击图标是否会产生连接
				JFreeChart jc = ChartFactory.createPieChart3D("天天影院销售统计图",dpd,true,true,true);
				//jc为一个看到的图表
				ChartFrame cf = new ChartFrame("天天影院销售统计图",jc);
				
				cf.pack();
				
				cf.setVisible(true);
				
				
				shell.close();
				
			}
		});
		button.setBounds(314, 164, 80, 27);
		button.setText("\u67E5\u8BE2");
		
		

	}

}
