
package com.example.georef.generales;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class St {

	@SerializedName("cc")
	@Expose
	private int cc;
	@SerializedName("p_exp")
	@Expose
	private int pExp;
	@SerializedName("p_rec")
	@Expose
	private int pRec;
	@SerializedName("p_per")
	@Expose
	private String pPer;
	@SerializedName("pi_rec")
	@Expose
	private int piRec;
	@SerializedName("pi_per")
	@Expose
	private String piPer;
	@SerializedName("v_exp_abs")
	@Expose
	private int vExpAbs;
	@SerializedName("v_exp")
	@Expose
	private int vExp;
	@SerializedName("v_rec")
	@Expose
	private int vRec;
	@SerializedName("v_per_abs")
	@Expose
	private String vPerAbs;
	@SerializedName("v_per")
	@Expose
	private String vPer;

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public int getPExp() {
		return pExp;
	}

	public void setPExp(int pExp) {
		this.pExp = pExp;
	}

	public int getPRec() {
		return pRec;
	}

	public void setPRec(int pRec) {
		this.pRec = pRec;
	}

	public String getPPer() {
		return pPer;
	}

	public void setPPer(String pPer) {
		this.pPer = pPer;
	}

	public int getPiRec() {
		return piRec;
	}

	public void setPiRec(int piRec) {
		this.piRec = piRec;
	}

	public String getPiPer() {
		return piPer;
	}

	public void setPiPer(String piPer) {
		this.piPer = piPer;
	}

	public int getVExpAbs() {
		return vExpAbs;
	}

	public void setVExpAbs(int vExpAbs) {
		this.vExpAbs = vExpAbs;
	}

	public int getVExp() {
		return vExp;
	}

	public void setVExp(int vExp) {
		this.vExp = vExp;
	}

	public int getVRec() {
		return vRec;
	}

	public void setVRec(int vRec) {
		this.vRec = vRec;
	}

	public String getVPerAbs() {
		return vPerAbs;
	}

	public void setVPerAbs(String vPerAbs) {
		this.vPerAbs = vPerAbs;
	}

	public String getVPer() {
		return vPer;
	}

	public void setVPer(String vPer) {
		this.vPer = vPer;
	}

	@Override
	public String toString() {
		return "St [cc=" + cc + ", pExp=" + pExp + ", pRec=" + pRec + ", pPer=" + pPer + ", piRec=" + piRec + ", piPer="
				+ piPer + ", vExpAbs=" + vExpAbs + ", vExp=" + vExp + ", vRec=" + vRec + ", vPerAbs=" + vPerAbs
				+ ", vPer=" + vPer + "]";
	}

}
