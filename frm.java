package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Dao.GiaoVien_Dao;
import Dao.Lophoc_Dao;
import Enity.LopHoc;





public class frm extends JFrame implements ActionListener,MouseListener {
	private JComboBox<String> cboGVCN;
	private JTextField txtMaLop;
	private JTextField txtTenLop;
	private JButton btnThem;
	private JButton btnLuu;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnTimGV;
	private JButton btnTimLop;
	private DefaultTableModel dataModel;
	private JTable table;
	private JTextField txtSiSo;
	private JLabel lbltim;
	private JTextField txttimkiem;
	
	

	public frm() {
		
		setTitle("Thông tin lớp học");
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Box b, b1, b2, b3, b4, b44, b5, b6, b7;
		//Dùng Box layout
		add(b = Box.createVerticalBox()); //Box theo chi�?u d�?c
		b.add(Box.createVerticalStrut(10)); //Tạo khoảng cách theo chi�?u d�?c
		b.add(b1 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); //b1 -> b7: Box theo chi�?u ngang
		b.add(b2 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b3 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b4 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b44 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b5 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b6 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b7 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 

		JLabel lblTieuDe, lblMaLop, lblTenLop, lblGVCN, lblSiSo;
		b1.add(lblTieuDe = new JLabel("THÔNG TIN LỚP HỌC", JLabel.CENTER));
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 26));

		b2.add(lblMaLop = new JLabel("Mã lớp: ", JLabel.RIGHT)); b2.add(txtMaLop = new JTextField());
		b3.add(lblTenLop = new JLabel("Tên lớp: ", JLabel.RIGHT)); b3.add(txtTenLop = new JTextField());
		b4.add(lblGVCN = new JLabel("Giáo viên chủ nhiệm: ", JLabel.RIGHT)); 
		String[] ds= { "Phạm Văn Hoàng","Lê Thế Vinh","Nguyễn Ngọc Long"};
		b4.add(cboGVCN = new JComboBox<String>(ds));
		cboGVCN.setEditable(false);
		b44.add(lblSiSo = new JLabel("Sỉ số : ", JLabel.RIGHT)); b44.add(txtSiSo = new JTextField());
		b44.add(lbltim= new JLabel("Tim Kiem : ", JLabel.RIGHT)); b44.add(txttimkiem = new JTextField());
		
		lblMaLop.setPreferredSize(lblGVCN.getPreferredSize());
		lblTenLop.setPreferredSize(lblGVCN.getPreferredSize());
		lblSiSo.setPreferredSize(lblGVCN.getPreferredSize());
		
		b5.add(btnThem = new JButton("Thêm"));
		b5.add(btnLuu= new JButton("Lưu"));
		b5.add(btnSua = new JButton("Sửa"));
		b5.add(btnXoa = new JButton("Xóa"));
		b5.add(btnTimGV = new JButton("Tìm theo mã giáo viên"));
		b5.add(btnTimLop = new JButton("Tìm theo mã lớp"));

		String[] headers = {"Mã lớp", "Tên lớp", "Giáo viên CN", "Sỉ số"};
		dataModel = new DefaultTableModel(headers , 0);
		JScrollPane scroll;
		b6.add(scroll = new JScrollPane(table = new JTable(dataModel)));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách lớp học"));

		b7.add(Box.createHorizontalStrut(600));
		
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnTimGV.addActionListener(this);
		btnTimLop.addActionListener(this);
		btnXoa.addActionListener(this);
		updatetable();
		table.addMouseListener(this  );
	
		
		//Khi chương trình chạy, nạp toàn bộ danh sách lớp h�?c lên bảng
		
}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		hienthongtin();
	}



	private void hienthongtin() {
		// TODO Auto-generated method stub
		int row= table.getSelectedRow()	;
		GiaoVien_Dao gvdao= new GiaoVien_Dao();
		txtMaLop.setText(String.valueOf(table.getValueAt(row, 0)));
		txtTenLop.setText(String.valueOf(table.getValueAt(row, 1)));
		String tengv= gvdao.get(String.valueOf(table.getValueAt(row, 2))).getTenGiaoVien();
		cboGVCN.setSelectedItem(tengv);
		txtSiSo.setText(String.valueOf(table.getValueAt(row, 3)));
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o= e.getSource();
		if(o.equals(btnThem))
			xoarong();
		if(o.equals(btnLuu))
			themvao();
		if(o.equals(btnSua))
			Sua();
		if(o.equals(btnTimLop))
			timkiemlop();
		if(o.equals(btnTimGV))
			timkiem();
		if(o.equals(btnXoa))
			Xoa();
	}



	private void Xoa() {
		// TODO Auto-generated method stub
		int chon= table.getSelectedRow();
		dataModel.setRowCount(0);
		Lophoc_Dao LopHocdao= new Lophoc_Dao();
		ArrayList<LopHoc> dsLopHoc= LopHocdao.getallophoc();
		LopHocdao.Xoa(dsLopHoc.get(chon));
		updatetable();
	}



	private void timkiem() {
		// TODO Auto-generated method stub
		Lophoc_Dao lophocdao= new Lophoc_Dao();
		ArrayList<LopHoc> dslopHoc=lophocdao.getallophoc();
		ArrayList<LopHoc> dslopHoctk= new ArrayList<LopHoc>();
		String timkiem= txttimkiem.getText();
		GiaoVien_Dao gvdao= new GiaoVien_Dao();
		int dem=0;
		for(int i= 0;i< dslopHoc.size();i++) {
			if(dslopHoc.get(i).getMaGiaoVien().equals(timkiem)==true) {
				dslopHoctk.add(dslopHoc.get(i));
				dem++;
			}
		}
		if(dem>0) {
			dataModel.setRowCount(0);
			for(LopHoc lopHoc:dslopHoc) {
				String tenGiaoVien=gvdao.getten(lopHoc.getMaGiaoVien()).getTenGiaoVien();
				Object [] row= {
					lopHoc.getMaLop(),
					lopHoc.getTenLop(),
					tenGiaoVien,
					lopHoc.getSiSo()
					
				};
				dataModel.addRow(row);
			}
			table.setModel(dataModel);
		}else {
			updatetable();
			JOptionPane.showMessageDialog(null, "Không tìm thấy","Thông báo",JOptionPane.INFORMATION_MESSAGE);
		}
	}



	private void timkiemlop() {
		// TODO Auto-generated method stub
		Lophoc_Dao lophocdao= new Lophoc_Dao();
		ArrayList<LopHoc> dslopHoc=lophocdao.getallophoc();
		ArrayList<LopHoc> dslopHoctk= new ArrayList<LopHoc>();
		String timkiem= txttimkiem.getText();
		GiaoVien_Dao gvdao= new GiaoVien_Dao();
		int dem=0;
		for(int i= 0;i< dslopHoc.size();i++) {
			if(dslopHoc.get(i).getMaLop().equals(timkiem)==true) {
				dslopHoctk.add(dslopHoc.get(i));
				dem++;
			}
		}
		if(dem>0) {
			dataModel.setRowCount(0);
			for(LopHoc lopHoc:dslopHoc) {
				String tenGiaoVien=gvdao.getten(lopHoc.getMaGiaoVien()).getTenGiaoVien();
				Object [] row= {
					lopHoc.getMaLop(),
					lopHoc.getTenLop(),
					tenGiaoVien,
					lopHoc.getSiSo()
					
				};
				dataModel.addRow(row);
			}
			table.setModel(dataModel);
		}else {
			updatetable();
			JOptionPane.showMessageDialog(null, "Không tìm thấy","Thông báo",JOptionPane.INFORMATION_MESSAGE);
		}
	}



	private void Sua() {
		// TODO Auto-generated method stub
		try {
			String malop=txtMaLop.getText();
			String tenlop=txtTenLop.getText();
			String tengv=(String)cboGVCN.getSelectedItem();
			int siso= Integer.parseInt(txtSiSo.getText());
			GiaoVien_Dao gvdao= new GiaoVien_Dao()	;
			String magv= gvdao.get(tengv).getMaGiaoVien();
			LopHoc lh= new LopHoc(malop,tenlop, magv, siso);
			Lophoc_Dao lophocdao= new Lophoc_Dao()	;
			lophocdao.Sua(lh);
			updatetable();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}



	private void themvao() {
		// TODO Auto-generated method stub
		try {
			String malop=txtMaLop.getText();
			String tenlop=txtTenLop.getText();
			String tengv=(String)cboGVCN.getSelectedItem();
			int siso= Integer.parseInt(txtSiSo.getText());
			GiaoVien_Dao gvdao= new GiaoVien_Dao()	;
			String magv= gvdao.get(tengv).getMaGiaoVien();
			LopHoc lh= new LopHoc(malop,tenlop, magv, siso);
			Lophoc_Dao lophocdao= new Lophoc_Dao()	;
			lophocdao.themlophoc(lh);
			updatetable();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}



	private void updatetable() {
		// TODO Auto-generated method stub
		dataModel.setRowCount(0);
		Lophoc_Dao lophocdao= new Lophoc_Dao();
		ArrayList<LopHoc> dsLopHoc= lophocdao.getallophoc();
		GiaoVien_Dao gvdao= new GiaoVien_Dao()	;
		for(LopHoc lopHoc:dsLopHoc) {
			String tenGiaoVien= gvdao.getten(lopHoc.getMaGiaoVien()).getTenGiaoVien();
			Object [] row= {
					lopHoc.getMaLop(),
					lopHoc.getTenLop(),
					tenGiaoVien,
					lopHoc.getSiSo()
			};
			dataModel.addRow(row);
		}
		table.setModel(dataModel);
	}



	private void xoarong() {
		// TODO Auto-generated method stub
		txtMaLop.setText("");
		txtTenLop.setText("");
		cboGVCN.setSelectedItem(null);
		txtSiSo.setText("");
		txtMaLop.requestFocus();
	}
	public static void main(String[] args) {
		frm fr= new frm();
		fr.setVisible(true);
	}
}
