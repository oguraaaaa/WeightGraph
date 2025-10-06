package com.example.weightGraphApp.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class LoginUser extends User{
	
	private String displayName;
	private Double hight;
//	private Goal goal;
//	private WeightRecord weightRecord;
	private Double limitBw;
	
	/** 最低限の情報を保持したUserDetails
	* 実装クラスUserを作成する */
	public LoginUser(String username,String password,
			Collection<? extends GrantedAuthority>authorities,
			String displayname) { // 【追加部分】displaynameを追加
		super(username,password,authorities);
		this.displayName = displayname;
	}
	public String getDisplayname() {
		return displayName;		
		}
	public Double getHight() {
		return hight;
	}
//	public Goal getGoal() {
//		return goal;
//	}
//	public WeightRecord getWeightRecord() {
//		return weightRecord;
//	}
	public Double getLimitBw() {
		return limitBw;
	}
	public void setLimitBw(Double limitBw) {
		this.limitBw = limitBw;
	}
	
}
