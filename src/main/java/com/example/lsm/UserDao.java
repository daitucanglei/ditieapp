package com.example.lsm;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import suanfa.zhunbei;
public class UserDao {
    public List<ditiepojo> selectAll ()
    {
        List<ditiepojo> list=new ArrayList<>();
        Connection conn = DBOpenHelper.getConn();
        Statement state = null;
        ResultSet rs = null;
        ditiepojo ditiepojo=null;
        String sql="select * from ditie1";
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                String xianlu = rs.getString("xianlu");
                String cid = rs.getString("cid");
                String zhandian = rs.getString("zhandian");
                String huanc = rs.getString("huanc");
                ditiepojo=new ditiepojo(xianlu,cid,zhandian,huanc);
                list.add(ditiepojo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBOpenHelper.close(rs, state, conn);
        }
        return list;
    }
    //根据线路查询
    public List<ditiepojo> chaxl (String xl)
    {
        List<ditiepojo> list=new ArrayList<>();
        Connection conn = DBOpenHelper.getConn();
        Statement state = null;
        ResultSet rs = null;
        ditiepojo ditiepojo=null;
        String sql="select * from ditie1 where xianlu like'%"+xl+"%'";
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                String xianlu = rs.getString("xianlu");
                String cid = rs.getString("cid");
                String zhandian = rs.getString("zhandian");
                String huanc = rs.getString("huanc");
                ditiepojo=new ditiepojo(xianlu,cid,zhandian,huanc);
                list.add(ditiepojo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBOpenHelper.close(rs, state, conn);
        }
        return list;
    }
    //查询站点
    public List<ditiepojo> chazd (String zd)
    {
        List<ditiepojo> list=new ArrayList<>();
        Connection conn = DBOpenHelper.getConn();
        Statement state = null;
        ResultSet rs = null;
        ditiepojo ditiepojo=null;
        String sql="select * from ditie1 where zhandian like'%"+zd+"%'";
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                String xianlu = rs.getString("xianlu");
                String cid = rs.getString("cid");
                String zhandian = rs.getString("zhandian");
                String huanc = rs.getString("huanc");
                ditiepojo=new ditiepojo(xianlu,cid,zhandian,huanc);
                list.add(ditiepojo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBOpenHelper.close(rs, state, conn);
        }
        return list;
    }
    public List<String> ld(String qi,String zhd)
    {
        List<String> list=new ArrayList<>();
        zhunbei zhunbei=new zhunbei();
        String zuiduan = zhunbei.zuiduan(qi, zhd);
        String[] s = zuiduan.split(" ");
        int b=s.length;
        for(int i=0;i<b;i++)
        {
            list.add(s[i]);
        }
        return list;
    }
}
