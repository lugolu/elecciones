
package com.example.georef.generales;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class R {

	@SerializedName("cc")
	@Expose
	private int cc;
	@SerializedName("pc")
	@Expose
	private int pc;
	@SerializedName("boc")
	@Expose
	private int boc;
	@SerializedName("v")
	@Expose
	private int v;
	@SerializedName("tot")
	@Expose
	private int tot;
	@SerializedName("per")
	@Expose
	private String per;

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public int getBoc() {
		return boc;
	}

	public void setBoc(int boc) {
		this.boc = boc;
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public String getPer() {
		return per;
	}

	public void setPer(String per) {
		this.per = per;
	}

	public Double getPorc() {
		return Double.parseDouble(per);
	}

	@Override
	public String toString() {
		return "R [cc=" + cc + ", pc=" + pc + ", boc=" + boc + ", v=" + v + ", tot=" + tot + ", per=" + per + ", porc=" + getPorc() + "]";
	}

}
