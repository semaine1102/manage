package com.jsu.zcl.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import javax.swing.JOptionPane;

import com.jsu.zcl.dbc.DatabaseConnectionSql;
public class PackageDataOperate {
    public static int getNum(int start,int end) {//������ط���ָ����Χ�������
    	//Math.random()�������0.0��1.0֮�����
        return (int)(Math.random()*(end-start+1)+start);
    }
    private static String city[]= {
    		"������Ͻ��", "������Ͻ��", 
    		"�����Ͻ��", "�����Ͻ��",
    		"���հ�����", "���հ�����", "����������", "���ճ�����", "���ճ�����", "���ճ�����", "���ո�����", "���պϷ���", "���ջ�����", "���ջ�����", "���ջ�ɽ��", "����������", "��������ɽ��", "����������", "����ͭ����", "�����ߺ���", "����������", 
    		"����", 
    		"���",
    		"����������", "����������", "������ƽ��", "����������", "����������", "����Ȫ����", "����������", "����������",
    		"���������", "���ඨ����", "������ϲ���������", "�����������", "��������", "�����Ȫ��", "����������", "�������Ļ���������", "����¤����", "����ƽ����", "����������", "������ˮ��", "����������", "������Ҵ��",
    		"�㶫������", "�㶫��ݸ��", "�㶫��ɽ��", "�㶫������", "�㶫��Դ��", "�㶫������", "�㶫������", "�㶫������", "�㶫ï����", "�㶫÷����", "�㶫��Զ��", "�㶫��ͷ��", "�㶫��β��", "�㶫�ع���", "�㶫������", "�㶫������", "�㶫�Ƹ���", "�㶫տ����", "�㶫������", "�㶫��ɽ��", "�㶫�麣��",
    		"������ɫ��", "����������", "����������", "�������Ǹ���", "���������", "����������", "�����ӳ���", "����������", "����������", "����������", "����������", "����������", "����������", "����������",
    		"���ݰ�˳��", "���ݱϽڵ���", "���ݹ�����", "��������ˮ��", "����ǭ�������嶱��������", "����ǭ�ϲ���������������", "����ǭ���ϲ���������������", "����ͭ�ʵ���", "����������",
    		"���Ϻ�����", "����������", "����ʡֱϽ�ؼ���������",
    		"�ӱ�������", "�ӱ�������", "�ӱ��е���", "�ӱ�������", "�ӱ���ˮ��", "�ӱ��ȷ���", "�ӱ��ػʵ���", "�ӱ�ʯ��ׯ��", "�ӱ���ɽ��", "�ӱ���̨��", "�ӱ��żҿ���",
    		"���ϰ�����", "���Ϻױ���", "���Ͻ�����", "���Ͽ�����", "����������", "���������", "����������", "����ƽ��ɽ��", "���������", "��������Ͽ��", "����������", "����������", "����������", "����������", "����֣����", "�����ܿ���", "����פ������",
    		"������������", "���������˰������", "��������������", "�������׸���", "�������ں���", "������������", "��������ľ˹��", "������ĵ������", "��������̨����", "���������������", "������˫Ѽɽ��", "�������绯��", "������������",
    		"����������", "������ʩ����������������", "�����Ƹ���", "������ʯ��", "����������", "����������", "����ʮ����", "����������", "�����人��", "����������", "�����差��", "����Т����", "�����˲���",
            "���ϳ�ɳ��", "���ϳ�����", "���ϳ�����", "���Ϻ�����", "���ϻ�����", "����¦����", "����������", "������̶��", "������������������������", "����������", "����������", "����������", "�����żҽ���", "����������",
			"���ְ׳���", "���ְ�ɽ��", "���ֳ�����", "���ּ�����", "������Դ��", "������ƽ��", "������ԭ��", "����ͨ����", "�����ӱ߳�����������",
            "���ճ�����", "���ջ�����", "�������Ƹ���", "�����Ͼ���", "������ͨ��", "����������", "������Ǩ��", "����̩����", "����������", "����������", "�����γ���", "����������", "��������",
            "����������", "����������", "����������", "������������", "�����Ž���", "�����ϲ���", "����Ƽ����", "����������", "����������", "�����˴���", "����ӥ̶��",
            "������ɽ��", "������Ϫ��", "����������", "����������", "����������", "������˳��", "����������", "������«����", "����������", "����������", "�����̽���", "����������", "����������", "����Ӫ����",
            "���ɹŰ�������", "���ɹŰ����׶���", "���ɹŰ�ͷ��", "���ɹų����", "���ɹŶ�����˹��", "���ɹź��ͺ�����", "���ɹź��ױ�����", "���ɹ�ͨ����", "���ɹ��ں���", "���ɹ������첼��", "���ɹ����ֹ�����", "���ɹ��˰���",
            "���Ĺ�ԭ��", "����ʯ��ɽ��", "����������", "����������", "����������",
            "�ຣ�������������", "�ຣ��������������", "�ຣ��������", "�ຣ���ϲ���������", "�ຣ�����ɹ������������", "�ຣ���ϲ���������", "�ຣ������", "�ຣ��������������",
            "ɽ��������", "ɽ��������", "ɽ����Ӫ��", "ɽ��������", "ɽ��������", "ɽ��������", "ɽ��������", "ɽ���ĳ���", "ɽ��������", "ɽ���ൺ��", "ɽ��������", "ɽ��̩����", "ɽ��������", "ɽ��Ϋ����", "ɽ����̨��", "ɽ����ׯ��", "ɽ���Ͳ���",
            "ɽ��������", "ɽ����ͬ��", "ɽ��������", "ɽ��������", "ɽ���ٷ���", "ɽ��������", "ɽ��˷����", "ɽ��̫ԭ��", "ɽ��������", "ɽ����Ȫ��", "ɽ���˳���",
            "����������", "����������", "����������", "����������", "����ͭ����", "����μ����", "����������", "����������", "�����Ӱ���", "����������",
            "�Ĵ����Ӳ���Ǽ��������", "�Ĵ�������", "�Ĵ��ɶ���", "�Ĵ�������", "�Ĵ�������", "�Ĵ����β���������", "�Ĵ��㰲��", "�Ĵ���Ԫ��", "�Ĵ���ɽ��", "�Ĵ���ɽ����������", "�Ĵ�������", "�Ĵ�üɽ��", "�Ĵ�������", "�Ĵ��ڽ���", "�Ĵ��ϳ���", "�Ĵ���֦����", "�Ĵ�������", "�Ĵ��Ű���", "�Ĵ��˱���", "�Ĵ�������", "�Ĵ��Թ���",
            "���ذ������", "���ز�������", "����������", "������֥����", "������������", "�����տ������", "����ɽ�ϵ���",
            "�½������յ���", "�½�����̩����", "�½����������ɹ�������", "�½����������ɹ�������", "�½���������������", "�½����ܵ���", "�½��������", "�½���ʲ����", "�½�����������", "�½��������տ¶�����������", "�½����ǵ���", "�½���³������", "�½���³ľ����", "�½����������������", "�½�������ֱϽ�ؼ���������",
            "���ϱ�ɽ��", "���ϳ�������������", "���ϴ�������������", "���ϵº���徰����������", "���ϵ������������", "���Ϻ�ӹ���������������", "����������", "����������", "�����ٲ���", "����ŭ��������������", "�����ն���", "����������", "������ɽ׳������������", "������˫���ɴ���������", "������Ϫ��", "������ͨ��",
            "�㽭������", "�㽭������", "�㽭������", "�㽭����", "�㽭��ˮ��", "�㽭������", "�㽭������", "�㽭������", "�㽭̨����", "�㽭������", "�㽭��ɽ��",
            "������Ͻ��", "������Ͻ��", "�����ؼ���",
          	"̨��̨����", "̨�������", "̨���¡��", "̨��̨����", "̨��̨����", "̨��������", "̨�������",
    		};
    public static  String getCity1() {//�����÷�����ַ
    	Random c1 = new Random();
    	return city[c1.nextInt(300)];
    }
    public static  String getCity2() {//�������ջ���ַ
    	Random c2 = new Random();
    	return city[c2.nextInt(300)];
    }
    //��������˵���
    public static StringBuilder getStuno() {//��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
    	StringBuilder id=new StringBuilder("20210110");//��ź�ǰ8λ��ͬ
    	StringBuilder id1=new StringBuilder(String.valueOf(getNum(1,10000)));//���ȡ��5λ
    	if(id1.length()==1) {
    		id1=id1.insert(0, "0000");//�����1λ����ǰ������2��0
    		id=id.append(id1);//ǰ4λ���5λƴ�ӳɱ��
    	}else if(id1.length()==2) {
    		id1=id1.insert(0, "000");//�����2λ����ǰ������1��0
    		id=id.append(id1);
    	}else if(id1.length()==3) {
    		id1=id1.insert(0, "00");//�����3λ����ǰ������1��0
    		id=id.append(id1);
    	}else if(id1.length()==4) {
    		id1=id1.insert(0, "0");//�����4λ����ǰ������1��0
    		id=id.append(id1);
    	}else {
    		id=id.append(id1);
    	}
    	return id;
    }
    /**
     * ȡ��ָ��sql��ѯ���ļ�¼
     * @param sql ��ѯ���
     * @return ��ѯ���Ľ����������ΪVectorǶ�׼��ϣ��������DefaultTableModel����ģ��
     */
    public static Vector<Vector> getSelectAll(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(rs.getString(1));//��ȡ��һ���ֶ��˵���
    			row.add(rs.getString(2));//��ȡ�ڶ����ֶη�����ַ
    			row.add(rs.getString(3));//��ȡ�������ֶ��ջ���ַ
    			row.add(rs.getInt(4));//��ȡ���ĸ��ֶ��˷�
    			rows.add(row);//�����������ӵ���¼������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//��������������
    }
    public static void main(String[] args) {
    	addpackage();
    }
    public static void addpackage() {//���Ӱ�������
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
    	String sql="insert into package(id,ad1,ad2,price) values(?,?,?,?)";//ʹ��ռλ������������
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
        	ArrayList<String> alist=new ArrayList<String>();//���弯��
    		for(int i=1;i<=10000;) {
    			String id=getStuno().toString();//�����ȡ���
    			if(!alist.contains(id)) {//�ж��˵����Ƿ�Ψһ
    				alist.add(id);//��ѧ�ż��뼯��
    				String ad1=getCity1();//�����ȡ������ַ
    				String ad2=getCity2();//�����ȡ�ջ���ַ
    				int price=getNum(12, 72);//�����ȡ�˷�
    				pstmt.setString(1, id);//�����1��ռλ��������
    	    		pstmt.setString(2, ad1);//�����2��ռλ��������
    	    		pstmt.setString(3, ad2);//�����3��ռλ��������
    	    		pstmt.setInt(4, price);
    	    		pstmt.addBatch();//�����������ȴ�ִ��
    				i++;//���ΨһΨһ��ѭ����������ִ��
    			}
    		}
    		pstmt.executeBatch();//����ִ�в������
    		JOptionPane.showMessageDialog(null, "���ӳɹ���");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
}
