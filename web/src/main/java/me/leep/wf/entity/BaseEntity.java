/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 所有entity类的超类. 
 * 
 * @author 李鹏
 */
@MappedSuperclass
public abstract class BaseEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4562370210152651953L;
	
	private String id;
	

	/**
	 * 静态变量块
	 */
	static {

	}

	/**
	 * @return id
	 */
	@Id
	@Column(name = "fid", unique = true, nullable = false, length = 36)
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            要设置的 id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 根据ID来虚拟一个对象，相当于load方法，用于弱关联的外键对象关系
	 * 
	 * @param param 传入的参数ID
	 */
	public void read(String param) {
		this.setId(param);
	}

}