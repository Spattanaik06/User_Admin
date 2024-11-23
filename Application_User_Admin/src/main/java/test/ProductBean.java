package test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductBean implements Serializable
{
	@Override
	public String toString() {
		return " Pcode :" + pcode + "\n"+" Pname : " + pname +"\n"+ " Pprice : " + pprice + "\n"+" Pqty : " + pqty  ;
	}
	private String pcode,pname;
	private float pprice;
	private int pqty;
	public ProductBean()
	{
	
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public float getPprice() {
		return pprice;
	}
	public void setPprice(float pprice) {
		this.pprice = pprice;
	}
	public int getPqty() {
		return pqty;
	}
	public void setPqty(int pqty) {
		this.pqty = pqty;
	}
	
}
