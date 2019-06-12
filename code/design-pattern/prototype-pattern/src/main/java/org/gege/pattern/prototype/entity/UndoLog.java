package org.gege.pattern.prototype.entity;

import java.util.Date;

public class UndoLog   {
	//对应取消台账的编码
	private String listCode;

	private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setListCode(String listCode) {
		this.listCode = listCode;
	}
    public String getListCode() {
        return listCode;
    }
}